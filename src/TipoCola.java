//7690-21-218 EDREI GIRON
public enum TipoCola {

    MESADEAYUDA("Mesa de ayuda"), SOPORTETECNICO("Soporte tecnico"),
    DESARROLLADOR("Desarrollador"), ATENDIDOS("Atendidos");

    private String tipoCola;

    public String getTipoCola() {
        return tipoCola;
    }

    TipoCola(String tipoCola) {
        this.tipoCola = tipoCola;
    }

}//FIN ENUMERATION TIPO COLA
