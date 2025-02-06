import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Usuario {
    @NonNull
    private String id;
    @NonNull
    private String nombre;
    @Builder.Default
    private List<Copia> copiasPrestadas;
}
