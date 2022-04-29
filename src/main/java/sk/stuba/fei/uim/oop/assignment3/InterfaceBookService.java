package sk.stuba.fei.uim.oop.assignment3;

import java.util.List;

public interface InterfaceBookService {

    public String hello();

    List<Book> getAll();
    Book createBook(BookRequest request);

    public List<Book> getAllByName(String name);
}
