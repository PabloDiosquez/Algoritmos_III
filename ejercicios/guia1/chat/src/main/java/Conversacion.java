import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class Conversacion {
    @Builder.Default
    private List<Mensaje> mensajes = new ArrayList<>();

    public void agregarMensaje(Mensaje mensaje){
        mensajes.add(mensaje);
    }
}
