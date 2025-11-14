package ro.uvt.commands;

import ro.uvt.services.BooksService;
import java.util.List;

public class CreateBookCommand implements Command {
    private final BooksService service;
    private final String title;
    private final List<Integer> authorIds;

    public CreateBookCommand(BooksService service, String title, List<Integer> authorIds) {
        this.service = service;
        this.title = title;
        this.authorIds = authorIds;
    }

    @Override public Object execute() {
        return service.createBook(title, authorIds);
    }
}
