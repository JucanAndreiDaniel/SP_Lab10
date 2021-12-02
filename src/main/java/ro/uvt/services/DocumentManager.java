package ro.uvt.services;

import ro.uvt.models.Book;

public class DocumentManager {
    public static DocumentManager instance;
    private Book book;

    private DocumentManager(){

    }

    public static DocumentManager getInstance(){
        if (instance == null)
            instance = new DocumentManager();
        return instance;
    }

    public Book getBook(){
        return book;
    }

    public void setBook(Book book){
        this.book = book;
    }
}
