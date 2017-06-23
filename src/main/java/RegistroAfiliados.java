import java.util.HashMap;
import java.util.Map;

/**
 * Created by YepezHinostroza on 22/5/2017.
 */
public class RegistroAfiliados {
    private Map<Integer, Afiliado> afiliados;

    public RegistroAfiliados() {
        afiliados = new HashMap<Integer, Afiliado>();
        try {
            Bibliotecario admin = new Bibliotecario("19004245", "Alex", "YH", "4731540", "Obispo Ceballos", "yhyhyh");
            afiliados.put(admin.getId(),admin);
        }
        catch(Exception e)
        {

        }
    }

    /*public void addAfiiado(Afiliado nuevo){
        afiliados.put(nuevo.getId(),nuevo);

    }*/
    public Afiliado getAfiliado(String id) {
        try {
            Integer ide = Integer.parseInt(id);
            return afiliados.get(ide);
        } catch (Exception e) {
            return null;

        }
    }


    public void addAfiliado (String id, String nombre, String apellido, String tel, String direccion) throws Exception{
        Afiliado nuevo;
       // try {
            nuevo = Afiliado.newAfiliado(id, nombre, apellido, tel, direccion);
            if (afiliados.containsKey(nuevo.getId())) {
                throw new Exception();
            } else {
                afiliados.put(nuevo.getId(), nuevo);
            }

        //} catch (Exception e) {
            //System.out.println("No se pudo crear");

        //}
    }

    public int sizeRegistro() {
        return afiliados.size();
    }

    public void removeAfiliado(String id) throws Exception{
        try {
            int dni = Integer.parseInt(id);
            if (afiliados.containsKey(dni)) {

                afiliados.remove(dni);
            } else {
                throw new Exception("Error al remover afiliado");
            }

        } catch (Exception e) {
            throw new Exception("Error al remover afiliado");

        }
    }

    public void changeDatos(String id, String telefono, String direccion) {
        Afiliado afiliado = this.getAfiliado(id);
        try {
            if (telefono.length() != 0)
                afiliado.setTel(telefono);

            if (direccion.length() != 0)
                afiliado.setDireccion(direccion);
        } catch (Exception e) {
            System.out.println("No se modificaron todos los campos.");

        }
    }
    public Map<Integer,Afiliado> getRegistroAfiliados(){ return afiliados;}


}
