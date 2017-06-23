import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by YepezHinostroza on 16/6/2017.
 */
public class RegistroItems {
    private Map<Integer,Item> items;


    public RegistroItems(){
        items = new HashMap<Integer,Item>();
    }

    public void addItem(Item item){
        items.put(item.getIdItem(),item);
    }
    public void deleteItem(int id){
        if(items.get(id)!=null){
            items.remove(id);
        }
        else{
            System.out.println("Item inexistente");
        }
    }
   /*public void porTipo( ){

        for(Item item : items.values()) {
            if (item  instanceof Class))
        }
    }*/
    public Item buscarItem(Item it){
        Item encontrado = null;
        for(Item item: items.values())
        {
            if(item.esIgual(it)){
                encontrado=item;
                break;

            }
        }
        return encontrado;
    }

    public void agregarEjemplar(Ejemplar ejemplar){
        if(buscarItem(ejemplar.getItem())!=null){

            Item registrado = buscarItem(ejemplar.getItem());
            ejemplar.setItem(registrado);
            registrado.enlistarEjemplar(ejemplar);

        }
        else{
            addItem(ejemplar.getItem());
            ejemplar.getItem().enlistarEjemplar(ejemplar);
        }

    }




    public Map<Integer,Item> getRegistroCompleto(){
        return items;
    }

    public List<Ejemplar> listarEjemplares(){
        List<Ejemplar> lista= new ArrayList<Ejemplar>();
        for( Item item: getRegistroCompleto().values())
        {
            for(Ejemplar ejem : item.ejemplares)
            {
                lista.add(ejem);
            }
        }
      return lista;
    }


    public void deleteEjemplar(int idEjemplar){
        Ejemplar borrado= null;
        Item it=null;
        try {

                for (Ejemplar ejem : listarEjemplares()) {
                    if (ejem.getIdEjemplar() == idEjemplar) {
                        it = ejem.getItem();
                        ejem.getItem().listaEjemplares().remove(ejem);
                        if(it.cantEjemplaes()==0){
                            getRegistroCompleto().remove(it.getIdItem());
                        }

                        return;

                    }
                }
        }
        catch(Exception e){}
    }

    public Ejemplar encontrarEjemplar(int Id){
        Ejemplar encontrado = null;
        for(Ejemplar ejemplar: listarEjemplares()){
            if(ejemplar.getIdEjemplar()==Id)
            {
                encontrado=ejemplar;

            }
        }
        return encontrado;
    }
}
