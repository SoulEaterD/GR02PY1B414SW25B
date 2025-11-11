import java.util.ArrayList;
import java.util.List;

public class RegistroNotas {

    //confuso (cambiar) hay que pensarle mas
    private List<Evaluacion> calificaciones;
    public void registrarEvaluacion (Evaluacion evaluacion){
        calificaciones.add(evaluacion);
    }
    public RegistroNotas() {
        this.calificaciones = new ArrayList<>();
    }

    public List<Evaluacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Evaluacion> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
