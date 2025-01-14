import lombok.*;

@Builder
@Getter
public class Materia {
    private @NonNull Integer codigo;

    private @NonNull String nombre;

    private int creditos;

    @Builder.Default
    private boolean optativa = false;
}
