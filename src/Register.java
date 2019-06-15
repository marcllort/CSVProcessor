public class Register {

    private int id;
    private String matricula;

    private String nifTitular;
    private String nifArrendador;

    private String codigoArrendatario;
    private String nombreArrendatario;

    private String fechaContrato;
    private String provinciaContratoId;
    private String municipioContratoId;

    private String provinciaOrigenId;
    private String municipioOrigenId;
    private String direccionOrigen;

    private String fechaInicio;

    private String provinciaDestinoId;
    private String municipioDestinoId;
    private String direccionDestino;

    private String fechaFin;

    private String provinciaDestinoLejanaId;
    private String municipioDestinoLejanaId;
    private String direccionDestinoLejana;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNifTitular() {
        return nifTitular;
    }

    public void setNifTitular(String nifTitular) {
        this.nifTitular = nifTitular;
    }

    public String getNifArrendador() {
        return nifArrendador;
    }

    public void setNifArrendador(String nifArrendador) {
        this.nifArrendador = nifArrendador;
    }

    public String getCodigoArrendatario() {
        return codigoArrendatario;
    }

    public void setCodigoArrendatario(String codigoArrendatario) {
        this.codigoArrendatario = codigoArrendatario;
    }

    public String getNombreArrendatario() {
        return nombreArrendatario;
    }

    public void setNombreArrendatario(String nombreArrendatario) {
        this.nombreArrendatario = nombreArrendatario;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getProvinciaContratoId() {
        return provinciaContratoId;
    }

    public void setProvinciaContratoId(String provinciaContratoId) {
        this.provinciaContratoId = provinciaContratoId;
    }

    public String getMunicipioContratoId() {
        return municipioContratoId;
    }

    public void setMunicipioContratoId(String municipioContratoId) {
        this.municipioContratoId = municipioContratoId;
    }

    public String getProvinciaOrigenId() {
        return provinciaOrigenId;
    }

    public void setProvinciaOrigenId(String provinciaOrigenId) {
        this.provinciaOrigenId = provinciaOrigenId;
    }

    public String getMunicipioOrigenId() {
        return municipioOrigenId;
    }

    public void setMunicipioOrigenId(String municipioOrigenId) {
        this.municipioOrigenId = municipioOrigenId;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getProvinciaDestinoId() {
        return provinciaDestinoId;
    }

    public void setProvinciaDestinoId(String provinciaDestinoId) {
        this.provinciaDestinoId = provinciaDestinoId;
    }

    public String getMunicipioDestinoId() {
        return municipioDestinoId;
    }

    public void setMunicipioDestinoId(String municipioDestinoId) {
        this.municipioDestinoId = municipioDestinoId;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getProvinciaDestinoLejanaId() {
        return provinciaDestinoLejanaId;
    }

    public void setProvinciaDestinoLejanaId(String provinciaDestinoLejanaId) {
        this.provinciaDestinoLejanaId = provinciaDestinoLejanaId;
    }

    public String getMunicipioDestinoLejanaId() {
        return municipioDestinoLejanaId;
    }

    public void setMunicipioDestinoLejanaId(String municipioDestinoLejanaId) {
        this.municipioDestinoLejanaId = municipioDestinoLejanaId;
    }

    public String getDireccionDestinoLejana() {
        return direccionDestinoLejana;
    }

    public void setDireccionDestinoLejana(String direccionDestinoLejana) {
        this.direccionDestinoLejana = direccionDestinoLejana;
    }

    @Override
    public String toString() {
        return id + ";" + matricula + ";" + nifTitular + ";" + nifArrendador + ";" + codigoArrendatario + ";" + nombreArrendatario + ";" + fechaContrato + ";" + provinciaContratoId +
                ";" + municipioContratoId + ";" + provinciaOrigenId + ";" + municipioOrigenId + ";" + direccionOrigen + ";" + fechaInicio + ";" + provinciaDestinoId + ";" + municipioDestinoId + ";" +
                direccionDestino + ";" + fechaFin + ";" + provinciaDestinoLejanaId + ";" + municipioDestinoLejanaId + ";" + direccionDestinoLejana;
    }
}
