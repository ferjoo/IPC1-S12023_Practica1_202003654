import java.util.Scanner;
import coupon.coupon;
public class AddCoupon {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cupon");
        String name = scanner.nextLine();
        System.out.println("Ingrese el descuento del cupon");
        double discount = scanner.nextDouble();
        // create a new coupon
        System.out.println("Ingrese el id del cupon");
        int id = scanner.nextInt();
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
