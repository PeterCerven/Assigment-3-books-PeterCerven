package sk.stuba.fei.uim.oop.assignment3.book;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.Author;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToOne
    private Author author;
    private int pages;
    private int amount;
    private int lendCount;


}
