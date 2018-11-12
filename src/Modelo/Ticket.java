package Modelo;

//import java.sql.Timestamp;

public class Ticket {
    
    private int id;
    private int cliente;
    private int tecnico;
    private String descripcion;
    private int estado;
    private String fechaCreacion;
    private String fechaFinalizacion;

    public Ticket() {
    }

    public Ticket(int id, int cliente, int tecnico, String descripcion, int estado, String fechaCreacion, String fechaFinalizacion) {
        this.id = id;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getTecnico() {
        return tecnico;
    }

    public void setTecnico(int tecnico) {
        this.tecnico = tecnico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", cliente=" + cliente + ", tecnico=" + tecnico + ", descripcion=" + descripcion + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion + ", fechaFinalizacion=" + fechaFinalizacion + '}';
    }
    
}
