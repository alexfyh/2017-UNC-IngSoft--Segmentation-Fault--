/**
 * Created by YepezHinostroza on 17/6/2017.
 */
import java.util.List;
import java.util.ArrayList;
public class ControladorBibliotecario implements Controlador {



    public boolean login (int dni, String password, BibliotecaModel model) {

        try {
            model.login(dni, password);
            return true;
        }
        catch (Exception e){
            return  false;
        }

    }

    public boolean logout ( BibliotecaModel model){

        try {
            model.logout();
            return true;
        }
        catch (Exception e){

        }
        return false;
    }



    public boolean prestar(int idEjemplar, int dni,BibliotecaModel model) {

        RegistroAfiliados afiliados = model.getAfiliados();
        RegistroItems items = model.getItems();
        try {
            if (afiliados.getAfiliado(String.valueOf(dni)) != null && items.encontrarEjemplar(idEjemplar) != null) {
                Afiliado afiliado= afiliados.getAfiliado(String.valueOf(dni));
                Ejemplar ejemplar = items.encontrarEjemplar(idEjemplar);
                if (afiliado.getCantPrestada() <= Afiliado.PrestamoMax&&(afiliado.fechaSuspension==null || afiliado.fechaSuspension.compareTo(model.getDate())<0)|| ejemplar.getEstado()==EstadoEjemplar.DISPONIBLE) {
                    afiliado.prestados.add(ejemplar);
                    ejemplar.prestarEjemplar(afiliado);
                    return true;
                }
                else return false;

            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean devolver(int idEjemplar, BibliotecaModel model){
        RegistroAfiliados afiliados = model.getAfiliados();
        RegistroItems items = model.getItems();
        try{
            Ejemplar ejemplar=  items.encontrarEjemplar(idEjemplar);
            ejemplar.getAfiliado().prestados.remove(ejemplar);
            ejemplar.devolverEjemplar();
            return true;

        }
        catch(Exception e){
            return false;
        }

    }

    public boolean suspender(int dni,  int mes, int dia, BibliotecaModel model){
        Afiliado afiliado = null;
        try{
            afiliado= model.getAfiliados().getAfiliado(String.valueOf(dni));
            afiliado.setFechaSuspension(mes,dia);
            return true;


        }
        catch(Exception e){
            return false;
        }
    }

    public boolean setFecha(int year,int month, int day,BibliotecaModel modelo){
       try{
           modelo.setDate(year, month, day);
            return true;
       }
       catch(Exception e ){
        return false;
        }
    }

    public boolean afiliar(int dni, String nombre,String apellido, String telefono,String direccion,BibliotecaModel model){
        try {

            String id = String.valueOf(dni);
            model.getAfiliados().addAfiliado(id, nombre, apellido, telefono, direccion);
            return true;
        }
        catch(Exception e){
            return false;

        }
    }
    public boolean desafiliar(int dni,BibliotecaModel model){
        try{
            model.getAfiliados().removeAfiliado(String.valueOf(dni));
            return true;

        }
        catch(Exception e)
        {
            return false;
        }

    }
    public boolean modPermisos(int dni,String password,BibliotecaModel model){
        Afiliado afiliado = model.getAfiliados().getAfiliado(String.valueOf(dni));
        try{
            afiliado = model.getAfiliados().getAfiliado(String.valueOf(dni));
            String tele=String.valueOf(afiliado.getTel());
            String id = String.valueOf(afiliado.getId());
            Bibliotecario nuevo = new Bibliotecario(id,afiliado.getNombre(),afiliado.getApellido(),tele,afiliado.getDireccion(),password);
            model.getControlador().desafiliar(dni,model);
            model.getAfiliados().getRegistroAfiliados().put(nuevo.getId(),nuevo);
            return true;
        }
        catch(Exception e){
            model.getAfiliados().getRegistroAfiliados().put(afiliado.getId(),afiliado);
            return false;
        }




    }
    public List<Afiliado> verAfiliados(BibliotecaModel model){
       List lista = new ArrayList<Afiliado>();
        for(Afiliado afiliado: model.getAfiliados().getRegistroAfiliados().values())
        {
            lista.add(afiliado);

        }

        return lista;
    }

/*
    public void agregarEjemplar(Ejemplar ejemplar,RegistroItems items){}
    public void eliminarEjemplar(Integer IdEjemplar, RegistroItems items ){}

    public void consultarDisponibilida(Integer idItem,RegistroItems items){}
    public void verInfo(Integer idItem){}
    public void filtrarPorCategoria(){}





    }
    public void login(Integer dni, String password, BibliotecaModel modelo){
        modelo.login(dni,password);

    }
    */
}
