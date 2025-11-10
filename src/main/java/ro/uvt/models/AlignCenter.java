package ro.uvt.models;

public class AlignCenter implements AlignStrategy{
    @Override
    public void render(Paragraph paragraph, int context)
    {
        String text = paragraph.getText();
        int spaces = (context - text.length()) / 2;
        if (spaces < 0) spaces = 0;
        String padding = " ".repeat(spaces);
        System.out.println("Paragraph (Center): " + padding + text);
    }
}