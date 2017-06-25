import java.util.Date;

/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public class EjemplarTesis extends Ejemplar{
    public EjemplarTesis(String titulo, String autor, Date fechaPublicacion,Categoria categoria){
        Item tesis = new Tesis( titulo,  autor,  fechaPublicacion, categoria);
        this.setItem(tesis);
        this.IdEjemplar = Ejemplar.EjemplarSig;
        this.estado= EstadoEjemplar.DISPONIBLE;
        Ejemplar.incrementarSiguiente();


    }

}
