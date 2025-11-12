import java.util.ArrayList;
import java.util.List;

public class RegistroNotas {

    private List<Double> calificaciones;

    public RegistroNotas() {
        this.calificaciones = new ArrayList<>();
    }

    public List<Double> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Double> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
