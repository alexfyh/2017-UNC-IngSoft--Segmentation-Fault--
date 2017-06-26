/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public abstract class Ejemplar {
    protected int IdEjemplar;
    protected EstadoEjemplar estado;
    protected Item item;
    protected static int EjemplarSig;
    protected Afiliado afiliado;

    public static void  incrementarSiguiente(){
        EjemplarSig++;
    }

    public Item getItem(){
        return this.item;
    }
    public int getIdEjemplar(){
        return IdEjemplar;
    }
    public EstadoEjemplar getEstado(){
        return this.estado;
    }
    public void prestarEjemplar(Afiliado afiliado){
        this.afiliado = afiliado;
        this.estado = EstadoEjemplar.PRESTADO;

    }

    public void devolverEjemplar(){
        this.afiliado.fechaSuspension = null;
        afiliado=null;
        this.estado = EstadoEjemplar.DISPONIBLE;
    }

    public void deshabilitarEjemplar(){
        this.estado = EstadoEjemplar.NODISPONIBLE;
    }

    public void setItem(Item registrado){
        this.item = registrado;
    }

    public Afiliado getAfiliado(){
        return afiliado;
    }

    public void setPrestado(){
        this.estado=EstadoEjemplar.PRESTADO;
    }




}
