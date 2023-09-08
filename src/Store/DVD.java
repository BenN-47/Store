package Store;
public class DVD extends Product{

    private String category;
    //Constructor
    public DVD(String name, double price, int stock, boolean inStock, String category, int idNum){
        
        super(name, price, stock, inStock, idNum);
        this.category = category;

    }
    //@returns Category
    public String getCategory(){
        return category;
    }
    // Displays The DVD Objects when into strings
    public String toString(){
        return "DVD: " + " " + this.getName() + " // Price: " + this.getPrice() + " // Genre: " + this.getCategory() + " // ID: " + this.getidNum();
    }
    // Method that prints out DVD Inventory in a format for "EndofDayInventory"
    public String printInfo(){
        return getidNum() + ","  + "DVD,"+ getName() + "," + getCategory() + "," + getStock() + "," + getPrice() + "," + getInStock();
    }
    //Displays the DVD Objects as a .display() method
    public void display(){
        System.out.println("DVD: " + this.getName() + " // " + "Price: " + this.getPrice() + " // " + "Stock: " + this.getStock() + " // " + "InStock: " + this.getInStock() + " // " + "Category: " + this.getCategory() + " // " + "ID: " + this.getidNum());
    }
}
