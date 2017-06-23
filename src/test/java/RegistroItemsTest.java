import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


import java.util.Date;



/**
 * Created by YepezHinostroza on 16/6/2017.
 */
public class RegistroItemsTest {
    RegistroItems registro = new RegistroItems();
    Item item1,item2,item3,item4,item5,item6,item7,item8;
    Ejemplar ejem1, ejem2,ejem3, ejem4;
    @Before
    public void inicializar() {
        ejem1 = new EjemplarLibro("El placer de cocinar a millhouse","Ms Krabapel",new Date(1990,10,10),Categoria.MEMES,19,"Springfield");
        ejem2 = new EjemplarRevista("Voluptuosas 2017","Kun Aguero", new Date(2017,1,5),Categoria.AMBIENTAL);
        ejem3 = new EjemplarAudioVisual("Taringa, los mejores gifs no porno del 2015","Fabrizio Perez", new Date(2015), Categoria.MEMES, 2,"Taringa!",600);
        ejem4 = new EjemplarLibro("Como fichar bultos sin parecer gay","Malano",new Date(2016,10,10),Categoria.COMPUTACION,10,"Gay");
        registro.agregarEjemplar(ejem1);
        registro.agregarEjemplar(ejem2);
        registro.agregarEjemplar(ejem3);
        registro.agregarEjemplar(ejem4);
        assertEquals(4,registro.getRegistroCompleto().size());

        /*
        item1 = new Libro("El placer de cocinar a millhouse","Ms Krabapel",new Date(1990,10,10),Categoria.MEMES,19,"Springfield");
        item2 = new Revista("Voluptuosas 2017","Kun Aguero", new Date(2017,1,5),Categoria.AMBIENTAL);
        item3 = new AudioVisual("Taringa, los mejores gifs no porno del 2015","Fabrizio Perez", new Date(2015,10,10), Categoria.MEMES, 2,"Taringa!",600);
        item4 = new Libro("Como fichar bultos sin parecer gay","Malano",new Date(2016,10,10),Categoria.COMPUTACION,10,"Gay");
        registro.addItem(item1);
        registro.addItem(item2);
        registro.addItem(item3);
        registro.addItem(item4);
        //RegistroItems registro = new RegistroItems();
        */
         }

    /*@AfterEach
    void tearDown() {
    }*/

    @Test
    public  void addItem() {
        Ejemplar ejemplar5, ejemplar6, ejemplar7, ejemplar8, ejemplar9;

        ejemplar5 = new EjemplarLibro("FPGA para todos y todas","Lazos",new Date(1990,10,10),Categoria.ELECTRONICA,2,"Brujas");
        registro.agregarEjemplar(ejemplar5);
        assertEquals(5, registro.getRegistroCompleto().size());  //verifica que si se agrega un nuevo ejemplar de un item inexistente, se agrega un nuevo item al registro

        ejemplar6 = new EjemplarLibro("FPGA para todos y todas","Lazos",new Date(1990,10,10),Categoria.ELECTRONICA,2,"Brujas");
        registro.agregarEjemplar(ejemplar6);
        assertEquals(5, registro.getRegistroCompleto().size());  //verifica que si se agrega un nuevo ejemplar de un item existente, no se agrega un nuevo item

        assertEquals(5, registro.getRegistroCompleto().size());

    }
    @Test
    public void agregarEjemplar(){

        Ejemplar ejemplar5, ejemplar6, ejemplar7, ejemplar8, ejemplar9;

        ejemplar5 = new EjemplarLibro("FPGA para todos y todas","Lazos",new Date(1990,10,10),Categoria.ELECTRONICA,2,"Brujas");
        ejemplar5.getItem();
        registro.agregarEjemplar(ejemplar5);
        Integer key = ejemplar5.getItem().getIdItem();
        assertEquals(1,registro.getRegistroCompleto().get(key).cantEjemplaes());

        registro.agregarEjemplar(ejemplar5);
        assertEquals(1,registro.getRegistroCompleto().get(key).cantEjemplaes()); //Verifica que no se puede enlistar el mismo ejemplar

        ejemplar6 = new EjemplarLibro("FPGA para todos y todas","Lazos",new Date(1990,10,10),Categoria.ELECTRONICA,2,"Brujas");
        registro.agregarEjemplar(ejemplar6);
        assertEquals(2,registro.getRegistroCompleto().get(key).cantEjemplaes()); //Ver que se aumenta la cantidad de ejemplares


    }
    @Test
    public void deleteItem() {

        //registro.getRegistroCompleto().remove()
    }
    @Test
    public void listaEjemplares() {
        assertEquals(4,registro.listarEjemplares().size());
        Ejemplar ejemplar5, ejemplar6;
        ejemplar5 = new EjemplarLibro("FPGA para todos y todas","Lazos",new Date(1990,10,10),Categoria.ELECTRONICA,2,"Brujas");
        registro.agregarEjemplar(ejemplar5);
        assertEquals(5,registro.listarEjemplares().size());
        ejemplar6 = new EjemplarLibro("FPGA para todos y todas","Lazos",new Date(1990,10,10),Categoria.ELECTRONICA,2,"Brujas");
        registro.agregarEjemplar(ejemplar6);
        assertEquals(6,registro.listarEjemplares().size());



        //registro.getRegistroCompleto().remove()
    }

    @Test
    public void borrarEjemplar() {
        Ejemplar ejemplar5, ejemplar6;
        ejemplar5 = new EjemplarLibro("FPGA para todos y todas","Lazos",new Date(1990,10,10),Categoria.ELECTRONICA,2,"Brujas");
        registro.agregarEjemplar(ejemplar5);
        assertEquals(5,registro.listarEjemplares().size());
        ejemplar6 = new EjemplarLibro("FPGA para todos y todas","Lazos",new Date(1990,10,10),Categoria.ELECTRONICA,2,"Brujas");
        registro.agregarEjemplar(ejemplar6);
        assertEquals(6,registro.listarEjemplares().size());
        registro.deleteEjemplar(ejemplar5.getIdEjemplar());
        assertEquals(5,registro.listarEjemplares().size());
        registro.deleteEjemplar(ejemplar6.getIdEjemplar());
        assertEquals(4,registro.getRegistroCompleto().size());
        registro.deleteEjemplar(ejem1.getIdEjemplar());
        assertEquals(3,registro.listarEjemplares().size());
        assertEquals(3,registro.getRegistroCompleto().size());

    }

    @Test
    public void buscarItem() {
    }

}