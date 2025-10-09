import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CashRegister {


    public static class Product {
        private final int upc;
        private final String name;
        private final double price;

        public Product(int upc, String name, double price) {
            this.upc = upc;
            this.name = name;
            this.price = price;
        }

        public int getUpc() {
            return upc;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    private final Map<Integer, Product> productMap;
    private final List<Product> scannedItems;
    private double subtotal;


    public CashRegister() {
        productMap = new HashMap<>();
        scannedItems = new ArrayList<>();
        subtotal = 0.0;
        loadProducts();
    }


    private void loadProducts() {
        try {
            java.util.Scanner fileScanner = new java.util.Scanner(new File("products.txt"));
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    int upc = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    Product product = new Product(upc, name, price);
                    productMap.put(upc, product);
                }
            }
            fileScanner.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public Product addItem(int upc) {
        Product p = productMap.get(upc);
        if (p != null) {
            scannedItems.add(p);
            subtotal += p.getPrice();
        }
        return p;
    }


    public double getSubtotal() {
        return subtotal;
    }


    public List<Product> getScannedItems() {
        return new ArrayList<>(scannedItems);
    }
}
