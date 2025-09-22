package entidades;

import java.util.HashSet;
import java.util.Set;

public class Categoria {
    private Long id;
    private String denominacion;

    public Categoria(Long id, String denominacion) {
        this.id = id;
        this.denominacion = denominacion;
    }

    public Long getId() { return id; }
    public String getDenominacion() { return denominacion; }
    public void setDenominacion(String denominacion) { this.denominacion = denominacion; }

    private Set<Articulo> articulos = new HashSet<>();
    public Set<Articulo> getArticulos() {
        return new HashSet<>(articulos);
    }
    private Set<Categoria> subCategorias = new HashSet<>();
    private Categoria categoriaPadre;

    public void agregarArticulo(Articulo articulo) {
        if(articulo != null) articulos.add(articulo);
    }

    public void agregarSubCategoria(Categoria subCategoria) {
        if(subCategoria != null) subCategorias.add(subCategoria);
    }
}
