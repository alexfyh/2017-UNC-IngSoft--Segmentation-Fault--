import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YepezHinostroza on 22/6/2017.
 */
public class PermisosBibliotecarioTest {
    BibliotecaModel model;

    @Before
    public void setUp()throws Exception{
        try {
            model = BibliotecaModel.getUniqueInstance();
            model.getPermisos().login(19004245, "yhyhyh", model);
            model.getPermisos().afiliar(1, "Fabrizio", "Perez", "12345", "Jesus Maria", model);
            model.getPermisos().afiliar(2, "David", "Lazos", "154456321", "Cba", model);
            model.getPermisos().afiliar(3, "Cristian", "Mellibosky", "04564567890", "CBA", model);
            model.getPermisos().afiliar(4, "Alex ", "Yepez Hinosttoza", "587943210", "Cordoba", model);
            model.getPermisos().afiliar(5, "Juli ", "Nonino", "123478956", "Cordoba", model);
            model.getPermisos().logout(model);
        }
        catch (Exception e){
            System.out.println("No pude ibnicializaer");
        }

    }

    @Test
    public  void login()throws Exception{
        try {
            assertTrue(model.getPermisos() instanceof PermisosAfiliado);
            assertFalse(model.getPermisos().login(19004245, "hyhyhy", model));
            assertTrue(model.getPermisos().login(19004245, "yhyhyh", model));
            assertTrue(model.getPermisos() instanceof PermisosBibliotecario);

        }
        catch(Exception e){
            model.getPermisos().logout(model);
        }

    }

    @After
    public  void logout()throws Exception{
       try {
           assertTrue(model.getPermisos().login(19004245, "yhyhyh", model));
           assertTrue(model.getPermisos().logout(model));
           assertTrue(model.getPermisos() instanceof PermisosAfiliado);
       }
       catch(Exception e){

       }
    }

    @Test
    public void prestar()  {
        model.getPermisos().login(19004245,"yhyhyh",model);
        //assertTrue(model.getPermisos());

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
        model.getPermisos().login(19004245,"yhyhyh",model);
        assertTrue(model.getPermisos().afiliar(93762652,"Franz","YH","4731540","Marti Garcia 116", model));
        assertEquals(7, model.getAfiliados().sizeRegistro());
        assertTrue(model.getPermisos().afiliar(10,"Fabri","Perez", "12345","Jesus Maria",model));
        assertEquals(8, model.getAfiliados().sizeRegistro());
        assertFalse(model.getPermisos().afiliar(1,"Fabri","Perez", "12345","Jesus Maria",model));

        assertEquals(8, model.getAfiliados().sizeRegistro());





    }

    @Test
    public void desafiliar() throws Exception {
        try {
            model.getPermisos().login(19004245, "yhyhyh", model);
            model.getPermisos().desafiliar(5, model);
            assertEquals(7, model.getAfiliados().sizeRegistro());
            model.getPermisos().desafiliar(10, model);
            assertEquals(6, model.getAfiliados().sizeRegistro());

        }catch (Exception e){

        }
    }

    @Test
    public void modPermisos() throws Exception {
        try{
            model.getPermisos().login(19004245, "yhyhyh", model);
            assertTrue(model.getPermisos().modPermisos(1,"contrasena",model));
            assertTrue(model.getAfiliados().getAfiliado(String.valueOf(1)) instanceof Bibliotecario);



        }
        catch(Exception e){}
    }

}