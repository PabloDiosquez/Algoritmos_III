import java.util.ArrayList;

public class Carrera {
    private int codigo;
    private String nombre;
    private ArrayList<Materia> materias;
    private ArrayList<Alumno> alumnos;
    private int creditosTotales;

    public Carrera(int codigo, String nombre, int creditosTotales) {
        this.codigo = codigo;
        this.nombre = nombre;
        materias = new ArrayList<>();
        alumnos = new ArrayList<>();
        this.creditosTotales = creditosTotales;
    }

    public void agregarAlumno(Alumno alumno){
        alumnos.add(alumno);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }
}
