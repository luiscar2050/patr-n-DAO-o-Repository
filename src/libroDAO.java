import java.util.List;

public interface libroDAO {
    void crear(libro libro);
    libro leer(int id);
    List<libro> listar();
    void actualizar(libro libro);
    void eliminar(int id);
}
