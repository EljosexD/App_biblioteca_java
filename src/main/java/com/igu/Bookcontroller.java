package com.igu;

import com.logic.Book;
import com.persistence.Books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Simple controller to manage a list of Book in memory and persist via Books.
 */
public class Bookcontroller {
	private final Books persistence;
	private final ArrayList<Book> books;

	public Bookcontroller() {
		this(new Books());
	}

	public Bookcontroller(Books persistence) {
		this.persistence = persistence;
		this.books = new ArrayList<>();
	}

	public synchronized List<Book> list() {
		return Collections.unmodifiableList(new ArrayList<>(books));
	}

	public synchronized Book add(Book b) {
		if (b == null) throw new IllegalArgumentException("book == null");
		if (b.getId() <= 0) b.setId(nextId());
		else if (findById(b.getId()) != null) b.setId(nextId());
		books.add(b);
		return b;
	}

	public synchronized boolean removeById(int id) {
		Book found = findById(id);
		if (found != null) return books.remove(found);
		return false;
	}

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

	public synchronized Book findById(int id) {
		for (Book b : books) if (b != null && b.getId() == id) return b;
		return null;
	}

	public synchronized void load() {
		ArrayList<Book> loaded = persistence.downloadProductFile();
		books.clear();
		if (loaded != null) books.addAll(loaded);
		books.sort(Comparator.comparingInt(Book::getId));
	}

	public synchronized void save() {
		persistence.uploadWriteFile(new ArrayList<>(books));
	}

	private int nextId() {
		int max = 0;
		for (Book b : books) if (b != null && b.getId() > max) max = b.getId();
		return max + 1;
	}
}
