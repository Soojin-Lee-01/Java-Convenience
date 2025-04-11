package model;

import lombok.Getter;
import lombok.Setter;
import service.FileService;

import java.util.ArrayList;
import java.util.List;

/*
* Product 싱글톤 객체
* 파일에서 데이터 불러와 관리
* 공통 instance
* */
@Getter
@Setter
public class ProductSingleton {
    private static ProductSingleton productSingleton;
    private List<Product> productList;
    private FileService fileService = new FileService();

    public ProductSingleton() {
        productList = new ArrayList<>();
    }

    public static ProductSingleton instance() {
        if (productSingleton == null) {
            productSingleton = new ProductSingleton();
        }
        return productSingleton;
    }


    public void setProductList() {
        this.productList = fileService.loadProduct();
    }


}
