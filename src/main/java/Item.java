import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by David Lazos on 6/6/2017.
 */
public abstract class Item {
    protected static int IdSiguiente=0;



    protected int idItem;
    protected String autor;
    protected String titulo;
    protected Date fechaPubicacion;
    protected Categoria categoria;
    protected List<Ejemplar> ejemplares;




    protected Item(String titulo,String autor,Date fechaPubicacion,Categoria categoria){
        this.idItem=IdSiguiente;
        Item.incrementarIdSiguiente();
        this.titulo=titulo;
        this.autor=autor;
        this.fechaPubicacion=fechaPubicacion;
        this.categoria=categoria;
        ejemplares = new ArrayList<Ejemplar>();
    }


    protected static void incrementarIdSiguiente(){
        IdSiguiente++;
    }

    public int getIdItem() {
        return idItem;
    }

    public String getAutor(){
        return this.autor;
    }

    public static int getIdSiguiente() {
        return IdSiguiente;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getFechaPubicacion() {
        return fechaPubicacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public abstract boolean esIgual(Item item);

    public int cantEjemplaes(){
        return ejemplares.size();
    }

    public int cantDisponibes(){
        int i=0;
        for(Ejemplar eje : ejemplares){
            if(eje.getEstado()==EstadoEjemplar.DISPONIBLE)
                i++;
        }
        return i;
    }

    public void enlistarEjemplar(Ejemplar ejemplar){
        // Verificar que el mismo ejemplar no se encoló previamente
        boolean encolado = false;
        for(Ejemplar ejem : ejemplares)
        {
            if(ejem.getIdEjemplar()==ejemplar.getIdEjemplar())
            {
                encolado=true;
            }
        }
        if(encolado==false)
        ejemplares.add(ejemplar);

    }
}
