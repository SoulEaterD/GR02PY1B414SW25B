import java.util.List;

public class Curso {

    private int idCurso;
    private String nombreCurso;
    private String descripcionCurso;
    private Docente docente;
    private List<Inscripcion> inscripcion;
    private List<Estudiante> estudiantes;
    private List<Material> material;
    private List<Evaluacion> evaluacion;
    
    public Curso(int idCurso, String nombreCurso, String descripcionCurso, Docente docente,
            List<Inscripcion> inscripcion, List<Estudiante> estudiantes, List<Material> material,
            List<Evaluacion> evaluacion) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.descripcionCurso = descripcionCurso;
        this.docente = docente;
        this.inscripcion = inscripcion;
        this.estudiantes = estudiantes;
        this.material = material;
        this.evaluacion = evaluacion;
    }

    public List<Inscripcion> getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(List<Inscripcion> inscripciones) {
        this.inscripcion = inscripciones;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiante) {
        this.estudiantes = estudiante;
    }

    public List<Material> getMaterial() {
        return material;
    }

    public void setMaterial(List<Material> material) {
        this.material = material;
    }

    public List<Evaluacion> getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(List<Evaluacion> evaluacione) {
        this.evaluacion = evaluacione;
    }

}
