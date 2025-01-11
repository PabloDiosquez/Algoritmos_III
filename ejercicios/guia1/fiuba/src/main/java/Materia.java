import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Materia {
    private @NonNull String codigo;

    private @NonNull String nombre;

    private int creditos;

    @Builder.Default
    private boolean optativa = false;
}
