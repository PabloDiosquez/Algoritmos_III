import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Builder
@ToString
public class Carrera {

    @Getter
    private @NonNull String codigo;

    @Getter
    private @NonNull String nombre;

    @Builder.Default
    @ToString.Exclude
    private List<Materia> materias = new ArrayList<>();

    @Getter
    private int creditosTotales;
}
