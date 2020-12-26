import java.text.DecimalFormat;

class Product {

    String productType;
    int quantity;
    double price;
    boolean imported;

    public Product(double price, String productType, int quantity, boolean imported) {
        this.price = price;
        this.productType = productType;
        this.quantity = quantity;
        this.imported = imported;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");

        if (quantity > 1) {
            return productType + ": " + df.format(price * quantity) + " " + "(" + quantity + " " + "@" + " " + price
                    + ")";
        }
        return productType + ": " + df.format(price);
    }

}
