import java.util.ArrayList;
import java.util.List;

public class Curso {

    private int idCurso;
    private String nombreCurso;
    private String descripcionCurso;
    private Docente docente;
    private List<Estudiante> estudiantes;
    private List<Material> material;
    private List<Evaluacion> evaluacion;

    public Material crearMaterial(int id, String titulo, String tipo, String url, boolean deber) {
        Material mat = new Material(id, titulo, tipo, url, deber);
        if (mat.isDeber()) {
            for (Estudiante e : estudiantes) {
                e.getDeberes().add(mat);
            }
        }
        material.add(mat);
        return mat;
    }

    public void calificarTarea(Estudiante e, Double nota) {
        e.seleccionarEstudiante(nota);
    }

    public void solicitarInscripcion(Estudiante estudiante) {
        estudiantes.add(estudiante);
        estudiante.guardarCurso(this);
    }

    public void mostrarMaterial() {
        for (Material mat : material) {
            System.out.println("ID Material: " + mat.getIdMaterial());
            System.out.println("Título: " + mat.getTitulo());
            System.out.println("Contenido: " + mat.getTipo());
            System.out.println("Enlace: " + mat.getUrl());
        }
    }

    public Curso(int idCurso, String nombreCurso, String descripcionCurso, Docente docente) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.descripcionCurso = descripcionCurso;
        this.docente = docente;
        this.estudiantes = new ArrayList<>();
        this.material = new ArrayList<>();
        this.evaluacion = new ArrayList<>();
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