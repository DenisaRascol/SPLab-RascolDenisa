package ro.uvt.services;

import org.springframework.stereotype.Service;
import ro.uvt.models.Author;
import ro.uvt.persistence.AuthorsRepository;

import java.util.List;

@Service
public class AuthorsService {

    private final AuthorsRepository repo;
    public AuthorsService(AuthorsRepository repo) { this.repo = repo; }

    public List<Author> getAllAuthors() { return repo.findAll(); }

    public Author createAuthor(String name, String surname) {
        return repo.save(new Author(name, surname));
    }

    public Author getAuthor(int id) { return repo.findById(id).orElse(null); }
}
