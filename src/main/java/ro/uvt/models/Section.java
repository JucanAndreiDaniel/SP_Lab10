package ro.uvt.models;

import ro.uvt.services.*;

import java.util.ArrayList;

public class Section implements Element,Visitee{
    private String title;
    private ArrayList<Element> elements = new ArrayList<>();

    public Section(String title){
        this.title = title;
    }

    public void add(Element element){
        Element clona = element.clone();
        this.elements.add(element);
    }

    public void remove(Element element) {
        this.elements.remove(element);
    }

    public boolean find(Element element) {
        for (Element e : this.elements) {
            if (e.find(element))
                return true;
        }

        return false;
    }

    public Element clone() {
        Section newclone = new Section(this.title);

        for(Element el : this.elements)
        {
            newclone.add(el.clone());
        }

        return newclone;
    }

    public void print() {
        System.out.println("Title" + this.title);
        
        for (Element e : this.elements)
            e.print();  
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void accept(Visitor visitor) {
        visitor.visitSection(this);
    }
}
