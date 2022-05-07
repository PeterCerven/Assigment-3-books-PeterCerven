package sk.stuba.fei.uim.oop.assignment3.book.bodies;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import java.util.stream.Collectors;

@Getter
@Setter
public class BookResponse {
    private Long id;
    private String name;
    private String description;
    private Long author;
    private int pages;
    private int amount;
    private int lendCount;

    public BookResponse(Book b) {
        this.id = b.getId();
        this.name = b.getName();
        this.description = b.getDescription();
        this.author = b.getAuthor().getId();
        this.pages = b.getPages();
        this.amount = b.getAmount();
        this.lendCount = b.getLendCount();
    }
}
