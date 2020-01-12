
package interfac;

import model.Equipos;
import java.util.List;


public interface CRUD {
    public List listar();
    public Equipos list(int id);
    public boolean add(Equipos per);
    public boolean edit(Equipos per);
    public boolean eliminar(int id);
}
