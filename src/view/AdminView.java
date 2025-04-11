package view;

import service.AdminService;
import service.UtilService;
import java.util.Scanner;

/*
* 판매자 모드
* - 물품 조회, 등록, 삭제
* */
public class AdminView {
    private final Scanner scanner = new Scanner(System.in);

    public AdminView() {

    }

    public void adminPrintInfo() {
        AdminService adminService = new AdminService();
        while(true) {
            String menuText =
                    """
                    ==관리자 모드==
                    1. 물품 조회
                    2. 물품 등록
                    3. 물품 삭제
                    4. 종료
                    """;
            System.out.print(menuText);

            int number = scanner.nextInt();
            // switch 문으로 바꾸기!
            switch (number) {
                case 1:
                    UtilService utilService = new UtilService();
                    utilService.categoryProductInfo();
                    break;
                case 2:
                    adminService.addProduct();
                    break;
                case 3:
                    adminService.deleteProduct();
                    break;
                case 4:
                    System.out.println("초기 화면으로 종료합니다. :)");
                    System.out.println();
                    return;
                default:
                    System.out.println("없는 번호입니다. :( 초기 화면으로 종료합니다.");
                    System.out.println();
                    return;
            }
        }
    }
}
