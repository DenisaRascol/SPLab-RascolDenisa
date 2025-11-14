package ro.uvt.controllers;

import org.springframework.web.bind.annotation.*;
import ro.uvt.services.BooksService;
import ro.uvt.commands.*;
import ro.uvt.dto.BookDTO;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService service;

    public BooksController(BooksService service) {
        this.service = service;
    }

    @GetMapping
    public Object getAllBooks() {
        Command cmd = new GetBooksCommand(service);
        return cmd.execute();
    }

    @GetMapping("/{id}")
    public Object getBookById(@PathVariable int id) {
        Command cmd = new GetBookByIdCommand(service, id);
        return cmd.execute();
    }

    @PostMapping
    public Object createBook(@RequestBody BookDTO dto) {
        Command cmd = new CreateBookCommand(service, dto.title, dto.authorIds);
        return cmd.execute();
    }

    @PutMapping("/{id}")
    public Object updateBook(@PathVariable int id, @RequestBody BookDTO dto) {
        Command cmd = new UpdateBookCommand(service, id, dto.title, dto.authorIds);
        return cmd.execute();
    }

    @DeleteMapping("/{id}")
    public Object deleteBook(@PathVariable int id) {
        Command cmd = new DeleteBookCommand(service, id);
        return cmd.execute();
    }
}
