public class TableOfContents implements Element {
    @Override
    public void print() {
        System.out.println("Table of Contents");
    }

    @Override
    public void add(Element e) {}
    @Override
    public void remove(Element e) {}
    @Override
    public Element get(int index) { return null; }
}
