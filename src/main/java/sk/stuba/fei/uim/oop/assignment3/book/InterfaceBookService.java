package sk.stuba.fei.uim.oop.assignment3.book;

import sk.stuba.fei.uim.oop.assignment3.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.BookRequest;

import java.util.List;

public interface InterfaceBookService {

    String hello();

    List<Book> getAll();

    Book createBook(BookRequest request);

    List<Book> getAllByName(String name);

    Book getById(Long id);
}
