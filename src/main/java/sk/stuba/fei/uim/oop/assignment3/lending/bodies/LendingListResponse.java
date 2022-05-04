package sk.stuba.fei.uim.oop.assignment3.lending.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.lending.data.LendList;

import java.util.List;

@Getter
@Setter
public class LendingListResponse {
    private Long id;
    private List<Book> lendingList;
    private boolean lended;

    public LendingListResponse(LendList list) {
        this.id = list.getId();
        this.lendingList = list.getLendingList();
        this.lended = list.isLended();
    }
}
