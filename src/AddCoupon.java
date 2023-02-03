import java.util.Scanner;
import coupon.coupon;
import helpers.randomIdGenerator;

public class AddCoupon {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cupon");
        String name = scanner.nextLine();
        // check if the discount name dont exist
        for (int i = 0; i < Main.coupons.length; i++) {
            if (Main.coupons[i] != null) {
                if (Main.coupons[i].getName().equals(name)) {
                    System.out.println("El nombre del cupon ya existe");
                    return;
                }
            }
        }
        System.out.println("Ingrese el descuento del cupon");
        double discount = scanner.nextDouble();
        // check if the discount is between 1 and 99
        while (discount < 1 || discount > 99) {
            System.out.println("El descuento debe ser entre 1 y 99");
            discount = scanner.nextDouble();
        }
        // create a new coupon
        String id = randomIdGenerator.generateId();
        // check if the id dont exist
        for (int i = 0; i < Main.coupons.length; i++) {
            if (Main.coupons[i] != null) {
                if (Main.coupons[i].getId().equals(id)) {
                    id = randomIdGenerator.generateId();
                    i = 0;
                }
            }
        }
        coupon newCoupon = new coupon(name, discount, id);
        // if the id dont exist add the coupon to the cart
        for (int i = 0; i < Main.coupons.length; i++) {
            if (Main.coupons[i] == null) {
                Main.coupons[i] = newCoupon;
                break;
            }
        }
    }
}
