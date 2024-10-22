import java.util.ArrayList;
import java.util.List;

public class libroDAOImpl implements libroDAO {
    private List<libro> libros;
    private int siguienteId;

    public libroDAOImpl() {
        this.libros = new ArrayList<>();
        this.siguienteId = 1; // Para generar IDs únicos
    }

    @Override
    public void crear(libro libro) {
        libro = new libro(siguienteId++, libro.getTitulo(), libro.getAutor(), libro.getAnioPublicacion());
        libros.add(libro);
    }

    @Override
    public libro leer(int id) {
        return libros.stream().filter(libro -> libro.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<libro> listar() {
        return new ArrayList<>(libros);
    }

    @Override
    public void actualizar(libro libroActualizado) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == libroActualizado.getId()) {
                libros.set(i, libroActualizado);
                return;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        libros.removeIf(libro -> libro.getId() == id);
    }
}
