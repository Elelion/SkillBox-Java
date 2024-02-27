package module_17_multithreading._17_21_practical_ForkJoinPool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import java.util.concurrent.*;
import java.util.concurrent.RecursiveTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SiteMapGenerator {
    private final String SITE_URL = "https://lenta.ru";
    private final int SEARCH_DEPTH = 3;
    private final int CORES_CPU = Runtime.getRuntime().availableProcessors();

    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_17_multithreading";
    private String pathLectureDir = "_17_21_practical_ForkJoinPool";
    private final String FILENAME =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "sitemap.txt";

    private Set<String> visitedUrls;
    private StringBuilder siteMap;
    private String childUrl;
    private String url;

    public SiteMapGenerator() throws FileNotFoundException {
        this.visitedUrls = new HashSet<>();
        this.siteMap = new StringBuilder();

        Document doc = takeUrlConnecting(SITE_URL);
        Elements links = doc.select("a[href]");

        /**
         * submit(ForkJoinTask<T> task) - этот метод отправляет задачу
         * (ForkJoinTask) на выполнение в пул потоков и возвращает объект
         * ForkJoinTask (расширяющий Future<T>), который представляет результат
         * выполнения задачи. Метод submit() можно использовать, когда нужно
         * асинхронно выполнить задачу и продолжить выполнение остальной части
         * кода без ожидания завершения выполнения задачи.
         *
         * invoke(ForkJoinTask<T> task) - этот метод также отправляет задачу
         * на выполнение в пул потоков, но блокирует текущий поток выполнения
         * до тех пор, пока задача не будет выполнена и не вернет результат.
         * Метод invoke() можно использовать, когда нужно синхронно выполнить
         * задачу и получить ее результат.
         */

        // заносим базовый URL
        visitedUrls.add(SITE_URL);
        siteMap.append(SITE_URL).append(System.lineSeparator());

        // запускаем многопоточку
        int coresCPU = Runtime.getRuntime().availableProcessors();
        ForkJoinPool forkJoinPool = new ForkJoinPool(coresCPU);

        forkJoinPool.invoke(new MyThread(links));

//        System.out.println(siteMap);
        writeSiteMapDataToFile();
    }

    /**
     * .header("Accept", "*//*") - указываем ожидаемый тип контента
     * referrer - указывем ресурс с которого отправляем запрос (у нас типа с гугла)
     */
    private Document takeUrlConnecting(String url) {
        try {
            return Jsoup.connect(url)
                .header("Accept", "*/*")
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .followRedirects(false)
                .referrer("https://google.com")
                .timeout(10_000)
                .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * # - отсекаем секции: https://example.com/page.html#section1
     * tel - отсекаем телефонные ссылки
     * mailto - отсекаем email ссылки
     */
    private boolean isValidUrl(String link) {
         return link.startsWith(SITE_URL)
             && !link.contains("#")
             && !link.contains("tel")
             && !link.contains("mailto")
             && !link.contains("?");
    }


    /**/


    private void addUrlToSiteMap(String url, int level) {
        for (int i = 0; i < level; i++) {
            siteMap.append("\t");
        }

        siteMap.append(url).append(System.lineSeparator());
    }

    /**
     * в цикле for мы перебираем внутренние ссылки. Те нам передали сюда уже
     * какую то ссылку которая была внешней (рутовой) и мы по этой ссылке
     * смотрим ссылки глубже
     *
     * если глубже то же есть ссылки, то рекурскией мы идем еще глубже
     */
    private void visitChildPages(String url, int level) {
        Document doc = takeUrlConnecting(url);
        visitedUrls.add(url);
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            childUrl = link.absUrl("href");

            if (isValidUrl(childUrl) && !visitedUrls.contains(childUrl) && level <= SEARCH_DEPTH) {
                System.out.println("=> " + childUrl);

                addUrlToSiteMap(childUrl, level);

                // для тестов
                // visitChildPages(childUrl, level + 1);
            }
        }
    }

    public void writeSiteMapDataToFile() throws FileNotFoundException {
        System.out.println("--------------");
        System.out.println("siteMap:");
        System.out.println(siteMap);

        System.out.println("--------------");
        System.out.println("FILENAME:");
        System.out.println(FILENAME);

        PrintWriter writer = new PrintWriter(FILENAME);

        writer.write(siteMap.toString());
        writer.flush();
        writer.close();
    }


    /* ----------------------------------------------------------------- */


    public class MyThread extends RecursiveTask<String> {
        Elements links;

        public MyThread(Elements links) {
            this.links = links;
        }

        @Override
        protected String compute() {

            /**
             * тут реализуем выполнение кода, при условии, что
             * поток разбит на трубуемое кол-во кусков
             */
            if (links.size() <= CORES_CPU) {
                for (Element link : links) {
                    url = link.absUrl("href");

                    if (isValidUrl(url) && !visitedUrls.contains(url)) {
                        addUrlToSiteMap(url, 1);
                        visitChildPages(url, 2);
                    }
                }
            }

            /**
             * тут разбиение потока на куски, после чего задача прогоняется
             * что то в виде рекурсии для примера, и выполняется уже
             * блок if, если поток разбили на достаточное кол-во кусков
             */
            else {
                List<Elements> subHTMLContentSiteLists = new ArrayList<>();
                int middle = links.size() / CORES_CPU;
                int startIndex = 0;
                int endIndex = middle;

                System.out.println("compute -> middle: " + middle);

                /**
                 * Добавляем разделенные на куски ссылки в
                 * наш subHTMLContentSiteLists -> ArrayList
                 *
                 * каждую итерацию мы startIndex присваиваем конечный кусок
                 * от ПРОШЛОЙ операции. И в это же время endIndex мы присваиваем
                 * кусок от следующей. Тем самым сдвигаем промежуток который уже
                 * был выполнен и который нужно выполнить
                 *
                 * те мы создаем тут ПОДсписки
                 */
                for (int i = 0; i < CORES_CPU - 1; i++) {
                    subHTMLContentSiteLists.add(new Elements(links.subList(startIndex, endIndex)));
                    startIndex = endIndex;
                    endIndex += middle;
                }

                /**
                 * Добавление последнего подсписка, который может быть больше,
                 * чем остальные подсписки в цикле for выше
                 */
                subHTMLContentSiteLists.add(new Elements(links.subList(startIndex, links.size())));

                /**
                 * Создание и запуск задач MyThread для каждого подсписка
                 * с использованием механизма Fork/Join Framework
                 *
                 * И вызываем compute() в каждом подсписке с
                 * использованием ForkJoinPool
                 *
                 * каждый кусок операции что выше мы записали в subHTMLContentSiteLists
                 * мы добавляем в task
                 *
                 * List<MyThread> tasks = new ArrayList<>(); - Использование параметризации
                 * List<MyThread> означает, что tasks является списком,
                 * содержащим объекты класса MyThread. В данном случае,
                 * tasks будет содержать экземпляры класса MyThread, созданные
                 * и запущенные для выполнения параллельных задач на разделенных подсписках.
                 */
                List<MyThread> tasks = new ArrayList<>();

                for (Elements sublist : subHTMLContentSiteLists) {
                    MyThread task = new MyThread(sublist);
                    tasks.add(task);

                    // запускаем ассинхронно
                    task.fork();
                }

                // Объедините результаты всех заданий
                for (MyThread task : tasks) {
                    task.join();
                }
            }

            return null;
        }
    }
}
