import java.util.Date;

/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public class EjemplarRevista extends Ejemplar {

    public EjemplarRevista(String titulo, String autor, Date fechaPublicacion, Categoria categoria){
        Item revista  = new Revista( titulo,  autor,  fechaPublicacion, categoria);
        this.setItem(revista);
        this.IdEjemplar = Ejemplar.EjemplarSig;
        Ejemplar.incrementarSiguiente();

    }
}
