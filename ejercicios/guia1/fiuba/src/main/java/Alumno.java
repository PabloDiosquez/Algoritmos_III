import java.util.ArrayList;

public class Alumno {
    private int legajo;
    private String nomYAPell;
    private ArrayList<Carrera> carreras;
    private ArrayList<Materia> materias;
    private ArrayList<Materia> aprobadas;

    public Alumno(int legajo, String nomYAPell) {
        this.legajo = legajo;
        this.nomYAPell = nomYAPell;
        carreras = new ArrayList<>();
        materias = new ArrayList<>();
        aprobadas = new ArrayList<>();
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNomYAPell() {
        return nomYAPell;
    }

    public void setNomYAPell(String nomYAPell) {
        this.nomYAPell = nomYAPell;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void agregarCarrera(Carrera carrera) {
        this.carreras.add(carrera);
    }

    public void agregarMateriaAprobada(Materia materia){
        aprobadas.add(materia);
    }

    public String consultarEstado(Carrera carrera) {
        for (Carrera c : carreras) {
            if (carrera.getCodigo() == c.getCodigo()) {
                return "Estado: ACTIVO";
            }
        }
        return "Estado: INACTIVO";
    }

}
