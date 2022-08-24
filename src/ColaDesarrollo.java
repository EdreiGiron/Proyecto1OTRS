import java.util.ArrayList;

public class ColaDesarrollo extends ColaServicio{
    public ColaDesarrollo(ArrayList<Ticket> cola, TipoCola tipo) {
        super(cola, tipo);
    }
    public void escalar(Ticket ticket){
        cola.remove(ticket);
    }

}

