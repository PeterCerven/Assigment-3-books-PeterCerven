package sk.stuba.fei.uim.oop.assignment3.lending.service;

import sk.stuba.fei.uim.oop.assignment3.exceptions.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lending.web.bodies.BookID;
import sk.stuba.fei.uim.oop.assignment3.lending.data.LendList;

import java.util.List;

public interface InterfaceLendingListService {

    List<LendList> getAllLendingLists();

    LendList getById(Long id) throws NotFoundException;

    LendList createLending();

    void deleteLendingList(Long id) throws NotFoundException;

    LendList addBookToList(Long listId, BookID bookId) throws NotFoundException, IllegalOperationException;

    void removeBookFromLendingList(Long listId, BookID bookId) throws NotFoundException;

    void lendList(Long listId) throws NotFoundException, IllegalOperationException;
}
