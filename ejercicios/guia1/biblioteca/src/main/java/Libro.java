import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Libro {
    @NonNull
    private String ISBN;
    @NonNull
    private String titulo;
    private LocalDate fechaPublicacion;
    private List<String> autores;

    public boolean esAutor(String autor){
        return autores.contains(autor);
    }
}
