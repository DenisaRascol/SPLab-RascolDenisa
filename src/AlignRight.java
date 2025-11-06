public class AlignRight implements AlignStrategy{
    @Override
    public void render(Paragraph paragraph, int context) {
        String text = paragraph.getText();
        int spaces = context - text.length();
        if (spaces < 0) spaces = 0; // dacă textul e prea lung, nu adăugăm spații
        String padding = " ".repeat(spaces);
        System.out.println("Paragraph (Right): " + padding + text);

    }
}