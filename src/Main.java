import java.util.Scanner;
public class Main {
    public static product[] products = new product[100];
    public static product[] cart = new product[100];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("BIENVENIDO A LA TIENDA SUPER-25");
        // variable to control the main loop
        boolean exit = false;
        // invoke the login method
        boolean loggedIn = Login.main();
        // main loop
        while (!exit) {
            // check if the user is logged in
            if (loggedIn) {
                // invoke the main menu method
                MainMenu.main();
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Agregar nuevos productos");
                        // add new product
                        // invoke the add product method
                        AddProduct.main();
                        break;
                    case 2:
                        System.out.println("Agregar cupones de descuento");
                        break;
                    case 3:
                        System.out.println("Realizar venta");
                        // show products and prices and id
                        for (int i = 0; i < products.length; i++) {
                            if (products[i] != null) {
                                System.out.println(products[i].getId() + " - " + products[i].getName() + " - " + products[i].getPrice());
                            }
                        }
                        // ask for the id of the product to add to the cart
                        System.out.println("Ingrese el id del producto que desea agregar al carrito");
                        int id = scanner.nextInt();
                        // add the product to the cart
                        for (int i = 0; i < products.length; i++) {
                            if (products[i] != null) {
                                if (products[i].getId() == id) {
                                    for (int j = 0; j < cart.length; j++) {
                                        if (cart[j] == null) {
                                            cart[j] = products[i];
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        // show the products in the cart
                        for (int i = 0; i < cart.length; i++) {
                            if (cart[i] != null) {
                                System.out.println(cart[i].getId() + " - " + cart[i].getName() + " - " + cart[i].getPrice());
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Realizar reporte");
                        // show the products arranged by times sold
                        // bubble sort
                        for (int i = 0; i < products.length; i++) {
                            for (int j = 0; j < products.length - 1; j++) {
                                if (products[j] != null && products[j + 1] != null) {
                                    if (products[j].getTimesSold() < products[j + 1].getTimesSold()) {
                                        product temp = products[j];
                                        products[j] = products[j + 1];
                                        products[j + 1] = temp;
                                    }
                                }
                            }
                        }

                        break;
                    case 5:
                        System.out.println("Salir");
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } else {
                System.out.println("Usuario o contraseña incorrectos");
                loggedIn = Login.main();
            }
        }
    }
}