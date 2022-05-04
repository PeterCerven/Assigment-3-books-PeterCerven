package sk.stuba.fei.uim.oop.assignment3.author.data;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @OneToMany
    private List<Book> books;

    public Author(AuthorRequest request) {
        this.name = request.getName();
        this.surname = request.getSurname();
    }

    public Author() {
        this.books = new ArrayList<>();
    }
}
