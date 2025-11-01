import java.util.ArrayList;
import java.util.List;

public class Chapter implements Element {
    private final String title;
    private final List<Subchapter> subChapters = new ArrayList<>();

    public Chapter(String title) {
        this.title = title;
    }

    public void addSubChapter(Subchapter subChapter) {
        subChapters.add(subChapter);
    }

    @Override
    public int get(Element element) {
        return subChapters.indexOf(element);
    }

    @Override
    public Element getParent() {
        return null;
    }

    @Override
    public void setParent(Element element) {

    }

    @Override
    public void print() {
        System.out.println("Chapter: " + title);
        for (Subchapter sc : subChapters) {
            sc.print();
        }
    }

    @Override
    public void add(Element element) {

    }

    @Override
    public void remove(Element element) {

    }
}
