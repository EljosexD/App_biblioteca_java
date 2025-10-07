package com.igu;

import com.logic.Book;
import com.persistence.Books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Controller responsable de la gestión en memoria de la colección de libros.
 * Provee métodos para añadir, listar, buscar, actualizar, borrar y persistir
 * la colección usando la clase {@link Books}.
 *
 * Diseño pensado para ser sencillo y reutilizable por la UI (por ejemplo, por
 * un `JTable` / `TableModel`).
 */
public class Bookcontroller {

	private final List<Book> books;
	private final Books persistence;

	public Bookcontroller() {
		this(new Books());
	}

	public Bookcontroller(Books persistence) {
		this.persistence = persistence;
		this.books = new ArrayList<>();
	}

	/**
	 * Devuelve una copia inmutable de la lista de libros (para evitar modificaciones externas).
	 */
	public synchronized List<Book> list() {
		return Collections.unmodifiableList(new ArrayList<>(books));
	}

	/**
	 * Añade un libro a la colección. Si el id es 0 o negativo se le asigna
	 * automáticamente un id único incremental.
	 * @return el libro añadido (misma instancia pasada como parámetro)
	 */
	public synchronized Book add(Book book) {
		if (book == null) throw new IllegalArgumentException("book == null");
		if (book.getId() <= 0) {
			book.setId(nextId());
		} else {
			// asegurar que no haya conflicto de id
			if (findById(book.getId()).isPresent()) {
				book.setId(nextId());
			}
		}
		books.add(book);
		return book;
	}

	/**
	 * Elimina un libro por su id.
	 * @return true si se eliminó algún libro
	 */
	public synchronized boolean removeById(int id) {
		Optional<Book> found = findById(id);
		if (found.isPresent()) {
			return books.remove(found.get());
		}
		return false;
	}

	/**
	 * Actualiza un libro existente (se busca por id). Retorna true si la actualización tuvo éxito.
	 */
	public synchronized boolean update(Book updated) {
		if (updated == null) throw new IllegalArgumentException("updated == null");
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == updated.getId()) {
				books.set(i, updated);
				return true;
			}
		}
		return false;
	}

	/**
	 * Busca un libro por id.
	 */
	public synchronized Optional<Book> findById(int id) {
		return books.stream().filter(b -> b.getId() == id).findFirst();
	}

	/**
	 * Busca libros cuyo nombre contenga el texto (case-insensitive).
	 */
	public synchronized List<Book> findByName(String text) {
		if (text == null || text.isEmpty()) return new ArrayList<>();
		String lower = text.toLowerCase();
		List<Book> out = new ArrayList<>();
		for (Book b : books) {
			if (b.getName() != null && b.getName().toLowerCase().contains(lower)) {
				out.add(b);
			}
		}
		return out;
	}

	/**
	 * Carga la lista desde la persistencia (archivo CSV) y la reemplaza en memoria.
	 * @return la lista cargada
	 */
	public synchronized List<Book> load() {
		List<Book> loaded = persistence.downloadProductFile();
		books.clear();
		if (loaded != null) books.addAll(loaded);
		// ordenar por id para consistencia visual
		books.sort(Comparator.comparingInt(Book::getId));
		return list();
	}

	/**
	 * Persiste la lista actual en memoria usando la clase {@link Books}.
	 */
	public synchronized void save() {
		// Books.uploadWriteFile espera un ArrayList<Book>
		persistence.uploadWriteFile(new ArrayList<>(books));
	}

	private int nextId() {
		return books.stream().mapToInt(Book::getId).max().orElse(0) + 1;
	}

}
