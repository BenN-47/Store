package Store;
public class CD extends Product{
    
private String artist;
    //Constructor
    public CD(String name, double price, int stock, boolean inStock, String artist, int idNum){

        super(name, price, stock, inStock, idNum);
        this.artist = artist;

    }
    //@returns artist
    public String getArtist(){
        return artist;
    }
    
    // Displays The CD Objects when into strings
    public String toString(){
        return "CD: " + " " + this.getName() + " // Price: " + this.getPrice() + " // Artist: " + this.getArtist() + " // ID: " + this.getidNum();
    }

    // Method that prints out CD Inventory in a format for "EndofDayInventory"
    public String printInfo(){
        return getidNum() + "," + "CD,"+ getName() + "," + getArtist() + "," + getStock() + "," + getPrice() + "," + getInStock();
    }

    //Displays the CD Objects as a .display() method
    public void display(){
        System.out.println("CD: " + this.getName() + " // " + "Price: " + this.getPrice() + " // " + "Stock: " + this.getStock() + " // " + "InStock: " + this.getInStock() + " // " + "Artist: " + this.getArtist() + " // " + "ID: " + this.getidNum());
    }

}