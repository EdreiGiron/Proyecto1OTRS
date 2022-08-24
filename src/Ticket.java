import java.util.ArrayList;

//7690-21-218 EDREI GIRON
public class Ticket {
    String nitUsuario;
    int id = 0;
    String problema;
    String estado;
    ArrayList<Bitacora> bitacora;


    public String getNitUsuario() {
        return nitUsuario;
    }
    public void setNitUsuario(String nitUsuario) {
        this.nitUsuario = nitUsuario;
    }
    public int getId() {
        return id;
    }
    public String getProblema() {
        return problema;
    }
    public void setProblema(String problema) {
        this.problema = problema;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Bitacora> getBitacora() {
        return bitacora;
    }

    public void setBitacora(ArrayList<Bitacora> bitacora) {
        this.bitacora = bitacora;
    }

    public Ticket(int id, String nitUsuario, String problema, String estado, ArrayList<Bitacora> bitacora) {
        this.id = id;
        this.nitUsuario = nitUsuario;
        this.problema = problema;
        this.estado = estado;
        this.bitacora = bitacora;
    }

    public void BitacoraTicket(Bitacora actualizarBitacora){
        bitacora.add(actualizarBitacora);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "nitUsuario='" + nitUsuario + '\'' +
                ", problema='" + problema + '\'' +
                ", estado='" + estado + '\'' +
                ", bitacora=" + bitacora +
                '}';
    }
}//FIN CLASE TICKET
