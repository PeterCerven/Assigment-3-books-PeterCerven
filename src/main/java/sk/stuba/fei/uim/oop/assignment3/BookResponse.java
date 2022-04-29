package sk.stuba.fei.uim.oop.assignment3;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponse {
    private Long id;
    private String author;
    private String name;

    public BookResponse(Book b) {
        this.author = b.getAuthor();
        this.id = b.getId();
        this.name = b.getName();
    }
}
