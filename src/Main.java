import entidades.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // --- Creo categorías ---

        Categoria pizzas = new Categoria(1L, "Pizzas");
        Categoria sandwiches = new Categoria(2L, "Sandwiches");
        Categoria lomos = new Categoria(3L, "Lomos");
        Categoria insumosCat = new Categoria(4L, "Insumos");


        // --- Creo unidades de medida ---

        UnidadMedida kg = new UnidadMedida(1L, "Kilogramos");
        UnidadMedida litro = new UnidadMedida(2L, "Litros");
        UnidadMedida gramos = new UnidadMedida(3L, "Gramos");


        // --- Creo Artículos Insumos ---

        ArticuloInsumo sal = new ArticuloInsumo(1L, "Sal", 0.0, insumosCat, gramos, 1000.0, 100, 200, true);
        ArticuloInsumo harina = new ArticuloInsumo(2L, "Harina", 0.0, insumosCat, kg, 1800.0, 50, 100, true);
        ArticuloInsumo aceite = new ArticuloInsumo(3L, "Aceite", 0.0, insumosCat, litro, 2000.0, 50, 100, true);
        ArticuloInsumo carne = new ArticuloInsumo(4L, "Carne", 0.0, insumosCat, kg, 5000.0, 40, 100, true);

        insumosCat.agregarArticulo(sal);
        insumosCat.agregarArticulo(harina);
        insumosCat.agregarArticulo(aceite);
        insumosCat.agregarArticulo(carne);


        // --- Creo imágenes para los productos ---

        Imagen img1 = new Imagen(1L, "HawaianaPizza1");
        Imagen img2 = new Imagen(2L, "HawaianaPizza2");
        Imagen img3 = new Imagen(3L, "HawaianaPizza3");
        Imagen img4 = new Imagen(4L, "LomoCompleto1");
        Imagen img5 = new Imagen (5L, "LomoCompleto2");
        Imagen img6 = new Imagen (6L, "LomoCompleto3");


        // --- Creo detalles de Artículos Manufacturados ---

        ArticuloManufacturadoDetalle detallePizza1 = new ArticuloManufacturadoDetalle(1L, 1);
        detallePizza1.agregarInsumo(sal);

        ArticuloManufacturadoDetalle detallePizza2 = new ArticuloManufacturadoDetalle(2L, 2);
        detallePizza2.agregarInsumo(harina);

        ArticuloManufacturadoDetalle detallePizza3 = new ArticuloManufacturadoDetalle(3L, 1);
        detallePizza3.agregarInsumo(aceite);

        ArticuloManufacturadoDetalle detalleLomo1 = new ArticuloManufacturadoDetalle(4L, 1);
        detalleLomo1.agregarInsumo(sal);

        ArticuloManufacturadoDetalle detalleLomo2 = new ArticuloManufacturadoDetalle(5L, 1);
        detalleLomo2.agregarInsumo(aceite);

        ArticuloManufacturadoDetalle detalleLomo3 = new ArticuloManufacturadoDetalle(6L, 1);
        detalleLomo3.agregarInsumo(carne);


        // --- Croe Artículos Manufacturados ---

        ArticuloManufacturado pizzaHawaiana = new ArticuloManufacturado(
                1L, "Pizza Hawaiana", 3200.0, pizzas, kg,
                "Pizza con ananá y jamón", 20, "Hornear 20 minutos"
        );

        pizzaHawaiana.agregarImagen(img1);
        pizzaHawaiana.agregarImagen(img2);
        pizzaHawaiana.agregarImagen(img3);

        pizzaHawaiana.agregarDetalle(detallePizza1);
        pizzaHawaiana.agregarDetalle(detallePizza2);
        pizzaHawaiana.agregarDetalle(detallePizza3);

        pizzas.agregarArticulo(pizzaHawaiana);

        ArticuloManufacturado lomoCompleto = new ArticuloManufacturado(
                2L, "Lomo Completo", 4700.0, lomos, kg,
                "Lomo completo de ternera con huevo, jamón, tomate y rúcula", 25, "Cocinar a la parrilla 25 minutos"
        );

        lomoCompleto.agregarImagen(img4);
        lomoCompleto.agregarImagen(img5);
        lomoCompleto.agregarImagen(img6);

        lomoCompleto.agregarDetalle(detalleLomo1);
        lomoCompleto.agregarDetalle(detalleLomo2);
        lomoCompleto.agregarDetalle(detalleLomo3);

        lomos.agregarArticulo(lomoCompleto);


        // --- Muestro todas las categorías y sus artículos ---

        System.out.println("=== Categorías y Artículos ===");
        for (Categoria cat : Set.of(pizzas, sandwiches, lomos, insumosCat)) {
            System.out.println(cat.getDenominacion() + ":");
            for (Articulo art : cat.getArticulos()) {
                System.out.print("   - " + art.getDenominacion() + " | Precio: $" + art.getPrecioVenta());
                if (art instanceof ArticuloManufacturado) {
                    ArticuloManufacturado m = (ArticuloManufacturado) art;
                    System.out.println(" | Preparación: " + m.getPreparacion());
                    System.out.println("     Detalles:");
                    for (ArticuloManufacturadoDetalle det : m.getDetalles()) {
                        System.out.print("       * Cantidad: " + det.getCantidad() + " | Insumos: ");
                        String insumosStr = det.getInsumos().stream()
                                .map(ArticuloInsumo::getDenominacion)
                                .reduce((a,b) -> a + ", " + b)
                                .orElse("");
                        System.out.println(insumosStr);
                    }
                } else if (art instanceof ArticuloInsumo) {
                    ArticuloInsumo i = (ArticuloInsumo) art;
                    System.out.println(" | Stock: " + i.getStockActual() + " " + i.getUnidadMedida().getDenominacion());
                } else {
                    System.out.println();
                }
            }
        }


        // --- Muestro Artículos Insumos ---

        System.out.println("\n=== Artículos Insumos ===");
        for (ArticuloInsumo insumo : Set.of(sal, harina, aceite, carne)) {
            System.out.println(insumo.getDenominacion() + " | Precio: $" + insumo.getPrecioCompra() +
                    " | Stock: " + insumo.getStockActual() + " " + insumo.getUnidadMedida().getDenominacion());
        }


        // --- Muestro Artículos Manufacturados ---

        System.out.println("\n=== Artículos Manufacturados ===");
        for (ArticuloManufacturado m : Set.of(pizzaHawaiana, lomoCompleto)) {
            System.out.println(m.getDenominacion() + " | Precio: $" + m.getPrecioVenta() +
                    " | Preparación: " + m.getPreparacion());
        }


        // --- Busco por Id ---

        Long buscarId = 2L;
        System.out.println("\n=== Buscar Artículo Manufacturado por Id: " + buscarId + " ===");
        for (ArticuloManufacturado m : Set.of(pizzaHawaiana, lomoCompleto)) {
            if (m.getId().equals(buscarId)) {
                System.out.println("Encontrado: " + m.getDenominacion() + " | Precio: $" + m.getPrecioVenta());
            }
        }


        // --- Actualizo por Id ---

        Long actualizarId = 1L;
        for (ArticuloManufacturado m : Set.of(pizzaHawaiana, lomoCompleto)) {
            if (m.getId().equals(actualizarId)) {
                m.setPrecioVenta(3200.0);
                m.setPreparacion("Hornear 25 minutos");
                System.out.println("\nArtículo actualizado: " + m.getDenominacion() + " | Precio: $" + m.getPrecioVenta());
            }
        }

        
        // --- Elimino por Id ---

        Long eliminarId = 2L;
        Set<ArticuloManufacturado> manufacturados = new HashSet<>();
        manufacturados.add(pizzaHawaiana);
        manufacturados.add(lomoCompleto);

        manufacturados.removeIf(m -> m.getId().equals(eliminarId));

        System.out.println("\n=== Artículos Manufacturados después de eliminar Id " + eliminarId + " ===");
        for (ArticuloManufacturado m : manufacturados) {
            System.out.println(m.getDenominacion() + " | Precio: $" + m.getPrecioVenta());
        }
    }
}