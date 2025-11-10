package ro.uvt.models;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, int context) {
        String text = paragraph.getText();
        System.out.println("Paragraph (Left): " + text);
    }
}