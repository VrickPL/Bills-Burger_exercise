import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MealOrder {
    private double totalCost = 0;

    public double getTotalCost() {
        return totalCost;
    }

    public void ordering(){
        Scanner scanner = new Scanner(System.in);

        String[] order = new String[50];
        int[] orderQuantity = new int[50];
        double[] orderCost = new double[50];
        int position = 0;

        boolean question = true;
        while(question) {
            if(position==0){
                System.out.println("Hi, do you want to order a basic set?");
            } else {
                System.out.println("Do you want to order a basic set?");
            }

            System.out.println("Press 'y' to say yes, or 'n' to say no: ");
            if (scanner.nextLine().toLowerCase().equals("y")) {
                System.out.println("===========================================");
                System.out.println("No. | Set                         | Price |");
                System.out.println("-------------------------------------------");
                System.out.println("[1] | Cheeseburger + cola + fries | $5.50 |");
                System.out.println("[2] | Hamburger + water + nuts    | $4.70 |");
                System.out.println("===========================================");
                System.out.println("");
                System.out.print("Enter number: ");
                int i = scanner.nextInt() - 1;
                scanner.nextLine();
                System.out.println("");
                while(i<0 || i>1){
                    System.out.println("Enter a proper number!");
                    System.out.println("===========================================");
                    System.out.println("No. | Set                         | Price |");
                    System.out.println("-------------------------------------------");
                    System.out.println("[1] | Cheeseburger + cola + fries | $5.50 |");
                    System.out.println("[2] | Hamburger + water + nuts    | $4.70 |");
                    System.out.println("===========================================");
                    System.out.println("");
                    System.out.print("Enter number: ");
                    i = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.println("");
                }
                System.out.print("Enter quantity: ");
                int q = scanner.nextInt();
                scanner.nextLine();
                if(q<1) q=1;
                System.out.println("");
                switch (i) {
                    case 0 -> {
                        order[position] = "Cheeseburger + cola + fries";
                        orderQuantity[position] = q;
                        orderCost[position] = q*5.50;
                        totalCost += orderCost[position];
                        position++;
                    }
                    case 1 -> {
                        order[position] = "Hamburger + water + nuts";
                        orderQuantity[position] = q;
                        orderCost[position] = q*4.70;
                        totalCost += orderCost[position];
                        position++;
                    }
                }


                System.out.println("Anything else?");
                System.out.print("Press 'y'-yes, 'n'-no: ");
                if(scanner.nextLine().toLowerCase().equals("n")){
                    question = false;
                }

                System.out.println("");


            } else {
                System.out.println("So, what do you want to order?");
                System.out.println("=============================");
                System.out.println("No. | Burger        | Price |");
                System.out.println("-----------------------------");
                System.out.println("[1] | Cheeseburger  | $3.00 |");
                System.out.println("[2] | Hamburger     | $2.70 |");
                System.out.println("=============================");
                System.out.println("");

                int setQuantity = scanner.nextInt() - 1;
                scanner.nextLine();


                while(setQuantity<0 || setQuantity>1){
                    System.out.println("Enter a proper number!");
                    System.out.println("What do you want to order?");
                    System.out.println("=============================");
                    System.out.println("No. | Burger        | Price |");
                    System.out.println("-----------------------------");
                    System.out.println("[1] | Cheeseburger  | $3.00 |");
                    System.out.println("[2] | Hamburger     | $2.70 |");
                    System.out.println("=============================");
                    System.out.println("");

                    setQuantity = scanner.nextInt() - 1;
                    scanner.nextLine();
                }
                System.out.print("Enter quantity: ");
                int burgersQuantity = scanner.nextInt();
                scanner.nextLine();
                if(burgersQuantity<1) burgersQuantity=1;
                System.out.println("");
                switch (setQuantity) {
                    case 0 -> {
                        order[position] = "Cheeseburger";
                        orderCost[position] = burgersQuantity*3.00;
                        orderQuantity[position] = burgersQuantity;
                        totalCost += orderCost[position];
                        position++;
                    }
                    case 1 -> {
                        order[position] = "Hamburger";
                        orderCost[position] = burgersQuantity*2.70;
                        orderQuantity[position] = burgersQuantity;
                        totalCost += orderCost[position];
                        position++;
                    }
                }


                System.out.println("Wanna customize?");
                System.out.print("Press 'y'-yes, 'n'-no: ");
                if (scanner.nextLine().toLowerCase().equals("y")) {
                    System.out.println("");
                    Burger burger = new Burger();
                    burger.burgerIngredians(burgersQuantity);

                    for(int j=0; j<burger.ingredians.length; j++){
                        if(burger.getIngrediantQuantity(j)>0){
                            order[position] = burger.getIngrediant(j);
                            orderQuantity[position] = burger.getIngrediantQuantity(j);
                            orderCost[position] = burger.ingrediantCost(j);
                            position++;
                        }
                    }

                    totalCost += burger.getTotalCost();
                }
                System.out.println("");
                System.out.println("");


                System.out.println("Anything to drink?");
                System.out.print("Press 'y'-yes, 'n'-no: ");
                if (scanner.nextLine().toLowerCase().equals("y")) {
                    System.out.println("");
                    System.out.println("Which size do you want?");
                    boolean drinkContinue = true;
                    while(drinkContinue) {
                        System.out.println("Press s-small, m-medium, l-large: ");
                        switch (scanner.nextLine().toLowerCase()) {
                            case "s" -> {
                                var drink = new SmallDrink();
                                order[position] = drink.drinkOrder();
                                orderCost[position] = drink.getDrinkCost();
                                orderQuantity[position] = drink.getQuantity();
                                position++;
                                totalCost += drink.getDrinkCost();
                                drinkContinue = false;

                            }
                            case "m" -> {
                                var drink = new MediumDrink();
                                order[position] = drink.drinkOrder();
                                orderCost[position] = drink.getDrinkCost();
                                orderQuantity[position] = drink.getQuantity();
                                position++;
                                totalCost += drink.getDrinkCost();
                                drinkContinue = false;
                            }
                            case "l" -> {
                                var drink = new LargeDrink();
                                order[position] = drink.drinkOrder();
                                orderCost[position] = drink.getDrinkCost();
                                orderQuantity[position] = drink.getQuantity();
                                position++;
                                totalCost += drink.getDrinkCost();
                                drinkContinue = false;
                            }
                            default -> System.out.println("Enter a proper char!");
                        }
                    }
                }
                System.out.println("");
                System.out.println("");


                System.out.println("Any side item?");
                System.out.print("Press 'y'-yes, 'n'-no: ");
                if (scanner.nextLine().toLowerCase().equals("y")) {
                    System.out.println("");
                    boolean sideItemContinue = true;
                    while(sideItemContinue) {
                        System.out.println("Press s-small, m-medium, l-large: ");
                        switch (scanner.nextLine().toLowerCase()) {
                            case "s" -> {
                                var sideItem = new SmallSideItem();
                                order[position] = sideItem.sideItemOrder();
                                orderCost[position] = sideItem.getSideItemCost();
                                orderQuantity[position] = sideItem.getQuantity();
                                position++;
                                totalCost += sideItem.getSideItemCost();
                                sideItemContinue = false;
                            }
                            case "m" -> {
                                var sideItem = new MediumSideItem();
                                order[position] = sideItem.sideItemOrder();
                                orderCost[position] = sideItem.getSideItemCost();
                                orderQuantity[position] = sideItem.getQuantity();
                                position++;
                                totalCost += sideItem.getSideItemCost();
                                sideItemContinue = false;
                            }
                            case "l" -> {
                                var sideItem = new LargeSideItem();
                                order[position] = sideItem.sideItemOrder();
                                orderCost[position] = sideItem.getSideItemCost();
                                orderQuantity[position] = sideItem.getQuantity();
                                position++;
                                totalCost += sideItem.getSideItemCost();
                                sideItemContinue = false;
                            }
                            default -> System.out.println("Enter a proper char!");
                        }
                    }
                }
                System.out.println("");
                System.out.println("");


                System.out.println("Anything else?");
                System.out.print("Press 'y'-yes, 'n'-no: ");
                if(!scanner.nextLine().toLowerCase().equals("y")) question = false;
                System.out.println("");
                System.out.println("");
            }
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        System.out.println("=".repeat(52));
        System.out.println("| Bills Burger restaurant " + " ".repeat(25) + "|");
        System.out.println("| " + dtf.format(now) + " ".repeat(30) + "|");
        System.out.println("|" + " ".repeat(50) + "|");
        System.out.println("| BILL" + " ".repeat(45) + "|");
        System.out.println("-".repeat(52));
        for(int i=0; i<order.length ; i++){
            if(order[i]!=null) System.out.printf("| - %-29s  | Q%-2d | $%-6.2f |\n", order[i], orderQuantity[i], orderCost[i]);
        }
        System.out.println("-".repeat(52));
        System.out.print("| TOTAL:" + " ".repeat(33));
        System.out.printf("| $%-6.2f |\n", getTotalCost());
        System.out.println("=".repeat(52));

    }
}

