import java.util.ArrayList;
import java.util.List;

public class RegistroNotas {

    //confuso (cambiar) hay que pensarle mas
    private List<Evaluacion> calificaciones;
    public void registrarEvaluacion (Evaluacion evaluacion){
        if (calificaciones ==null) {
            calificaciones = new ArrayList<>();
        }
        calificaciones.add(evaluacion);
    }
    public RegistroNotas(List<Evaluacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public List<Evaluacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Evaluacion> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
