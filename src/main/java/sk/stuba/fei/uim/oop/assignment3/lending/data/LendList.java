package sk.stuba.fei.uim.oop.assignment3.lending.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.lending.bodies.LendingListRequest;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LendList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Book> lendingList;

    private boolean lended;


    public LendList(LendingListRequest request) {
        this.lendingList = request.getLendingList();
        this.lended = request.isLended();
    }


}
