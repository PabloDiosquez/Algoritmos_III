public class Materia {
    private int codigo;
    private String nombre;
    private int creditos;
    private boolean esObligatoria;

    public Materia(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Materia(int codigo, String nombre, int creditos) {
        this(codigo, nombre);
        this.creditos = creditos;
    }

    public Materia(int codigo, String nombre, int creditos, boolean esObligatoria) {
        this(codigo, nombre, creditos);
        this.esObligatoria = esObligatoria;
    }

    public Materia(Materia otra) {
        this(otra.codigo, otra.nombre, otra.creditos);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public boolean isEsObligatoria() {
        return esObligatoria;
    }

    public void setEsObligatoria(boolean esObligatoria) {
        this.esObligatoria = esObligatoria;
    }

    @Override
    public String toString() {
        return String.format("Cod: %d -- Nombre: %s", this.codigo, this.nombre);
    }
}
