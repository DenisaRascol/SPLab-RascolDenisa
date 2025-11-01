import java.util.ArrayList;
import java.util.List;

public class Book implements Element {
    private final String title;
    private final List<Author> authors = new ArrayList<>();
    private final List<Element> elements = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        elements.add(element);
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);
        System.out.println("\nAuthors: ");
        for (Author a : authors) {
            a.print();
        }
        System.out.println("");
        for (Element e : elements) {
            e.print();
        }
    }

    @Override
    public void add(Element e) {
        elements.add(e);
    }

    @Override
    public void remove(Element e) {
        elements.remove(e);
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }
}
