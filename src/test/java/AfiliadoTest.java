import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.Date;

public class AfiliadoTest {
    Afiliado cosme;
    Afiliado homero;

    @Before
    public void  inicio(){
        homero = Afiliado.newAfiliado("12345", "Homero J", "Simpsons", "6789", "Siempre Viva 123");



    }

    @Test
    public void createAfiliado() {
        homero = Afiliado.newAfiliado("12345", "Homero J", "Simpsons", "6789", "Siempre Viva 123");
        cosme = Afiliado.newAfiliado("1234", "Cosme", "Fulanito", "xyz", "siempre viva 123");
        cosme = Afiliado.newAfiliado("ABCD", "Cosme", "Fulanito", "456", "siempre viva 123");
        cosme = Afiliado.newAfiliado("", "Cosme", "Fulanito", "456", "siempre viva 123");
        cosme = Afiliado.newAfiliado(null, "Cosme", "Fulanito", "456", "siempre viva 123");
        assertNotEquals(null, homero);
        assertEquals(null, cosme);
    }


    @Test
    public void getId() {
        assertEquals(12345, homero.getId());
        assertNotEquals(4567, homero.getId());
        //assertEquals(null,cosme);
    }

    @Test
    public void getNombre() {
        assertEquals("Homero J", homero.getNombre());
    }

    @Test
    public void getApellido() {
        assertEquals("Simpsons", homero.getApellido());
        assertNotEquals("Simpsone", homero.getApellido());
    }

    @Test
    public void getTel() {
        assertEquals(6789, homero.getTel(),1);
        assertNotEquals(1234, homero.getTel());
    }

    @Test
    public void getDireccion() {
        assertEquals("Siempre Viva 123", homero.getDireccion());
    }

    @Test
    public void setNombre() {
        homero.setNombre("Cosme");
        assertEquals("Cosme", homero.getNombre());
        assertNotEquals("Homero", homero.getNombre());

    }

    @Test
    public void setApellido() {
        homero.setApellido("Fulanito");
        assertEquals("Fulanito", homero.getApellido());
        assertNotEquals("Simpsons", homero.getApellido());
    }

    @Test
    public void setTel() {
        try {
            homero.setTel("1515");
        } catch (Exception e) {

        }


        assertEquals(1515, homero.getTel(),1);
        assertNotEquals(6789, homero.getApellido());
        try {
            homero.setTel("15ABC");
        } catch (Exception e) {
        }
        assertEquals(1515, homero.getTel(),1);

    }

    @Test
    public void setDireccion() {
        homero.setDireccion("Calle sin numero");
        assertEquals("Calle sin numero", homero.getDireccion());
        assertNotEquals("Siempre Viva 123", homero.getDireccion());
    }

    @Test
    public void setFechaSuspension(){
        assertEquals(null,homero.getFechaSuspension());
        homero.setFechaSuspension(06,24);
        System.out.println(homero.getFechaSuspension());
        assertTrue(homero.getFechaSuspension().compareTo(new Date())>0);
        homero.setFechaSuspension(06,20);
        assertTrue(homero.getFechaSuspension().compareTo(new Date())<0);
        System.out.println(homero.getFechaSuspension());

        /*
        assertEquals((new Date()).getYear(),homero.getFechaSuspension().getYear());
        assertEquals(06,homero.getFechaSuspension().getMonth());
        assertEquals(22,homero.getFechaSuspension().getDay());*/

    }

}