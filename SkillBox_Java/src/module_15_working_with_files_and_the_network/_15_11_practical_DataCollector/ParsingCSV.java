package module_15_working_with_files_and_the_network._15_11_practical_DataCollector;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ParsingCSV {
    private List<String> lines = new ArrayList<>();
    private static LinkedHashMap<String, String> csvArrayHash = new LinkedHashMap<>();

    /**/

    /**
     * для более удобного восприятия, ниже приведенный код НЕ разноситься по
     * методам, и имеет 4 вложенности, что не есть хорошо!!!
     */
    public ParsingCSV(File file) {
        if (file.getName().toLowerCase().endsWith(".csv")) {
            String[] parsedLines;

            try {
                lines = Files.readAllLines(Paths.get(file.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            lines.remove(0);
            String name = "";
            String date = "";

            for (String line : lines) {

                parsedLines = line.split(",");
                name = parsedLines[0];
                date = parsedLines[1];
                csvArrayHash.put(name, date);
            }

            System.out.println(System.lineSeparator());
            consoleColorLog("file name CSV: " + file.getName());
            printParsedCsv();
        }
    }

    /**
     * цветная консоль вывода
     */
    private void consoleColorLog(String str) {
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_YELLOW + str + ANSI_RESET);
    }

    /**
     * вывести LinkedHashMap
     */
    private void printParsedCsv() {
        for (Map.Entry entry : csvArrayHash.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }
}
