package sk.stuba.fei.uim.oop.assignment3.book.service;

import sk.stuba.fei.uim.oop.assignment3.book.bodies.Amount;
import sk.stuba.fei.uim.oop.assignment3.book.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.bodies.BookRequestEdit;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import java.util.List;

public interface InterfaceBookService {


    List<Book> getAll();

    Book createBook(BookRequest request);

    Book getById(Long id);

    Book updateBook(Long id, BookRequestEdit body);

    void deleteBook(Long id);

    int getAmount(Long id);

    int updateBookAmount(Long id, Amount amount);

    int getLendCount(Long id);

}
