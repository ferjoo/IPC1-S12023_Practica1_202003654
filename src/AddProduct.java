import java.util.Scanner;
public class AddProduct {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto");
        String name = scanner.nextLine();
        System.out.println("Ingrese el precio del producto");
        double price = scanner.nextDouble();
        // create a new product
        // check the price is higher than 0
        while (price <= 0) {
            System.out.println("El precio debe ser mayor a 0");
            price = scanner.nextDouble();
        }
        System.out.println("Ingrese el id del producto");
        int id = scanner.nextInt();
        product newProduct = new product(name, price, id, 0);
        // check if the id already exists
        boolean idAlreadyExists = false;
        for (int i = 0; i < Main.products.length; i++) {
            if (Main.products[i] != null) {
                if (Main.products[i].getId() == id) {
                    idAlreadyExists = true;
                }
            }
        }
        // if the id dont exist add the product to the cart
        if (!idAlreadyExists) {
            for (int i = 0; i < Main.products.length; i++) {
                if (Main.products[i] == null) {
                    Main.products[i] = newProduct;
                    break;
                }
            }
        } else {
            System.out.println("Ya existe un producto con ese identificador");
        }

    }
}
