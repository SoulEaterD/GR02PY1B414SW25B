import java.util.ArrayList;
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


    public Material crearMaterial(int id, String titulo, String tipo, String url) {
        if (material == null) {
            material = new ArrayList<>();
        }
        Material mat = new Material (1, "Material de prueba", "Contenido de prueba", "www.google.com");
        material.add(mat);
        return mat;
    }


    public Inscripcion solicitarInscripcion(Estudiante estudiante){
       if (inscripcion==null && estudiantes==null){
            inscripcion = new ArrayList<>();
            estudiantes = new ArrayList<>();
        }
        Inscripcion in1 = new Inscripcion(idCurso, descripcionCurso, estudiante, this);
        inscripcion.add(in1);
        estudiantes.add(in1.getEstudiante());
        estudiante.guardarCurso(this);
        return in1;
    }
    



    public void mostrarMaterial(){
        if (material == null) {
            System.out.println("No hay material disponible.");
        }else{
            for (Material mat : material) {
                System.out.println("ID Material: "+ mat.getIdMaterial());
                System.out.println("Título: "+ mat.getTitulo());
                System.out.println("Contenido: "+ mat.getTipo());
                System.out.println("Enlace: "+ mat.getUrl());
            }
        }
    }

    public Evaluacion elegirEvaluacion(Estudiante estudiante) {
        mostrarEvaluacionesDisponibles();
        Evaluacion ev = getEvaluacion().get(0);
        ev.rendirEvaluacion();
        estudiante.asignarNotaRegistro(ev);
        estudiante.getEvaluacionesRealizadas().add(ev);
        return ev;
    }
    public Evaluacion crearEvaluacion(String titulo, List<Pregunta> preguntas) {
        if (evaluacion ==null) {
            evaluacion = new ArrayList<>();
        }
        Evaluacion evaluacionC = new Evaluacion(titulo, null, 0);
        evaluacionC.setPreguntas(evaluacionC.crearPreguntas(2));
        evaluacion.add(evaluacionC);
        return evaluacionC;
    }
    public void mostrarEvaluacionesDisponibles() {
        if (evaluacion != null) {
            int numeroEvaluaciones = 1;
            for (Evaluacion eval : evaluacion) {
                System.out.println(numeroEvaluaciones+"Título: " + eval.getTitulo());
                System.out.println(eval.getPreguntas().size() + " preguntas disponibles.");
                System.out.println(eval.getPreguntas().get(0).getOpciones().size() + " opciones por pregunta.");
                numeroEvaluaciones++;
            }
        } else {
            System.out.println("No hay evaluaciones disponibles.");
        }
    }
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
