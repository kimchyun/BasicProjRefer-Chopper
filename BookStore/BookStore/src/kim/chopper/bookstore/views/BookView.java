package kim.chopper.bookstore.views;

import kim.chopper.bookstore.book.BookController;
import kim.chopper.bookstore.book.BookVO;
import kim.chopper.bookstore.common.HomeMenu;

import java.util.List;
import java.util.Scanner;

public class BookView {
    private static BookView instance = new BookView();

    private BookView() {
    }
    public static BookView getInstance() {
        return instance;
    }

    public void printBooks(List<BookVO> vos) {
        for (BookVO vo : vos) {
            System.out.println(vo);
        }
    }

    public void printBook(BookVO vo) {
        if (vo != null) {
            System.out.println(vo);
        } else {
            System.out.println("조회하실 책이 존재하지 않습니다.");
        }
    }

}
