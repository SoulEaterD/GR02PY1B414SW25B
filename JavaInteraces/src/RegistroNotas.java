import java.util.ArrayList;
import java.util.List;

public class RegistroNotas {

    // confuso (cambiar) hay que pensarle mas
    private List<Double> calificaciones;

    public void agregarCalificacion(Double calificacion) {
        calificaciones.add(calificacion);
    }

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
