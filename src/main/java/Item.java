import java.util.Date;

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




    protected Item(String titulo,String autor,Date fechaPubicacion,Categoria categoria){
        this.idItem=IdSiguiente;
        Item.incrementarIdSiguiente();
        this.titulo=titulo;
        this.autor=autor;
        this.fechaPubicacion=fechaPubicacion;
        this.categoria=categoria;
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
}
