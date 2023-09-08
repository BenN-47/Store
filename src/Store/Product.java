package Store;
public abstract class Product implements Comparable{

     private String name;
     private double price;
     private int stock;
     private boolean inStock;
     private int idNum;
    //Constructor
    public Product(String name, double price, int stock, boolean inStock, int idNum){

         this.name = name;
         this.price = price;
         this.stock = stock;
         this.inStock = inStock;
         this.idNum = idNum;
         
     }
     
    // Getters
    //@returns name
     public String getName(){
         return name;
     }
    //@returns price
     public double getPrice(){
         return price;
     }
    //@returns stock
     public int getStock(){
         return stock;
     }
    //@returns inStock
     public boolean getInStock(){
         return inStock;
     }
     //@returns idNum
     public int getidNum(){
         return idNum;
     }

    // Setters
    // sets stock to new param value
     public void setStock(int newStock){
         this.stock = newStock;
     }
     // removes 1 stock to indicate one of the item being purchased
    public int removeStock(){
         stock = stock -1;
         return stock;
     }


    // Display
    public void display(){
        System.out.println(name + " " + "Price: " + price + " " + "Stock: " + stock + " " + "InStock: " + inStock);
    }

    // Method that prints out Inventory in a format for "EndofDayInventory"
    public String printInfo(){
        return getidNum() + "," + getName() + "," + getStock() + "," + getPrice() + "," + getInStock();
    }
    // Compares price values
    public double compareTo(Product p){
        System.out.println(p.getPrice());
        if(this.getPrice() > p.getPrice())
            return 1;
        else if(this.getPrice() < p.getPrice())
            return -1;
        else{
            return 0;
        }
    }
}