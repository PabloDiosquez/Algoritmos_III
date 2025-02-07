import java.util.List;
import java.util.Map;

public class App {
    private Map<String, Usuario> usuarios;
    private Map<String, Conversacion> conversaciones;

    public void enviarMensaje(Usuario emisor, Usuario receptor, String contenido){
        Mensaje mensaje = emisor.enviarMensaje(receptor, contenido);
        ConversacionPrivada conversacion =
                ConversacionPrivada.builder()
                .participante1(emisor)
                .participante2(receptor)
                .build();
        conversacion.agregarMensaje(mensaje);
        emisor.agregarConversacion(conversacion);
        receptor.agregarConversacion(conversacion);
    }

    public List<Mensaje> buscarMensajes(Usuario us, Usuario otroUs) {
        return us.verHistorial(otroUs.getId());
    }
}
