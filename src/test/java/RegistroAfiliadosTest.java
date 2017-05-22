import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by YepezHinostroza on 22/5/2017.
 */
class RegistroAfiliadosTest {
    RegistroAfiliados registro;
    @BeforeEach
    void setUp() {
        registro = new RegistroAfiliados();
        registro.addAfiliado("12345","Homero J","Simpsons","6789","Siempre Viva 123");
        registro.addAfiliado("23456","Marge" ,"Simpsons","6789","Siempre Viva 123");
        registro.addAfiliado("34567","Lisa" ,"Simpsons","6789","Siempre Viva 123");
        registro.addAfiliado("98765","Bartolomeo" ,"Simpsons","6789","Siempre Viva 123");

    }

    @AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getAfiliado() {

        assertNotNull(registro.getAfiliado("12345"));
        assertNotNull(registro.getAfiliado("23456"));
        assertNotNull(registro.getAfiliado("34567"));
        assertNotNull(registro.getAfiliado("98765"));
        assertNull(registro.getAfiliado("43210"));
        assertNull(registro.getAfiliado("ABCD"));
    }

    @org.junit.jupiter.api.Test
    void addAfiliado() {
        //void addAfiliado(String id,String nombre, String apellido, String tel,String direccion )


        registro.addAfiliado("1234","Cosme","Fulanito","xyz","siempre viva 123");
        registro.addAfiliado("ABCD","Cosme","Fulanito","456","siempre viva 123");
        registro.addAfiliado("","Cosme","Fulanito","456","siempre viva 123");
        registro.addAfiliado(null,"Cosme","Fulanito","456","siempre viva 123");
        assertEquals(4,this.registro.sizeRegistro());
    }

}