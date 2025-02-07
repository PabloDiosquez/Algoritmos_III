import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.ArrayList;

@RequiredArgsConstructor
@Builder
public class Usuario {
    @NonNull
    private String id;
    @NonNull
    private String nombre;

    @Builder.Default
    private List<ConversacionPrivada> conversacionesPrivadas =
            new ArrayList<>();
}
