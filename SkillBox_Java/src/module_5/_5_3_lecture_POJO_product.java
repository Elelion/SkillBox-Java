package module_5;

public class _5_3_lecture_POJO_product {
    /**
     * POJO классы (plain-old-Java-object - простой старый java объект) - объекты
     * которых выступают хранилищами разных данных те по сути это Data class.
     */

    private String name;
    private int price;

    public _5_3_lecture_POJO_product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**/

    public void setName(String name) {
        this.name = name;
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
}
