import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Builder
@ToString
public class Materia {
    @Getter
    private @NonNull String codigo;

    @Getter
    private @NonNull String nombre;

    private int creditos;

    @Builder.Default
    private boolean optativa = false;
}
