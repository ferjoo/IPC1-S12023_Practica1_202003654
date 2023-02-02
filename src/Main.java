import coupon.coupon;

import java.util.Scanner;
public class Main {
    // array of products
    public static product[] products = new product[100];
    // array of products in the cart including the quantity
    public static cartProduct[] cart = new cartProduct[100];
    // array of coupons
    public static coupon[] coupons = new coupon[100];
    //variable for continue shopping
    public static boolean continueShopping = true;
    // variable to control the main loop
    public static boolean exit = false;
    // variable to continue adding coupons
    public static boolean continueAddingCoupons = true;
    // variable to continue adding products
    public static boolean continueAddingProducts = true;
    // invoke the login method
    public static boolean loggedIn = Login.main();
    // scanner
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("BIENVENIDO A LA TIENDA SUPER-25");
        // main loop
        while (!exit) {
            // check if the user is logged in
            if (loggedIn) {
                // invoke the main menu method
                MainMenu.main();
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        addProducts();
                        break;
                    case 2:
                        addCoupons();
                        break;
                    case 3:
                        makeAPurchase();
                        break;
                    case 4:
                        showReports();
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
    static void addProducts() {
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
        System.out.println("Productos");
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i].getId() + " - " + products[i].getName() + " - " + products[i].getPrice());
            }
        }
    }
    private static void addCoupons() {
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
    }
    private static void makeAPurchase() {
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
            // ask the product to add to the cart
            System.out.println("Ingrese la cantidad del producto que desea agregar al carrito");
            int quantity = scanner.nextInt();
            // add the product to the cart
            for (int i = 0; i < products.length; i++) {
                if (products[i] != null) {
                    if (products[i].getId() == id) {
                        // check if the product is already in the cart
                        boolean productAlreadyInCart = false;
                        for (int j = 0; j < cart.length; j++) {
                            if (cart[j] != null) {
                                if (cart[j].getId() == id) {
                                    productAlreadyInCart = true;
                                    cart[j].setQuantity(cart[j].getQuantity() + quantity);
                                }
                            }
                        }
                        if (!productAlreadyInCart) {
                            for (int j = 0; j < cart.length; j++) {
                                if (cart[j] == null) {
                                    cart[j] = new cartProduct(products[i].getId(), products[i].getName(), products[i].getPrice(), quantity);
                                    break;
                                }
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
        System.out.println("Carrito");
        double totalPrice = 0;
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] != null) {
                System.out.println(cart[i].getId() + " - " + cart[i].getName() + " - " + cart[i].getPrice() + " - " + cart[i].getQuantity());
                totalPrice += cart[i].getPrice() * cart[i].getQuantity();
            }
        }
        System.out.println("Total: " + totalPrice);
        // ask if the user wants to apply a coupon
        System.out.println("Desea aplicar un cupon? (s/n)");
        String answer = scanner.next();
        if (answer.equals("s")) {
            // show the coupons and their index as the id
            for (int i = 0; i < coupons.length; i++) {
                if (coupons[i] != null) {
                    System.out.println(coupons[i].getId() + " - " + coupons[i].getName() + " - " + coupons[i].getDiscount());
                }
            }
            // ask for the id of the coupon to apply
            System.out.println("Ingrese el id del cupon que desea aplicar");
            int id = scanner.nextInt();
            // apply the coupon to the total price using percentage
            for (int i = 0; i < coupons.length; i++) {
                if (coupons[i] != null) {
                    if (coupons[i].getId() == id) {
                        totalPrice -= totalPrice * coupons[i].getDiscount() / 100;
                    }
                }
            }
            System.out.println("Total con descuento: " + totalPrice);

        }
    }
    private static void showReports() {
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
    }
}