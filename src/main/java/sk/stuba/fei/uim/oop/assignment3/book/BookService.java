package sk.stuba.fei.uim.oop.assignment3.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements InterfaceBookService {

    private BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public String hello(){
        return "hello";
    }

    @Override
    public List<Book> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Book createBook(BookRequest request) {
        Book newBook = new Book();
        newBook.setAuthor(request.getAuthor());
        newBook.setName(request.getName());
        return this.repository.save(newBook);
    }

    @Override
    public List<Book> getAllByName(String name){
        return repository.findBookByName(name);
    }

    @Override
    public Book getById(Long id) {
        return repository.findBookById(id);
    }

}
