package module_5;

// Задание 1
public class _5_4_lecture_product {
    private final String barCode;
    private final String name;
    private int price;

    public _5_4_lecture_product(String name, int price, String barCode) {
        this.barCode = barCode;
        this.name = name;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
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
