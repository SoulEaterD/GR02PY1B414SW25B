import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario {

    private List<Curso> cursosEstudiante;
    private RegistroNotas notasEstudiante;
    private List<Evaluacion> evaluacionesRealizadas;

    public void asignarNotaRegistro(Evaluacion evaluacion) {
        notasEstudiante.registrarEvaluacion(evaluacion);
        evaluacionesRealizadas.add(evaluacion);
    }

    public void guardarCurso(Curso curso){
        cursosEstudiante.add(curso);
    }

    public Estudiante(String id, String correo, String contrasenia) {
        super(id, correo, contrasenia, false);
        this.cursosEstudiante = new ArrayList<>();
        this.evaluacionesRealizadas = new ArrayList<>();
        this.notasEstudiante = new RegistroNotas();
    }

    public List<Curso> getCursosEstudiante() {
        return cursosEstudiante;
    }

    public void setCursosEstudiante(List<Curso> cursosEstudiante) {
        this.cursosEstudiante = cursosEstudiante;
    }

    public RegistroNotas getNotasEstudiante() {
        return notasEstudiante;
    }

    public void setNotasEstudiante(RegistroNotas notasEstudiante) {
        this.notasEstudiante = notasEstudiante;
    }

    public List<Evaluacion> getEvaluacionesRealizadas() {
        return evaluacionesRealizadas;
    }

    public void setEvaluacionesRealizadas(List<Evaluacion> evaluacionesRealizadas) {
        this.evaluacionesRealizadas = evaluacionesRealizadas;
    }

        
}