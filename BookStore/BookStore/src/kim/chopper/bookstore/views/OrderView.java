package kim.chopper.bookstore.views;

import kim.chopper.bookstore.book.BookVO;
import kim.chopper.bookstore.order.OrderVO;

import java.util.List;
import java.util.Scanner;

public class OrderView {
    private static OrderView instance = new OrderView();

    private OrderView() {
    }
    public static OrderView getInstance() {
        return instance;
    }

    public void printOrder(List<OrderVO> vos) {
        for (OrderVO vo : vos) {
            System.out.println(vo);
        }
    }

    public int inputCountBook(Scanner scanner, BookVO vo) {
        if (vo == null) {
            System.out.println("주문하실 책이 존재하지 않습니다.");
            return 0;
        }
        System.out.print("구매하실 책 수량을 입력하세요: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void resultOrder(int result) {
        if (result > 0) {
            System.out.println("주문이 완료되었습니다.");
        } else {
            System.out.println("주문이 정상적으로 완료되지 않았습니다. 다시 확인하세요.");
        }
    }
}
