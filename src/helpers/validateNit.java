package helpers;
import java.util.Scanner;

public class validateNit {
    static Scanner scanner = new Scanner(System.in);
    // check if a nit was entered else return 'C/F'
    public static String validateNit() {
        System.out.println("Desea ingresar un nit? (s/n)");
        String answer = scanner.nextLine();
        if (answer.equals("s")) {
            System.out.println("Ingrese el nit");
            String nit = scanner.nextLine();
            return nit;
        } else {
            return "C/F";
        }
    }
}
