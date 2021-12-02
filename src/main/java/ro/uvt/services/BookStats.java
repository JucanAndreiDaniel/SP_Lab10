package ro.uvt.services;

import ro.uvt.models.*;

public class BookStats implements Visitor
{
    private int visitedBooks = 0;
    private int visitedSections = 0;
    private int visitedTableOfContents = 0;
    private int visitedParagraphs = 0;
    private int visitedImageProxy = 0;
    private int visitedImages = 0;
    private int visitedTables = 0;

    @Override
    public void visitBook(Book book) {
        visitedBooks++;

        for (Element elem : book.getElements()) {
            ((Visitee) elem).accept(this);
        }
    }

    @Override
    public void visitSection(Section section) {
        visitedSections++;

        for (Element elem : section.getElements()) {
            ((Visitee) elem).accept(this);
        }
    }

    @Override
    public void visitTableOfContents(TableOfContents toc) {
        visitedTableOfContents++;
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        visitedParagraphs++;
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        visitedImageProxy++;
    }

    @Override
    public void visitImage(Image image) {
        visitedImages++;
    }

    @Override
    public void visitTable(Table table) {
        visitedTables++;
    }

    public void printStatistics() {
        System.out.println("Visited Books: " + visitedBooks);
        System.out.println("Visited Sections: " + visitedSections);
        System.out.println("Visited Table Of Contents: " + visitedTableOfContents);
        System.out.println("Visited Paragraphs: " + visitedParagraphs);
        System.out.println("Visited Proxy'd Images: " + visitedImageProxy);
        System.out.println("Visited Images: " + visitedImages);
        System.out.println("Visited Tables: " + visitedTables);
    }
}
