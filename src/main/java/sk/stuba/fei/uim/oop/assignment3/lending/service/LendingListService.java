package sk.stuba.fei.uim.oop.assignment3.lending.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lending.bodies.BookID;
import sk.stuba.fei.uim.oop.assignment3.lending.data.LendList;
import sk.stuba.fei.uim.oop.assignment3.lending.bodies.LendingListRequest;
import sk.stuba.fei.uim.oop.assignment3.lending.data.LendingListRepository;

import java.util.List;

@Service
public class LendingListService implements InterfaceLendingListService {

    private final LendingListRepository repository;

    private final BookRepository bookRepository;

    @Autowired
    public LendingListService(LendingListRepository repository, BookRepository bookRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<LendList> getAllLendingLists() {
        return repository.findAll();
    }

    @Override
    public LendList getById(Long id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public LendList createLending() {
        return this.repository.save(new LendList());
    }

    @Override
    public void deleteLendingList(Long id) {
        LendList lendList = repository.findById(id).orElseThrow(NotFoundException::new);
        repository.delete(lendList);
    }

    @Override
    public LendList addBookToList(Long listId, BookID bookId) {
        Book book = bookRepository.findById(bookId.getBookId()).orElseThrow(NotFoundException::new);
        LendList lendList = repository.findById(listId).orElseThrow(NotFoundException::new);
        lendList.getLendingList().add(book);
        return repository.save(lendList);
    }

    @Override
    public void removeBookFromLendingList(Long listId, BookID bookId) {
        Book book = bookRepository.findById(bookId.getBookId()).orElseThrow(NotFoundException::new);
        LendList lendList = repository.findById(listId).orElseThrow(NotFoundException::new);
        lendList.getLendingList().remove(book);
    }

    @Override
    public void lendList(Long listId) {
        LendList lendList = repository.findById(listId).orElseThrow(NotFoundException::new);
        lendList.setLended(true);
    }
}
