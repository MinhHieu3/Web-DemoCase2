package QuanLyQuanNet.services;

import QuanLyQuanNet.models.Computer;
import QuanLyQuanNet.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ManagerProduct implements IManager<Product>{
    List<Product> productList =new ArrayList<>();

    public ManagerProduct() {
        productList.add(new Product(1,"Mì Tôm",120,12));
        productList.add(new Product(2,"Xúc Xích",130,20));
        productList.add(new Product(3,"Trứng",100,30));
    }

    @Override
    public void add(Product add) {
        productList.add(add);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void edit(int n, Product product) {
        int index=-1;
        for (int i = 0; i < this.productList.size(); i++) {
            if (n==this.productList.get(i).getId()){
                index=i;
            }
        }
        productList.set(index,product);
    }

    @Override
    public void delete(int n) {
        for (Product p: productList) {
            if (p.getId()==n){
                productList.remove(p);
                break;
            }
        }
    }

    @Override
    public Product search(int n) {
        for (Product p: productList) {
            if (p.getId()==n){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Computer> showAll() {
        for (Product p: productList) {
            System.out.println(p);
        }

        return null;
    }


}
