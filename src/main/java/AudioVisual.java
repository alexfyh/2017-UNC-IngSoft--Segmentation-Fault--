import java.util.Date;

/**
 * Created by David Lazos on 6/6/2017.
 */
public class AudioVisual extends Item{
    private int  duracionEnSegundos;


    public AudioVisual(String titulo, String autor, Date fechaPublicacion, Categoria categoria, int edicion, String editorial, int duracionEnSegundos){
        super(titulo, autor, fechaPublicacion, categoria);
        this.duracionEnSegundos=duracionEnSegundos;

    }


    public int getDuracionEnSegundos(){
        return duracionEnSegundos;
    }
    private String duracion(){
        return ""+duracionEnSegundos;

    }

    public boolean esIgual(Item item)
    {
        if(item  instanceof AudioVisual){
            if(this.titulo.equals(item.titulo)&&this.autor.equals(item.autor)&&this.fechaPubicacion.equals(item.fechaPubicacion)&&
                    this.categoria.equals(item.categoria)&&this.duracionEnSegundos==((AudioVisual) item).getDuracionEnSegundos()){
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
