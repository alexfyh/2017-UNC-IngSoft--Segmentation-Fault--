import java.util.Date;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public class BibliotecaModel {
    private Controlador controlador;
    private RegistroAfiliados afiliados;
    private RegistroItems items;
    private static BibliotecaModel UniqueInstance;
    private Date fechaActual;
    private List<Observer> observerList;

    public RegistroAfiliados getAfiliados(){

        return afiliados;
    }
    public RegistroItems getItems(){


        return items;
    }
    private BibliotecaModel() {
        afiliados = new RegistroAfiliados();
        items = new RegistroItems();
        controlador = new ControladorAfiliado();
        fechaActual = new Date();
        controlador = new ControladorAfiliado();
        observerList = new ArrayList<Observer>();
    }

    public static BibliotecaModel getUniqueInstance() {
        if (UniqueInstance == null) {
            BibliotecaModel.UniqueInstance = new BibliotecaModel();
            return UniqueInstance;
        } else {
            return UniqueInstance;
        }

    }



    public Controlador getControlador() {
        return controlador;
    }

    public void logout() {
        controlador = new ControladorAfiliado();
    }

    public void setDate(int anio, int mes, int dia) {
        this.fechaActual = new Date(anio, mes, dia);

        notifyObserver();
    }

    public Date getDate() {
        return this.fechaActual;
    }


    public boolean agregarRevista(String titulo, String autor, Date fechaPublicacion, Categoria categoria){
        try {
            Ejemplar revista = new EjemplarRevista(titulo, autor, fechaPublicacion, categoria);

            items.agregarEjemplar(revista);
            return true;
        }
        catch(Exception e){return false;}

    }
    public void registerObserver(Observer observer){
        observerList.add(observer);
    }

    public void removeObserver(Observer observer){
        int i = observerList.indexOf(observer);
        if (i >= 0) {
            observerList.remove(i);
        }
    }
    public void notifyObserver(){
        for(Observer o: observerList){
            o.update();
        }
    }



}
