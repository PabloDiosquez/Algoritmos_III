import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Clase que representa una biblioteca con una colección de libros y una lista de clientes.
 * Ofrece funcionalidades para gestionar libros, clientes y préstamos.
 */
@Builder
public class Biblioteca {

    @Getter
    private @NonNull String nombre;

    @Builder.Default
    private List<Libro> libros = new ArrayList<>();

    @Builder.Default
    public List<Cliente> clientes = new ArrayList<>();

    // -------------------- LIBROS --------------------

    /**
     * Agrega un libro a la colección. Si ya existe, incrementa su stock.
     * @param titulo el título del libro a agregar.
     */
    public void agregarLibro(String titulo) {
        if (pertenece(titulo)) {
            buscar(titulo).actualizarStock(1);
        } else {
            Libro libro = Libro.builder()
                    .ISBN(generarISBN())
                    .titulo(titulo)
                    .build();
            libros.add(libro);
        }
    }

    /**
     * Elimina un libro de la colección por su título.
     * @param titulo el título del libro a eliminar.
     * @return una descripción del resultado de la operación.
     */
    public String quitarLibro(String titulo) {
        if (pertenece(titulo)) {
            Libro libro = buscar(titulo);
            libros.remove(libro);
            return String.format("El libro '%s' fue eliminado de la colección.", libro.getTitulo());
        }
        return "El libro no forma parte de la colección de la biblioteca.";
    }

    /**
     * Consulta el stock de un libro por su título.
     * @param titulo el título del libro.
     * @return el stock disponible del libro.
     */
    public int consultarStock(String titulo) {
        return consultarStock(libro -> libro.getTitulo().equals(titulo));
    }

    /**
     * Consulta el stock de un libro por su ISBN.
     * @param ISBN el identificador único del libro.
     * @return el stock disponible del libro.
     */
    public int consultarStock(int ISBN) {
        return consultarStock(libro -> libro.getISBN() == ISBN);
    }

    private int consultarStock(Predicate<Libro> criterio) {
        Libro libro = buscar(criterio);
        return libro != null ? libro.getStock() : 0;
    }

    private Libro buscar(int ISBN) {
        return buscar(libro -> libro.getISBN() == ISBN);
    }

    private Libro buscar(String titulo) {
        return buscar(libro -> libro.getTitulo().equals(titulo));
    }

    private Libro buscar(Predicate<Libro> criterio) {
        for (Libro libro : libros) {
            if (criterio.test(libro)) {
                return libro;
            }
        }
        return null;
    }

    private boolean pertenece(int ISBN) {
        return pertenece(libro -> libro.getISBN() == ISBN);
    }

    private boolean pertenece(String titulo) {
        return pertenece(libro -> libro.getTitulo().equals(titulo));
    }

    private boolean pertenece(Predicate<Libro> criterio) {
        for (Libro libro : libros) {
            if (criterio.test(libro)) {
                return true;
            }
        }
        return false;
    }

    // -------------------- CLIENTES --------------------

    /**
     * Agrega un cliente a la lista de clientes.
     * @param nombre el nombre del cliente.
     * @param apellido el apellido del cliente.
     * @return una descripción del resultado de la operación.
     */
    public String agregarCliente(String nombre, String apellido) {
        if (esCliente(nombre, apellido)) {
            return "El cliente ya está registrado.";
        }
        Cliente cliente = Cliente.builder()
                .id(generarId())
                .nombre(nombre)
                .apellido(apellido)
                .build();
        clientes.add(cliente);
        return String.format("Cliente agregado: ID %d, Nombre %s %s.", cliente.getId(), cliente.getNombre(), cliente.getApellido());
    }

    /**
     * Elimina un cliente por su nombre y apellido.
     * @param nombre el nombre del cliente.
     * @param apellido el apellido del cliente.
     * @return una descripción del resultado de la operación.
     */
    public String quitarCliente(String nombre, String apellido) {
        if (esCliente(nombre, apellido)) {
            Cliente cliente = buscarCliente(nombre, apellido);
            clientes.remove(cliente);
            return String.format("Cliente eliminado: ID %d, Nombre %s %s.", cliente.getId(), cliente.getNombre(), cliente.getApellido());
        }
        return "El cliente no está registrado.";
    }

    /**
     * Presta un libro a un cliente.
     * @param titulo el título del libro.
     * @param nombre el nombre del cliente.
     * @param apellido el apellido del cliente.
     * @return una descripción del resultado de la operación.
     */
    public String prestarLibro(String titulo, String nombre, String apellido) {
        if (consultarStock(titulo) > 0 && esCliente(nombre, apellido)) {
            Libro libro = buscar(titulo);
            libro.actualizarStock(-1);
            Cliente cliente = buscarCliente(nombre, apellido);
            cliente.agregarLibro(libro);
            return String.format("Préstamo exitoso: Libro '%s' para %s %s.", libro.getTitulo(), cliente.getNombre(), cliente.getApellido());
        }
        return "Préstamo fallido. Verifique los datos ingresados.";
    }

    /**
     * Procesa la devolución de un libro por un cliente.
     * @param titulo el título del libro.
     * @param nombre el nombre del cliente.
     * @param apellido el apellido del cliente.
     * @return una descripción del resultado de la operación.
     */
    public String devolverLibro(String titulo, String nombre, String apellido) {
        if (!esCliente(nombre, apellido)) {
            return "El cliente no está registrado.";
        }
        Cliente cliente = buscarCliente(nombre, apellido);
        if (!cliente.tieneLibro(titulo)) {
            return "El cliente no tiene el libro indicado.";
        }
        Libro libro = cliente.devolverLibro(titulo);
        libro.actualizarStock(1);
        return String.format("Devolución exitosa: Libro '%s' por %s %s.", libro.getTitulo(), cliente.getNombre(), cliente.getApellido());
    }

    /**
     * Consulta los libros prestados por un cliente.
     * @param nombre el nombre del cliente.
     * @param apellido el apellido del cliente.
     * @return una descripción de los libros prestados.
     */
    public String consultarPrestamo(String nombre, String apellido) {
        if (!esCliente(nombre, apellido)) {
            return "El cliente no está registrado.";
        }
        Cliente cliente = buscarCliente(nombre, apellido);
        String librosPrestados = cliente.verLibros();
        return librosPrestados.isEmpty() ? "El cliente no tiene libros prestados." : librosPrestados;
    }

    private Cliente buscarCliente(String nombre, String apellido) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre) && cliente.getApellido().equals(apellido)) {
                return cliente;
            }
        }
        return null;
    }

    private boolean esCliente(String nombre, String apellido) {
        return buscarCliente(nombre, apellido) != null;
    }

    // -------------------- AUXILIARES --------------------

    private int generarISBN() {
        return new Random().nextInt(1000) + 1;
    }

    private int generarId() {
        return new Random().nextInt(1000) + 1;
    }
}