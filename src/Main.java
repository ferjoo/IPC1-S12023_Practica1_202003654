import coupon.coupon;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import helpers.validateNit;
import java.util.InputMismatchException;

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

        // main loop
        while (!exit) {
            // check if the user is logged in
            if (loggedIn) {
                System.out.println("BIENVENIDO A LA TIENDA SUPER-25");
                // invoke the main menu method
                MainMenu.main();
                // try catch to validate the option and retry if it's not valid
                try {
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
                            System.out.println("Gracias por usar la tienda Super-25");
                            exit = true;
                            break;
                        default:
                            System.out.println("Opcion invalida");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opcion invalida");
                    scanner.next();
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
            } else if (!answer.equals("s")) {
                System.out.println("Opcion invalida");
            } else {
                System.out.println("Opcion invalida");
            }
        } while (continueAddingProducts);
        // reset the variable
        continueAddingProducts = true;
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
            String id = scanner.next();
            // ask the product to add to the cart
            System.out.println("Ingrese la cantidad del producto que desea agregar al carrito");
            int quantity = scanner.nextInt();
            // add the product to the cart and check if the product is already in the cart or the id is valid
            for (int i = 0; i < products.length; i++) {
                if (products[i] != null) {
                    if (products[i].getId().equals(id)) {
                        // check if the product is already in the cart
                        boolean productAlreadyInCart = false;
                        for (int j = 0; j < cart.length; j++) {
                            if (cart[j] != null) {
                                if (cart[j].getId().equals(products[i].getId())) {
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
        // reset the variable
        continueShopping = true;
        printShoppingCart();
    }
    private static void showReports() {
        System.out.println("Reporte de prodcutos");
        // products array for sorting
        reportProduct[] productsTimesSold = new reportProduct[100];
        // check each product on products array and if the current product times sold is greater than the last product on productTimesSold array check the item above and if its higher check the next until the item is lower and insert the current product on that position
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                for (int j = 0; j < productsTimesSold.length; j++) {
                    if (productsTimesSold[j] == null) {
                        productsTimesSold[j] = new reportProduct(products[i].getName(), products[i].getTimesSold());
                        break;
                    } else {
                        if (products[i].getTimesSold() > productsTimesSold[j].getTimesSold()) {
                            for (int k = productsTimesSold.length - 1; k > j; k--) {
                                productsTimesSold[k] = productsTimesSold[k - 1];
                            }
                            productsTimesSold[j] = new reportProduct(products[i].getName(), products[i].getTimesSold());
                            break;
                        }
                    }
                }
            }
        }
        // print the products sorted by times sold
        for (int i = 0; i < productsTimesSold.length; i++) {
            if (productsTimesSold[i] != null) {
                System.out.println(productsTimesSold[i].getName() + " - " + productsTimesSold[i].getTimesSold());
            }
        }

    }
    private static void printShoppingCart() {
        double totalPrice = 0;
        double discountSelected = 0;
        // print the cart and the total price
        System.out.println("Carrito");
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] != null) {
                System.out.println(cart[i].getId() + " - " + cart[i].getName() + " - " + cart[i].getPrice() + " - " + cart[i].getQuantity());
                totalPrice += cart[i].getPrice() * cart[i].getQuantity();
            }
        }
        System.out.println("Total: " + totalPrice);
        // ask to confirm the purchase
        System.out.println("Desea realizar la compra? (s/n)");
        String answer = scanner.next();
        if (answer.equals("s")) {
            // ask if the user wants to apply a coupon
            System.out.println("Desea aplicar un cupon? (s/n)");
            String answerDiscount = scanner.next();
            if (answerDiscount.equals("s")) {
                // show the coupons and their index as the id
                for (int i = 0; i < coupons.length; i++) {
                    if (coupons[i] != null) {
                        System.out.println(coupons[i].getId() + " - " + coupons[i].getName() + " - " + coupons[i].getDiscount());
                    }
                }
                // ask for the id of the coupon to apply
                System.out.println("Ingrese el id del cupon que desea aplicar");
                String id = scanner.next();
                // apply the coupon to the total price using percentage
                for (int i = 0; i < coupons.length; i++) {
                    if (coupons[i] != null) {
                        if (coupons[i].getId().equals(id)) {
                            discountSelected = coupons[i].getDiscount();
                        }
                    }
                }
                System.out.println("Total con descuento: " + totalPrice);
            }
            printInvoice(totalPrice, discountSelected);
        } else {
            clearCart();
        }
    }
    private static void printInvoice(Double total, Double discount) {
        // print the invoice
        Double totalWithDiscount = total - ((total * discount)/100);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Ingrese su nombre");
        String name = scanner.next();
        // use the validateNit helper
        String nit = validateNit.validateNit();
        System.out.println("==================================");
        System.out.println("Factura");
        System.out.println("Factura afiliada a FEL");
        System.out.println("Tienda SUPER-25");
        System.out.println("Nit: "+ nit);
        System.out.println("Nombre: "+ name);
        System.out.println("Fecha: " + dateFormat.format(now));
        System.out.println("Productos");
        System.out.println("Id - Nombre - Precio - Cantidad");
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] != null) {
                System.out.println(cart[i].getId() + " - " + cart[i].getName() + " - " + cart[i].getPrice() + " - " + cart[i].getQuantity());
            }
        }
        System.out.println("Subtotal: " + total);
        if(discount > 0) {
            System.out.println("Descuento: " + discount);
        }
        System.out.println("Total: " + totalWithDiscount);
        System.out.println("Gracias por su compra");
        System.out.println("==================================");
        updateReport();
    }
    private static void updateReport() {
        System.out.println("Actualizando productos");
        // update the times sold of the products in the products array by the quantity of the product in the cart
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] != null) {
                for (int j = 0; j < products.length; j++) {
                    if (products[j] != null) {
                        if (products[j].getId().equals(cart[i].getId())) {
                            products[j].setTimesSold(products[j].getTimesSold() + cart[i].getQuantity());
                        }
                    }
                }
            }
        }
        clearCart();
    }
    private static void clearCart() {
        for (int i = 0; i < cart.length; i++) {
            cart[i] = null;
        }
    }
}