import java.util.ArrayList;

public class ColaAtendidos extends ColaServicio{

    public ColaAtendidos(ArrayList<Ticket> cola, TipoCola tipo) {
        super(cola, tipo);
    }

    public void escalar(Ticket ticket){
        cola.remove(ticket);
    }

}

