interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() { System.out.println("Word opened"); }
}

class PdfDocument implements Document {
    public void open() { System.out.println("PDF opened"); }
}

class ExcelDocument implements Document {
    public void open() { System.out.println("Excel opened"); }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory {
    public Document createDocument() { return new WordDocument(); }
}

class PdfFactory extends DocumentFactory {
    public Document createDocument() { return new PdfDocument(); }
}

class ExcelFactory extends DocumentFactory {
    public Document createDocument() { return new ExcelDocument(); }
}

public class Main2 {
    public static void main(String[] args) {
        Document doc1 = new WordFactory().createDocument();
        Document doc2 = new PdfFactory().createDocument();
        doc1.open();
        doc2.open();
    }
}
