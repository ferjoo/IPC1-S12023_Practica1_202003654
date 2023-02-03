import java.util.Scanner;
import coupon.coupon;
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
        System.out.println("Ingrese el id del cupon");
        int id = scanner.nextInt();
        // check if the id dont exist
        for (int i = 0; i < Main.coupons.length; i++) {
            if (Main.coupons[i] != null) {
                if (Main.coupons[i].getId() == id) {
                    System.out.println("El id del cupon ya existe");
                    return;
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
