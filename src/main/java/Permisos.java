/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public interface Permisos {

    public void prestar(Afiliado afiliado, Ejemplar ejemplar);
    public void devolver(Ejemplar ejemplar); // ver si hace hace falta pasarle el afiliado

    public void setFecha(BibliotecaModel modelo);

    public void afiliar(Afiliado afiliado,RegistroAfiliados registro);
    public void desafiliar(Integer dni,RegistroAfiliados registro);
    public void modPermisos(Integer dni,RegistroAfiliados registro);

    public void agregarEjemplar(Ejemplar ejemplar,RegistroItems items);
    public void eliminarEjemplar(Integer IdEjemplar, RegistroItems items );

    public void consultarDisponibilida(Integer idItem,RegistroItems items);
    public void verInfo(Integer idItem);
    public void filtrarPorCategoria();




    public void logout();
    public void login(Integer dni, String password);

    // prestamo
    //login
    //logout

}
