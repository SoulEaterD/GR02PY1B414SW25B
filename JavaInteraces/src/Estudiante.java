import java.util.ArrayList;
import java.util.List;

public class Estudiante {

    private String nombreEstudiante;
    private String idEstudiante;
    private String correoEstudiante;
    private String contraseniaEstudiante;
    private boolean permisosEstudiante;
    private List<Curso> cursosEstudiante;
    private RegistroNotas notasEstudiante;
    private List<Evaluacion> evaluacionesRealizadas;

    public void asignarNotaRegistro(Evaluacion evaluacion) {
        if (notasEstudiante == null && evaluacionesRealizadas == null) {
            notasEstudiante = new RegistroNotas(null);
            notasEstudiante.registrarEvaluacion(evaluacion);
            evaluacionesRealizadas =  new ArrayList<>();
        }else{
            notasEstudiante.registrarEvaluacion(evaluacion);
        }
    }

    public void guardarCurso(Curso curso){
        if(cursosEstudiante==null){
            cursosEstudiante = new ArrayList<>();
        }
        cursosEstudiante.add(curso);
    }

    public Estudiante(String nombreEstudiante, String idEstudiante, String correoEstudiante, String contraseniaEstudiante, List<Curso> cursosEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
        this.idEstudiante = idEstudiante;
        this.correoEstudiante = correoEstudiante;
        this.contraseniaEstudiante = contraseniaEstudiante;
        this.permisosEstudiante = false;
        this.cursosEstudiante = cursosEstudiante;
    }
    
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCorreoEstudiante() {
        return correoEstudiante;
    }

    public void setCorreoEstudiante(String correoEstudiante) {
        this.correoEstudiante = correoEstudiante;
    }

    public String getContraseniaEstudiante() {
        return contraseniaEstudiante;
    }

    public void setContraseniaEstudiante(String contraseniaEstudiante) {
        this.contraseniaEstudiante = contraseniaEstudiante;
    }

    public boolean isPermisosEstudiante() {
        return permisosEstudiante;
    }

    public List<Curso> getCursosEstudiante() {
        return cursosEstudiante;
    }

    public void setPermisosEstudiante(boolean permisosEstudiante) {
        this.permisosEstudiante = permisosEstudiante;
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