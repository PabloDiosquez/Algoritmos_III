import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Biblioteca {
    private String nombre;

    private List<Libro> libros;
    private List<Cliente> clientes;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        libros = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public boolean crearLbro(int isbn, String titulo){
        Libro libro = Libro.builder()
                .isbn(isbn)
                .titulo(titulo)
                .build();
        libros.add(libro);
        return true;
    }

    public String borrarLibro(int isbn){
        Libro libro = buscarLibro(isbn);
        if(libro == null){
            return "NOT FOUND";
        }
        libros.remove(libro);
        return libro.getTitulo();
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
