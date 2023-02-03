package module_15_working_with_files_and_the_network._15_11_practical_DataCollector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParsingJSON {
    private LinkedHashMap<String, String> jsonArrayHash = new LinkedHashMap<>();
    private File file;

    /**/

    /**
     * парсим наш документ
     */
    public void parsingJsonToLinkedHashMap() {
        if (file.getName().toLowerCase().endsWith(".json")) {
            JSONParser parser = new JSONParser();

            try {
                JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

                for (Object itemArray : jsonArray) {
                    JSONObject person = (JSONObject) itemArray;
                    String name = (String) person.get("station_name");
                    String depth = (String) person.get("depth");

                    jsonArrayHash.put(name, depth);
                }

            }  catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(System.lineSeparator());
            consoleColorLog("file name JSON: " + file.getName());
        }
    }

    /**
     * вывести LinkedHashMap
     */
    public void printParsedJson() {
        for (Map.Entry entry : jsonArrayHash.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }

    /**
     * заносим данные в наш LinkedHashMap
     */
    public void setFile(File file) {
        this.file = file;
    }

    public LinkedHashMap<String, String> getJsonArrayHash() {
        return jsonArrayHash;
    }

    /**
     * цветная консоль вывода
     */
    private void consoleColorLog(String str) {
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_YELLOW + str + ANSI_RESET);
    }
}
