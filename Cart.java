import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Cart {

    static HashMap<String, Product> shoppingCart = new HashMap<String, Product>();
    static double totalSalesTax = 0.0;
    static double totalPrice = 0.0;

    public Cart() {
        enterItems();
        printRecipt();
    }

    static void enterItems() {

        double itemSalesTax = 0.0;
        final double salesTax = 0.10;
        final double importTax = 0.05;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the items you would like to purchase.");

        while (scan.hasNextLine()) {
            String item = scan.nextLine();

            /* Keyword to break the loop and then print recipt */
            if (item.equals("Done Shopping")) {
                break;
            }

            /* Lines 34-51 parse the input String */
            boolean imported = false;
            if (item.contains("Imported") || item.contains("imported")) {
                imported = true;
            }

            String[] split = item.split(" at ");
            String firstSubString = split[0];
            String parts[] = firstSubString.split(" ", 2);

            int quantity = Integer.parseInt(parts[0]);
            String productName = parts[1];
            double price = Double.parseDouble(split[1]);

            /* Check if product is imported and add import tax if so */
            if (imported) {
                itemSalesTax += (price * importTax);
                totalSalesTax += (price * importTax);
            }

            /*
             * Check if product falls under any of the tax free items - if not add sales tax
             */
            if (productName.contains("Book") || productName.contains("Chocolate") || productName.contains("chocolate")
                    || productName.contains("headache")) {
            } else {
                itemSalesTax += (price * salesTax);
                totalSalesTax += (price * salesTax);
            }

            /* Rounds UP the tax to nearest 0.05 */
            itemSalesTax = (Math.ceil((itemSalesTax) * 20.0) / 20.0);

            /* Adjust price with tax added on and the total price */
            price = price + itemSalesTax;
            totalPrice += price;

            /*
             * HashMap to track reapeat products -using product name and price as the unique
             * key
             */
            String key = productName + price;

            if (shoppingCart.containsKey(key)) {
                Product prod = shoppingCart.get(key);
                prod.quantity++;
            } else {
                shoppingCart.put(key, new Product(price, productName, quantity, imported));
            }
            itemSalesTax = 0.0;
        }
    }

    /*
     * Loops through the HashMap and prints the product to 2 decimal places based on
     * Product toString method
     */
    static void printRecipt() {
        DecimalFormat df = new DecimalFormat("0.00");

        for (String name : shoppingCart.keySet()) {
            Product prod = shoppingCart.get(name);
            System.out.println(prod.toString());
        }
        System.out.println("Sales Taxes: " + df.format(Math.ceil((totalSalesTax) * 20.0) / 20.0));
        System.out.println("Total: " + df.format(Math.ceil((totalPrice) * 20.0) / 20.0));
    }

}
