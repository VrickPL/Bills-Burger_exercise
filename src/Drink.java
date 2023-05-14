import java.util.Scanner;

public class Drink {

    private int quantity;
    Scanner scanner = new Scanner(System.in);

    public void setQuantity() {
        System.out.println("How much do you want? ");
        System.out.print("Quantity: ");
        quantity = scanner.nextInt();
    }

    public int getQuantity() {
        return quantity;
    }



    public String drinkOrder(){
        System.out.println("Which drink do you want?");
        System.out.println("Press c-cola, w-water: ");
        return "";
    }
}

class SmallDrink extends Drink{
    private double drinkCost;

    public double getDrinkCost() {
        return drinkCost;
    }

    final double colaPrice = 2;
    final double waterPrice = 1.5;

    @Override
    public String drinkOrder() {
        super.drinkOrder();
        while(true) {
            switch (scanner.nextLine().toLowerCase()) {
                case "c" -> {
                    setQuantity();
                    drinkCost = getQuantity()*colaPrice;
                    return "Small cola";
                }
                case "w" -> {
                    setQuantity();
                    drinkCost = getQuantity()*waterPrice;
                    return "Small water";
                }
                default -> System.out.println("Enter a proper char!");
            }
        }
    }
}

class MediumDrink extends Drink{
    private double drinkCost;

    public double getDrinkCost() {
        return drinkCost;
    }

    final double colaPrice = 2.5;
    final double waterPrice = 2;


    @Override
    public String drinkOrder() {
        super.drinkOrder();
        while(true) {
            switch (scanner.nextLine().toLowerCase()) {
                case "c" -> {
                    setQuantity();
                    drinkCost = getQuantity()*colaPrice;
                    return "Medium cola";
                }
                case "w" -> {
                    setQuantity();
                    drinkCost = getQuantity()*waterPrice;
                    return "Medium water";
                }
                default -> System.out.println("Enter a proper char!");
            }
        }
    }
}

class LargeDrink extends Drink{
    private double drinkCost;

    public double getDrinkCost() {
        return drinkCost;
    }

    final double colaPrice = 3;
    final double waterPrice = 2.5;

    @Override
    public String drinkOrder() {
        super.drinkOrder();
        while(true) {
            switch (scanner.nextLine().toLowerCase()) {
                case "c" -> {
                    setQuantity();
                    drinkCost = getQuantity()*colaPrice;
                    return "Large cola";
                }
                case "w" -> {
                    setQuantity();
                    drinkCost = getQuantity()*waterPrice;
                    return "Large water";
                }
                default -> System.out.println("Enter a proper char!");
            }
        }
    }
}
