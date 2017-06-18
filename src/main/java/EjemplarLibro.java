import java.util.Date;

/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public class EjemplarLibro extends Ejemplar{



    public EjemplarLibro(String titulo, String autor, Date fechaPublicacion,Categoria categoria,int edicion,String editorial){
        Item libro = new Libro( titulo,  autor,  fechaPublicacion, categoria, edicion, editorial);
        this.setItem(libro);
        this.IdEjemplar = Ejemplar.EjemplarSig;
        Ejemplar.incrementarSiguiente();


    }




}
