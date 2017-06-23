/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public interface Permisos {

    public boolean login(int dni, String password, BibliotecaModel model);
    public boolean logout ( BibliotecaModel model);

    public boolean prestar(int idEjemplar, int dni,BibliotecaModel model);
    public boolean devolver(int  ejemplar,BibliotecaModel model);
    public boolean suspender(int dni,  int mes, int dia,BibliotecaModel model);

    public boolean setFecha(int year,int month, int day,BibliotecaModel modelo);

    public boolean afiliar(int dni, String nombre,String apellido, String telefono,String direccion,BibliotecaModel model);
    public boolean desafiliar(int dni,BibliotecaModel model);
    public boolean modPermisos(int dni,String password, BibliotecaModel model);

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
