package kim.chopper.bookstore.sign;

import kim.chopper.bookstore.BookstoreApplication;
import kim.chopper.bookstore.common.HomeMenu;
import kim.chopper.bookstore.join.CustomerVO;
import kim.chopper.bookstore.views.JoinView;
import kim.chopper.bookstore.views.SignView;

import java.util.Scanner;

public class SignController {
    private static SignController instance = new SignController();
    public static SignController getInstance() {
        return instance;
    }
    private SignController() {}

    private SignService service = SignService.getInstance();
    private SignView view = SignView.getInstance();
    private CustomerVO session = BookstoreApplication.getSession();

    public HomeMenu signIn(Scanner scanner) {
        CustomerVO vo = view.inputLoginInfo(scanner);
        CustomerVO custom = service.findUser(vo);
        // 세션에 로그인 정보 저장
        if (custom != null) {
            session.setCustId(custom.getCustId());
            session.setName(custom.getName());
        }
        return view.resultLogin(custom);
    }
    public HomeMenu signOut() {
        // 세션 초기화
        session.invalidate();
        return HomeMenu.HOME;
    }
}
