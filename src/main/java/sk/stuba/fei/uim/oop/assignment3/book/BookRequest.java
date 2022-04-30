package sk.stuba.fei.uim.oop.assignment3.book;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.Author;

import javax.persistence.OneToOne;

@Setter
@Getter
public class BookRequest {
    private String name;
    private String description;
    private Author author;
    private int pages;
    private int amount;
    private int lendCount;

}
