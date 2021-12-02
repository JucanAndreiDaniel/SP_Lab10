package ro.uvt.services;

import ro.uvt.models.*;

public interface Visitor {
    void visitBook(Book book);
    void visitSection(Section section);
    // T visitTableOfContents(TableOfContents toc);
    void visitTableOfContents(TableOfContents toc);
    void visitParagraph(Paragraph paragraph);
    void visitImageProxy(ImageProxy imageProxy);
    void visitImage(Image image);
    void visitTable(Table table);
}
