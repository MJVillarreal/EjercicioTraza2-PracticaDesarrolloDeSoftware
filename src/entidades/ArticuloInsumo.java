package entidades;

public class ArticuloInsumo extends Articulo{
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Boolean esParaElaborar;

    public ArticuloInsumo(Long id, String denominacion, Double precioVenta, Categoria categoria, UnidadMedida unidadMedida,
                          Double precioCompra, Integer stockActual, Integer stockMaximo, Boolean esParaElaborar) {
        super(id, denominacion, precioVenta, categoria, unidadMedida);
        this.precioCompra = precioCompra;
        this.stockActual = stockActual;
        this.stockMaximo = stockMaximo;
        this.esParaElaborar = esParaElaborar;
    }

    public Double getPrecioCompra() { return precioCompra; }
    public Integer getStockActual() { return stockActual; }
    public Integer getStockMaximo() { return stockMaximo; }
    public Boolean getEsParaElaborar() { return esParaElaborar; }

    public void setPrecioCompra(Double precioCompra) { this.precioCompra = precioCompra; }
    public void setStockActual(Integer stockActual) { this.stockActual = stockActual; }
    public void setStockMaximo(Integer stockMaximo) { this.stockMaximo = stockMaximo; }
    public void setEsParaElaborar(Boolean esParaElaborar) { this.esParaElaborar = esParaElaborar; }
}
