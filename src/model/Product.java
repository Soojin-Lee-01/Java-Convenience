package model;

import lombok.Getter;
import lombok.Setter;

/*
* Product
* */
@Setter
@Getter
public class Product {
    private ProductType productType;
    private String productName;
    private int price;
    private int productCount;

    public Product(String productName, int price, int productCount, ProductType productType) {
        this.productName = productName;
        this.price = price;
        this.productCount = productCount;
        this.productType = productType;
    }

    // Product객체를 파일 문자열로 변환
    public String toFileString() {
        return productName + "," + price + "," + productCount + "," + productType;
    }

    // 파일 문자열을 Product 객체로 변환
    public static Product fromFileString(String line) {
        String[] parts = line.split(",");
        String name = parts[0];
        int price = Integer.parseInt(parts[1]);
        int count = Integer.parseInt(parts[2]);
        ProductType productType1 = ProductType.valueOf(parts[3]);

        return new Product(name, price, count, productType1);
    }

    // 출력
    public String toString() {
        String data = "이름 : " + productName + ", 가격 : " + price + "원, 수량  : " + productCount;
        String category = null;
        if (productType.equals(ProductType.DRINK)) {
            category = "음료";
        } else if (productType.equals(ProductType.SNACK)) {
            category = "과자";
        } else {
            category = "라면";
        }
        data += ", 카테고리 : " + category;

        return data;
    }

}
