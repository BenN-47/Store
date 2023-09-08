package Store;
public class Member{
    
    private String name;
    private int numPurchases;
    private int memId;
    private boolean isPremiumMember;
    //Constructor
    public Member(String name, int numPurchases, int memId, boolean isPremiumMember){
        this.name = name;
        this.numPurchases = numPurchases;
        this.memId = memId;
        this.isPremiumMember = isPremiumMember;
    }
    //Getters
    //@returns name
    public String getName(){
        return name;
    }
    //@returns numPurchases
    public int getNumPurchases(){
        return numPurchases;
    }
    //@returns memID
    public int getMemId(){
        return memId;
    }
    //@returns isPremiumMember
    public boolean getisPremiumMember(){
        return isPremiumMember;
    }
    // Setters
    // Sets memID to param value1
    public void setMemId(int newMemId){
        this.memId = newMemId;
    }
    // Sets name to param value
    public void setName(String newName){
        this.name = newName;
    }
    // Sets numPurchases to param value
    public void setNumPurchases(int newNumPurchases){
        this.numPurchases = newNumPurchases;
    }
    // Sets isPremiumMember to param value
    public void setisPremiumMember(boolean isPremiumMember){
        this.isPremiumMember = isPremiumMember;
    }
    // ToString
    public String toString(){
        return "Name: " + name + " has Purchased " + numPurchases + " Items" +" " +  "ID: " + memId;
    }
    //displays Members as a Method
    public void display(){

        System.out.println(name + "Is a Premium Member with " + numPurchases + " purchases and has the id of " + memId);
        
    }
}