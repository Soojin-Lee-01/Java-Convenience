import model.Product;
import model.ProductSingleton;
import service.FileService;
import view.MainView;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProductSingleton productSingleton = ProductSingleton.instance();
        productSingleton.setProductList();

        // 뷰 실행
        MainView mainboard = new MainView();
        mainboard.menuPrintInfo();

        //List<Product> productList = ProductSingleton.instance().getProductList();

    }
}