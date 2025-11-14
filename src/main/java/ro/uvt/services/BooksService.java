package ro.uvt.services;

import org.springframework.stereotype.Service;
import ro.uvt.models.Book;
//import ro.uvt.models.Author;
import ro.uvt.persistence.BooksRepository;
import ro.uvt.persistence.AuthorsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final BooksRepository booksRepo;
    private final AuthorsRepository authorsRepo;

    public BooksService(BooksRepository booksRepo, AuthorsRepository authorsRepo) {
        this.booksRepo = booksRepo;
        this.authorsRepo = authorsRepo;
    }

    public List<Book> getAllBooks() {
        return booksRepo.findAll();
    }

    public Book getBook(int id) {
        return booksRepo.findById(id).orElse(null);
    }

    // create with title and optional list of author ids
    public Book createBook(String title, List<Integer> authorIds) {
        Book book = new Book(title);
        if (authorIds != null) {
            for (Integer aid : authorIds) {
                authorsRepo.findById(aid).ifPresent(book.getAuthors()::add);
            }
        }
        return booksRepo.save(book);
    }

    public Book updateBook(int id, String newTitle, List<Integer> authorIds) {
        Optional<Book> ob = booksRepo.findById(id);
        if (ob.isEmpty()) return null;
        Book b = ob.get();
        b.setTitle(newTitle);
        b.getAuthors().clear();
        if (authorIds != null) {
            for (Integer aid : authorIds) {
                authorsRepo.findById(aid).ifPresent(b.getAuthors()::add);
            }
        }
        return booksRepo.save(b);
    }

    public boolean deleteBook(int id) {
        if (!booksRepo.existsById(id)) return false;
        booksRepo.deleteById(id);
        return true;
    }
}
