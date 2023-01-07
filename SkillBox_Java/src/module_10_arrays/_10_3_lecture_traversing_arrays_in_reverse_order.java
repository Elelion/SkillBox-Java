package module_10_arrays;

public class _10_3_lecture_traversing_arrays_in_reverse_order {
    public _10_3_lecture_traversing_arrays_in_reverse_order() {
        System.out.println("10.3 - 1 - перебираем массив - в обратном порядке");

        // ,? - занпятая может быть или не быть
        String text = "где желает знать знать Каждый Каждый охотник сидит фазан";
        String[] fazan = text.split(",?\\s");

        for (int i = fazan.length - 1; i >= 0; i--) {
             System.out.println(fazan[i]);
        }
        System.out.println("-");

        /**/

        System.out.println("10.3 - 2 - убираем последующие дубли в строке");

        for (int i = 0; i < fazan.length; i++) {

            // сравниваем текуший елемент с предыдущим
            if (i > 0 && fazan[i].equals(fazan[i - 1])) {
                continue;
            }

            System.out.println(fazan[i]);
        }
    }
}
