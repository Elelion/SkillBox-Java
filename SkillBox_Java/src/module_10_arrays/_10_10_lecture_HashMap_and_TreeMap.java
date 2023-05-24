package module_10_arrays;

import java.util.HashMap;
import java.util.Scanner;

public class _10_10_lecture_HashMap_and_TreeMap {
    public _10_10_lecture_HashMap_and_TreeMap() {

        // указываем тип ключа и тип значения
        HashMap<String, Integer> good2count = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        for(;;) {
            String goodNameUserString = scanner.nextLine();
            System.out.println("goodNameUserString: " + goodNameUserString);

            if (goodNameUserString.equals("LIST")) {
                printHashMap(good2count);
                continue;
            }

            int count = 1;

            /**
             * если в good2count уже есть значение что мы вводим, то...
             * Для того, чтобы получить значение, мы должны передать в методы get()
             */
            if (good2count.containsKey(goodNameUserString)) {
                count = good2count.get(goodNameUserString) + 1;
            }

            good2count.put(goodNameUserString, count);
        }
    }

    /**
     * в данную конструкцию можно передавать и Treemap и HashMap
     * те это некое подобие интерфейсов... Вот такая вот хитрость
     */
    private static void printHashMap(HashMap<String, Integer> map) {
        for (String key : map.keySet()) {
            System.out.println(key + " => " + map.get(key));
        }
    }
}
