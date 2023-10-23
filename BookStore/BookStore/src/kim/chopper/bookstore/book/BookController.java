package kim.chopper.bookstore.book;

import kim.chopper.bookstore.common.HomeMenu;
import kim.chopper.bookstore.views.BookView;
import kim.chopper.bookstore.views.MainView;

import java.util.List;
import java.util.Scanner;

public class BookController {
    private static BookController instance = new BookController();
    public static BookController getInstance() {
        return instance;
    }
    private BookController() {}

    private BookService service = BookService.getInstance();
    private BookView view = BookView.getInstance();

    public HomeMenu selectBooks(Scanner scanner) {
        String searchWord = "";
        if (scanner != null) {
            searchWord = MainView.inputData(scanner);
        }
        List<BookVO> books = service.findAll(searchWord);
        view.printBooks(books);
        return HomeMenu.BOOK;
    }
    public HomeMenu selectBook(Scanner scanner) {
        String inputData = MainView.inputData(scanner);
        int bookId = Integer.parseInt(inputData);
        BookVO book = service.findByBookId(bookId);
        view.printBook(book);
        return HomeMenu.BOOK;
    }

}
