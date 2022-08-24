//7690-21-218 EDREI GIRON
public class Bitacora {
    String nitSoporte;
    String fechaHora;
    String mensaje;
    TipoEvento evento;

    public String getNitSoporte() {
        return nitSoporte;
    }

    public void setNitSoporte(String nitSoporte) {
        this.nitSoporte = nitSoporte;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public TipoEvento getEvento() {
        return evento;
    }

    public void setEvento(TipoEvento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Bitacora{" +
                "nitSoporte=" + nitSoporte +
                ", fechaHora='" + fechaHora + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", evento=" + evento.getTipoEvento() +
                '}';
    }

    public Bitacora(String nitSoporte, String fechaHora, String mensaje, TipoEvento evento) {
        this.nitSoporte = nitSoporte;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.evento = evento;
    }

    public Bitacora() {
    }

}//FIN CLASE BITACORA
