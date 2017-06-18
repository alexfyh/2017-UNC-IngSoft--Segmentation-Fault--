import java.util.HashMap;
import java.util.Map;
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
    public void porTipo( ){
        for(Item item : items.values()) {
            //if (is instanceof ))
        }
    }
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
}
