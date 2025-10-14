package com.logic;

import com.persistence.Books;
import java.util.ArrayList;
import java.util.Comparator;

/**
+ * Controlador simple para gestionar libros en memoria y delegar la persistencia.
 *
 * Responsabilidades:
 * - Mantener una lista en memoria de objetos Book
 * - Proveer operaciones básicas: listar, añadir, actualizar, eliminar por id
 * - Cargar y guardar la lista usando la clase de persistencia `Books`
 *
 * Notas de diseño:
 * - Los métodos están sincronizados para protección básica contra acceso concurrente
 *   (suficiente para una aplicación Swing sencilla). Si se requiere alta concurrencia,
 *   habría que replantear la estrategia.
 */
public class Bookcontroller {
    // Dependencia a la capa de persistencia (CSV en este proyecto)
    private final Books persistence;

    // Lista en memoria que almacena los libros actualmente cargados
    private final ArrayList<Book> books;

    // Constructor por defecto crea su propia instancia de persistencia
    public Bookcontroller() {
        this(new Books());
    }

    // Permite inyectar una implementación de persistencia (útil para pruebas)
    public Bookcontroller(Books persistence) {
        this.persistence = persistence;
        this.books = new ArrayList<Book>();
    }

    /**
     * Devuelve una vista inmodificable de la lista de libros.
     * Se devuelve una copia para evitar que el cliente modifique la lista interna.
     */
    public synchronized ArrayList<Book> list() {
        return new ArrayList<Book>(books);
    }

    /**
     * Añade un libro a la colección.
     * - Si el libro no tiene id (<=0) o si su id choca con uno existente, se asigna
     *   un id nuevo mediante nextId().
     * - Devuelve el libro añadido (posible con id actualizado).
     */
    public synchronized Book add(Book b) {
        if (b == null) throw new IllegalArgumentException("book == null");
        if (b.getId() <= 0) b.setId(nextId());
        else if (findById(b.getId()) != null) b.setId(nextId());
        books.add(b);
        return b;
    }

    /**
     * Elimina un libro por su id. Devuelve true si se eliminó un elemento.
     */
    public synchronized boolean removeById(int id) {
        Book found = findById(id);
        if (found != null) return books.remove(found);
        return false;
    }

    /**
     * Actualiza un libro existente (busca por id y sustituye el objeto en la lista).
     * Devuelve true si se realizó la actualización.
     */
    public synchronized boolean update(Book updated) {
        if (updated == null) return false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == updated.getId()) {
                books.set(i, updated);
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un libro por id y devuelve la instancia si existe.
     */
    public synchronized Book findById(int id) {
        for (Book b : books) if (b != null && b.getId() == id) return b;
        return null;
    }

    /**
     * Carga la lista desde la persistencia y ordena por id.
     * - Borra la lista en memoria y añade los elementos cargados.
     */
    public synchronized void load() {
        ArrayList<Book> loaded = persistence.downloadProductFile();
        books.clear();
        if (loaded != null) books.addAll(loaded);
        books.sort(Comparator.comparingInt(Book::getId));
    }

    /**
     * Guarda la lista actual en la persistencia (hace una copia defensiva).
     */
    public synchronized void save() {
        persistence.uploadWriteFile(new ArrayList<>(books));
    }

    /**
     * Calcula el siguiente id disponible (max + 1). Se usa cuando un libro no tiene id.
     */
    private int nextId() {
        int max = 0;
        for (Book b : books) if (b != null && b.getId() > max) max = b.getId();
        return max + 1;
    }
}
