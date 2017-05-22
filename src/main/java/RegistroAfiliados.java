import java.util.HashMap;
import java.util.Map;

/**
 * Created by YepezHinostroza on 22/5/2017.
 */
public class RegistroAfiliados {
    private Map<Integer, Afiliado> afiliados;

    public RegistroAfiliados(){
        afiliados = new HashMap<Integer, Afiliado>();
    }

    /*public void addAfiiado(Afiliado nuevo){
        afiliados.put(nuevo.getId(),nuevo);

    }*/
    public Afiliado getAfiliado(String id){
        try{
            Integer  ide = Integer.parseInt(id);
            return afiliados.get(ide);
        }
        catch(Exception e){
            return null;

        }


    }
    public void addAfiliado(String id, String nombre,String apellido, String tel, String direccion){
        Afiliado nuevo;
        try{
            nuevo = Afiliado.newAfiliado(id, nombre, apellido, tel, direccion);
            if(afiliados.containsKey(nuevo.getId())){
                System.out.println("Id ya en uso");
            }
            else{
                afiliados.put(nuevo.getId(),nuevo);
            }

        }
        catch(Exception e){
            System.out.println("No se pudo crear");

        }
    }

    public int sizeRegistro(){
        return afiliados.size();
    }




}
