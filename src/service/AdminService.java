package service;

import model.Product;
import model.ProductSingleton;
import model.ProductType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 관리자 모드 Service 파일
* 물품 삭제, 등록
* */
public class AdminService {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Product> productList = ProductSingleton.instance().getProductList();

    public AdminService() {

    }

    // 물품 등록하기
    public void addProduct() {
        System.out.println("<물품 등록>");
        System.out.println("등록할 물품 이름을 입력하세요.");
        String name = scanner.nextLine();
        System.out.println(name + "의 가격을 입력하세요");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println(name +"의 등록 수량을 입력하세요.");
        int productCount = Integer.parseInt(scanner.nextLine());
        System.out.println("어떤 카테고리 상품인가요? 번호를 입력해주세요. (DRINK : 1, SNACK : 2, RAMEN : 3)");
        int productCategory = Integer.parseInt(scanner.nextLine());
        ProductType category = null;
        switch (productCategory) {
            case 1:
                category = ProductType.DRINK;
                break;
            case 2:
                category = ProductType.SNACK;
                break;
            case 3:
                category = ProductType.RAMEN;
                break;
            default:
                System.out.println("등록할 수 없는 카테고리입니다. :(");
                break;
        }
        try {
            List<Product> newProduct = new ArrayList<>();
            newProduct.add(new Product(name, price, productCount, category));

            // 등록 물품 파일에 저장
            FileService fileService = new FileService();
            fileService.saveProduct(newProduct);
            productList.add(new Product(name, price, productCount, category));
            ProductSingleton.instance().setProductList();

            System.out.println("물품 등록이 완료되었습니다. :)");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 물품 삭제
    public void deleteProduct() {
        System.out.println("<물품 삭제>");
        System.out.println("삭제할 물품의 이름을 입력하세요.");
        String name = scanner.nextLine();

        boolean isDeleted = false;

        for (int i = 0 ; i < productList.size() ; i++) {
            if (productList.get(i).getProductName().equals(name)) {
                FileService fileService = new FileService();
                if (fileService.deleteProduct(productList.get(i))) {
                    isDeleted = true;
                    ProductSingleton.instance().setProductList();
                    System.out.println("물품 삭제를 완료했습니다.");
                    System.out.println();
                    break;
                } else {
                    System.out.println("해당 물품이 없습니다. :(");
                    break;
                }
            }
        }
        if (!isDeleted) {
            System.out.println("해당 물품이 없습니다 :(");

        }
    }
}
