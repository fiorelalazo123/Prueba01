package model;

public class Ejercicio {
    private int id;
    private String nombre;
    private String musculo;
    private String estado;

    public Ejercicio() {
    }

    public Ejercicio(int id, String nombre, String musculo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.musculo = musculo;
        this.estado = estado;
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

    public String getMusculo() {
        return musculo;
    }

    public void setMusculo(String musculo) {
        this.musculo = musculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
