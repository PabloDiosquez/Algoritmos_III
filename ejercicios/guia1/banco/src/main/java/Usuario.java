import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
@Builder
public class Usuario {
    @NonNull @Getter
    private String id;
    @NonNull
    private String nombre;
    @Builder.Default
    private List<Cuenta> cuentas = new ArrayList<>();

    public boolean agregarCuenta(Cuenta cuenta){
        if(cuenta == null){
            return false;
        }
        cuentas.add(cuenta);
        return true;
    }
}
