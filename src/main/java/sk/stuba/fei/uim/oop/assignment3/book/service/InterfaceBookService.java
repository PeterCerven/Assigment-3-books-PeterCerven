package sk.stuba.fei.uim.oop.assignment3.book.service;

import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.Amount;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequestEdit;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

import java.util.List;

public interface InterfaceBookService {


    List<Book> getAll();

    Book createBook(BookRequest request) throws NotFoundException;

    Book getById(Long id) throws NotFoundException;

    Book updateBook(Long id, BookRequestEdit body) throws NotFoundException;

    void deleteBook(Long id) throws NotFoundException;

    int getAmount(Long id) throws NotFoundException;

    int updateBookAmount(Long id, Amount amount) throws NotFoundException;

    int getLendCount(Long id) throws NotFoundException;

}
