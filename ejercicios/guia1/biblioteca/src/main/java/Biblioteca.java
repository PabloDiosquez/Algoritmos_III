
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class Biblioteca {
    private @NonNull String nombre;

    @Builder.Default
    private List<Libro> libros = new ArrayList<>();

    @Builder.Default
    private List<Cliente> clientes = new ArrayList<>();

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

}
