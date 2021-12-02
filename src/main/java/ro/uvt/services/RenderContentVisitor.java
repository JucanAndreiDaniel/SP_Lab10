package ro.uvt.services;

import ro.uvt.models.*;

public class RenderContentVisitor implements Visitor
{
    public void visitBook(Book book) {
        System.out.println("Carte: " + book.getTitle());

        System.out.println("Autori: ");
        for (Author i : book.getAuthors())
            i.print();

        System.out.println("Elemente: ");
        for (Element elem : book.getElements()) {
            ((Visitee) elem).accept(this);
        }
    }

    @Override
    public void visitSection(Section section) {
        System.out.println("Titlu: " + section.getTitle());

        for (Element elem : section.getElements()) {
            ((Visitee) elem).accept(this);
        }
    }

    @Override
    public void visitTableOfContents(TableOfContents toc) {
        System.out.println("Cuprins");
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        if (paragraph.getAlignStrategy() != null) {
            paragraph.getAlignStrategy().render(paragraph, null);
        }
        else
            System.out.println("models.Paragraph" + paragraph.getText());
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        System.out.println("models.Image proxy with url:" + imageProxy.getUrl() + " and dimension:" + imageProxy.getDim());

        Image localImage = imageProxy.loadImage();
        visitImage(localImage);
    }

    @Override
    public void visitImage(Image image) {
        System.out.println(image.getImageName());
    }

    @Override
    public void visitTable(Table table) {
        System.out.println(table.getTitle());
    }
}