package ro.uvt.models;

public class Paragraph implements Element{
    private final String text;
    private AlignStrategy textAlignment;
    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.textAlignment = alignStrategy;
    }
    @Override
    public void print() {
        if (textAlignment != null) {
            // dacă are strategie -> o folosește
            textAlignment.render(this, 40); // contextWidth = 40 (exemplu)
        } else {
            // dacă nu are strategie -> doar afișează textul normal
            System.out.println("Paragraph: " + text);
        }
    }

    @Override
    public void add(Element element) {}
    @Override
    public void remove(Element element) {}
    @Override
    public Element get(int index) {
        return null;
    }
}
