import java.util.Scanner;

public class Burger {
    final double beefPrice = 2;
    final double veggiesPrice = 1.3;
    final double saucePrice = 0.5;
    final double baconPrice = 1;
    final double cheesePrice = 0.5;
    private double totalCost = 0;
    private int[] ingrediansQuantity = {0, 0, 0, 0, 0};
    final String[] ingredians = {"Beef", "Veggies", "Sauce", "Bacon", "Cheese"};


    public int getIngrediantQuantity(int index) {
        return ingrediansQuantity[index];
    }

    public String getIngrediant(int index) {
        return ingredians[index];
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getBeefPrice() {
        return beefPrice;
    }

    public double getVeggiesPrice() {
        return veggiesPrice;
    }

    public double getSaucePrice() {
        return saucePrice;
    }

    public double getBaconPrice() {
        return baconPrice;
    }

    public double getCheesePrice() {
        return cheesePrice;
    }

    public double ingrediantCost(int index){
        switch(index){
            case 0 -> {
                return getIngrediantQuantity(index) * getBeefPrice();
            }
            case 1 -> {
                return getIngrediantQuantity(index) * getVeggiesPrice();
            }
            case 2 -> {
                return getIngrediantQuantity(index) * getSaucePrice();
            }
            case 3 -> {
                return getIngrediantQuantity(index) * getBaconPrice();
            }
            case 4 -> {
                return getIngrediantQuantity(index) * getCheesePrice();
            }
            default -> System.out.println("");
        }
        return -1;
    }
    public void burgerIngredians(int burgersQuantity){
        Scanner scanner = new Scanner(System.in);
        System.out.println("============================");
        System.out.println("No. | Ingrediant   | Price |");
        System.out.println("----------------------------");
        System.out.printf("[1] | Beef          | %.2f |\n", beefPrice);
        System.out.printf("[2] | Veggies       | %.2f |\n", veggiesPrice);
        System.out.printf("[3] | Sauce         | %.2f |\n", saucePrice);
        System.out.printf("[4] | Bacon         | %.2f |\n", baconPrice);
        System.out.printf("[5] | Cheese        | %.2f |\n", cheesePrice);
        System.out.println("============================");
        System.out.println("Press 'e' to end customizing");
        System.out.println("Enter: ");
        boolean question = true;
        String order;
        while(question){
            order = scanner.nextLine();
            if(order.equals("1") || order.equals("2") || order.equals("3") || order.equals("4") || order.equals("5") || order.toLowerCase().equals("e")) {
                if (order.toLowerCase().equals("e")) {
                    question = false;
                } else {
                    switch (Integer.parseInt(order)) {
                        case 1 -> {
                            if(ingrediansQuantity[0]==3){
                                System.out.println("You can't add more than 3 " + ingredians[0].toLowerCase() + "!");
                            } else {
                                setTotalCost(totalCost + beefPrice);
                                ingrediansQuantity[0]++;
                                System.out.println(ingredians[0] + " added");
                            }

                        }
                        case 2 -> {
                            if(ingrediansQuantity[1]==3){
                                System.out.println("You can't add more than 3 " + ingredians[1].toLowerCase() + "!");
                            } else {
                                setTotalCost(totalCost + veggiesPrice);
                                ingrediansQuantity[1]++;
                                System.out.println(ingredians[1] + " added");
                            }

                        }
                        case 3 -> {
                            if(ingrediansQuantity[2]==3){
                                System.out.println("You can't add more than 3 " + ingredians[2].toLowerCase() + "!");
                            } else {
                                setTotalCost(totalCost + saucePrice);
                                ingrediansQuantity[2]++;
                                System.out.println(ingredians[2] + " added");
                            }

                        }
                        case 4 -> {
                            if(ingrediansQuantity[3]==3){
                                System.out.println("You can't add more than 3 " + ingredians[3].toLowerCase() + "!");
                            } else {
                                setTotalCost(totalCost + baconPrice);
                                ingrediansQuantity[3]++;
                                System.out.println(ingredians[3] + " added");
                            }

                        }
                        case 5 -> {
                            if(ingrediansQuantity[4]==3){
                                System.out.println("You can't add more than 3 " + ingredians[4].toLowerCase() + "!");
                            } else {
                                setTotalCost(totalCost + cheesePrice);
                                ingrediansQuantity[4]++;
                                System.out.println(ingredians[4] + " added");
                            }

                        }
                        default -> System.out.println("");
                    }
                }
            } else {
                System.out.println("Enter proper number or 'e' to exit");
            }
        }
    }
}
