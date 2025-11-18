package ro.uvt.controllers;

import org.springframework.web.bind.annotation.*;
import ro.uvt.services.BooksService;
import ro.uvt.commands.*;
import ro.uvt.dto.BookDTO;
import ro.uvt.models.Book;
import ro.uvt.observer.AllBooksSubject;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService service;
    private final AllBooksSubject subject;   

    public BooksController(BooksService service, AllBooksSubject subject) {
        this.service = service;
        this.subject = subject;
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
        Book created = (Book) cmd.execute();

        // 🔥 Notifică toți observatorii SSE
        subject.add(created);

        return created;
    }

    @PutMapping("/{id}")
    public Object updateBook(@PathVariable int id, @RequestBody BookDTO dto) {
        Command cmd = new UpdateBookCommand(service, id, dto.title, dto.authorIds);
        Book updated = (Book) cmd.execute();

        // 🔥 Notifică observatorii și pentru update (opțional)
        subject.add(updated);

        return updated;
    }

    @DeleteMapping("/{id}")
    public Object deleteBook(@PathVariable int id) {
        Command cmd = new DeleteBookCommand(service, id);
        return cmd.execute();
    }
}
