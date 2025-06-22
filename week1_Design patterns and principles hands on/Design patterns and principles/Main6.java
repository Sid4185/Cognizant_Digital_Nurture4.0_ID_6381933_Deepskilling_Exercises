interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;
    public RealImage(String filename) {
        this.filename = filename;
        System.out.println("Loading " + filename);
    }
    public void display() { System.out.println("Displaying " + filename); }
}

class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;
    public ProxyImage(String filename) { this.filename = filename; }
    public void display() {
        if (realImage == null) realImage = new RealImage(filename);
        realImage.display();
    }
}

public class Main6 {
    public static void main(String[] args) {
        Image img = new ProxyImage("pic.jpg");
        img.display();
        img.display();
    }
}
