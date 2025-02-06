import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Usuario {
    @NonNull @Getter
    private String id;
    @NonNull
    private String nombre;
    @Builder.Default
    private List<Copia> copiasPrestadas;

    public void agregarCopia(Copia copia){
        copiasPrestadas.add(copia);
    }
}
