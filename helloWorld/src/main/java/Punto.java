/**
 * Clase Punto que representa un punto en el plano cartesiano.
 * Proporciona constructores para inicializar el punto con coordenadas específicas,
 * con valores predeterminados (0, 0), o copiando otro punto. También incluye métodos
 * para obtener y establecer las coordenadas, así como un método para representar el
 * punto como una cadena.
 */
public class Punto {
    private int x; // Coordenada X del punto
    private int y; // Coordenada Y del punto

    /**
     * Constructor por defecto. Inicializa el punto en (0, 0).
     */
    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructor que inicializa el punto con las coordenadas especificadas.
     *
     * @param x la coordenada X.
     * @param y la coordenada Y.
     */
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor de copia. Inicializa el punto copiando las coordenadas de otro punto.
     *
     * @param otro el punto del cual se copiarán las coordenadas.
     */
    public Punto(Punto otro) {
        this.x = otro.x;
        this.y = otro.y;
    }

    /**
     * Obtiene la coordenada X del punto.
     *
     * @return la coordenada X.
     */
    public int getX() {
        return x;
    }

    /**
     * Establece la coordenada X del punto.
     *
     * @param x la nueva coordenada X.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Obtiene la coordenada Y del punto.
     *
     * @return la coordenada Y.
     */
    public int getY() {
        return y;
    }

    /**
     * Establece la coordenada Y del punto.
     *
     * @param y la nueva coordenada Y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Devuelve una representación en cadena del punto.
     * El formato de salida es "(x: valor, y: valor)".
     *
     * @return una cadena que representa el punto.
     */
    @Override
    public String toString() {
        return String.format("(x: %d, y: %d)", this.x, this.y);
    }
}