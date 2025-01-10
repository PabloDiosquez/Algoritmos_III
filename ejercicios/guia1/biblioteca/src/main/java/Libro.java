import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un libro con información básica como ISBN, título,
 * fecha de publicación, autores, y stock.
 */
@Builder
public class Libro {

    @Getter
    private @NonNull int ISBN;

    @Getter
    @Setter
    private @NonNull String titulo;

    private LocalDate fechaPublicacion;

    @Builder.Default
    private List<String> autores = new ArrayList<>();

    @Getter
    private int stock;

    /**
     * Actualiza el stock del libro. No permite disminuir el stock con valores negativos.
     * @param stock cantidad a incrementar al stock actual (puede ser negativa para disminuciones).
     */
    public void actualizarStock(int stock) {
        if (this.stock + stock < 0) {
            return;
        }
        this.stock += stock;
    }

    /**
     * Devuelve la fecha de publicación como una cadena. Si no está definida, devuelve "Fecha no disponible".
     * @return la fecha de publicación en formato texto.
     */
    public String verFechaPublicacion() {
        return (fechaPublicacion != null) ? fechaPublicacion.toString() : "Fecha no disponible";
    }

    /**
     * Devuelve una representación de los autores del libro como una cadena, separados por comas.
     * @return una cadena con la lista de autores.
     */
    public String verAutores() {
        return String.join(", ", autores);
    }

    /**
     * Agrega un autor a la lista de autores.
     * @param autor el nombre del autor a agregar.
     */
    public void agregarAutor(String autor) {
        autores.add(autor);
    }
}
