import java.util.Scanner;
public class Login {
    public static boolean main(String username, String pass) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inicio de sesión tienda SUPER-25");
        System.out.println("Ingrese su usuario");
        String user = scanner.nextLine();
        System.out.println("Ingrese su contraseña");
        String password = scanner.nextLine();
        // check if the user and password are correct
        if (user.equals(username) && password.equals(pass)) {
            // return true if the user is logged in
            return true;
        } else {
            // return false if the user is not logged in
            return false;
        }
    }
}
