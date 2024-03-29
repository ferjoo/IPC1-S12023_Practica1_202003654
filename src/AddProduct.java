import helpers.randomIdGenerator;
import java.util.InputMismatchException;

import java.util.Scanner;
public class AddProduct {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        try {
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
            String id = randomIdGenerator.generateId();
            // check if the id dont exist
            for (int i = 0; i < Main.products.length; i++) {
                if (Main.products[i] != null) {
                    if (Main.products[i].getId().equals(id)) {
                        id = randomIdGenerator.generateId();
                        i = 0;
                    }
                }
            }
            product newProduct = new product(name, price, id, 0);
            // add new product to the products array
            for (int i = 0; i < Main.products.length; i++) {
                if (Main.products[i] == null) {
                    Main.products[i] = newProduct;
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("El precio debe ser un numero, el producto no se agregó");
            scanner.next();
        }

    }
}
