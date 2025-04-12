package view;

import java.util.Scanner;

/*
* 초기 화면 View
* 관리자 모드 & 판매자 모드 둘 중 원하는 걸 선택할 수 있음.
* */
public class MainView {
    private final Scanner scanner = new Scanner(System.in);

    public MainView() {

    }

    public void menuPrintInfo() {
        while (true) {
            String menuText =
                    """
                    편의점입니다. 원하는 숫자를 선택해주세요.
                    1. 관리자 모드
                    2. 구매자 모드
                    3. 종료
                    """;
            System.out.print(menuText);

            int number = Integer.parseInt(scanner.nextLine());

            switch (number) {
                case 1:
                    adminView();
                    break;
                case 2:
                    customerView();
                    break;
                case 3:
                    System.out.println("안녕히가세요 :)");
                    return;
                default:
                    System.out.println("유효하지 않은 숫자입니다. 종료합니다. :(");
                    return;
            }
        }
    }

    public void adminView() {
        AdminView adminView = new AdminView();
        adminView.adminPrintInfo();
    }

    public void customerView() {
        CustomerView customerView = new CustomerView();
        customerView.customerPrintInfo();
    }

}

