import java.util.ArrayList;
import java.util.Scanner;

public class EcommerceCartSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Product> cart = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n----- E-Commerce Cart System -----");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Total Bill");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();
                    cart.add(new Product(name, price));
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Product Name to Remove: ");
                    String removeName = sc.nextLine();
                    boolean removed = false;

                    for (int i = 0; i < cart.size(); i++) {
                        if (cart.get(i).name.equalsIgnoreCase(removeName)) {
                            cart.remove(i);
                            removed = true;
                            System.out.println("Product removed successfully!");
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Product not found in cart.");
                    }
                    break;

                case 3:
                    System.out.println("\n----- Items in Cart -----");
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        for (Product p : cart) {
                            System.out.println(p.name + " - ₹" + p.price);
                        }
                    }
                    break;

                case 4:
                    double total = 0;
                    for (Product p : cart) {
                        total += p.price;
                    }
                    System.out.println("Total Bill: ₹" + total);
                    break;

                case 5:
                    System.out.println("Exiting... Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
