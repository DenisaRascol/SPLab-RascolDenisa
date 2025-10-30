import java.util.ArrayList;
import java.util.List;

public class Subchapter implements Element {
    private final String title;
    private final List<Element> elements = new ArrayList<>();

    public Subchapter(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("  SubChapter: " + title);
        for (Element c : elements) {
            c.print();
        }
    }

    @Override
    public void add(Element element) {

    }

    @Override
    public void remove(Element element) {

    }

    @Override
    public int get(Element element) {
        return 0;
    }

    @Override
    public Element getParent() {
        return null;
    }

    @Override
    public void setParent(Element element) {

    }
}
