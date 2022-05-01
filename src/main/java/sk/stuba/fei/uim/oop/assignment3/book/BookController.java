package sk.stuba.fei.uim.oop.assignment3.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/books")
    public List<BookResponse> getAllBooks(){
        return this.bookService.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public BookResponse addBook(@RequestBody BookRequest request)  {
        return new BookResponse(this.bookService.createBook((request)));
    }

    @GetMapping("/{name}")
    public List<BookResponse> getAllBooksByName(@PathVariable("name") String name)  {
        return bookService.getAllByName(name).stream().map(BookResponse::new).collect(Collectors.toList());
    }

}
