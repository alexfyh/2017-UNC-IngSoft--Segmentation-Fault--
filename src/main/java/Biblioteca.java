/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public class Biblioteca {
    public static void main(String[] args) {
        BibliotecaModel modelo = BibliotecaModel.getUniqueInstance();

        Ventana ventana = new Ventana(  modelo);
        Ventana ventana2 = new Ventana(  modelo);


    }

}
