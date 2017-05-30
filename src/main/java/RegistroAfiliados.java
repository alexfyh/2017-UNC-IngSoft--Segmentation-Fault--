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

    public void removeAfiliado(String id){
        try{
            int dni = Integer.parseInt(id);
            if(afiliados.containsKey(dni)){

                afiliados.remove(dni);
            }
            else{
                System.out.println("No corresponde a un afiliado existente");
            }

        }
        catch(Exception e){
            System.out.println("ID no valida");

        }
    }

    public void changeDatos(String id,String telefono, String direccion){
        Afiliado afiliado = this.getAfiliado(id);
        try{
            if(telefono.length()!=0)
                afiliado.setTel(telefono);

            if(direccion.length()!=0)
                afiliado.setDireccion(direccion);
        }
        catch (Exception e){
            System.out.println("No se modificaron todos los campos.");

        }
        



    }




}
