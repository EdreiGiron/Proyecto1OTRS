import java.util.ArrayList;

//7690-21-218 EDREI GIRON
public class ColaServicio {

    ArrayList<Ticket> cola;
    TipoCola tipo;

    public ArrayList<Ticket> getCola() {
        return cola;
    }

    public void setCola(ArrayList<Ticket> cola) {
        this.cola = cola;
    }

    public TipoCola getTipo() {
        return tipo;
    }

    public void setTipo(TipoCola tipo) {
        this.tipo = tipo;
    }

    public ColaServicio(ArrayList<Ticket> cola, TipoCola tipo) {
        this.cola = cola;
        this.tipo = tipo;
    }

    public void agregar(Ticket ticket){
        cola.add(ticket);
    }

    public void quitar(Ticket ticket){
        cola.remove(ticket);
    }

}//FIN CLASE COLA SERVICIO
