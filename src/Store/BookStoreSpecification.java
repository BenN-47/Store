package Store;
public interface BookStoreSpecification {

    public double inventoryTotal(double inventoryTotal);

    public void restockProduct(int id, int newStock);

}