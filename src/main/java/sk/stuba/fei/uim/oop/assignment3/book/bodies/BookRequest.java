package sk.stuba.fei.uim.oop.assignment3.book.bodies;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;

@Setter
@Getter
public class BookRequest {
    private String name;
    private String description;
    private Long author;
    private int pages;
    private int amount;
    private int lendCount;

}
