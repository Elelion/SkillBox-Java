package module_10_arrays;

public class _10_4_lecture_arrays_of_arrays {
    public _10_4_lecture_arrays_of_arrays() {
        System.out.println("10.4 - 1 - заполнение по умолчанию массивов");

        /**
         * boolean - false по умолчанию
         * String - null по умолчанию
         *
         */
        boolean[] array = new boolean[5];
        System.out.println(array[0]);
        System.out.println("-");

        /**/

        System.out.println("10.4 - 2 - создаем массив массивов");
        int[][] studentsMarks = {
            {1, 2, 3, 4},
            {2, 3, 1},
            {7, 5, 1, 2, 3}
        };
        System.out.println(studentsMarks.length); // 3

        for (int i = 0; i < studentsMarks.length; i++) {
            // будет взята длинна каждого вложенного массива, 4, 3, 5...
            System.out.println("class " + i + " {" + studentsMarks[i].length + " students}");

            // печатаем их оценки, те в цикле мы бегаем уже по вложенному массиву
            for (int j = 0; j < studentsMarks[i].length; j++) {
                System.out.println("\t" + studentsMarks[i][j]) ;
            }
        }
    }
}
