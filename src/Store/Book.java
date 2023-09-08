package Store;
public class Book extends Product{

    private String author;
    //Constructor
    public Book(String name, double price, int stock, boolean inStock, String author, int idNum){

        super(name, price, stock, inStock, idNum);
        this.author = author;

    }
    // @returns Author
    public String getAuthor(){
        return author;
    }
    
    // Displays The Book Objects when into strings
    public String toString(){
        return "Book: " + " " + this.getName() + " // By: " + this.getAuthor() + " // Price: " + this.getPrice() +  " // ID: " + this.getidNum();
    }

    // Method that prints out Book Inventory in a format for "EndofDayInventory"
    public String printInfo(){
        return getidNum() + ","  + "Book,"+ getName() + "," + getAuthor() + "," + getStock() + "," + getPrice() + "," + getInStock();
    }


    //Displays the Book Objects as a .display() method
    public void display(){
        System.out.println("Book: " + this.getName() + " // " + "Price: " + this.getPrice() + " // " + "Stock: " + this.getStock() + " // " + "InStock: " + this.getInStock() + " // " + "Author: " + this.getAuthor() + " // " + "ID: " + this.getidNum());
    }

}