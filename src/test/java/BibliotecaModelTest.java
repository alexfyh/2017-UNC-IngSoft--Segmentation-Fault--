import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public class BibliotecaModelTest {
    BibliotecaModel model;
    @Before
    public void setUp() throws Exception {
        model = BibliotecaModel.getUniqueInstance();


    }

    @Test
    public void getUniqueInstance() throws Exception {
        BibliotecaModel model2= BibliotecaModel.getUniqueInstance();
        assertTrue(model==model2);
    }

    @Test
    public void login(){
        try {
            model.login(19004245, "yhyhyh");
            assertTrue(model.getControlador() instanceof ControladorBibliotecario);
        }
        catch (Exception e){

        }

    }

    @Test
    public void logout() throws Exception {
        model.logout();
        assertTrue(model.getControlador() instanceof ControladorAfiliado);
        model.login(19004245,"yhyhyh");
        assertTrue(model.getControlador() instanceof ControladorBibliotecario);
        model.logout();
        assertTrue(model.getControlador() instanceof ControladorAfiliado);
    }

    @Test
    public void setDate(){
        int anio = 1990;
        int mes = 11;
        int dia = 06;
        model.setDate(anio,mes,dia);
        assertEquals(anio, model.getDate().getYear());
        assertEquals(mes, model.getDate().getMonth());
        assertEquals(dia, model.getDate().getDay());
    }
    @Test
    public void prestar(){


    }

}