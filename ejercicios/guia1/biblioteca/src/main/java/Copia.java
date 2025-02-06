import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Copia {
    @NonNull
    private String idCopia;
    @NonNull
    private Libro libro;
    private Boolean disponible;
}
