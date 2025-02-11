import java.util.concurrent.ThreadLocalRandom;

public class Helper {
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generarStringRandom(int longitud) {
        StringBuilder sb = new StringBuilder(longitud);
        int caracteresLength = CARACTERES.length();
        for (int i = 0; i < longitud; i++) {
            int index = ThreadLocalRandom.current().nextInt(caracteresLength);
            sb.append(CARACTERES.charAt(index));
        }
        return sb.toString();
    }
}
