package kim.chopper.bookstore.views;

import kim.chopper.bookstore.common.HomeMenu;
import kim.chopper.bookstore.join.CustomerVO;
import kim.chopper.bookstore.sign.SignController;

import java.util.Scanner;

public class SignView {
    private static SignView instance = new SignView();

    private SignView() {
    }
    public static SignView getInstance() {
        return instance;
    }

    public CustomerVO inputLoginInfo(Scanner scanner) {
        System.out.print("아이디: ");
        int userId = Integer.parseInt(scanner.nextLine());
        System.out.print("패스워드: ");
        String userPw = scanner.nextLine();
        return new CustomerVO(userId, userPw);
    }

    public HomeMenu resultLogin(CustomerVO vo) {
        if (vo == null) {
            System.out.println("로그인 정보가 일치하지 않습니다. 아이디와 비밀번호를 확인하세요.");
            return HomeMenu.LOGIN;
        }
        System.out.println(vo.getName() + "님 로그인되었습니다.");
        return HomeMenu.MAIN;
    }
}
