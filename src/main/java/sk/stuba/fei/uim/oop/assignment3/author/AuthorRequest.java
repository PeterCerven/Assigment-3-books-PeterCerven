package sk.stuba.fei.uim.oop.assignment3.author;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.Book;

import java.util.ArrayList;

@Getter
@Setter
public class AuthorRequest {
    private String name;
    private String surname;
    private ArrayList<Book> books;
}
