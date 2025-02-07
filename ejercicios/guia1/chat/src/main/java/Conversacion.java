import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Builder
public class Conversacion {
    @NonNull
    private String id;
    @Builder.Default
    private List<Mensaje> mensajes = new ArrayList<>();

    public void agregarMensaje(Mensaje mensaje){
        mensajes.add(mensaje);
    }

    public List<Mensaje> obtenerHistorial(){
        return null;
    }
}
