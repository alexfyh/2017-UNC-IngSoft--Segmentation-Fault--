import java.util.Date;
/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public class BibliotecaModel {
    private Controlador controlador;
    private RegistroAfiliados afiliados;
    private RegistroItems items;
    private static BibliotecaModel UniqueInstance;
    private Date fechaActual;

    public RegistroAfiliados getAfiliados(){
        return afiliados;
    }
    public RegistroItems getItems(){
        return items;
    }
    private BibliotecaModel() {
        afiliados = new RegistroAfiliados();
        items = new RegistroItems();
        controlador = new ControladorAfiliado();
        fechaActual = new Date();
        controlador = new ControladorAfiliado();
    }

    public static BibliotecaModel getUniqueInstance() {
        if (UniqueInstance == null) {
            BibliotecaModel.UniqueInstance = new BibliotecaModel();
            return UniqueInstance;
        } else {
            return UniqueInstance;
        }

    }

    public void login(int id, String password) throws Exception{

        Afiliado afiliado = afiliados.getAfiliado(String.valueOf(id));
        if (afiliado != null || password != null) {

            if (afiliado instanceof Bibliotecario) {
                if (((Bibliotecario) afiliado).getContrasena().equals(password))
                    controlador = new ControladorBibliotecario();
                else{
                    throw new Exception();
                }

            } else {
                throw new Exception();

            }

        } else {
            throw new Exception();
        }


    }

    public Controlador getControlador() {
        return controlador;
    }

    public void logout() {
        controlador = new ControladorAfiliado();
    }

    public void setDate(int anio, int mes, int dia) {
        this.fechaActual = new Date(anio, mes, dia);
    }

    public Date getDate() {
        return this.fechaActual;
    }


    public boolean agregarRevista(String titulo, String autor, Date fechaPublicacion, Categoria categoria){
        try {
            Ejemplar revista = new EjemplarRevista(titulo, autor, fechaPublicacion, categoria);

            items.agregarEjemplar(revista);
            return true;
        }
        catch(Exception e){return false;}

    }

}
