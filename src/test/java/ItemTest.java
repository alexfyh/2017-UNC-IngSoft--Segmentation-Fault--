import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YepezHinostroza on 16/6/2017.
 */
public class ItemTest {
    Item item1,item2,item3,item4;



    @Test
    public void incrementarIdSiguiente() {
        item1 = new Libro("El placer de cocinar a millhouse","Ms Krabapel",new Date(1990,10,10),Categoria.MEMES,19,"Springfield");
        assertEquals(1,Item.getIdSiguiente());
        item2 = new Revista("Voluptuosas 2017","Kun Aguero", new Date(2017,1,5),Categoria.AMBIENTAL);
        assertEquals(2,Item.getIdSiguiente());
        item3 = new AudioVisual("Taringa, los mejores gifs no porno del 2015","Fabrizio Perez", new Date(2015), Categoria.MEMES, 2,"Taringa!",600);
        assertEquals(3,Item.getIdSiguiente());
        item4 = new Libro("Como fichar bultos sin parecer gay","Malano",new Date(2016,10,10),Categoria.COMPUTACION,10,"Gay");
        assertEquals(4,Item.getIdSiguiente());
    }

    @Test
    public void getIdItem() {
    }

    @Test
    public void getAutor() {
    }

    @Test
    public void getIdSiguiente() {
    }

    @Test
    public void getTitulo() {
    }

    @Test
    public void getFechaPubicacion() {
    }

    @Test
    public void getCategoria() {
    }

    @Test
    public void esIgual() {
    }

}