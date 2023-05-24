package module_8_numbers_and_dates;

public class _8_3_lecture_increment_and_decrement {
    public _8_3_lecture_increment_and_decrement() {
        // инкремент
        int inc = 1;
        inc++;

        // декремент
        int decr = 1;
        decr--;

        /**/

        // но принято писать i++ а не i = i + 1
        for (int i = 0; i < 10; i = i + 1) {
            System.out.println(i);
        }
        System.out.println('-');

        /**/

        char c = 'b';
        System.out.println(c);
        c++;
        System.out.println(c);
        System.out.println('-');

        /**/

        /**
         * Пост/пре инкремент/декремент - пост в начале происходит присваивание
         * переменной, а потом ее увеличение/уменьшение и присвоение новой
         * переменной (увеличенной или уменьшений) уже НЕ произойдет. пре - в
         * начале происходит увеличение/уменьшение, а только потом уже присваивание
         * переменной. Те присвоение произойдет уже увеличенной или
         * уменьшений переменной.
         */
        int prePost = 10;
        int post = prePost++;
        System.out.println(post + " - " + prePost); // 10 - 11

        int pre = ++prePost;
        System.out.println(pre + " - " + prePost); // 12 - 12
        System.out.println('-');

        /**/

        int x = 50;
        int value = x++ + ++x;
        System.out.println(value); // 102
    }
}
