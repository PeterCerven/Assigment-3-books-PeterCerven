package sk.stuba.fei.uim.oop.assignment3.lending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exceptions.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lending.bodies.BookID;
import sk.stuba.fei.uim.oop.assignment3.lending.bodies.LendingListResponse;
import sk.stuba.fei.uim.oop.assignment3.lending.service.InterfaceLendingListService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class LendingListController {

    private final InterfaceLendingListService lendingListService;

    @Autowired
    public LendingListController(InterfaceLendingListService lendingListService) {
        this.lendingListService = lendingListService;
    }

    @GetMapping
    public List<LendingListResponse> getAllLendingLists() {
        return lendingListService.getAllLendingLists().stream().map(LendingListResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<LendingListResponse> createLendingList() {
        return new ResponseEntity<>(new LendingListResponse(lendingListService.createLending()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public LendingListResponse getLendingList(@PathVariable("id") Long lendingListId)
            throws NotFoundException {
        return new LendingListResponse(this.lendingListService.getById(lendingListId));
    }

    @DeleteMapping("/{id}")
    public void deleteLendingList(@PathVariable("id") Long lendingListId)
            throws NotFoundException {
        this.lendingListService.deleteLendingList(lendingListId);
    }

    @PostMapping("{id}/add")
    public LendingListResponse addBookToList(@PathVariable("id") Long listId, @RequestBody BookID bookId)
            throws NotFoundException, IllegalOperationException {
        return new LendingListResponse(this.lendingListService.addBookToList(listId, bookId));
    }

    @DeleteMapping("{id}/remove")
    public void removeBookFromList(@PathVariable("id") Long listId, @RequestBody BookID bookId)
            throws NotFoundException {
        this.lendingListService.removeBookFromLendingList(listId, bookId);
    }

    @GetMapping("{id}/lend")
    public void lendList(@PathVariable("id") Long listId)
            throws NotFoundException, IllegalOperationException {
        this.lendingListService.lendList(listId);
    }
}
