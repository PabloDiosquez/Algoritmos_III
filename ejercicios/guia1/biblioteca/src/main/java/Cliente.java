import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase que representa a un cliente con un identificador, nombre, apellido,
 * y una lista de libros asociados.
 */
@Builder
public class Cliente {

    @Getter
    private @NonNull int id;

    @Getter
    private @NonNull String nombre;

    @Getter
    private @NonNull String apellido;

    @Builder.Default
    private List<Libro> libros = new ArrayList<>();

    /**
     * Devuelve el nombre completo del cliente en formato "Nombre Apellido".
     * @return el nombre y apellido concatenados.
     */
    public String nomYApell() {
        return String.format("%s %s", nombre, apellido);
    }

    /**
     * Agrega un libro a la lista de libros del cliente.
     * @param libro el libro a agregar.
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Devuelve un libro por título. Si el libro existe en la lista, lo elimina y lo retorna.
     * Si no se encuentra, retorna null.
     * @param titulo el título del libro a devolver.
     * @return el libro devuelto si se encuentra; null de lo contrario.
     */
    public Libro devolverLibro(String titulo) {
        Iterator<Libro> iter = libros.iterator();
        while (iter.hasNext()) {
            Libro libro = iter.next();
            if (libro.getTitulo().equals(titulo)) {
                iter.remove();
                return libro;
            }
        }
        return null;
    }

    /**
     * Verifica si un libro con el título dado existe en la lista de libros del cliente.
     * @param titulo el título del libro a verificar.
     * @return true si el libro está presente; false de lo contrario.
     */
    public boolean tieneLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna una representación en cadena de todos los libros asociados al cliente.
     * @return una cadena que representa la lista de libros.
     */
    public String verLibros() {
        StringBuilder sb = new StringBuilder();
        for (Libro libro : libros) {
            sb.append(libro).append("\n");
        }
        return sb.toString();
    }
}