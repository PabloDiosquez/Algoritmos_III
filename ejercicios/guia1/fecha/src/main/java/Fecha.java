import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa una fecha con día, mes y año.
 * Permite crear una fecha a partir de un número de mes o su nombre,
 * así como imprimirla en formato estándar.
 */
public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    private static final Map<String, Integer> MESES = new HashMap<>();
    static {
        MESES.put("enero", 1);
        MESES.put("febrero", 2);
        MESES.put("marzo", 3);
        MESES.put("abril", 4);
        MESES.put("mayo", 5);
        MESES.put("junio", 6);
        MESES.put("julio", 7);
        MESES.put("agosto", 8);
        MESES.put("septiembre", 9);
        MESES.put("octubre", 10);
        MESES.put("noviembre", 11);
        MESES.put("diciembre", 12);
    }

    /**
     * Constructor que inicializa la fecha con día, mes (como número) y año.
     *
     * @param dia El día de la fecha.
     * @param mes El mes de la fecha (número).
     * @param anio El año de la fecha.
     */
    public Fecha(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /**
     * Constructor que inicializa la fecha con día, mes (como nombre) y año.
     *
     * @param mes El mes de la fecha (nombre).
     * @param dia El día de la fecha.
     * @param anio El año de la fecha.
     */
    public Fecha(String mes, int dia, int anio){
        this.dia = dia;
        this.mes = convertirMes(mes);
        this.anio = anio;
    }

    /**
     * Convierte el nombre de un mes a su número correspondiente.
     *
     * @param mes El nombre del mes en minúsculas.
     * @return El número correspondiente al mes (1-12).
     * @throws IllegalArgumentException Si el mes no es válido.
     */
    private int convertirMes(String mes) {
        mes = mes.toLowerCase().trim();
        Integer mesNumero = MESES.get(mes);
        if (mesNumero == null) {
            throw new IllegalArgumentException("Mes inválido: " + mes);
        }
        return mesNumero;
    }

    /**
     * Convierte un número de días a un formato de fecha (día, mes).
     *
     * @param dias El número total de días desde el inicio del año.
     */
    private void convertirDiaYMes(int dias){
        int[] diasPorMes = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        for (int i = 1; i <= 12; i++) {
            if (dias <= diasPorMes[i]) {
                this.mes = i;
                this.dia = dias - diasPorMes[i - 1];
                return;
            }
        }
    }

    /**
     * Imprime la fecha en formato estándar: día/mes/año.
     */
    public void imprimirFecha(){
        System.out.println(String.format("%d/%d/%d", dia, mes, anio));
    }
}