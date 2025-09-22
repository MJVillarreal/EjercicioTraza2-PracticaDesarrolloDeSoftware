package entidades;

public abstract class Articulo {
    protected Long id;
    protected String denominacion;
    protected Double precioVenta;
    protected Categoria categoria;
    protected UnidadMedida unidadMedida;

    public Articulo(Long id, String denominacion, Double precioVenta, Categoria categoria, UnidadMedida unidadMedida) {
        this.id = id;
        this.denominacion = denominacion;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
        this.unidadMedida = unidadMedida;
    }

    public Long getId() { return id; }
    public String getDenominacion() { return denominacion; }
    public Double getPrecioVenta() { return precioVenta; }
    public Categoria getCategoria() { return categoria; }
    public UnidadMedida getUnidadMedida() { return unidadMedida; }

    public void setDenominacion(String denominacion) { this.denominacion = denominacion; }
    public void setPrecioVenta(Double precioVenta) { this.precioVenta = precioVenta; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setUnidadMedida(UnidadMedida unidadMedida) { this.unidadMedida = unidadMedida; }
}
