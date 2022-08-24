import java.util.ArrayList;

public class ColaMesa extends ColaServicio {

    public ColaMesa(ArrayList<Ticket> cola, TipoCola tipo) {
        super(cola, tipo);
    }

public void escalar(Ticket ticket){
        cola.remove(ticket);
        }

}
