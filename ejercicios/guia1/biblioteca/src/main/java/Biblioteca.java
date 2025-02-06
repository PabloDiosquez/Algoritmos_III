import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
public class Biblioteca {
    @Builder.Default
    private Map<Libro, List<Copia>> catalogo = new HashMap<>();
    @Builder.Default
    private List<Usuario> usuarios = new ArrayList<>();
    @Builder.Default
    private List<Prestamo> prestamos = new ArrayList<>();
    
    public void agregarLibro(Libro libro, int cantidad){

    }

    public Boolean eliminarLibro(String ISBN){
        return false;
    }

    public void registrarUsuario(Usuario us) {

    }

    public Boolean prestarCopia(String ISBN, Usuario us) {
        return false;
    }

    public Boolean devolverCopia(Copia copia){
        return false;
    }

    public int consultarStockPorTitulo(String titulo) {
        return 0;
    }
    public int consultarStockPorFecha(LocalDate fecha) {
        return 0;
    }
    public int consultarStockPorAutor(String autor) {
        return 0;
    }

    public List<Libro> buscarLibrosPorISBN(String ISBN){
        return null;
    }
}
