
import java.util.Scanner;

/**
 * Created by Fabrizio_p on 27/05/2017.
 */
public class Bibliotecario extends Afiliado {
    private String contrasena;
    public static int minContr = 6;
    public static int maxContr = 15;


    public Bibliotecario(String id, String nombre, String apellido, String tel, String direccion, String laContrasena) throws Exception {
        super(id, nombre, apellido, tel, direccion);

        this.setContrasena(laContrasena);

    }


    public void setContrasena(String contras) throws Exception{
        if (contras.length() < minContr || contras.length() > maxContr) {
            throw new Exception("Contrasena no valida");

        }
        else{
            this.contrasena = contras;
        }
        //System.out.println("La contraseña se cambió exitosamente");
    }

    public  String getContrasena(){
        return contrasena;
    }


}

