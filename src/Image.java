public class Image implements Element {
    private final String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + this.url);
    }

    @Override
    public void add(Element element) {}
    @Override
    public void remove(Element element) {}
    @Override
    public Element get(int index) { return null; }
}
