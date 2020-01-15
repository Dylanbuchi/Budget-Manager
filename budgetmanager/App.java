package budgetmanager;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        // String input = "";

        // ShoppingList sl = new ShoppingList();

        // sl.myShoppingList(in, input);

        Menu menu = new Menu();
        menu.start(in);

    }
}