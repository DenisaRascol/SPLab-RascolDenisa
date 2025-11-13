package ro.uvt.commands;

import ro.uvt.services.BooksService;

public class GetBooksCommand implements Command {
    private final BooksService service;

    public GetBooksCommand(BooksService service) {
        this.service = service;
    }

    @Override
    public Object execute() {
        System.out.println("Executing GetBooksCommand...");
        return service.getAllBooks();
    }
}
