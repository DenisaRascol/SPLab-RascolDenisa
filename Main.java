public class Main {
    public static void main(String[] args) {
        Author author = new Author("Ion Creanga");
        Book book = new Book("Amintiri din Copilarie");
        book.addAuthor(author);

        Chapter chapter = new Chapter("Capitolul 1");
        SubChapter subChapter = new SubChapter("Subcapitolul 1.1");
        subChapter.addElement(new Paragraph("Primul paragraf"));
        subChapter.addElement(new Image("Imaginea 1"));
        subChapter.addElement(new Table("Tabelul 1"));
        chapter.addSubChapter(subChapter);

        book.addChapter(chapter);
        book.setTableOfContents(new TableOfContents());

        book.print();
    }
}
