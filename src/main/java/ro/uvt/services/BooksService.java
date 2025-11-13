package ro.uvt.services;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BooksService {
    private final Map<Integer, String> books = new HashMap<>();
    private int nextId = 0;

    public List<String> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public String getBook(int id) {
        return books.getOrDefault(id, "Book not found");
    }

    public String createBook(String book) {
        books.put(nextId++, book);
        return "Book created: " + book;
    }

    public String updateBook(int id, String newBook) {
        books.put(id, newBook);
        return "Book updated: " + newBook;
    }

    public String deleteBook(int id) {
        books.remove(id);
        return "Book deleted with id=" + id;
    }
}
