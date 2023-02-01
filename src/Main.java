import java.util.Scanner;
public class Main {
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
                        break;
                    case 2:
                        System.out.println("Agregar cupones de descuento");
                        break;
                    case 3:
                        System.out.println("Realizar venta");
                        break;
                    case 4:
                        System.out.println("Realizar reporte");
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