package ro.uvt.observer;

import org.springframework.stereotype.Component;
import ro.uvt.models.Book;
import java.util.*;

@Component
public class AllBooksSubject implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void add(Book book) {
        for (Observer o : observers) {
            o.update(book);
        }
    }
}
