package ro.uvt.commands;

import ro.uvt.services.BooksService;

public class GetBookByIdCommand implements Command {
    private final BooksService service;
    private final int id;

    public GetBookByIdCommand(BooksService service, int id) {
        this.service = service;
        this.id = id;
    }

    @Override
    public Object execute() {
        System.out.println("Executing GetBookByIdCommand...");
        return service.getBook(id);
    }
}
