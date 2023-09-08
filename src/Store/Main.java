package Store;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {


    public static void main(String[] args) {

        var BookStore = new Bookstore();

        BookStore.generateInventory();
        BookStore.generateMembers();
        
        boolean isDone = false;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\n***** WELCOME TO BENS BOOKSTORE *****" +
                               "\n=====================================");

            while(isDone == false){
                
            System.out.println
            ("Please select which function you would like to do by typing in a number: \n" 
            + "1: Order a Book\n" 
            + "2: Order a CD\n"
            + "3: Order a DVD\n"
            + "4: Add a New Member\n"
            + "5: Check Your Cart\n" 
            + "6: Checkout\n"
            + "7. Cancel Order / Exit\n"
            + "***Staff Functions***\n"
            + "8: Restock Inventory\n"
            + "9: Display Inventory Total\n"
            + "10: Show All Inventory\n"
            + "11: Compare different items\n");
            
                try{
                int num = sc.nextInt();
                switch(num){
                    case 1:
                     System.out.println("These are the books we currently have in stock:");
                                    BookStore.getBookInventory();
                                    System.out.println("Please Enter the ID Number of the book you would like to purchase! Enter 0 if you would like to go back to the main menu.");
                                    int bookNum = sc.nextInt();
                                        switch (bookNum){
                                            case 1:
                                                System.out.println("Don Quixote has been added to your cart!");
                                                System.out.println("----------------------------------------");
                                                BookStore.addToCart(1);
                                                BookStore.newStock(0);
                                                break; 
                                            case 2:
                                                System.out.println("A Tale of Two Cities has been added to your cart!");
                                                System.out.println("-------------------------------------------------");
                                                BookStore.addToCart(2);
                                                BookStore.newStock(1);
                                                break;
                                            case 3:
                                                System.out.println("The Lord of the Rings has been added to your cart!");
                                                System.out.println("--------------------------------------------------");
                                                BookStore.addToCart(3);
                                                BookStore.newStock(2);
                                                break;
                                            case 0:
                                                break;
                                            default:
                                                System.out.println("Please Enter 1-4!");
                                            }
                                        break;
                    case 2:
                        System.out.println("These are the CD's we currently have in stock: ");
                        BookStore.getCDInventory();
                        System.out.println("Please Enter the ID Number of the CD you would like to purchase! Enter 0 if you would like to go back to the main menu.");
                                   int cdNum = sc.nextInt();
                                    switch (cdNum)     {
                                        case 4:
                                            System.out.println("Hotel California by Eagles has been added to your cart!");
                                            System.out.println("--------------------------------------------------------");
                                            BookStore.addToCart(4);
                                            BookStore.newStock(3);
                                            break;
                                        case 5:
                                            System.out.println("Thriller by Eagles has been added to your cart!");
                                            System.out.println("--------------------------------------------------------");
                                            BookStore.addToCart(5);
                                            BookStore.newStock(4);
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Please Enter a Number between 1-3");
                                            break;
                                        }                                      

                        break;
                    case 3:
                        System.out.println("These are the DVD's we currently have in stock: ");
                        BookStore.getDVDInventory();
                        System.out.println("Please Enter the ID Number of the DVD you would like to purchase! Enter 0 if you would like to go back to the main menu.");
                                    int dvdNum = sc.nextInt();
                                    switch (dvdNum){
                                       case 6:
                                            System.out.println("The Lion King has been added to your cart!");
                                            System.out.println("------------------------------------------");
                                            BookStore.addToCart(6);
                                            BookStore.newStock(5);
                                
                                            break;
                                       case 0:
                                            break;
                                       default:
                                            System.out.println("Please Enter a number between 1 - 2 ");
                                   }
                        break;
                    case 4:
                        BookStore.addNewMember("",0,0);
                        break;
                    case 5:
                        BookStore.getCartInventory();
                        break;
                    case 6:
                        BookStore.checkPremMember();
                        System.out.println("You Have These Items In Your Cart: ");
                        BookStore.getCartInventory();
                        System.out.println("Your Total is: " + BookStore.checkoutTotal());
                        BookStore.checkout();
                        BookStore.writeFile();
                        BookStore.writeInventoryFile();
                    case 7:
                        System.out.println("Have a Nice Day!");
                        isDone = true;
                        System.exit(0);
                        break;  
                    case 8:
                        BookStore.restockProduct(0,0);
                        break;
                    case 9:
                        BookStore.inventoryTotal(0.0);
                        break; 
                    case 10:
                        BookStore.showProductList();
                        break; 
                    case 11:
                        BookStore.compare();
                        break;
                    default:
                        System.out.println("Please Enter a Correct Number");
                        break;
                }
                }catch(InputMismatchException e){
                    System.out.println("\nPlease Enter A Number, NOT a Letter or Character");
                    sc.nextLine();
                } catch(Exception e){
                    System.out.println("Cannot Process Scanner");
                    System.exit(0);
                }
                }
        }

        }
        }                         
