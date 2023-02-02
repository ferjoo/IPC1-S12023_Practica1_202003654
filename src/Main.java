import coupon.coupon;

import java.util.Scanner;
public class Main {
    // array of products
    public static product[] products = new product[100];
    // array of products in the cart
    public static product[] cart = new product[100];
    // array of coupons
    public static coupon[] coupons = new coupon[100];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("BIENVENIDO A LA TIENDA SUPER-25");
        //variable for continue shopping
        boolean continueShopping = true;
        // variable to control the main loop
        boolean exit = false;
        // variable to continue adding coupons
        boolean continueAddingCoupons = true;
        // variable to continue adding products
        boolean continueAddingProducts = true;
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
                        // do while to continue adding products
                        do {
                            System.out.println("Agregar nuevos productos");
                            // invoke the add product method
                            AddProduct.main();
                            // ask if the user wants to continue adding products
                            System.out.println("Desea agregar otro producto? (s/n)");
                            String answer = scanner.next();
                            if (answer.equals("n")) {
                                continueAddingProducts = false;
                            }
                        } while (continueAddingProducts);
                        // show the products
                        for (int i = 0; i < products.length; i++) {
                            if (products[i] != null) {
                                System.out.println(products[i].getId() + " - " + products[i].getName() + " - " + products[i].getPrice());
                            }
                        }
                        break;
                    case 2:
                        // do white to continue adding coupons
                        do {
                            System.out.println("Agregar nuevos cupones");
                            // invoke the add coupon method
                            AddCoupon.main();
                            // ask if the user wants to continue adding coupons
                            System.out.println("Desea agregar otro cupon? (s/n)");
                            String answer = scanner.next();
                            if (answer.equals("n")) {
                                continueAddingCoupons = false;
                            }
                        } while (continueAddingCoupons);
                        // show the coupons
                        for (int i = 0; i < coupons.length; i++) {
                            if (coupons[i] != null) {
                                System.out.println(coupons[i].getId() + " - " + coupons[i].getName() + " - " + coupons[i].getDiscount());
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Realizar venta");
                        // do while to continue shopping
                        do {
                            // show products and prices and their index as the id
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
                            // ask if the user wants to continue shopping
                            System.out.println("Desea continuar comprando? (s/n)");
                            String answer = scanner.next();
                            if (answer.equals("n")) {
                                continueShopping = false;
                            }
                        } while (continueShopping);
                        // print the cart and the total price
                        double totalPrice = 0;
                        for (int i = 0; i < cart.length; i++) {
                            if (cart[i] != null) {
                                System.out.println(cart[i].getName() + " - " + cart[i].getPrice());
                                totalPrice += cart[i].getPrice();
                            }
                        }
                        System.out.println("Total: " + totalPrice);
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