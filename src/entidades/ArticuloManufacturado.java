package entidades;

import java.util.HashSet;
import java.util.Set;

public class ArticuloManufacturado extends Articulo {
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;

    private Set<ArticuloManufacturadoDetalle> detalles = new HashSet<>();
    private Set<Imagen> imagenes = new HashSet<>();

    public ArticuloManufacturado(Long id, String denominacion, Double precioVenta, Categoria categoria, UnidadMedida unidadMedida,
                                 String descripcion, Integer tiempoEstimadoMinutos, String preparacion) {
        super(id, denominacion, precioVenta, categoria, unidadMedida);
        this.descripcion = descripcion;
        this.tiempoEstimadoMinutos = tiempoEstimadoMinutos;
        this.preparacion = preparacion;
    }

    public String getDescripcion() { return descripcion; }
    public Integer getTiempoEstimadoMinutos() { return tiempoEstimadoMinutos; }
    public String getPreparacion() { return preparacion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setTiempoEstimadoMinutos(Integer tiempoEstimadoMinutos) { this.tiempoEstimadoMinutos = tiempoEstimadoMinutos; }
    public void setPreparacion(String preparacion) { this.preparacion = preparacion; }

    public void agregarDetalle(ArticuloManufacturadoDetalle detalle) {
        if(detalle != null) detalles.add(detalle);
    }

    public void quitarDetalle(ArticuloManufacturadoDetalle detalle) {
        detalles.remove(detalle);
    }

    public Set<ArticuloManufacturadoDetalle> getDetalles() {
        return new HashSet<>(detalles);
    }

    public void agregarImagen(Imagen imagen) {
        if(imagen != null) imagenes.add(imagen);
    }

    public void quitarImagen(Imagen imagen) {
        imagenes.remove(imagen);
    }

    public Set<Imagen> getImagenes() {
        return new HashSet<>(imagenes);
    }
}
