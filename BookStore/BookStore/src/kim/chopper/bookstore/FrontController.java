package kim.chopper.bookstore;

import kim.chopper.bookstore.book.BookController;
import kim.chopper.bookstore.common.HomeMenu;
import kim.chopper.bookstore.common.MenuNotFoundException;
import kim.chopper.bookstore.join.JoinController;
import kim.chopper.bookstore.order.OrderController;
import kim.chopper.bookstore.sign.SignController;
import kim.chopper.bookstore.views.MainView;

import java.util.Scanner;

public class FrontController {
    private JoinController joinController = JoinController.getInstance();
    private BookController bookController = BookController.getInstance();
    private SignController signController = SignController.getInstance();
    private OrderController orderController = OrderController.getInstance();

    private MainView view = MainView.getInstance();

    private Scanner scanner = new Scanner(System.in);

    public void process() {
        int number = view.init(scanner);
        HomeMenu menu = HomeMenu.findMenu(number);
        try {
            loop: while (true) {
                System.out.print(menu.getMenuString());
                switch (menu) {
                    // 메뉴를 보여주는 부분은 이곳에 모아주면 된다.
                    case HOME:
                    case MAIN:
                    case BOOK:
                    case ORDER:
                    case CUSTOMER:
                    case CUSTOMER_MODIFY_INFO:
                        menu = HomeMenu.findMenu(Integer.parseInt(scanner.nextLine()));
                        break;
                    case JOIN:
                        menu = joinController.join(scanner);
                        break;
                    case CUSTOMER_INFO:
                        menu = joinController.getCustomerInfo();
                        break;
                    case MODIFY_NAME:
                    case MODIFY_ADDRESS:
                    case MODIFY_PHONE:
                        menu = joinController.modifyInfo(scanner, menu);
                        break;
                    case CUSTOMER_MODIFY_PASSWORD:
                        menu = joinController.modifyPassword(scanner);
                        break;
                    case LOGIN:
                        menu = signController.signIn(scanner);
                        break;
                    case LOGOUT:
                        menu = signController.signOut();
                        break;
                    case BOOK_LIST:
                        menu = bookController.selectBooks(null);
                        break;
                    case BOOK_SEARCH:
                        menu = bookController.selectBooks(scanner);
                        break;
                    case BOOK_DETAIL:
                        menu = bookController.selectBook(scanner);
                        break;
                    case ORDER_BOOK:
                        menu = orderController.orderBook(scanner);
                        break;
                    case ORDER_LIST:
                        menu = orderController.selectOrders();
                        break;
                    case QUIT:
                        break loop;
                }
                System.out.println();
            }
        } catch (MenuNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.print(HomeMenu.HOME.getMenuString());
        }
    }
}