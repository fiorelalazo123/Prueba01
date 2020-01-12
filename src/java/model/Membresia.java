
package model;


public class Membresia {
    
    private int id;
    private String tipo;
    private Double precio;    
    private String estado;

    public Membresia() {
        
    }

    public Membresia(int id, String tipo, Double precio, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    

       }