public class Main {
    private static libroDAO LibroDAO;

    public static void main(String[] args) {
        libroDAO libroDAO = new libroDAOImpl();

        libroDAO.crear(new libro(0, "Spiderman 2", "Stan lee", 2004));
        libroDAO.crear(new libro(0, "Harry Potter y la piedra filosofal", "J. K. Rowling", 1997 ));

        System.out.println("Lista de libros:");
        for (libro libro : libroDAO.listar()) {
            System.out.println(libro);
        }

        libro libroLeido = libroDAO.leer(1);
        System.out.println("\nLibro leído: " + libroLeido);

        libroLeido = new libro(libroLeido.getId(), "Spiderman 3", "Stan lee", 2007);
        libroDAO.actualizar(libroLeido);
        System.out.println("\nLibro actualizado: " + libroDAO.leer(1));

        libroDAO.eliminar(2);
        System.out.println("\nLista de libros después de eliminar:");
        for (libro libro : libroDAO.listar()) {
            System.out.println(libro);
        }
    }
}
