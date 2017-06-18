/**
 * Created by YepezHinostroza on 17/6/2017.
 */
public abstract class Ejemplar {
    protected int IdEjemplar;
    protected EstadoEjemplar estado;
    protected Item item;
    protected static int EjemplarSig;

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
    public void prestarEjemplar(){
        //definir afiliado
        this.estado = EstadoEjemplar.PRESTADO;

    }

    public void devolverEjemplar(){
        //deasociar afiliad
        this.estado = EstadoEjemplar.DISPONIBLE;
    }

    public void deshabilitarEjemplar(){
        this.estado = EstadoEjemplar.NODISPONIBLE;
    }

    public void setItem(Item registrado){
        this.item = registrado;
    }




}
