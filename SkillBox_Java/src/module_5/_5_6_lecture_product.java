package module_5;

// Задание 1
public class _5_6_lecture_product {
    private final String name;
    private final int price;
    private final String barCode;

    public _5_6_lecture_product(String name, int price, String barCode) {
        this.barCode = barCode;
        this.name = name;
        this.price = price;
    }

    /**/

    /**
     * изменение контстант будет осуществляться за счет создания нового
     * объекта класса, с передачей требуемых параметров
     */
    public _5_6_lecture_product setName(String name) {
        return new _5_6_lecture_product(name, price, barCode);
    }

    public _5_6_lecture_product setPrice(int price) {
        return new _5_6_lecture_product(name, price, barCode);
    }

    public _5_6_lecture_product setBarcode(String barCode) {
        return new _5_6_lecture_product(name, price, barCode);
    }

    /**/

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getBarCode() {
        return barCode;
    }

    /**/

    public String toString() {
        return name + " - " + price;
    }
}
