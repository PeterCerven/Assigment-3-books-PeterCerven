package sk.stuba.fei.uim.oop.assignment3.book.data;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.book.bodies.BookRequest;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Author.class, cascade = CascadeType.PERSIST)
    private Author author;
    private int pages;
    private int amount;
    private int lendCount;

    public Book(BookRequest request, Author author) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.author = author;
        this.pages = request.getPages();
        this.amount = request.getAmount();
        this.lendCount = request.getLendCount();
    }
}
