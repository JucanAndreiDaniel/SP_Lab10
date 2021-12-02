package ro.uvt.models;


import ro.uvt.services.Visitee;
import ro.uvt.services.Visitor;

import java.util.ArrayList;

public class Book implements Visitee {

    private String title;
    private ArrayList<Author> authors;
    private ArrayList<Element> elements; 
    
    public Book(String title){
        this.title = title;
        this.authors = new ArrayList<>();
        this.elements = new ArrayList<>();
    }

    public void addContent (Element element) {
        this.elements.add(element);
    }

    public void addAuthor(Author author) {
        this.authors.add(author);  
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void print() {
        System.out.println("Book: " + title);
        
        for (Author author : this.authors) {
            author.print();
        }
        for (Element chapter : elements) {
            chapter.print();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visitBook(this);
    }
}