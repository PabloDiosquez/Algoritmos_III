import lombok.Builder;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
@Builder
public class Usuario {
    @NonNull
    private String id;
    @NonNull
    private String nombre;
    @Builder.Default
    private List<Cuenta> cuentas = new ArrayList<>();
}
