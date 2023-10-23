package kim.chopper.bookstore.views;

import kim.chopper.bookstore.join.CustomerVO;

import java.util.Scanner;

public class JoinView {
    private static JoinView instance = new JoinView();

    private JoinView() {
    }
    public static JoinView getInstance() {
        return instance;
    }

    public CustomerVO inputJoinInfo(Scanner scanner) {
        CustomerVO vo = null;
        while (true) {
            try {
                System.out.print("아이디: ");
                String id = scanner.nextLine();
                if (id.length() < 1 || id.length() > 2) {
                    throw new NumberFormatException();
                }
                int custId = Integer.parseInt(id);
                System.out.print("이름: ");
                String name = scanner.nextLine();
                System.out.print("주소: ");
                String address = scanner.nextLine();
                System.out.print("전화번호: ");
                String phone = scanner.nextLine();
                System.out.print("패스워드: ");
                String password = scanner.nextLine();
                vo = new CustomerVO(custId, name, address, phone, password);
                break;
            } catch (NumberFormatException e) {
                System.out.println("아이디는 2자리 이하 숫자만 가능합니다.");
            } catch (Exception e) {
                System.out.println("회원 가입 도중 오류가 발생하였습니다.");

            }
        }
        return vo;
    }

    /**
     * 회원 가입 결과
     * @param result
     * @return 회원 가입 성공시 반복문 종료를 위해 false 반환, 실패시 반복을 위한 true 반환
     */
    public boolean resultJoin(int result, Scanner scanner) {
        if (result > 0) {
            System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
            return false;
        }
        System.out.print("회원 가입 실패! 다시 회원가입을 하시겠습니까?(y 또는 n을 입력): ");
        String answer = scanner.nextLine();
        if (!"y".equalsIgnoreCase(answer)) {
            // y를 입력하지 않으면 회원가입 종료, 그렇지 않으면 회원가입 다시 시작하기
            return false;
        }
        return true;
    }
    public void printCustomerInfo(CustomerVO vo) {
        System.out.printf("아이디: %d\n", vo.getCustId());
        System.out.printf("이름: %s\n", vo.getName());
        System.out.printf("주소: %s\n", vo.getAddress());
        System.out.printf("휴대전화번호: %s\n", vo.getPhone());
    }

    public void resultModifyInfo(int result) {
        if (result > 0) {
            System.out.println("회원 정보가 수정되었습니다.");
        } else {
            System.out.println("회원 정보가 정상적으로 수정되지 않았습니다. 다시 확인하세요.");
        }
    }

    public String changePassword(Scanner scanner) {
        String confirmPassword;
        while (true) {
            System.out.print("변경할 패스워드를 입력하세요: ");
            String newPassword = scanner.nextLine();
            System.out.print("비밀번호 확인을 위해 다시 한번 입력해주세요: ");
            confirmPassword = scanner.nextLine();
            if (!newPassword.equals(confirmPassword)) {
                System.out.println("입력하신 비밀번호가 일치하지 않습니다. 다시 입력하세요.");
            } else {
                break;
            }
        }
        return confirmPassword;
    }

    public void resultChangePassword(int result) {
        if (result > 0) {
            System.out.println("비밀번호가 변경되었습니다.");
        } else {
            System.out.println("비밀번호가 변경되지 않았습니다. 다시 확인하세요.");
        }
    }

}
