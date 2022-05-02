package sk.stuba.fei.uim.oop.assignment3.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements InterfaceBookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Book> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Book createBook(BookRequest request) {
        return this.repository.save(new Book(request));
    }


    @Override
    public Book getById(Long id) {
        return repository.findBookById(id);
    }

    @Override
    public Book updateBook(Long id, BookRequest body) {
        Book book = repository.findBookById(id);
        if (book == null){
            throw new NotFoundException();
        }
        if (body.getName() != null){
            book.setName(body.getName());
        }
        if (body.getDescription() != null){
            book.setDescription(body.getDescription());
        }
        if (body.getPages() != 0){
            book.setPages(body.getPages());
        }
        if (body.getAuthor() != 0L && body.getAuthor() != null){
            book.setAuthor(body.getAuthor());
        }
        return repository.findBookById(id);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = repository.findBookById(id);
        if (book == null){
            throw new NotFoundException();
        }
        repository.delete(book);
    }

    @Override
    public int getAmount(Long id) {
        return repository.findById(id).orElseThrow(NotFoundException::new).getAmount();
    }

    @Override
    public int updateBookAmount(Long id, Amount amount) {
        Book book = repository.findById(id).orElseThrow(NotFoundException::new);
        book.setAmount(amount.getAmount());
        return book.getAmount();
    }

}
