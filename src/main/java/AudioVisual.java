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
}
