package ro.uvt.models;

import ro.uvt.services.*;

/**
 * TableOfContents
 */
public class TableOfContents implements Element,Visitee{
    private String title;

    public TableOfContents(String title)
    {
        this.title=title;
    }

    public void print() {
        //empty
    }

    public void add(Element element) {
        //later
    }

    public void remove(Element element) {
        //later
    }

    public boolean find(Element element) {
        //not needed
        return false;
    }

    public Element clone() {
        TableOfContents newtoc=new TableOfContents(this.title);
        return newtoc;
     }
     
    // public <T> T accept(Visitor<T> visitor) {
    //     return visitor.visitTableOfContents(this);
    // }

    public void accept(Visitor visitor) {
        visitor.visitTableOfContents(this);
    }
}