import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
@Builder
@Data
public class Cliente {
    private @NonNull int id;

    private String nomYApell;

    @Builder.Default
    private List<Libro> librosPrestados = new ArrayList<>();

    public void agregarLibro(Libro libro){
        librosPrestados.add(libro);
    }

    public void removerLibro(Libro libro){
        librosPrestados.remove(libro);
    }

    public Libro buscarLibro(String titulo){
        for (Libro libro: librosPrestados) {
            if(libro.getTitulo().equals(titulo)){
                return libro;
            }
        }
        return null;
    }

}
