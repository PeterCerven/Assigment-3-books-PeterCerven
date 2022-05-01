package sk.stuba.fei.uim.oop.assignment3.book;

import java.util.List;

public interface InterfaceBookService {


    List<Book> getAll();

    Book createBook(BookRequest request);

    List<Book> getAllByName(String name);

    Book getById(Long id);
}
