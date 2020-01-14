package budgetmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Converter
 */
public class ShoppingList {

    // fields
    // add list of the elements user inputs
    private List<String> list;

    // list of prices taken from the list to calculate total
    private List<String> prices;

    // Total of price
    private double total;

    // constructor
    public ShoppingList() {
        list = new ArrayList<String>();
        prices = new ArrayList<String>();
        total = 0.0;
    }

    public void myShoppingList(Scanner in, String input) {

        // while user keeps typing until ctrl + c to stop program when finishing the
        // list
        while (in.hasNext()) {
            input = in.nextLine();

            // add every line user typed into list
            list.add(input);
        }

        convert();
        total();
        printList();
        printTotal();
    }

    // print elements in the list
    public void printList() {
        for (String string : list) {
            System.out.println(string);

        }

    }

    // print total price
    public void printTotal() {
        System.out.println("Total: $" + getTotal());

    }

    // convert method to get the prices from list
    private void convert() {

        // create empty string to store the new string
        String concat = "";

        // create the string from every elements in the list
        for (String string : list) {

            concat += string;
        }

        // replace everything that doesn't match this price pattern --> ($89.90) into
        // new String
        String num = concat.replaceAll("[^\\$0-9.]", "");

        // split the string into parts into an array that matches price pattern -->
        // ($89.90)
        String parts[] = num.split("(?=\\$[0-9.]+)");

        for (String string : parts) {

            // check if the parts matches the price pattern --> ($89.90) then add into the
            // prices
            // list

            if (Pattern.matches("\\$[0-9.]+", string)) {
                // replace the dollar sign with nothing to get only numbers
                prices.add(string.replace("$", ""));

            }
        }

    }

    // print the total
    private void total() {
        for (String string : prices) {
            total += Double.parseDouble(string);

        }

    }

    // getter
    public double getTotal() {
        return total;
    }

}
