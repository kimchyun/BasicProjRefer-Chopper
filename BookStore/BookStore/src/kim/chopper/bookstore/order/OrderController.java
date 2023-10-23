package kim.chopper.bookstore.order;

import kim.chopper.bookstore.BookstoreApplication;
import kim.chopper.bookstore.book.BookService;
import kim.chopper.bookstore.book.BookVO;
import kim.chopper.bookstore.common.HomeMenu;
import kim.chopper.bookstore.views.MainView;
import kim.chopper.bookstore.views.OrderView;

import java.util.List;
import java.util.Scanner;

public class OrderController {
    private static OrderController instance = new OrderController();
    public static OrderController getInstance() {
        return instance;
    }
    private OrderController() {}

    private OrderService orderService = OrderService.getInstance();
    private BookService bookService = BookService.getInstance();
    private OrderView view = OrderView.getInstance();

    public HomeMenu selectOrders() {
        List<OrderVO> orders = orderService.findAll(BookstoreApplication.getSession().getCustId());
        view.printOrder(orders);
        return HomeMenu.MAIN;
    }

    public HomeMenu orderBook(Scanner scanner) {
        String inputData = MainView.inputData(scanner);
        int orderBookId = Integer.parseInt(inputData);
        BookVO book = bookService.findByBookId(orderBookId);
        int count = view.inputCountBook(scanner, book);
        if (count > 0) {
            OrderVO vo = new OrderVO(BookstoreApplication.getSession().getCustId(), book.getBookId(), book.getPrice() * count);
            int result = orderService.orderBook(vo);
            view.resultOrder(result);
        }
        return HomeMenu.ORDER;
    }
}
