package Modelo;

public class Usuario {
    
    private int id;
    private String nombre;
    private String documento;
    private String empresa;
    private String direccion;
    private String password;
    private int rol;
    private int especialidad;

    public Usuario(int id, String nombre, String documento, String empresa, String direccion, String password, int rol, int especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.empresa = empresa;
        this.direccion = direccion;
        this.password = password;
        this.rol = rol;
        this.especialidad = especialidad;
    }

    public Usuario() {
        this.id = 0;
        this.nombre = "";
        this.documento = "";
        this.empresa = "";
        this.direccion = "";
        this.password = "";
        this.rol = 0;
        this.especialidad = 0;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", documento=" + documento + ", empresa=" + empresa + ", direccion=" + direccion + ", password=" + password + ", rol=" + rol + ", especialidad=" + especialidad + '}';
    }
    
    
}


