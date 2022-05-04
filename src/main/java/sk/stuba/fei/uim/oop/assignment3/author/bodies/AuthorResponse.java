package sk.stuba.fei.uim.oop.assignment3.author.bodies;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import java.util.List;

@Getter
@Setter
public class AuthorResponse {
    private Long id;
    private String name;
    private String surname;
    private List<Book> books;

    public AuthorResponse(Author a) {
        this.id = a.getId();
        this.name = a.getName();
        this.surname = a.getSurname();
        this.books = a.getBooks();
    }
}
