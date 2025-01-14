import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

@Builder
public class FIUBA {
    @Builder.Default
    private List<Carrera> carreras = new ArrayList<>();

    @Builder.Default
    private List<Alumno> alumnos = new ArrayList<>();

    // ------------------- CARRERAS -------------------


    // ------------------- ALUMNOS -------------------



    // ----------------- AUXILIARES -------------------


    private static String generarCodigo(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringAleatorio = new StringBuilder(longitud);
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            stringAleatorio.append(caracteres.charAt(indice));
        }

        return stringAleatorio.toString();
    }

    private static int generarLegajo(){
        return new Random().nextInt(1000);
    }

}
