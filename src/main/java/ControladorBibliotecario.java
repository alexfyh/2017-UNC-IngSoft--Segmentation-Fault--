/**
 * Created by YepezHinostroza on 17/6/2017.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
public class ControladorBibliotecario implements Controlador {



    public boolean login (int dni, String password, BibliotecaModel model) {

        try {

                Afiliado afiliado = model.getAfiliados().getAfiliado(String.valueOf(dni));
                if (afiliado != null || password != null) {

                    if (afiliado instanceof Bibliotecario) {
                        if (((Bibliotecario) afiliado).getContrasena().equals(password))
                            return true;

                        else{
                            throw new Exception();
                        }

                    } else {
                        throw new Exception();

                    }

                } else {
                    return false;

                }

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
           modelo.setDate(year, month-1, day);
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
    public boolean modDatos(int id,String telefono,String direccion, BibliotecaModel model){

        try {
            Afiliado afiliado = model.getAfiliados().getRegistroAfiliados().get(id);
            if(direccion.length()!=0)
                afiliado.setTel(telefono);
            if(telefono.length()!=0)
                afiliado.setDireccion(direccion);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean agregarLibro(String titulo, String autor, String fechaPublicacion, Categoria categoria, int edicion, String editorial, BibliotecaModel modelo){
        try{

            String[] numeros = fechaPublicacion.split("/",3);
            int dia = Integer.parseInt(numeros[0]);
            //if(dia<1||dia>31)
                //throw new Exception("Dia invalido");
            int mes = Integer.parseInt(numeros[1]);
            //if(mes<0||mes>12)
                //throw new Exception("Mes invalido");
            int anio = Integer.parseInt(numeros[2]);
            //if(anio<1900||anio>(new Date()).getYear()+1)
                //throw new Exception("Anio invalido");
            Date fecha = new Date(anio, mes, dia);
            EjemplarLibro libro = new EjemplarLibro(titulo,autor,fecha,categoria,edicion,editorial);
            modelo.getItems().agregarEjemplar(libro);
            return true;

        }
        catch(Exception e){
            return false;
        }
    }
    public boolean agregarRevista(String titulo, String autor, String fechaPublicacion, Categoria categoria, BibliotecaModel modelo){
        try{

            String[] numeros = fechaPublicacion.split("/",3);
            int dia = Integer.parseInt(numeros[0]);
            int mes = Integer.parseInt(numeros[1]);
            int anio = Integer.parseInt(numeros[2]);
            Date fecha = new Date(anio, mes, dia);
            EjemplarRevista revista = new EjemplarRevista(titulo,autor,fecha,categoria);
            modelo.getItems().agregarEjemplar(revista);
            return true;

        }
        catch(Exception e){
            return false;
        }
    }

    public boolean agregarAudoVisual(String titulo, String autor, String fechaPublicacion, Categoria categoria,String edicion, String editorial, String duracion, BibliotecaModel modelo){
        try{

            String[] numeros = fechaPublicacion.split("/",3);
            int dia = Integer.parseInt(numeros[0]);
            int mes = Integer.parseInt(numeros[1]);
            int anio = Integer.parseInt(numeros[2]);
            Date fecha = new Date(anio-1900, mes, dia);
            int duracionEnSegundos = Integer.parseInt(duracion);
            int ed =Integer.parseInt(edicion);
            EjemplarAudioVisual audio = new EjemplarAudioVisual(titulo,autor,fecha,categoria, ed,editorial,duracionEnSegundos);
            modelo.getItems().agregarEjemplar(audio);
            return true;

        }
        catch(Exception e){
            return false;
        }
    }

    public boolean agregarTesis(String titulo, String autor, String fechaPublicacion, Categoria categoria, BibliotecaModel modelo){
        try{

            String[] numeros = fechaPublicacion.split("/",3);
            int dia = Integer.parseInt(numeros[0]);
            int mes = Integer.parseInt(numeros[1]);
            int anio = Integer.parseInt(numeros[2]);
            Date fecha = new Date(anio-1900, mes, dia);

            EjemplarTesis tesis = new EjemplarTesis(titulo,autor,fecha,categoria);
            modelo.getItems().agregarEjemplar(tesis);
            return true;

        }
        catch(Exception e){
            return false;
        }
    }

    public boolean borrarEjemplar(int id, BibliotecaModel modelo){
        try {
            modelo.getItems().deleteEjemplar(id);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }
    public boolean darBaja(int id, BibliotecaModel modelo){
        try{
            Ejemplar ejem = modelo.getItems().encontrarEjemplar(id);
            ejem.deshabilitarEjemplar();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean setFecha(String fecha, BibliotecaModel modelo){
        try{
            String[] numeros =fecha.split("/",3);
            int dia = Integer.parseInt(numeros[0]);
            int mes = Integer.parseInt(numeros[1]);
            int anio = Integer.parseInt(numeros[2]);
            modelo.setDate(anio-1900,mes,dia);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Date getFecha(BibliotecaModel modelo){ return modelo.getDate();}
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
