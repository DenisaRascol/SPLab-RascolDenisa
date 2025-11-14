package ro.uvt.commands;

import ro.uvt.services.BooksService;
import java.util.List;

public class UpdateBookCommand implements Command {
    private final BooksService service;
    private final int id;
    private final String newTitle;
    private final List<Integer> authorIds;

    public UpdateBookCommand(BooksService service, int id, String newTitle, List<Integer> authorIds) {
        this.service = service; this.id = id; this.newTitle = newTitle; this.authorIds = authorIds;
    }

    @Override public Object execute() {
        return service.updateBook(id, newTitle, authorIds);
    }
}
