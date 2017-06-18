import java.util.Date;

/**
 * Created by David Lazos on 6/6/2017.
 */
public class Revista extends Item{
    public Revista(String titulo, String autor, Date fechaPublicacion, Categoria categoria){
        super( titulo, autor, fechaPublicacion, categoria);

    }


    public boolean esIgual(Item item)
    {
        if(item  instanceof Revista){
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
