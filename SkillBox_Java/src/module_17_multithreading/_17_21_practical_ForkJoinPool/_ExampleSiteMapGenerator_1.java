package module_17_multithreading._17_21_practical_ForkJoinPool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _ExampleSiteMapGenerator_1 {

    private final String SITE_URL = "https://proffurkom.ru/";
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

    public _ExampleSiteMapGenerator_1() throws IOException, InterruptedException {
        this.visitedUrls = new HashSet<>();
        this.siteMap = new StringBuilder();

        Document doc = getUrlParsing();
        generateSiteMap(doc);
    }

    /**/

    private Document getUrlParsing() {
        try {
            return Jsoup.connect(SITE_URL).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateSiteMap(Document doc) throws IOException, InterruptedException {
        // добавляем корневой адрес сайта
        visitedUrls.add(SITE_URL);

        // добавляем в siteMap - корневой сайт и разделитель
        siteMap.append(SITE_URL + System.lineSeparator());

        // ищем ссылки
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            url = link.absUrl("href");

            // отсекаем телефоны, ссылки итп && уже посещенные сайты
            if (isValidUrl(url) && !visitedUrls.contains(url)) {
                long startProgramExecution = System.currentTimeMillis();

                // добавляем в карту сайта ссылку
                addUrlToSiteMap(1);
                visitChildPages(url, 2);

                System.out.println("Время выполнения: " + (System.currentTimeMillis() - startProgramExecution) / 1_000 + " сек");
            }
        }

        writeSiteMapDataToFile();
        System.out.println(siteMap);
    }

    /**/

    private boolean isValidUrl(String url) throws IOException {
         return url.startsWith(SITE_URL) && !url.contains("#");
    }

    private void addUrlToSiteMap(int level) {
        for (int i = 0; i < level; i++) {
            siteMap.append("\t");
        }

        siteMap.append(childUrl).append(System.lineSeparator());
    }

    /**
     * выносим этот код в поток
     */
    private void visitChildPages(String url, int level) {
        try {
            Document doc = Jsoup.connect(url)
                .header("Accept", "*/*") // указываем ожидаемый тип контента
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .followRedirects(false)
                .referrer("https://google.com")
                .timeout(10_000)
                .get();

            visitedUrls.add(url);
            Elements links = doc.select("a[href]");

            // перебираем вообще все ссылки
            for (Element link : links) {
                // получаем только url
                childUrl = link.absUrl("href");
                // System.out.println("-> " + childUrl);

                /**
                 * получаем url которые содержат корневой url и проверяем
                 * содержит ли this.visitedUrls = new HashSet<>(); значение
                 * строки String childUrl = link.absUrl("href");
                 *
                 * те если встречается ссылки типа:
                 * -> https://skillbox.ru/games/
                 * => https://skillbox.ru/games/
                 *
                 * то, первый раз в visitedUrls будет добавлена строка
                 * https://skillbox.ru/games/, а при второй итерации
                 * произойдет проверка, и тк эта строка уже есть в visitedUrls
                 * то выполниться наше условие ниже
                 */
                if (isValidUrl(childUrl) && !visitedUrls.contains(childUrl) && level <= SEARCH_DEPTH) {
                    System.out.println("=> " + childUrl);

                    //addUrlToSiteMap(level);

                    // добавляем задержку перед подключением к следующей странице
                    Thread.sleep(1);
                    //visitChildPages(childUrl, level + 1);
                }
            }
        }
        catch (IOException e) {
             System.err.println("Error connecting to " + url + ": " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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

}
