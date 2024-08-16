package JHDataAccess.JHDTO;

public class JHHormigeroDTO {

    private Integer idHormiga;
    private Integer tipoHormiga;
    private Integer idCatalogoSexo;
    private Integer idCatalogoProvincia; 
    private Integer idCatalogoGenoAlimento;
    private Integer idCatalogoIngestaNativa;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    
    public JHHormigeroDTO() {
    }

    public JHHormigeroDTO(Integer idHormiga, Integer tipoHormiga, Integer idCatalogoSexo,  Integer idCatalogoProvincia, Integer idCatalogoGenoAlimento,Integer idCatalogoIngestaNativa, String estado, String fechaCreacion, String fechaModifica) {
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
        this.idCatalogoGenoAlimento = idCatalogoGenoAlimento;
        this.idCatalogoIngestaNativa = idCatalogoIngestaNativa;
        this.idCatalogoProvincia = idCatalogoProvincia;
        this.idCatalogoSexo = idCatalogoSexo;
        this.idHormiga = idHormiga;
        this.tipoHormiga = tipoHormiga;
    }

    public Integer getIdHormiga() {
        return idHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        this.idHormiga = idHormiga;
    }

    public Integer getTipoHormiga() {
        return tipoHormiga;
    }

    public void setTipoHormiga(Integer tipoHormiga) {
        this.tipoHormiga = tipoHormiga;
    }

    public Integer getIdCatalogoSexo() {
        return idCatalogoSexo;
    }

    public void setIdCatalogoSexo(Integer idCatalogoSexo) {
        this.idCatalogoSexo = idCatalogoSexo;
    }

    public Integer getIdCatalogoProvincia() {
        return idCatalogoProvincia;
    }

    public void setIdCatalogoProvincia(Integer idCatalogoProvincia) {
        this.idCatalogoProvincia = idCatalogoProvincia;
    }

    public Integer getIdCatalogoGenoAlimento() {
        return idCatalogoGenoAlimento;
    }

    public void setIdCatalogoGenoAlimento(Integer idCatalogoGenoAlimento) {
        this.idCatalogoGenoAlimento = idCatalogoGenoAlimento;
    }

    public Integer getIdCatalogoIngestaNativa() {
        return idCatalogoIngestaNativa;
    }

    public void setIdCatalogoIngestaNativa(Integer idCatalogoIngestaNativa) {
        this.idCatalogoIngestaNativa = idCatalogoIngestaNativa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }


    @Override
    public  String toString(){
        return getClass().getName()
               + "\n idHormiga              " + getIdHormiga()
               + "\n tipoHormiga            " + getTipoHormiga()
               + "\n idCatalogoSexo         " + getIdCatalogoSexo()
               + "\n idCatalogoProvincia    " + getIdCatalogoProvincia()
               + "\n idCatalogoGenoAlimento " + getIdCatalogoGenoAlimento()
               + "\n idCatalogoIngestaNativa" + getIdCatalogoIngestaNativa()
               + "\n estado                 " + getEstado()
               + "\n fechaCreacion          " + getFechaCreacion()
               + "\n fechaModifica          " + getFechaModifica(); 
    }
}
