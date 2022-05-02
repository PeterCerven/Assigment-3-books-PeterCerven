package sk.stuba.fei.uim.oop.assignment3.lending;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.Book;

import java.util.List;

@Getter
@Setter
public class LendingListResponse {
    private Long id;
    private List<Book> lendingList;
    private boolean lended;

    public LendingListResponse(LendingList list) {
        this.id = list.getId();
        this.lendingList = list.getTemporaryLendingList();
        this.lended = list.isLended();
    }
}
