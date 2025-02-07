import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Builder
public class Usuario {
    @NonNull @Getter
    private String id;
    @NonNull
    private String nombre;

    @Builder.Default
    private List<ConversacionPrivada> conversacionesPrivadas =
            new ArrayList<>();


    public Mensaje enviarMensaje(Usuario otroUs, String contenido){
        return Mensaje.builder()
                .emisor(this)
                .receptor(otroUs)
                .contenido(contenido)
                .build();
    }
    public void agregarConversacionPrivada(ConversacionPrivada conversacion){
        if(conversacionesPrivadas.contains(conversacion)){
            return;
        }
        conversacionesPrivadas.add(conversacion);
    }

    public List<Mensaje> verHistorial(String usId){
        Optional<ConversacionPrivada> conversacionPrivadaOptional =
                conversacionesPrivadas.stream().filter(conversacionPrivada ->
                        conversacionPrivada.esParticipante(usId)).findFirst();

        return conversacionPrivadaOptional.map(Conversacion::getMensajes).orElse(Collections.EMPTY_LIST);
    }
}
