package models;

public class SolicitudMatricula {

    private int id;
    private String numeroDocumento;
    private String nombreAspirante;
    private String gradoSolicitado;
    private String estadoMatricula;

    public SolicitudMatricula() {
    }

    public SolicitudMatricula(int id, String numeroDocumento, String nombreAspirante,
                              String gradoSolicitado, String estadoMatricula) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.nombreAspirante = nombreAspirante;
        this.gradoSolicitado = gradoSolicitado;
        this.estadoMatricula = estadoMatricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombreAspirante() {
        return nombreAspirante;
    }

    public void setNombreAspirante(String nombreAspirante) {
        this.nombreAspirante = nombreAspirante;
    }

    public String getGradoSolicitado() {
        return gradoSolicitado;
    }

    public void setGradoSolicitado(String gradoSolicitado) {
        this.gradoSolicitado = gradoSolicitado;
    }

    public String getEstadoMatricula() {
        return estadoMatricula;
    }

    public void setEstadoMatricula(String estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }
}