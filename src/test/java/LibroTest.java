import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;



/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public class LibroTest {
    @Test
    public void constructor() {
       Item item1 = new Libro("El placer de cocinar a millhouse","Ms Krabapel",new Date(1990,10,10),Categoria.MEMES,19,"Springfield");
       assertEquals(Item.getIdSiguiente(),item1.getIdItem()+1);
    }

}