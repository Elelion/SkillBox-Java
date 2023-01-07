package module_5_objects_and_classes_Part_2;

public class _5_6_lecture_copying_objects {
    public void addProduct(_5_6_lecture_product product) {

        // добавляем копию в заказ и каждый заказ будет размещаться в новом участке ОЗУ
        _5_6_lecture_product copy = new _5_6_lecture_product(product.getName(), product.getPrice(), product.getBarCode());

        // если же написать так как ниже, то будет передаваться ссылка на объект
        _5_6_lecture_product ccopy = product;
    }


}
