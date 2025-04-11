package view;

import service.CustomerService;
import service.UtilService;
import java.util.Scanner;

/*
* 구매자 모드
* - 물품 조회, 구매, 위시리시트 추가 / 조회
* */
public class CustomerView {
    private final Scanner scanner = new Scanner(System.in);

    public CustomerView() {

    }

    public void customerPrintInfo() {
        CustomerService customerService = new CustomerService();
        System.out.println("==구매자 모드==");
        System.out.println("안녕하세요! 당신을 뭐라고 불러드릴까요? :)");
        String name = scanner.nextLine();

        while (true) {
            System.out.println(name + "님 메뉴를 선택해주세요!");
            String menuText =
                    """
                    1. 물품 조회
                    2. 물품 구매
                    3. 위시리스트 담기
                    4. 위시리스트 확인
                    5. 종료
                    """;
            System.out.print(menuText);

            int number = Integer.parseInt(scanner.nextLine());

            switch (number) {
                case 1:
                    UtilService utilService = new UtilService();
                    utilService.categoryProductInfo();
                    break;
                case 2:
                    customerService.buyProduct();
                    break;
                case 3:
                    customerService.addWishlist();
                    break;
                case 4:
                    customerService.myWishlist();
                    break;
                case 5:
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
