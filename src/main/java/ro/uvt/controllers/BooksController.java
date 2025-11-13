package ro.uvt.controllers;

import org.springframework.web.bind.annotation.*;
import ro.uvt.services.BooksService;
import ro.uvt.commands.*;

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
    public Object createBook(@RequestBody String book) {
        Command cmd = new CreateBookCommand(service, book);
        return cmd.execute();
    }

    @PutMapping("/{id}")
    public Object updateBook(@PathVariable int id, @RequestBody String newBook) {
        Command cmd = new UpdateBookCommand(service, id, newBook);
        return cmd.execute();
    }

    @DeleteMapping("/{id}")
    public Object deleteBook(@PathVariable int id) {
        Command cmd = new DeleteBookCommand(service, id);
        return cmd.execute();
    }
}
