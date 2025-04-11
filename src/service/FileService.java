package service;

import model.Product;
import model.ProductType;
import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
* 파일 관련 클래스
* - 조회, 저장, 수정, 삭제
* */
public class FileService {
    private static final String FilPath = "data/productData.txt";

    // 파일에 새로운 데이터 추가 저장
    public void saveProduct(List<Product> productList) {
        try {

            File file = new File(FilPath);
            if (!file.exists()) {
                file.getParentFile().mkdir();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            for (Product product : productList) {
                writer.write(product.toFileString());
                writer.newLine();
            }

            writer.close();

        } catch (IIOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 파일에 특정 물품 삭제
    public boolean deleteProduct(Product product) {
        try {
            File file = new File(FilPath);
            List<Product> templist = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                templist.add(Product.fromFileString(line));
            }
            reader.close();

            boolean isDeleted = false;
            for (int i = 0 ; i < templist.size() ; i++) {
                if (templist.get(i).getProductName().equals(product.getProductName())) {
                    templist.remove(i);
                    // 상품 삭제 완료
                    isDeleted = true;
                    break;
                }
            }

            // 만약 찾는 상품이 없다면
            if (!isDeleted) {
                System.out.println("삭제할 수 있는 상품이 없습니다.");
                return false;
            }

            // 새롭게 저장
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Product p : templist) {
                writer.write(p.toFileString());
                writer.newLine();
            }

            writer.close();

        } catch (IIOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    // 파일에 정보 수정 후 다시 저장
    public void updateProduct(List<Product> productList) {
        try {

            File file = new File(FilPath);
            if (!file.exists()) {
                file.getParentFile().mkdir();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Product product : productList) {
                writer.write(product.toFileString());
                writer.newLine();
            }

            writer.close();

        } catch (IIOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 파일 데이터에 모든 정보 불러오기
    public List<Product> loadProduct() {
        List<Product> productList = new ArrayList<>();
        File file = new File(FilPath);

        if (!file.exists()) {
            List<Product> tempData = List.of(
                    new Product("코카콜라", 1600, 23, ProductType.DRINK),
                    new Product("스프라이트", 1500, 30, ProductType.DRINK),
                    new Product("오렌지주스", 1700, 45, ProductType.DRINK),
                    new Product("감자깡", 1200, 2, ProductType.SNACK),
                    new Product("나쵸", 1350, 12, ProductType.SNACK),
                    new Product("홈런볼", 1200, 34, ProductType.SNACK),
                    new Product("신라면", 1000, 5, ProductType.RAMEN),
                    new Product("진라면", 900, 15, ProductType.RAMEN),
                    new Product("너구리", 1100, 1, ProductType.RAMEN)
            );
            saveProduct(tempData);
            return tempData;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                productList.add(Product.fromFileString(line));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return productList;
    }

}
