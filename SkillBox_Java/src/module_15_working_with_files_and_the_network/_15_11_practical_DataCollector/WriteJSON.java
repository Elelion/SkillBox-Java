package module_15_working_with_files_and_the_network._15_11_practical_DataCollector;

import org.apache.logging.log4j.core.util.JsonUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class WriteJSON {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_15_working_with_files_and_the_network";
    private String pathLectureDir = "_15_11_practical_DataCollector";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator;

    /**/

    public WriteJSON(
        LinkedHashMap<String, String> parsedSubwayLines,
        LinkedHashMap<String, String> parsedSubwayStations,
        LinkedHashMap<String, String> jsonFromFile
    ) {
        // раздел задания 5.1
        writeLinesPerStationsInJSON(parsedSubwayLines, parsedSubwayStations);

        // раздел задания 5.2
        writeStationsInfoJSON();


        JSONObject json = new JSONObject();

//        LinkedHashMap<String, String> name = new LinkedHashMap<>();
        LinkedHashMap<String, String> line = new LinkedHashMap<>();

        // номер линии и название линии - 11A Каховская линия
        for (Map.Entry<String, String> entry : parsedSubwayLines.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
//            System.out.println(key + " - " + value);

            // номер линии и список станций этой линии : 11A 1. Каховская 2. Варшавская 3. Каширская
            for (Map.Entry<String, String> entry2 : parsedSubwayStations.entrySet()) {
                String key2 = entry2.getKey();
                Object value2 = entry2.getValue();

                if (key == key2) {
                    String str = value2.toString();
                    String[] strings;

                    strings = str.split("\\d+.\\s");
                    LinkedHashMap<String, String> name = new LinkedHashMap<>();

                    for (String item : strings) {
                        System.out.println(item);
//                        name.put("name", item);

                        json.put("stations", item);
                    }

                }

//                System.out.println(key2 + " - " + value2);
            }

            for (Map.Entry<String, String> entry3 : jsonFromFile.entrySet()) {
                String key3 = entry3.getKey();
                Object value3 = entry3.getValue();

//                System.out.println(key3 + " - " + value3);
            }

        /*
        {
            "stations": [
              {
                    "name": "Название станции",
                    "line": "Название линии",
                    "date": "Дата открытия в формате 19.01.2005",
                    "depth": "Глубина станции в виде числа",
                    "hasConnection": "Есть ли на станции переход"
              },
             …
            ]
        }
         */
        }


        try (PrintWriter out = new PrintWriter(
            new FileWriter(DATA_FILE + "stations.json")
        )) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeLinesPerStationsInJSON(
        LinkedHashMap<String, String> parsedSubwayLines,
        LinkedHashMap<String, String> parsedSubwayStations
    ) {
        JSONObject json = new JSONObject();

        // номер линии и название линии - 11A Каховская линия
        for (Map.Entry<String, String> entry : parsedSubwayLines.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            // номер линии и список станций этой линии : 11A 1. Каховская 2. Варшавская 3. Каширская
            for (Map.Entry<String, String> entry2 : parsedSubwayStations.entrySet()) {
                String key2 = entry2.getKey();
                Object value2 = entry2.getValue();

                if (key == key2) {
                    String str = value2.toString();
                    String[] strings;

                    strings = str.split("\\d+.\\s");

                    json.put(key, List.of(
                        Arrays.stream(strings)
                            .filter(item -> !item.equals(""))
                            .collect(Collectors.toList())));
                }
            }
        }

        try (PrintWriter out = new PrintWriter(
            new FileWriter(DATA_FILE + "writeLinesPerStationsJSON.json")
        )) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeStationsInfoJSON() {

    }
}


// FIXME: Прочие наработки...
                /*
                for (String item : parsedSubwayStations) {
                    String str = item;
                    String station = str.substring(str.indexOf('-') + 2);


                    stationsArrayList.add(station);

                }
                 */

//            for (int i = 0; i < parsedSubwayStations.size(); i++) {
//                String str = parsedSubwayStations.get(i);
//                String line = str.substring(0, str.indexOf('-') - 1);
//                String station = str.substring(str.indexOf('-') + 2);
//
//                System.out.println(line);
////                if (line.equals("1")) {
////                    System.out.println(":::");
////                    break;
////                }
//            }


//            System.out.println(parsedSubwayLines);
//            System.out.println(parsedSubwayStations);
//            json.put("stationsssss", List.of("Mountain View", "Los Angeles", "New York"));
//            json.put("stations222", emp);

//            json.put("stations", List.of(linesPerStations));
//            json.put("name", "Google");
//            json.put("employees", 140000);

//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }