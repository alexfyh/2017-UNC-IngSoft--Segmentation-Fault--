import java.util.Date;
/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public class BibliotecaModel {
    private Permisos permisos;
    private RegistroAfiliados afiliados;
    private RegistroItems items;
    private static BibliotecaModel UniqueInstance;
    private Date fechaActual;

    private  BibliotecaModel(){
        afiliados=new RegistroAfiliados();
        items = new RegistroItems();
        permisos= new PermisosAfiliado();
        fechaActual = new Date();
    }

    public static BibliotecaModel getUniqueInstance(){
        if(UniqueInstance==null){
            BibliotecaModel.UniqueInstance = new BibliotecaModel();
            return UniqueInstance;
        }
        else{
            return UniqueInstance;
        }

    }

    public void login(Integer id, String password){
        Afiliado afiliado = afiliados.getAfiliado(id.toString());
        if(afiliado!=null||password!=null||id!=null){

            if(afiliado instanceof Bibliotecario){
                if(((Bibliotecario) afiliado).getContrasena().equals(password))
                   permisos = new PermisosBibliotecario();
            }
            else{

            }

        }else{
            //redifinir Interfaz permisos
        }


    }
    public Permisos getPermisos(){
        return permisos;
    }
    public void logout(){
        permisos = new PermisosAfiliado();
    }

    public void setDate(int anio, int mes, int dia){
        this.fechaActual = new Date(anio, mes,dia);
    }

    public Date getDate(){
        return this.fechaActual;
    }

}
