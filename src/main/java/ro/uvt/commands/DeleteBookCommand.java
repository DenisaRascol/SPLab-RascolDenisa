package ro.uvt.commands;

import ro.uvt.services.BooksService;

public class DeleteBookCommand implements Command {
    private final BooksService service;
    private final int id;
    public DeleteBookCommand(BooksService service, int id) { this.service = service; this.id = id; }
    @Override public Object execute() { return service.deleteBook(id); }
}
