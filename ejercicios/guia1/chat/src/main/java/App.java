import lombok.Builder;

import java.util.*;

public class App {
    @Builder.Default
    private Map<String, Usuario> usuarios = new HashMap<>();
    @Builder.Default
    private List<ConversacionPrivada> conversacionesPrivadas = new ArrayList<>();

    public void enviarMensajePrivado(Usuario emisor, Usuario receptor, String contenido){
        Mensaje mensaje = emisor.enviarMensaje(receptor, contenido);
        Optional<ConversacionPrivada> conversacionPrivadaOptional =
                buscarConversacion(emisor, receptor);
        ConversacionPrivada conversacion = conversacionPrivadaOptional.orElseGet(() -> {
            ConversacionPrivada nuevaConv = ConversacionPrivada.builder()
                    .participante1(emisor)
                    .participante2(receptor)
                    .build();
            conversacionesPrivadas.add(nuevaConv);
            return nuevaConv;
        });
        conversacion.agregarMensaje(mensaje);
        emisor.agregarConversacionPrivada(conversacion);
        receptor.agregarConversacionPrivada(conversacion);
    }

    public List<Mensaje> buscarMensajes(Usuario us, Usuario otroUs) {
        return us.verHistorial(otroUs.getId());
    }

    private Optional<ConversacionPrivada> buscarConversacion(Usuario us, Usuario otro){
        return conversacionesPrivadas.stream()
                .filter(conversacion ->
                 conversacion.esParticipante(
                 us.getId()) && conversacion.esParticipante(otro.getId()))
                .findFirst();
    }
}
