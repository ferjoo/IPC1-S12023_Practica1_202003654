import java.util.Scanner;
public class AddProduct {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto");
        String name = scanner.nextLine();
        System.out.println("Ingrese el precio del producto");
        double price = scanner.nextDouble();
        // create a new product
        System.out.println("Ingrese el id del producto");
        int id = scanner.nextInt();
        product newProduct = new product(name, price, id, 0);
        // if the id dont exist add the product to the cart
        for (int i = 0; i < Main.products.length; i++) {
            if (Main.products[i] == null) {
                Main.products[i] = newProduct;
                break;
            }
        }

    }
}
