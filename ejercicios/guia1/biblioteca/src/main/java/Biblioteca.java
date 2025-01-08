
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Builder
@Getter
public class Biblioteca {
    private @NonNull String nombre;

    @Builder.Default
    private List<Libro> libros = new ArrayList<>();

    @Builder.Default
    private List<Cliente> clientes = new ArrayList<>();

    // ------------------- LIBROS -------------------
    public boolean crearLibro(int isbn, String titulo) {
        Libro libro = buscarLibro(isbn);
        if (libro == null) {
            libro = Libro.builder()
                    .isbn(isbn)
                    .titulo(titulo)
                    .stock(1)
                    .build();
            libros.add(libro);
            return true;
        } else {
            libro.incrementarStock();
            return false;
        }
    }

    public String borrarLibro(int isbn) {
        Libro libro = buscarLibro(isbn);
        if (libro == null) {
            return "Libro no encontrado";
        }
        libros.remove(libro);
        return "Libro " + libro.getTitulo() + " eliminado correctamente";
    }

    // TODO: consultar el stock de libros por título, fecha o autor
    public int consultarStock(String titulo){
        for (Libro libro: libros) {
            if(libro.getTitulo().equals(titulo)){
                return libro.getStock();
            }
        }
        return 0;
    }

    public Libro buscarLibro(int isbn){
        for (Libro libro: libros) {
            if(libro.getIsbn() == isbn){
                return libro;
            }
        }
        return null;
    }

    public Libro buscarLibro(String titulo){
        for (Libro libro: libros) {
            if(libro.getTitulo().equals(titulo)){
                return libro;
            }
        }
        return null;
    }

    // ------------------- CLIENTES -------------------

    // TODO: Revisar los problemas con los nullPointers (asserts...)
    public void crearCliente(String nomYApell){
        Cliente cliente = Cliente.builder()
                .id(new Random().nextInt(1000))
                .nomYApell(nomYApell)
                .build();
        clientes.add(cliente);
    }
    public boolean prestarLibro(String titulo, String nomYApell){
        Libro libro = buscarLibro(titulo);
        assert libro != null;
        if (libro.getStock() == 0){
            return false;
        }
        Cliente cliente = buscarCliente(nomYApell);
        assert cliente != null;
        cliente.agregarLibro(libro);
        libro.setStock(libro.getStock()-1);
        return true;
    }

    public void devolverLibro(String titulo, String nomYApell){
        Cliente cliente = buscarCliente(nomYApell);
        assert cliente != null;
        Libro libro = cliente.buscarLibro(titulo);
        assert libro != null;
        cliente.removerLibro(libro);
        buscarLibro(libro.getIsbn()).incrementarStock();
    }

    private Cliente buscarCliente(String nomYApell) {
        return null;
    }
}