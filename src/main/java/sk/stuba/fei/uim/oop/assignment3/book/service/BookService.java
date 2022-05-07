package sk.stuba.fei.uim.oop.assignment3.book.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.data.AuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.book.bodies.BookRequestEdit;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.bodies.Amount;
import sk.stuba.fei.uim.oop.assignment3.book.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.exceptions.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements InterfaceBookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }


    @Override
    public Book createBook(BookRequest request) {
        Optional<Author> authorOptional = authorRepository.findById(request.getAuthor());
        Author author = authorOptional.orElseThrow(NotFoundException::new);
        Book book = new Book(request,author);
        author.getBooks().add(book);
        return this.bookRepository.save(book);
    }


    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Book updateBook(Long id, BookRequestEdit body) {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        if (body.getName() != null) {
            book.setName(body.getName());
        }
        if (body.getDescription() != null) {
            book.setDescription(body.getDescription());
        }
        if (body.getPages() != 0) {
            book.setPages(body.getPages());
        }
        if (body.getAuthor() != null && body.getAuthor() != 0L) {
            Optional<Author> authorOptional = authorRepository.findById(body.getAuthor());
            Author author = authorOptional.orElseThrow(NotFoundException::new);
            book.setAuthor(author);
        }
        return bookRepository.findBookById(id);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        bookRepository.delete(book);
    }

    @Override
    public int getAmount(Long id) {
        return bookRepository.findById(id).orElseThrow(NotFoundException::new).getAmount();
    }

    @Override
    public int updateBookAmount(Long id, Amount amount) {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        book.setAmount(book.getAmount() + amount.getAmount());
        return book.getAmount();
    }

    @Override
    public int getLendCount(Long id) {
        return bookRepository.findById(id).orElseThrow(NotFoundException::new).getLendCount();
    }

}
