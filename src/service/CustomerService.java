package service;

import model.Product;
import model.ProductSingleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 구매자 모드 Service 파일
* 물품 구매, 위시리스트 조회/추가
* */
public class CustomerService {
    private final List<Product> productList = ProductSingleton.instance().getProductList();
    private final Scanner scanner = new Scanner(System.in);
    private final List<Product> wishlist = new ArrayList<>();


    public CustomerService() {

    }

    // 물품 구매
    public void buyProduct() {
        System.out.println("<물품 구매>");
        System.out.println("구매를 원하는 상품의 이름을 알려주세요 :)");
        String name = scanner.nextLine();
        System.out.println("구매하려는 갯수를 알려주세요.");
        int count = Integer.parseInt(scanner.nextLine());
        boolean isBuy = false;

        for (Product product : productList) {
            if (product.getProductName().equals(name)) {
                if (product.getProductCount() >= count) {
                    product.setProductCount(product.getProductCount() - count);
                    System.out.println("물품 구매가 완료되었습니다. :)");
                    isBuy = true;
                    // 파일 서비스로 전달 후 수정
                    FileService fileService = new FileService();
                    fileService.updateProduct(productList);
                    ProductSingleton.instance().setProductList();
                    break;
                } else {
                    System.out.println("수량이 부족합니다. 다음에 이용해주세요.");
                    isBuy = true;
                    System.out.println();
                    break;
                }
            }
        }
        if (!isBuy) {
            System.out.println("원하시는 물품이 없습니다. 물품 조회를 통해 확인해주세요!");
            System.out.println();
        }

    }

    // 찜 내역 조회
    public void myWishlist() {
        System.out.println("나의 위시리스트>");
        for (Product product : wishlist) {
            System.out.println(product.toString());
        }
        System.out.println();
    }

    // 찜하기
    public void addWishlist() {
        System.out.println("위시리스트에 담을 물품의 이름을 입력해주세요.");
        String name = scanner.nextLine();

        boolean isWish = false;
        for (Product product : productList) {
            if (product.getProductName().equals(name)) {
                isWish = true;
                wishlist.add(new Product(product.getProductName(), product.getPrice(), product.getProductCount(), product.getProductType()));
                System.out.println(name + "이 담겼습니다!");
                System.out.println();
                break;
            }
        }

        if (!isWish) {
            System.out.println("원하시는 물품이 없습니다. :(");
        }
    }
}
