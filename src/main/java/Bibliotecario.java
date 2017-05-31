
import java.util.Scanner;

/**
 * Created by Fabrizio_p on 27/05/2017.
 */
public class Bibliotecario extends Afiliado {
    private String contrasena;
    public static int minContr = 6;
    public static int maxContr = 15;
    Scanner scanner = new Scanner(System.in);

    public Bibliotecario(String id, String nombre, String apellido, String tel, String direccion, String laContrasena) throws Exception {
        super(id, nombre, apellido, tel, direccion);

        setContrasena(laContrasena);

    }


    public void setContrasena(String contras) {
        while (contras.length() <= minContr || contras.length() > maxContr) {
            System.out.print("No se ha podido crear contraseña, reingrese");
            System.out.print("min 6 caracteres, max 15: ");
            this.contrasena = scanner.nextLine();
        }
        System.out.println("La contraseña se cambió exitosamente");
    }

}

