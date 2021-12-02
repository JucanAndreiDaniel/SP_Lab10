package ro.uvt.models;

import ro.uvt.services.*;

public class ImageProxy implements Element,Picture,Visitee{
    private String url;
    private Dimension dim = new Dimension(300, 300);
    private Image img;

    public ImageProxy(String url) {
        this.url = url;
    }

    public Image loadImage() {
        if(this.img==null)
        {
            this.img = new Image(url);
        }
        return this.img;
    }

    public String getUrl() {
        return url;
    }

    public Dimension getDim() {
        return dim;
    }

    @Override
    public String url() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Dimension dim() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        System.out.println("Image proxy with url " + this.url + "dimension " + dim);
        loadImage().print();
    }

    @Override
    public void add(Element element) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void remove(Element element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean find(Element element) {
        // TODO Auto-generated method stub
        return false;
    }

    public Element clone() {
        ImageProxy newProxy = new ImageProxy(this.url);
        return newProxy;
    }

    public void accept(Visitor visitor) {
        visitor.visitImageProxy(this);
    }
}
