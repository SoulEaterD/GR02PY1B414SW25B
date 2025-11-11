public class Usuario {

    private String id;
    private String nombre;
    private String correo;
    private String contrasenia;
    private boolean permisos;

    public Usuario(String id, String nombre,String correo, String contrasenia, boolean permisos) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.permisos = permisos;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isPermisos() {
        return permisos;
    }
    
    public void setPermisos(boolean permisos) {
        this.permisos = permisos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
