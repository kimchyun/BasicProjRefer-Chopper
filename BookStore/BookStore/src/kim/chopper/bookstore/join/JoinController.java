package kim.chopper.bookstore.join;

import kim.chopper.bookstore.BookstoreApplication;
import kim.chopper.bookstore.common.HomeMenu;
import kim.chopper.bookstore.views.JoinView;
import kim.chopper.bookstore.views.MainView;

import java.util.Scanner;

public class JoinController {
    private static JoinController instance = new JoinController();
    public static JoinController getInstance() {
        return instance;
    }
    private JoinController() {}

    private JoinService service = JoinService.getInstance();
    private JoinView view = JoinView.getInstance();

    public HomeMenu join(Scanner scanner) {
        boolean flag = true;
        while (flag) {
            CustomerVO vo = view.inputJoinInfo(scanner);
            if (vo == null) {
                flag = false;
            } else {
                int result = service.join(vo);
                flag = view.resultJoin(result, scanner);
            }
        }
        return HomeMenu.HOME;
    }

    public HomeMenu getCustomerInfo() {
        CustomerVO vo = service.findCustomer(BookstoreApplication.getSession().getCustId());
        view.printCustomerInfo(vo);
        return HomeMenu.CUSTOMER;
    }

    public HomeMenu modifyInfo(Scanner scanner, HomeMenu menu) {
        String modifyData = MainView.inputData(scanner);
        CustomerVO vo = new CustomerVO();
        vo.setCustId(BookstoreApplication.getSession().getCustId());
        switch (menu) {
            case MODIFY_NAME:
                vo.setName(modifyData);
                break;
            case MODIFY_ADDRESS:
                vo.setAddress(modifyData);
                break;
            case MODIFY_PHONE:
                vo.setPhone(modifyData);
                break;
        }
        int result = service.modifyInfo(vo, menu);
        view.resultModifyInfo(result);
        return HomeMenu.CUSTOMER;
    }
    public HomeMenu modifyPassword(Scanner scanner) {
        String password = view.changePassword(scanner);
        CustomerVO vo = new CustomerVO();
        vo.setCustId(BookstoreApplication.getSession().getCustId());
        vo.setPassword(password);
        int result = service.modifyPassword(vo);
        view.resultChangePassword(result);
        return HomeMenu.CUSTOMER;
    }
}
