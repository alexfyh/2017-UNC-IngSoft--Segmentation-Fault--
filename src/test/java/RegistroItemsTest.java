import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YepezHinostroza on 16/6/2017.
 */
class RegistroItemsTest {
    RegistroItems registro = new RegistroItems();
    Item item1,item2,item3,item4;
    @BeforeEach
    void setUp() {
        //RegistroItems registro = new RegistroItems();
         }

    /*@AfterEach
    void tearDown() {
    }*/

    @Test
    void addItem() {
        item1 = new Libro("El placer de cocinar a millhouse","Ms Krabapel",new Date(1990,10,10),Categoria.MEMES,19,"Springfield");
        item2 = new Revista("Voluptuosas 2017","Kun Aguero", new Date(2017,1,5),Categoria.AMBIENTAL);
        item3 = new AudioVisual("Taringa, los mejores gifs no porno del 2015","Fabrizio Perez", new Date(2015), Categoria.MEMES, 2,"Taringa!",600);
        item4 = new Libro("Como fichar bultos sin parecer gay","Malano",new Date(2016,10,10),Categoria.COMPUTACION,10,"Gay");

        assertEquals(0,registro.getRegistroCompleto().size());
        registro.addItem(item1);
        assertEquals(1,registro.getRegistroCompleto().size());

        registro.addItem(item2);
        assertEquals(2,registro.getRegistroCompleto().size());
        registro.addItem(item3);

        registro.addItem(item4);
       assertEquals(4,registro.getRegistroCompleto().size());
    }

    @Test
    void deleteItem() {
    }

    @Test
    void porTipo() {
    }

    @Test
    void buscarItem() {
    }

}