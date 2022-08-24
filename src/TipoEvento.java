//7690-21-218 EDREI GIRON
public enum TipoEvento {
    CREARTICKET("Ticket creado"), ASIGNAR("Ticket asignado"),
    MOVER("Ticket escalado"), SOLUCION("Ticket solucionado");

    private String tipoEvento;

    public String getTipoEvento() {
        return tipoEvento;
    }

    TipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

}//FIN ENUMERATION TIPO EVENTO
