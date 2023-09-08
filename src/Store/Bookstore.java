package Store;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Bookstore implements BookStoreSpecification{

    Scanner sc1 = new Scanner(System.in);

    ArrayList<Member> memberList = new ArrayList<Member>();
    ArrayList<Product> productList = new ArrayList<Product>();
    ArrayList<Product> cart = new ArrayList<Product>();

    public Bookstore(){}
     /* 
     Scan Inventory File and Put Into ArrayList for Usage 
     @returns void
     */
    public void generateInventory(){
        try{
            Scanner fileScanner = new Scanner(new File("C:\\Users\\benni\\Documents\\Store\\src\\EndofDayInventory.csv"));
            while(fileScanner.hasNext()){
                String lines = fileScanner.nextLine();

                if(lines.contains("Book")){
                    String[] bookArray = lines.split(",");
                    int id = Integer.parseInt(bookArray[0]);
                    int stock = Integer.parseInt(bookArray[4]);
                    String name = bookArray[2];
                    String author = bookArray[3];
                    double price = Double.parseDouble(bookArray[5]);
                    boolean inStock = Boolean.parseBoolean(bookArray[6]);
                    Book book = new Book(name,price,stock,inStock,author,id);
                    productList.add(book);
                }
                if(lines.contains("CD")){
                    String[] cdArray = lines.split(",");
                    int id = Integer.parseInt(cdArray[0]);
                    int stock = Integer.parseInt(cdArray[4]);
                    String name = cdArray[2];
                    String artist = cdArray[3];
                    double price = Double.parseDouble(cdArray[5]);
                    boolean inStock = Boolean.parseBoolean(cdArray[6]);
                    CD cd = new CD(name,price,stock,inStock,artist,id);
                    productList.add(cd);
                }
                if(lines.contains("DVD")){
                    String[] dvdArray = lines.split(",");
                    int id = Integer.parseInt(dvdArray[0]);
                    int stock = Integer.parseInt(dvdArray[4]);
                    String name = dvdArray[2];
                    String artist = dvdArray[3];
                    double price = Double.parseDouble(dvdArray[5]);
                    boolean inStock = Boolean.parseBoolean(dvdArray[6]);
                    DVD dvd = new DVD(name,price,stock,inStock,artist,id);
                    productList.add(dvd);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException ex) {
        System.out.println("Caught FileNotFoundException for outputData.txt: Try Again making sure the file name and path are correct");
    }
    }
    /* 
     Scan Members file and puts in to Arraylist called members
     @returns void
    */
    public void generateMembers(){
   
    try{
            Scanner memberScanner = new Scanner(new File("C:\\Users\\benni\\Documents\\Store\\src\\Members.txt"));
            while(memberScanner.hasNext()){
                String lines1 = memberScanner.nextLine();

                if(lines1.contains("false")){
                    String[] memberArray = lines1.split(",");
                    String name = memberArray[0];
                    int numPurchases = Integer.parseInt(memberArray[1]);
                    int memID = Integer.parseInt(memberArray[2]);
                    boolean isPremiumMember = Boolean.parseBoolean(memberArray[3]);
                    Member member = new Member(name, numPurchases, memID, isPremiumMember);
                    memberList.add(member);

                }
                 if(lines1.contains("true")){

                    String[] premiumMemberArray = lines1.split(",");
                    String name = premiumMemberArray[0];
                    int numPurchases = Integer.parseInt(premiumMemberArray[1]);
                    int memID = Integer.parseInt(premiumMemberArray[2]);
                    boolean isPremiumMember = Boolean.parseBoolean(premiumMemberArray[3]);
                    PremiumMember premiumMember = new PremiumMember(name, numPurchases,false, memID, isPremiumMember);
                    memberList.add(premiumMember);
                }
            }

            memberScanner.close();

        } catch (FileNotFoundException ex1) {
        System.out.println("Caught FileNotFoundException for outputData.txt: Try Again making sure the file name and path are correct");
    }
    }
    
    // Generates the list of the all the Books in productList @returns productList
    public ArrayList<Product> getBookInventory(){
        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i) instanceof Book){
                System.out.println(productList.get(i));
            }
        }
        return productList;
    }

    // Generates the list of the all the CDs in productList @returns productList
    public ArrayList<Product> getCDInventory(){
        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i) instanceof CD){
                System.out.println(productList.get(i));
            }
        }
        return productList;
    }

    // Generates the list of the all the DVDs in productList @returns productList
     public ArrayList<Product> getDVDInventory(){
        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i) instanceof DVD){
                System.out.println(productList.get(i));
            }
        }
        return productList;
    }

    // Generates the list of the all the members in memberList @returns memberList
    public ArrayList<Member> getMembersList(){
        for(int i = 0; i < memberList.size(); i++){
            if(memberList.get(i) instanceof Member){
                System.out.println(memberList.get(i).getName());
            }
        }
        return memberList;
    }
    
    // Generates the list of the all the Premium Members in memberList @returns memberList
    public ArrayList<Member> getPremiumMembersList(){
        for(int i = 0; i < memberList.size(); i++){
            if(memberList.get(i) instanceof PremiumMember){
                System.out.println(memberList.get(i).getName());
            }
        }
        return memberList;
    }

    // Adds new member to memberlist
    public void addNewMember(String name, int numPurchases, int newID){
        System.out.println("Please Enter your Name");
        name = sc1.next();
        System.out.println("Enter your number of Purchases");
        numPurchases = sc1.nextInt();
        System.out.println("Enter Your New ID Number");
        newID = sc1.nextInt();
        Member mem5 = new Member(name, numPurchases, newID, false);
        memberList.add(mem5);
        System.out.println(memberList);
    }

    // Allows the user to put it new amount of stock of a certain item
    public void restockProduct(int id, int newStock){
        System.out.println("What is the ID Number of the Item?");
        id = sc1.nextInt();
        System.out.println("How Much Total is the new Stock?");
        newStock = sc1.nextInt();
        for(int i = 0; i < productList.size(); i++){
            if (productList.get(i).getidNum() == id){
                productList.get(i).setStock(newStock);
            }
        }
    }

    // Prints Everything we have In Stock 
    public ArrayList<Product> showProductList(){
        for(int i = 0; i < productList.size(); i++){
            productList.get(i).display();
        }
        return productList;
    }

    // Calcualtes the total cost of everything in the store
    public double inventoryTotal(double inventoryTotal){
        inventoryTotal = 0;
        for(int i = 0; i < productList.size(); i++){
            inventoryTotal += productList.get(i).getPrice() * productList.get(i).getStock();
        }
        System.out.println("The Total for the Inventory is: " + inventoryTotal);
        return inventoryTotal;
    }

    // adds item to cart ArrayList
    public void addToCart(int bookNum){
        cart.add(productList.get(bookNum-1));
    }

    // Prints out everything in cart
    public ArrayList<Product> getCartInventory(){
        for(int i = 0; i < cart.size(); i++){
            cart.get(i).display();
        }
        return productList;
    }

    // Gets total amount in cart by adding all the prices of the items together
    public double checkoutTotal(){
        double total = 0;
        for(int i = 0; i < cart.size(); i++){
            total += cart.get(i).getPrice();
        }
        return total;
    }

    // Compares the price of all inventory
    public void compare(){
        for(int i = 0; i < productList.size(); i++){
            productList.get(i).compareTo(productList.get(i));
        }
    }

    // Gets an Input of an ID number and checks if you are a Premium Member 
    public ArrayList<Member> checkPremMember(){
        System.out.println("What is Your Member ID");
        int memberID = sc1.nextInt();
        for(int i = 0; i < memberList.size(); i++){
            if(memberList.get(i).getMemId() == memberID && memberList.get(i).getisPremiumMember() == true){
                System.out.println("You Are A Premium Member");
            }
            else if(memberList.get(i).getMemId() == memberID && memberList.get(i).getisPremiumMember() == false){
                System.out.println("You Are Not A Premium Member");
            }
        }
        return memberList;
    }

    // Allows the user to checkout and make documents of EndofDayInventory.csv and Info
    public String checkout(){
        System.out.println("Do you want to finish the transaction?: (y/n)");
        String checkout1 = sc1.next();
        if(checkout1.equals("y")){
        }
        else{
            System.out.println("Transaction Reset");
        }
        return checkout1;
    }
    // Removes 1 Stock once item is bought
    public int newStock(int index){
        productList.get(index).removeStock();
        return index;
    }
    // Writes New CSV File Called "End of Day Inventory" that shows all new inventory with new stock
    public void writeInventoryFile(){
        try{
    FileOutputStream fs1 = new FileOutputStream("EndofDayInventory.csv");
    PrintWriter outFS1 = new PrintWriter(fs1);

    outFS1.println("productID,type,title,author/artist,Stock,price");  

    for(int i = 0; i < productList.size(); i++){
        if(productList.get(i) instanceof Book){
            outFS1.println(productList.get(i).printInfo());
        }
        else if(productList.get(i) instanceof CD){
            outFS1.println(productList.get(i).printInfo());
        }
        else if(productList.get(i) instanceof DVD){
            outFS1.println(productList.get(i).printInfo());
        }
    }

    outFS1.close();
    fs1.close();
} catch (FileNotFoundException ex) {
        System.out.println("Caught FileNotFoundException for outputData.txt: Try Again making sure the file name and path are correct");
    } catch(IOException ex){
        System.out.println("Caught IOException when closing output stream. Try Again");
    }
    }

    // Writing The File that Shows What Was Bought, and New Members
    public void writeFile(){
        try{
    FileOutputStream fs = new FileOutputStream("Info");
    PrintWriter outFS = new PrintWriter(fs);
        outFS.println("The Items That were Purchased Today Are: " + 
        "\n=================================================================");
        for(int i = 0; i < cart.size(); i++){
            outFS.println(cart.get(i));
        }
        outFS.println("=================================================================");
        outFS.println("The Total Sales for Today is: " + checkoutTotal());
        if(memberList.size() > 5){
            outFS.println("New Members: ");
            for(int i = 5; i < memberList.size(); i++){
                outFS.println(memberList.get(i));

            }
        }
        else {
            outFS.println("No New Members were Added");
        }
        

    outFS.close();
    fs.close();
} catch (FileNotFoundException ex) {
        System.out.println("Caught FileNotFoundException for outputData.txt: Try Again making sure the file name and path are correct");
    } catch(IOException ex){
        System.out.println("Caught IOException when closing output stream. Try Again");
    }

}
}