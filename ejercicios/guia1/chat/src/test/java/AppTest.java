import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class AppTest {

    private App app;
    private Usuario user1;
    private Usuario user2;

    @BeforeEach
    void setUp() {
        app = new App();
        user1 = Usuario.builder().id("user1").nombre("Alice").build();
        user2 = Usuario.builder().id("user2").nombre("Bob").build();
    }

    @Test
    void testEnviarMensajePrivado_CreaConversacionSiNoExiste() {
        app.enviarMensajePrivado(user1, user2, "Hola Bob!");

        List<ConversacionPrivada> conversacionesGlobal = app.getConversacionesPrivadas();
        assertEquals(1, conversacionesGlobal.size(), "Se debe haber creado una única conversación.");

        ConversacionPrivada conversacion = conversacionesGlobal.get(0);
        assertTrue(conversacion.esParticipante(user1.getId()), "User1 debe ser participante.");
        assertTrue(conversacion.esParticipante(user2.getId()), "User2 debe ser participante.");

        List<Mensaje> mensajes = conversacion.getMensajes();
        assertEquals(1, mensajes.size(), "La conversación debe contener un mensaje.");
        Mensaje mensaje = mensajes.get(0);
        assertEquals("Hola Bob!", mensaje.getContenido());
        assertEquals(user1, mensaje.getEmisor());
        assertEquals(user2, mensaje.getReceptor());

        assertTrue(user1.getConversacionesPrivadas().contains(conversacion), "User1 debe tener la conversación en su lista.");
        assertTrue(user2.getConversacionesPrivadas().contains(conversacion), "User2 debe tener la conversación en su lista.");
    }

    @Test
    void testEnviarMensajePrivado_UtilizaConversacionExistente() {
        app.enviarMensajePrivado(user1, user2, "Primer mensaje");
        app.enviarMensajePrivado(user1, user2, "Segundo mensaje");

        List<ConversacionPrivada> conversacionesGlobal = app.getConversacionesPrivadas();
        assertEquals(1, conversacionesGlobal.size(), "No debe duplicarse la conversación.");

        ConversacionPrivada conversacion = conversacionesGlobal.get(0);
        List<Mensaje> mensajes = conversacion.getMensajes();
        assertEquals(2, mensajes.size(), "La conversación debe contener ambos mensajes.");
        assertEquals("Primer mensaje", mensajes.get(0).getContenido());
        assertEquals("Segundo mensaje", mensajes.get(1).getContenido());
    }

    @Test
    void testBuscarMensajes_RetornaHistorialCorrecto() {
        app.enviarMensajePrivado(user1, user2, "Mensaje 1");
        app.enviarMensajePrivado(user1, user2, "Mensaje 2");

        List<Mensaje> historial = app.buscarMensajes(user1, user2);

        assertNotNull(historial, "El historial no debe ser nulo.");
        assertEquals(2, historial.size(), "El historial debe contener 2 mensajes.");
        assertEquals("Mensaje 1", historial.get(0).getContenido());
        assertEquals("Mensaje 2", historial.get(1).getContenido());
    }
}
