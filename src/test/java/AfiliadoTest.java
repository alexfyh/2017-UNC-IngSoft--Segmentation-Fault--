import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YepezHinostroza on 22/5/2017.
 */
class AfiliadoTest {
    Afiliado cosme;
    Afiliado homero;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        homero =  Afiliado.newAfiliado("12345","Homero J" ,"Simpsons","6789","Siempre Viva 123");

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
    @org.junit.jupiter.api.Test
    void createAfiliado() {

        cosme = Afiliado.newAfiliado("1234","Cosme","Fulanito","xyz","siempre viva 123");
        cosme = Afiliado.newAfiliado("ABCD","Cosme","Fulanito","456","siempre viva 123");
        cosme = Afiliado.newAfiliado("","Cosme","Fulanito","456","siempre viva 123");
        cosme = Afiliado.newAfiliado(null,"Cosme","Fulanito","456","siempre viva 123");
        assertNotEquals( null, homero);
        assertEquals(null,cosme);
    }


    @org.junit.jupiter.api.Test
    void getId() {
        assertEquals( 12345, homero.getId());
        assertNotEquals(4567,homero.getId());
        //assertEquals(null,cosme);
    }

    @org.junit.jupiter.api.Test
    void getNombre() {
        assertEquals("Homero J",homero.getNombre());
    }

    @org.junit.jupiter.api.Test
    void getApellido() {
        assertEquals("Simpsons",homero.getApellido());
        assertNotEquals("Simpsone",homero.getApellido());
    }

    @org.junit.jupiter.api.Test
    void getTel() {
        assertEquals(6789,homero.getTel());
        assertNotEquals(1234,homero.getTel());
    }

    @org.junit.jupiter.api.Test
    void getDireccion() {
        assertEquals("Siempre Viva 123",homero.getDireccion());
    }

    @org.junit.jupiter.api.Test
    void setNombre() {
        homero.setNombre("Cosme");
        assertEquals("Cosme",homero.getNombre());
        assertNotEquals("Homero",homero.getNombre());

    }

    @org.junit.jupiter.api.Test
    void setApellido() {
        homero.setApellido("Fulanito");
        assertEquals("Fulanito",homero.getApellido());
        assertNotEquals("Simpsons",homero.getApellido());
    }

    @org.junit.jupiter.api.Test
    void setTel() {
        try {
            homero.setTel("1515");
        }
        catch(Exception e){

        }
        assertEquals(1515,homero.getTel());
        assertNotEquals(6789,homero.getApellido());
        try{
            homero.setTel("15ABC");
        }
        catch (Exception e){
        }
        assertEquals(1515,homero.getTel());

    }

    @org.junit.jupiter.api.Test
    void setDireccion() {
        homero.setDireccion("Calle sin numero");
        assertEquals("Calle sin numero",homero.getDireccion());
        assertNotEquals("Siempre Viva 123",homero.getDireccion());
    }

}