import java.util.List;

public class Curso {
    private int idCurso;
    private String nombreCurso;
    private String descripcionCurso;
    private Docente docente;
    private List<Inscripcion> inscripciones;
    private List<Estudiante> estudiante;
    private List<Material> materiale; 
    private List<Evaluacion> evaluacione;
    
    public Curso(int idCurso, String nombreCurso, String descripcionCurso, Docente docente,
            List<Inscripcion> inscripciones, List<Estudiante> estudiante, List<Material> materiale,
            List<Evaluacion> evaluacione) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.descripcionCurso = descripcionCurso;
        this.docente = docente;
        this.inscripciones = inscripciones;
        this.estudiante = estudiante;
        this.materiale = materiale;
        this.evaluacione = evaluacione;
    }
    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }
    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
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
    public List<Estudiante> getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(List<Estudiante> estudiante) {
        this.estudiante = estudiante;
    }
    public List<Material> getMateriale() {
        return materiale;
    }
    public void setMateriale(List<Material> materiale) {
        this.materiale = materiale;
    }
    public List<Evaluacion> getEvaluacione() {
        return evaluacione;
    }
    public void setEvaluacione(List<Evaluacion> evaluacione) {
        this.evaluacione = evaluacione;
    } 
}
