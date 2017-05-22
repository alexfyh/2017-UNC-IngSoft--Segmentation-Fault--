import java.util.concurrent.ExecutionException;

/**
 * Created by YepezHinostroza on 21/5/2017.
 */
public class Afiliado {
    private int id;
    private String nombre;
    private String apellido;
    private int tel;
    private String direccion;

    public static Afiliado newAfiliado(String id, String nombre,String apellido, String tel, String direccion){
        Afiliado nuevo;
        try{
            nuevo = new Afiliado(id, nombre, apellido, tel, direccion);

        }
        catch (Exception e){
            System.out.println("No se ha podido crear el cliente");
            nuevo = null;
        }
        finally{

        }
        return nuevo;




    }
    private Afiliado(String id, String nombre,String apellido, String tel, String direccion) throws Exception{
           try {
               this.setId(id);
               this.setNombre(nombre);
               this.setApellido(apellido);
               this.setTel(tel);
               this.setDireccion(direccion);

           }
           catch(Exception e){
               throw new Exception();

        }

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getTel() {
        return tel;
    }

    public String getDireccion() {
        return direccion;
    }

    private void setId(String id) {                      // NO SE PUEDE MODIFICAR LA ID DESDE AFUERA

        this.id = Integer.parseInt(id);
        /*

        try{
            this.id = Integer.parseInt(id);
        }
        catch(NumberFormatException notInt){
            // còmo imprimir en pantalla que no es un nùmero?
            System.out.println(notInt.getMessage());
        }
        catch(NullPointerException pointerNull){
            // como informo por pantalla que era vacia la cadena
            System.out.println(pointerNull.getMessage());
            //throw (Exception; );
        }
        catch(Exception e){
            System.out.println("Telefono invalido");
        }*/

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTel(String tel) throws Exception{

        //this.tel = Integer.parseInt(tel);
        try{
            this.tel = Integer.parseInt(tel);
        }
        /*catch(NumberFormatException notInt){
            // còmo imprimir en pantalla que no es un nùmero?
            System.out.println(notInt.getMessage());
            throw ExecutionException
        }
        catch(NullPointerException pointerNull){
            // como informo por pantalla que era vacia la cadena
            System.out.println(pointerNull.getMessage());
            throw Exception ;
        }*/
        catch(Exception e){
            System.out.println("No se pudo establecer  el telefono");
            throw new Exception();
        }

    }

    public void setDireccion(String direccion) {
        try{
            this.direccion = direccion;
        }
        catch (NullPointerException pointerNull){
            System.out.println(pointerNull.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
