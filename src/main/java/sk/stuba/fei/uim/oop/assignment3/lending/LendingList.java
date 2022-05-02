package sk.stuba.fei.uim.oop.assignment3.lending;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.BookRequest;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LendingList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(orphanRemoval = true)
    private List<Book> temporaryLendingList;

    private boolean lended;



    public LendingList(LendingListRequest request){
        this.temporaryLendingList = request.getTemporaryLendingList();
        this.lended = request.isLended();
    }


}
