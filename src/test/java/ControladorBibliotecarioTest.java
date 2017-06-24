import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YepezHinostroza on 22/6/2017.
 */
public class ControladorBibliotecarioTest {
    BibliotecaModel model;

    @Before
    public void setUp()throws Exception{
        try {
            model = BibliotecaModel.getUniqueInstance();
            model.getControlador().login(19004245, "yhyhyh", model);
            model.getControlador().afiliar(1, "Fabrizio", "Perez", "12345", "Jesus Maria", model);
            model.getControlador().afiliar(2, "David", "Lazos", "154456321", "Cba", model);
            model.getControlador().afiliar(3, "Cristian", "Mellibosky", "04564567890", "CBA", model);
            model.getControlador().afiliar(4, "Alex ", "Yepez Hinosttoza", "587943210", "Cordoba", model);
            model.getControlador().afiliar(5, "Juli ", "Nonino", "123478956", "Cordoba", model);
            model.getControlador().logout(model);
        }
        catch (Exception e){
            System.out.println("No pude ibnicializaer");
        }

    }

    @Test
    public  void login()throws Exception{
        try {
            assertTrue(model.getControlador() instanceof ControladorAfiliado);
            assertFalse(model.getControlador().login(19004245, "hyhyhy", model));
            assertTrue(model.getControlador().login(19004245, "yhyhyh", model));
            assertTrue(model.getControlador() instanceof ControladorBibliotecario);

        }
        catch(Exception e){
            model.getControlador().logout(model);
        }

    }

    @After
    public  void logout()throws Exception{
       try {
           assertTrue(model.getControlador().login(19004245, "yhyhyh", model));
           assertTrue(model.getControlador().logout(model));
           assertTrue(model.getControlador() instanceof ControladorAfiliado);
       }
       catch(Exception e){

       }
    }

    @Test
    public void prestar()  {
        model.getControlador().login(19004245,"yhyhyh",model);
        //assertTrue(model.getControlador());

    }

    @Test
    public void devolver() {
    }

    @Test
    public void suspender() throws Exception {
    }

    @Test
    public void setFecha() throws Exception {
    }

    @Test
    public void afiliar(){
        model.getControlador().login(19004245,"yhyhyh",model);
        assertTrue(model.getControlador().afiliar(93762652,"Franz","YH","4731540","Marti Garcia 116", model));
        assertEquals(7, model.getAfiliados().sizeRegistro());
        assertTrue(model.getControlador().afiliar(10,"Fabri","Perez", "12345","Jesus Maria",model));
        assertEquals(8, model.getAfiliados().sizeRegistro());
        assertFalse(model.getControlador().afiliar(1,"Fabri","Perez", "12345","Jesus Maria",model));

        assertEquals(8, model.getAfiliados().sizeRegistro());





    }

    @Test
    public void desafiliar() throws Exception {
        try {
            model.getControlador().login(19004245, "yhyhyh", model);
            model.getControlador().desafiliar(5, model);
            assertEquals(7, model.getAfiliados().sizeRegistro());
            model.getControlador().desafiliar(10, model);
            assertEquals(6, model.getAfiliados().sizeRegistro());

        }catch (Exception e){

        }
    }

    @Test
    public void modPermisos() throws Exception {
        try{
            model.getControlador().login(19004245, "yhyhyh", model);
            assertTrue(model.getControlador().modPermisos(1,"contrasena",model));
            assertTrue(model.getAfiliados().getAfiliado(String.valueOf(1)) instanceof Bibliotecario);



        }
        catch(Exception e){}
    }

}