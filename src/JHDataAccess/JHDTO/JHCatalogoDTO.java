package JHDataAccess.JHDTO;

public class JHCatalogoDTO {

    private Integer idCatalogo;
    private Integer idCatalogoTipo;
    private String nombre;
    private Integer idCatalogoPadre;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    
    public JHCatalogoDTO() {
    }

    public JHCatalogoDTO(Integer idCatalogo, Integer idCatalogoTipo, String nombre, Integer idCatalogoPadre,
            String estado, String fechaCreacion, String fechaModifica) {
        this.idCatalogo = idCatalogo;
        this.idCatalogoTipo = idCatalogoTipo;
        this.nombre = nombre;
        this.idCatalogoPadre = idCatalogoPadre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }


    public Integer getIdCatalogo() {
        return idCatalogo;
    }
    public void setIdCatalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }
    public Integer getIdCatalogoTipo() {
        return idCatalogoTipo;
    }
    public void setIdCatalogoTipo(Integer idCatalogoTipo) {
        this.idCatalogoTipo = idCatalogoTipo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getIdCatalogoPadre() {
        return idCatalogoPadre;
    }
    public void setIdCatalogoPadre(Integer idCatalogoPadre) {
        this.idCatalogoPadre = idCatalogoPadre;
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
     
    @ Override
    public String toString(){
        return getClass().getName()
              + "\n idCatalogo          " + getIdCatalogo()
              + "\n idCatalogoTipo      " + getIdCatalogoTipo()
              + "\n nombre              " + getNombre()
              + "\n idCatalogPadre      " + getIdCatalogoPadre()
              + "\n estado              " + getEstado()
              + "\n fechaCreacion       " + getFechaCreacion()
              + "\n fechaModifica       " + getFechaModifica();
    }
}
