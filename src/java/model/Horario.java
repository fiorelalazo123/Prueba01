
package model;





public class Horario {
    private int id;
    private String dia;
    private int horas;
    private String estado;

    
      public Horario() {
    }

    public Horario(int id, String dia, int horas, String estado) {
        this.id = id;
        this.dia = dia;
        this.horas = horas;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    }
   