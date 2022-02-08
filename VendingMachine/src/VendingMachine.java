import java.util.*;

public class VendingMachine {
    private float runningBalance;
    Map<String, List<Integer>> items;
    VendingMachine(){
        runningBalance=0;
        items= new HashMap<>();
        initializeItems();
    }
    public void initializeItems(){
        items.put("Snickers", Arrays.asList(10,5));
        items.put("Coke",Arrays.asList(20,5));
    }

    public void insertDollars(int i){
        runningBalance+=i;
        System.out.println("Your Running balance is.."+runningBalance);
    }
    public void insertQuarters(int i){
        runningBalance = runningBalance +(float)(i*0.25);
        System.out.println("Your Running balance is.."+runningBalance);
    }
    public void insertDimes(int i){
        runningBalance =  (runningBalance +(float)(i*0.10));
        System.out.println("Your Running balance is.."+runningBalance);
    }
    public void insertNickels(int i){
        runningBalance =  (runningBalance +(float)(i*0.05));
        System.out.println("Your Running balance is.."+runningBalance);
    }
    public void purchase(String itemName,int quantity){
        if(items.containsKey(itemName)){
            List<Integer> details = items.get(itemName);
            int availableQuantity = details.get(1);
            int price = details.get(0);
            if(runningBalance >= price && quantity <= availableQuantity && quantity>0){
                    availableQuantity-=quantity;
                    runningBalance-=(price*quantity);
                    details = new ArrayList<>();
                    details.add(price);
                    details.add(availableQuantity);
                    items.put(itemName,details);
                    System.out.println(itemName + " purchased..");

                   // System
            }
            else{
                    System.out.println("Please check your Balance or Quantity");
            }
        }else{
            System.out.println("Item Doesn't Exists");
        }
        System.out.println("Your Running balance is.."+runningBalance);
    }

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.insertDollars(50);
        vm.purchase("Coke",1);
        vm.purchase("Snickers",3);
        vm.insertQuarters(100);
        vm.purchase("Snickers",2);
        vm.purchase("thump",1);
        vm.insertDimes(100);
        vm.purchase("Snickers",1);
        vm.insertNickels(100);
        vm.purchase("Coke",1);
    }
}
