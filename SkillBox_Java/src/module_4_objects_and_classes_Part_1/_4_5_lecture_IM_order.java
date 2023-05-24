package module_4_objects_and_classes_Part_1;

public class _4_5_lecture_IM_order {
    private int count = 0;
    private int totalCost = 0;

    public void addProducts(int productCount, int cost) {
        count += productCount;
        totalCost += cost;
    }

    public int getProductsCount() {
        return count;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
