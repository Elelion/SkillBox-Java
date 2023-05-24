package module_18_efficiency._18_4_lecture_string_concatenation_duration;

public class StringConcatenationDuration {
    public StringConcatenationDuration() {
        long start = System.currentTimeMillis();
        String str = "";

        /**
         * При конкатенации строк каждый раз будет создаваться НОВАЯ строка
         * общей длинны равной сумме длины строки на предыдущей итерации и
         * добавляемой строки
         *
         * и с каждым разом время выполнения будет расти экспоненциально
         */
        for (int i = 0; i < 100_000; i++) {
            str += "some text some text some test";
        }

        System.out.println((System.currentTimeMillis() - start) + " ms");
        System.out.println("-");

        new StringBuilderConcatenation();
    }

    public class StringBuilderConcatenation {
        public StringBuilderConcatenation() {
            long start = System.currentTimeMillis();
            StringBuilder builder = new StringBuilder();

            /**
             * Собственно говоря это и есть самая простая оптимизация...
             * мы НЕ создаем каждый раз НОВЫЙ объект в памяти как это было
             * в примере со строкой выше, а просто добавляем в уже созданный
             * объект значения
             *
             * это в разы уменьшает расходы ресурсов ПК на выполнение программы
             */
            for (int i = 0; i < 100_000; i++) {
                builder.append("some text some text some test");
            }

            System.out.println(builder.toString().length());
            System.out.println((System.currentTimeMillis() - start) + " ms");
        }
    }
}
