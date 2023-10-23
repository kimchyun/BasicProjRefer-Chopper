package kim.chopper.bookstore.views;

import kim.chopper.bookstore.common.HomeMenu;

import java.util.Scanner;

public class MainView {
    private static MainView instance = new MainView();
    private MainView() {
    }
    public static MainView getInstance() {
        return instance;
    }
    public int init(Scanner scanner) {
        System.out.println("쵸파 북스토어에 오신 것을 환영합니다!");
        System.out.print(HomeMenu.HOME.getMenuString());
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputData(Scanner scanner) {
        return scanner.nextLine();
    }

}
