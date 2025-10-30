public class Main {

    public static void main(String[] args) {
        // Creăm cartea cu date modificate
        Book povesti = new Book("Povesti pentru copii");
        Author mariaPop = new Author("Maria Popescu");
        povesti.addAuthor(mariaPop);

        Section capitol1 = new Section("Capitolul 1");
        Section capitol11 = new Section("Subcapitol 1.1");
        Section capitol111 = new Section("Subcapitol 1.1.1");
        Section capitol1111 = new Section("Partea finală 1.1.1.1");

        povesti.addElement(new Paragraph("A fost odata ca niciodata..."));
        povesti.addElement(capitol1);
        capitol1.add(new Paragraph("Introducere in capitol"));
        capitol1.add(capitol11);
        capitol11.add(new Paragraph("Text din subcapitol 1.1"));
        capitol11.add(capitol111);
        capitol111.add(new Paragraph("Text din subcapitol 1.1.1"));
        capitol111.add(capitol1111);
        capitol1111.add(new Image("Imagine finala"));

        povesti.print();
    }
}
