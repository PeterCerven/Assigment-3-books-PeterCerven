package sk.stuba.fei.uim.oop.assignment3.book;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.Author;

@Getter
@Setter
public class BookResponse {
    private Long id;
    private String name;
    private String description;
    private Author author;
    private int pages;
    private int amount;
    private int lendCount;

    public BookResponse(Book b) {
        this.id = b.getId();
        this.name = b.getName();
        this.description = b.getDescription();
        this.author = b.getAuthor();
        this.pages = b.getPages();
        this.amount = b.getAmount();
        this.lendCount = b.getLendCount();
    }
}
