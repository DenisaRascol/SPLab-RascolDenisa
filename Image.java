public class Image extends Element {
    private String imageName;

    public Image(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void print() {
        System.out.println("    Image: " + imageName);
    }
}
