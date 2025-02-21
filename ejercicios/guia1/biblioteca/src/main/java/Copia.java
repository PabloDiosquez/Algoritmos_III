import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Builder
public class Copia {
    @NonNull @Getter
    private String idCopia;
    @NonNull
    private Libro libro;
    @Getter @Setter
    private Boolean disponible;
}
