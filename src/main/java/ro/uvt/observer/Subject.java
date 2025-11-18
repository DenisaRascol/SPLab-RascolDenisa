package ro.uvt.observer;

import ro.uvt.models.Book;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void add(Book book);
}
