package sk.stuba.fei.uim.oop.assignment3.book.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.service.AuthorService;
import sk.stuba.fei.uim.oop.assignment3.book.bodies.Amount;
import sk.stuba.fei.uim.oop.assignment3.book.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.bodies.BookRequestEdit;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;


@Service
public class BookService implements InterfaceBookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }


    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }


    @Override
    public Book createBook(BookRequest request) throws NotFoundException {
        Author author = authorService.findAuthorById(request.getAuthor());
        Book book = new Book(request, author);
        author.getBooks().add(book);
        return this.bookRepository.save(book);
    }


    @Override
    public Book getById(Long id) throws NotFoundException {
        return bookRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Book updateBook(Long id, BookRequestEdit body) throws NotFoundException {
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
            Author author = authorService.findAuthorById(body.getAuthor());
            book.setAuthor(author);
        }
        return book;
    }

    @Override
    public void deleteBook(Long id) throws NotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        book.getAuthor().getBooks().remove(book);
        bookRepository.delete(book);
    }

    @Override
    public int getAmount(Long id) throws NotFoundException {
        return bookRepository.findById(id).orElseThrow(NotFoundException::new).getAmount();
    }

    @Override
    public int updateBookAmount(Long id, Amount amount) throws NotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        book.setAmount(book.getAmount() + amount.getAmount());
        return book.getAmount();
    }

    @Override
    public int getLendCount(Long id) throws NotFoundException {
        return bookRepository.findById(id).orElseThrow(NotFoundException::new).getLendCount();
    }

    public Book findBookById(Long id) throws NotFoundException{
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElseThrow(NotFoundException::new);
    }

}
