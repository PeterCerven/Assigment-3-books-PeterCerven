package sk.stuba.fei.uim.oop.assignment3.lending.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.service.BookService;
import sk.stuba.fei.uim.oop.assignment3.exceptions.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lending.bodies.BookID;
import sk.stuba.fei.uim.oop.assignment3.lending.data.LendList;
import sk.stuba.fei.uim.oop.assignment3.lending.data.LendingListRepository;

import java.util.List;


@Service
public class LendingListService implements InterfaceLendingListService {

    private final LendingListRepository lendingListRepository;
    private final BookService bookService;

    @Autowired
    public LendingListService(LendingListRepository lendingListRepository, BookService bookService) {
        this.lendingListRepository = lendingListRepository;
        this.bookService = bookService;
    }

    @Override
    public List<LendList> getAllLendingLists() {
        return lendingListRepository.findAll();
    }

    @Override
    public LendList getById(Long id) throws NotFoundException {
        return lendingListRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public LendList createLending() {
        return this.lendingListRepository.save(new LendList());
    }

    @Override
    public void deleteLendingList(Long id) throws NotFoundException {
        LendList lendList = lendingListRepository.findById(id).orElseThrow(NotFoundException::new);
        for (Book book : lendList.getLendingLists()) {
            book.setLendCount(book.getLendCount() - 1);
        }
        lendingListRepository.delete(lendList);
    }

    @Override
    public LendList addBookToList(Long listId, BookID bookId) throws NotFoundException, IllegalOperationException {
        Book book = bookService.findBookById(bookId.getId());
        LendList lendList = lendingListRepository.findById(listId).orElseThrow(NotFoundException::new);
        if (lendList.getLendingLists().contains(book)) {
            throw new IllegalOperationException();
        }
        if (lendList.isLended()) {
            throw new IllegalOperationException();
        }
        lendList.getLendingLists().add(book);
        return lendingListRepository.save(lendList);
    }

    @Override
    public void removeBookFromLendingList(Long listId, BookID bookId) throws NotFoundException {
        Book book = bookService.findBookById(bookId.getId());
        LendList lendList = lendingListRepository.findById(listId).orElseThrow(NotFoundException::new);
        if (lendList.isLended()) {
            book.setLendCount(book.getLendCount() - 1);
        }
        lendList.getLendingLists().remove(book);
        lendingListRepository.save(lendList);
    }

    @Override
    public void lendList(Long listId) throws NotFoundException, IllegalOperationException {
        LendList lendList = lendingListRepository.findById(listId).orElseThrow(NotFoundException::new);
        if (lendList.isLended()) {
            throw new IllegalOperationException();
        }
        for (Book book : lendList.getLendingLists()) {
            book.setLendCount(book.getLendCount() + 1);
        }
        lendList.setLended(true);
        lendingListRepository.save(lendList);
    }
}
