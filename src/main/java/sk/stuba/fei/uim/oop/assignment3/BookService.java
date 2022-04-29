package sk.stuba.fei.uim.oop.assignment3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements InterfaceBookService{

    private LibraryRepository repository;

    @Autowired
    public BookService(LibraryRepository repository) {
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

}
