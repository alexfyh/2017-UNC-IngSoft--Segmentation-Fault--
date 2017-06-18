import java.util.Date;

/**
 * Created by David Lazos on 6/6/2017.
 */
public class Libro extends Item{


    //private String autor;
    private int edicion;
    private String editorial;

    public Libro(String titulo, String autor,Date fechaPublicacion,Categoria categoria,int edicion,String editorial){
        super( titulo, autor, fechaPublicacion, categoria);
        this.edicion=edicion;
        this.editorial=editorial;
    }



    public int getEdicion() {
        return this.edicion;
    }

    public String getEditorial(){
        return this.editorial;
    }

    public boolean esIgual(Item item)
    {
        if(item  instanceof Libro){
            if(this.titulo.equals(item.titulo)&&this.autor.equals(item.autor)&&this.fechaPubicacion.equals(item.fechaPubicacion)&&
                    this.categoria.equals(item.categoria)&&this.edicion== ((Libro) item).getEdicion()&&this.editorial.equals(((Libro) item).getEditorial())){
                return true;
            }
            else{return false;}
        }
        else
        {
            return false;
        }
    }
}
