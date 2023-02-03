package module_15_working_with_files_and_the_network._15_8_lecture_parsing_HTML_files;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ParsingHTML {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_15_working_with_files_and_the_network";
    private String pathLectureDir = "_15_8_lecture_parsing_HTML_files";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "code.html";

    public ParsingHTML() {
        String htmlFile = parseFile(DATA_FILE);

        /**
         * используем нашу библиотеку jsoup-1.15.3.jar из папки /lib в корне
         * Jsoup.parse - возвращает объект класса Document...
         * doc.select - возвращает Elements по указанному классу
         */
        Document doc = Jsoup.parse(htmlFile);
        Elements elements = doc.select("a.catalog-card__link");

        // вернет тег <a> со всем содержимым указанного класса
//        elements.forEach(System.out::println);

        // вернет текст который содержиться в каждом теге <a> указанного класса
        elements.forEach(element -> {
            System.out.println(element.text());
        });

        // вывести весь html файл
//        System.out.println(htmlFile);
    }

    public String parseFile(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return builder.toString();
    }
}
