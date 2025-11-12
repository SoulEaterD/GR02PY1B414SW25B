import java.util.ArrayList;
import java.util.List;

public class Curso {

    private int idCurso;
    private String nombreCurso;
    private String descripcionCurso;
    private Docente docente;
    private List<Estudiante> estudiantes;
    private List<Material> material;
    private List<Tarea> tareas;
    private RegistroNotas rNotas;

    public Tarea obtenerTareaPorTitulo(String titulo) {
        if (tareas == null)
            return null;
        for (Tarea t : tareas) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                return t;
            }
        }
        return null;
    }

    public List<Tarea> crearTarea(String titulo, String descripcion) {
        Tarea tarea = new Tarea(titulo, descripcion);
        tareas.add(tarea);
        for (Estudiante est : estudiantes) {
            est.setDeberes(new ArrayList<>(tareas));
        }
        return tareas;
    }

    public void calificarTarea(Estudiante estudiante,Tarea tarea, Double calificacion) {
        estudiante.getNotasEstudiante().getCalificaciones().add(calificacion);
        tarea.setCalificacion(calificacion);
        rNotas.getCalificaciones().add(calificacion);
    }

    public Material crearMaterial(int id, String titulo, String tipo, String url) {
        Material mat = new Material(id, titulo, tipo, url);
        material.add(mat);
        return mat;
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

    public RegistroNotas getrNotas() {
        return rNotas;
    }

    public void setrNotas(RegistroNotas rNotas) {
        this.rNotas = rNotas;
    }
}