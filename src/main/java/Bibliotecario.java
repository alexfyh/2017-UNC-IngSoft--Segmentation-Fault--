
import java.util.Scanner;

/**
 * Created by Fabrizio_p on 27/05/2017.
 */
public class Bibliotecario extends Afiliado{
    private String contraseña;
    public static int minContr = 6;
    public static int maxContr = 15;
    Scanner scanner = new Scanner (System.in);

    public Bibliotecario(String id, String nombre, String apellido, String tel, String direccion, String laContraseña) throws Exception {
        super(id, nombre, apellido, tel, direccion);

        setContraseña(laContraseña);

    }


    public void setContraseña(String contras){
        while (contras.length()<= minContr || contras.length() > maxContr){
            System.out.print("No se ha podido crear contraseña, reingrese") ;
            System.out.print("min 6 caracteres, max 15: ");
            this.contraseña = scanner.nextLine();
        }
        System.out.println("La contraseña se cambió con éxito");
    }

}

