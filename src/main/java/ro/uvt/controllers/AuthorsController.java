package ro.uvt.controllers;

import org.springframework.web.bind.annotation.*;
import ro.uvt.services.AuthorsService;
import ro.uvt.dto.AuthorDTO;
import ro.uvt.models.Author;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorsService service;
    public AuthorsController(AuthorsService service) { this.service = service; }

    @GetMapping
    public List<Author> getAll() { return service.getAllAuthors(); }

    @PostMapping
    public Author create(@RequestBody AuthorDTO dto) { return service.createAuthor(dto.name, dto.surname); }
}
