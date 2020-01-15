package budgetmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Menu
 */
public class Menu {

    private double balance;
    private List<Product> list = new ArrayList<Product>();
    private boolean exit = false;

    // add income into balance
    public void addIncome(Scanner in) {
        System.out.println("Enter income: ");

        int money = in.nextInt();

        balance += (double) money;

        System.out.println("Income was added!");

    }

    // create interaction
    public void start(Scanner in) {
        while (!exit) {

            showMenu(in);

        }

    }

    // show menu Actions
    public void showMenu(Scanner in) {

        System.out.println("Choose your action: ");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("0) Exit");

        menuOptions(in);

    }

    // options actions for menu
    public void menuOptions(Scanner in) {

        switch (in.nextLine()) {

        case "1":
            addIncome(in);

            break;
        case "2":
            addPurchase(in);

            break;
        case "3":
            showListOfProducts();

            break;
        case "4":
            showBalance();

            break;
        case "0":
            System.out.println("Bye!");
            exit = true;
            break;

        default:
            System.out.println("Error! Please enter a correct option");
            break;
        }

    }

    // show balance
    public void showBalance() {

        System.out.println("Balance: $" + getBalance());

    }

    // show sum of every purchase
    public void showTotal() {
        double total = 0.0;

        for (Product product : list) {
            total += product.getPrice();
        }
        System.out.println("Total sum: $" + total);

    }

    // show every products
    public void showListOfProducts() {
        if (list.isEmpty()) {
            System.out.println("Purchase list is empty");
            return;

        }

        for (Product product : list) {
            System.out.println(product.toString());

        }
        showTotal();

    }

    /// add new product to the list
    public void addPurchase(Scanner in) {

        System.out.print("Enter purchase name: ");
        String item = in.nextLine();

        System.out.print("Enter its price: ");
        double price = in.nextDouble();
        in.nextLine();

        list.add(new Product(item, price));

        balance -= price;

        System.out.println("Purchase was added!");

    }

    /**
     * @return the balance
     */
    public double getBalance() {

        return balance;
    }

}