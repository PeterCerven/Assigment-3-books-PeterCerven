package sk.stuba.fei.uim.oop.assignment3.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.service.InterfaceBookService;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.Amount;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequestEdit;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {
    private final InterfaceBookService bookService;

    @Autowired
    public BookController(InterfaceBookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public List<BookResponse> getAllBooks() {
        return this.bookService.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest request) throws NotFoundException {
        return new ResponseEntity<>(new BookResponse(this.bookService.createBook(request)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable("id") Long bookId) throws NotFoundException {
        return new BookResponse(this.bookService.getById(bookId));
    }

    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable("id") Long bookId, @RequestBody BookRequestEdit body) throws NotFoundException {
        return new BookResponse(this.bookService.updateBook(bookId, body));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long bookId) throws NotFoundException {
        this.bookService.deleteBook(bookId);
    }

    @GetMapping("/{id}/amount")
    public Amount getBookAmount(@PathVariable("id") Long id) throws NotFoundException {
        return new Amount(this.bookService.getAmount(id));
    }

    @PostMapping("/{id}/amount")
    public Amount updateBookAmount(@PathVariable("id") Long id, @RequestBody Amount amount) throws NotFoundException {
        return new Amount(this.bookService.updateBookAmount(id, amount));
    }

    @GetMapping("/{id}/lendCount")
    public Amount getBookLendCount(@PathVariable("id") Long id) throws NotFoundException {
        return new Amount(this.bookService.getLendCount(id));
    }


}
