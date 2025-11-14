package ro.uvt.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();

    // keep Element children transient for now (persisting elements is optional/advanced)
    @Transient
    private List<Element> elements = new ArrayList<>();

    public Book() { }

    public Book(String title) { this.title = title; }

    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<Author> getAuthors() { return authors; }
    public void setAuthors(List<Author> authors) { this.authors = authors; }

    public void addAuthor(Author author) { authors.add(author); }

    // Element interface
    @Override
    public void print() { System.out.println("Book: " + title); }

    @Override
    public void add(Element e) { elements.add(e); }

    @Override
    public void remove(Element e) { elements.remove(e); }

    @Override
    public Element get(int index) { return elements.get(index); }
}
