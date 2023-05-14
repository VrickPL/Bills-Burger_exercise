import java.util.Scanner;

public class SideItem {

    private int quantity;
    Scanner scanner = new Scanner(System.in);

    public void setQuantity() {
        System.out.println("How much do you want? ");
        System.out.print("Quantity: ");
        quantity = scanner.nextInt();
        System.out.println("");
    }

    public int getQuantity() {
        return quantity;
    }



    public String sideItemOrder(){
        System.out.println("Which side item do you want?");
        System.out.println("Press f-fries, n-nuts: ");
        return "0";
    }
}

class SmallSideItem extends SideItem{

    private double sideItemCost = 0;

    public double getSideItemCost() {
        return sideItemCost;
    }

    final double friesPrice = 2;
    final double nutsPrice = 1.5;

    @Override
    public String sideItemOrder() {
        super.sideItemOrder();
        while(true) {
            switch (scanner.nextLine().toLowerCase()) {
                case "f" -> {
                    setQuantity();
                    sideItemCost = getQuantity()*friesPrice;
                    return "Small fries";
                }
                case "n" -> {
                    setQuantity();
                    sideItemCost = getQuantity()*nutsPrice;
                    return "Small nuts";
                }
                default -> System.out.println("Enter a proper char!");
            }
        }
    }
}

class MediumSideItem extends SideItem{
    private double sideItemCost = 0;

    public double getSideItemCost() {
        return sideItemCost;
    }
    final double friesPrice = 2.5;
    final double nutsPrice = 2;

    @Override
    public String sideItemOrder() {
        super.sideItemOrder();
        while(true) {
            switch (scanner.nextLine().toLowerCase()) {
                case "f" -> {
                    setQuantity();
                    sideItemCost = getQuantity()*friesPrice;
                    return "Medium fries";
                }
                case "n" -> {
                    setQuantity();
                    sideItemCost = getQuantity()*nutsPrice;
                    return "Mediun nuts";
                }
                default -> System.out.println("Enter a proper char!");
            }
        }
    }
}

class LargeSideItem extends SideItem{
    private double sideItemCost = 0;

    public double getSideItemCost() {
        return sideItemCost;
    }
    final double friesPrice = 3;
    final double nutsPrice = 2.5;

    @Override
    public String sideItemOrder() {
        super.sideItemOrder();
        while(true) {
            switch (scanner.nextLine().toLowerCase()) {
                case "f" -> {
                    setQuantity();
                    sideItemCost = getQuantity()*friesPrice;
                    return "Large fries";
                }
                case "n" -> {
                    setQuantity();
                    sideItemCost = getQuantity()*nutsPrice;
                    return "Large nuts";
                }
                default -> System.out.println("Enter a proper char!");
            }
        }
    }
}