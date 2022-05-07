package sk.stuba.fei.uim.oop.assignment3.lending.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.bodies.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.lending.data.LendList;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class LendingListResponse {
    private Long id;
    private List<BookResponse> lendingList;
    private boolean lended;

    public LendingListResponse(LendList list) {
        this.id = list.getId();
        this.lendingList = list.getLendingLists().stream().map(BookResponse::new).collect(Collectors.toList());
        this.lended = list.isLended();
    }
}
