package ro.uvt.services;

import ro.uvt.models.*;

import java.util.ArrayList;

public class BookSaveVisitor implements Visitor{ 
    //
    String output="";
    
    public static String convertToJson(Object o) {
        return o==null ? null : "\"" + o + "\"";
    }

    public void visitBook(Book book) {
        // {Book : {Title: title, author:{Name: author 1}}
        // 
        // }
        output += String.format("{\"Book\": {\"Title\": \"%s\"", book.getTitle());

        ArrayList<Author> authors = book.getAuthors();

        if(authors.size() > 0)
        {
            output += ",\"authors\" : [";
            for (int i = 0; i<authors.size();  i++)
            {
                output+=String.format("{\"Author\" : {\"Name\": \"%s\"}}", authors.get(i).getName());
                if(i == book.getAuthors().size())
                {
                    break;
                }
                output+= ",";
            }
            output += "]";
        }

        ArrayList<Element> elements = book.getElements();
        if(elements.size()>0) {
            output+=",\"elements\":[";

            for (int i=0;i<elements.size();i++) 
            {
                ((Visitee) elements.get(i)).accept(this);

                if(i == elements.size()-1)
                {
                    break;
                }
                output+=",";
            }
            output+="]";
        }
        output+="}}";
    }

    @Override
    public void visitSection(Section section) {
        output+=String.format("{\"Section\": {\"Title\": \"%s\"", section.getTitle());

        ArrayList<Element> elements = section.getElements();
        if(elements.size()>0)
        {
            output+=",\"elements\":[";

            for (int i=0;i<elements.size();i++) {
                ((Visitee) elements.get(i)).accept(this);
                if(i == elements.size()-1)
                {
                    break;
                }
                output+=",";
            }
            output+="]";
        }
        output+="}}";
    }

    @Override
    public void visitTableOfContents(TableOfContents toc) {
        output+=convertToJson(toc);
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        output+=paragraphToJson(paragraph);
    }

    public String paragraphToJson(Paragraph paragraph)
    {
        return String.format("{\"Paragraph\" : {\"Text\": \"%s\",\"AlignStrategy\": \"%s\"}}", 
        paragraph.getText(), generateObjectName(paragraph.getAlignStrategy()));
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        String imageOutput ="";

        Image image = imageProxy.loadImage();
        
        imageOutput = image == null ? "null" : imageToJson(image);
        output+= String.format("{\"ImageProxy\" : {\"Url\": \"%s\", \"Dimension\":{\"Height\" :\"%s\",\"Width\" :\"%s\" }, \"Image\": %s}}",
                imageProxy.getUrl(),imageProxy.getDim().getHeight(),imageProxy.getDim().getWidth(), imageOutput);
    }

    @Override
    public void visitImage(Image image) {
        output+=imageToJson(image);
    }

    public String imageToJson(Image image)
    {
        return String.format("{\"Image\" : {\"Url\": \"%s\" ,\"ImageLoader\": \"%s\" ,\"ImageLoaderFactory\": \"%s\"}}",
        image.url(), generateObjectName(image.getContent()), generateObjectName(image.getImageFactory()));
    }

    @Override
    public void visitTable(Table table) {
        output+= String.format("{\"Table\" : {\"Title\": \"%s\"}}", table.getTitle());
    }

    public String generateObjectName(Object object)
    {
        if(object==null)
        {
            return "null";
        }
        else
        {
            return object.getClass().getSimpleName();
        }
    }

    public String show(){
        return output;
    }
}
