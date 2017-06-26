/**
 * Created by YepezHinostroza on 17/6/2017.
 */
import java.util.Date;
import java.util.List;
public interface Controlador {


    public boolean login(int dni, String password, BibliotecaModel model);
    public boolean logout ( BibliotecaModel model);

    public boolean prestar(int idEjemplar, int dni,BibliotecaModel model);
    public boolean devolver(int  ejemplar,BibliotecaModel model);
    public boolean suspender(int dni,  int mes, int dia,BibliotecaModel model);

    public boolean setFecha(int year,int month, int day,BibliotecaModel modelo);

    public boolean afiliar(int dni, String nombre,String apellido, String telefono,String direccion,BibliotecaModel model);
    public boolean desafiliar(int dni,BibliotecaModel model);
    public boolean modPermisos(int dni,String password, BibliotecaModel model);
    public List<Afiliado> verAfiliados(BibliotecaModel modelo);
    public boolean modDatos(int id,String telefono,String direccion, BibliotecaModel model);

    public boolean agregarLibro(String titulo, String autor, String fechaPublicacion, Categoria categoria, int edicion, String editorial, BibliotecaModel modelo);
    public boolean agregarRevista(String titulo, String autor, String fechaPublicacion, Categoria categoria, BibliotecaModel modelo);
    public boolean agregarAudoVisual(String titulo, String autor, String fechaPublicacion, Categoria categoria,String edicion, String editorial, String duracion, BibliotecaModel modelo);
    public boolean agregarTesis(String titulo, String autor, String fechaPublicacion, Categoria categoria, BibliotecaModel modelo);

    public boolean borrarEjemplar(int id, BibliotecaModel modelo);
    public boolean darBaja( int id, BibliotecaModel modelo);
    public boolean setFecha(String fecha,BibliotecaModel model);
    public Date getFecha(BibliotecaModel modelo);
    public boolean getItem(int id,BibliotecaModel modelo);

    /*
    public void agregarEjemplar(Ejemplar ejemplar,RegistroItems items);

    public void eliminarEjemplar(int IdEjemplar, RegistroItems items );

    public void consultarDisponibilida(Integer idItem,RegistroItems items);
    public void verInfo(Integer idItem);
    public void filtrarPorCategoria();




    public void logout(BibliotecaModel model);


    // prestamo
    //login
    //logout
*/
}
