package ro.uvt.commands;

import ro.uvt.services.BooksService;

public class UpdateBookCommand implements Command {
    private final BooksService service;
    private final int id;
    private final String newBook;

    public UpdateBookCommand(BooksService service, int id, String newBook) {
        this.service = service;
        this.id = id;
        this.newBook = newBook;
    }

    @Override
    public Object execute() {
        System.out.println("Executing UpdateBookCommand...");
        return service.updateBook(id, newBook);
    }
}
