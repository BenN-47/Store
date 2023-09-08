package Store;
public class PremiumMember extends Member{

    private boolean hasPaidDues;
    //Constructor
    public PremiumMember(String name, int numPurchases, boolean hasPaidDues, int memId, boolean isPremiumMember){
        
        super(name,numPurchases,memId,isPremiumMember);
        this.hasPaidDues = hasPaidDues;

    }

    //@returns hasPaidDues
    public boolean getHasPaidDues(){
        return hasPaidDues;
    }
    
}