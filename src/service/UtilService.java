package service;

import model.Product;
import model.ProductSingleton;
import model.ProductType;
import java.util.List;
import java.util.Scanner;


/*
* 공통 기능
* 특정 카테고리 물품 조회
* 조회한 물품 정보 출력
* */
public class UtilService {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Product> productList = ProductSingleton.instance().getProductList();

    public UtilService() {

    }

    // 특정 카테고리 물품 조회
    public List<Product> getProducts() {

        System.out.println("<물품 조회>");
        System.out.println("조회를 원하시는 물품의 카테고리를 입력하세요. (DRINK : 1, SNACK : 2, RAMEN : 3)");
        int category = Integer.parseInt(scanner.nextLine());
        ProductType productType = null;
        switch(category) {
            case 1:
                productType = ProductType.DRINK;
                break;
            case 2:
                productType = ProductType.SNACK;
                break;
            case 3:
                productType = ProductType.RAMEN;
                break;
            default:
                System.out.println("없는 번호입니다. :(");
                break;
        }
        ProductType finalProductType = productType;
        return productList.stream()
                .filter(n -> n.getProductType().equals(finalProductType))
                .toList();
    }

    // 찾은 특정 카테고리 물품 출력
    public void categoryProductInfo() {
        List<Product> temp = getProducts();
        for (Product product : temp) {
            System.out.println(product.toString());
        }
        System.out.println();
    }

}
