package module_15_working_with_files_and_the_network._15_11_practical_DataCollector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class ParsingSubwayFromWeb {
    private final String URL = "https://skillbox-java.github.io";
    private final LinkedHashMap<String, String> linesNameAndNumber = new LinkedHashMap<>();
    private final LinkedHashMap<String, String> stationsNameAndLine = new LinkedHashMap<>();

    /**/

    public ParsingSubwayFromWeb() throws IOException {
        Document doc = getUrlParsing();

        generateLines(doc);
        generateStations(doc);
    }

    /**/

    private Document getUrlParsing() throws IOException {
        return Jsoup.connect(URL).get();
    }

    private void generateLines(Document doc) {
        Elements lineElement = doc.select("div.js-toggle-depend");

        for (Element itemLn : lineElement) {
            String numberLn = itemLn.select("span").attr("data-line");
            String nameLn = itemLn.text();

            linesNameAndNumber.put(numberLn, nameLn);
        }
    }

    private void generateStations(Document doc) {
        Elements stationsElement = doc.select("div.js-metro-stations");

        for (Element itemSt : stationsElement) {
            String numberSt = itemSt.attr("data-line");
            String nameSt = itemSt.select("p.single-station").text();// + "|";// + System.lineSeparator() + "_endString" + System.lineSeparator();

            stationsNameAndLine.put(numberSt, nameSt);
        }
    }

    /**/

    public LinkedHashMap<String, String> getLines() {
        return linesNameAndNumber;
    }

    public LinkedHashMap<String, String> getStations() {
        return stationsNameAndLine;
    }
}
