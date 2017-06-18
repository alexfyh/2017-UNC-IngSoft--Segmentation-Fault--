import java.util.Date;

/**
 * Created by David Lazos on 6/6/2017.
 */
public class Tesis  extends Item{
    //private String autor;
    public Tesis(String titulo, String autor, Date fechaPublicacion, Categoria categoria){
        super( titulo, autor, fechaPublicacion, categoria);

    }
    public boolean esIgual(Item item)
    {
        if(item  instanceof Tesis){
             if(this.titulo.equals(item.titulo)&&this.autor.equals(item.autor)&&this.fechaPubicacion.equals(item.fechaPubicacion)&&
                     this.categoria.equals(item.categoria)){
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
