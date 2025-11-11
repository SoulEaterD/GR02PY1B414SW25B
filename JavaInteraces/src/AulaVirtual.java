import java.util.ArrayList;
import java.util.List;

public class AulaVirtual {
    
    List<Curso> cursosDisponibles;
    List<Docente> docentesDisponibles;
    List<Estudiante> estudiantesRegistrados;
    public AulaVirtual(List<Curso> cursosDisponibles, List<Docente> docentesDisponibles,
            List<Estudiante> estudiantesRegistrados) {
        this.cursosDisponibles = new ArrayList<>();
        this.docentesDisponibles = new ArrayList<>();
        this.estudiantesRegistrados = new ArrayList<>();
    }
    public Curso crearCurso(int idCurso,  String nombreCurso, String descripcionCurso, Docente docente, List<Inscripcion> inscripcion, List<Estudiante> estudiantes, List<Material> material, List<Evaluacion> evaluacion){
        Curso c1 = new Curso(idCurso, nombreCurso, descripcionCurso, docente, inscripcion, estudiantes, material, evaluacion);
        cursosDisponibles.add(c1);
        return c1;
    }

    public Curso seleccionarCurso(Estudiante estudiante){
        Curso c1 = cursosDisponibles.get(0);
        c1.solicitarInscripcion(estudiante);
        return c1;
    }
    public List<Curso> getCursosDisponibles() {
        return cursosDisponibles;
    }
    public void setCursosDisponibles(List<Curso> cursosDisponibles) {
        this.cursosDisponibles = cursosDisponibles;
    }
    public List<Docente> getDocentesDisponibles() {
        return docentesDisponibles;
    }
    public void setDocentesDisponibles(List<Docente> docentesDisponibles) {
        this.docentesDisponibles = docentesDisponibles;
    }
    public List<Estudiante> getEstudiantesRegistrados() {
        return estudiantesRegistrados;
    }
    public void setEstudiantesRegistrados(List<Estudiante> estudiantesRegistrados) {
        this.estudiantesRegistrados = estudiantesRegistrados;
    }

}
