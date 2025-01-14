import lombok.*;

@Builder
@Getter
public class Materia {
    private @NonNull String codigo;

    private @NonNull String nombre;

    private int creditos;

    @Builder.Default
    private boolean optativa = false;
}
