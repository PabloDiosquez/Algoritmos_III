import java.util.UUID;

public class Helper {
    public static String generarStrRandom(int longitud) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, longitud);
    }
}