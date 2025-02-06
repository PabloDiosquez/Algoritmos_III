import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
@Builder
public class Copia {
    @NonNull
    private String idCopia;
    @NonNull
    private Libro libro;
    @Getter
    private Boolean disponible;
}
