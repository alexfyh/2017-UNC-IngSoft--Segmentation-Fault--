import java.util.Date;

/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public class EjemplarAudioVisual extends Ejemplar {
    public EjemplarAudioVisual(String titulo, String autor, Date fechaPublicacion, Categoria categoria, int edicion, String editorial, int duracion){
        Item audio = new AudioVisual( titulo,  autor,  fechaPublicacion, categoria,edicion,editorial,duracion);
        this.setItem(audio);
        this.IdEjemplar = Ejemplar.EjemplarSig;
        Ejemplar.incrementarSiguiente();


    }
}
