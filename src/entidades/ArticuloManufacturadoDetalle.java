package entidades;

import java.util.HashSet;
import java.util.Set;

public class ArticuloManufacturadoDetalle {
    private Long id;
    private Integer cantidad;
    private Set<ArticuloInsumo> insumos = new HashSet<>();

    public ArticuloManufacturadoDetalle(Long id, Integer cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Long getId() { return id; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public void agregarInsumo(ArticuloInsumo insumo) {
        if(insumo != null) insumos.add(insumo);
    }

    public void quitarInsumo(ArticuloInsumo insumo) {
        insumos.remove(insumo);
    }

    public Set<ArticuloInsumo> getInsumos() {
        return new HashSet<>(insumos);
    }
}