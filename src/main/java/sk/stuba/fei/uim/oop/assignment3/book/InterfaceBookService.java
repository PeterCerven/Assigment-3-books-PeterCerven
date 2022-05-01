package sk.stuba.fei.uim.oop.assignment3.book;

import java.util.List;

public interface InterfaceBookService {


    List<Book> getAll();

    Book createBook(BookRequest request);

    Book getById(Long id);

    Book updateBook(Long id, BookRequest body);

    void deleteBook(Long id);

}
