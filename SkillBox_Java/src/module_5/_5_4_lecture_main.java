package module_5;

public class _5_4_lecture_main {
    public static void main(String[] args) {

        // Задание №1
        _5_4_lecture_product product = new _5_4_lecture_product("Молоко", 4601162, "6pbp");
        product.setPrice(89);
        System.out.println("Название: " + product.getName());
        System.out.println("Цена: " + product.getPrice());
        System.out.println("Штрих-код: " + product.getBarCode());
        System.out.println("---");

        // Задание №2
        _5_4_lecture_book book = new _5_4_lecture_book(
                "Война и мир",
                "Л.Н.Толстой",
                1274,
                "978-0-1916-1254-1"
        );

        System.out.println("Название: " + book.getName());
        System.out.println("Автор: " + book.getAuthor());
        System.out.println("Кол-во страниц: " + book.getPagesCount());
        System.out.println("ISBN: " + book.getISBN());
        System.out.println("---");

        // 5.5 Передача по ссылке или по значению
        int a = 5;
        int b = a; // будет выделено новая область в ОЗУ
        a = a + 1;
        System.out.println(a);
        System.out.println(b);

        // в случае с объектами ситуация будет другая
        _5_4_lecture_product aObj = new _5_4_lecture_product("Milk", 56, "ttt55");
        _5_4_lecture_product bObj = aObj;

        aObj.setPrice(15);

        /**
         * в данном случае результат будет одинаковым, тк в случае с объектами
         * знак = не создает копию, а создает ссылку на тот же объект
         */
        System.out.println(aObj);
        System.out.println(bObj);
    }
}
