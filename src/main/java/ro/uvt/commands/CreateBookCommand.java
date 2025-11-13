package ro.uvt.commands;

import ro.uvt.services.BooksService;

public class CreateBookCommand implements Command {
    private final BooksService service;
    private final String book;

    public CreateBookCommand(BooksService service, String book) {
        this.service = service;
        this.book = book;
    }

    @Override
    public Object execute() {
        System.out.println("Executing CreateBookCommand...");
        return service.createBook(book);
    }
}
