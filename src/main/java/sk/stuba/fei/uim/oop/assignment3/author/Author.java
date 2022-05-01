package sk.stuba.fei.uim.oop.assignment3.author;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.Book;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
}
