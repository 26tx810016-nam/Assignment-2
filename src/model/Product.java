package model;

import util.ProductValidator;
    // Nếu một sản phẩm bị “huỷ”, totalProducts không nên giảm để quản lí tổng số lượng sản phẩm
    // Phương thức discontinue() sẽ quản lí sản phẩm bằng cách ẩn đi thay vì xóa.

public class Product {
    private String productCode;
    private String name;
    private double price;
    private int quantity;
    private boolean isDiscontinue;

    private static int counter = 1;
    private static int totalProducts = 0;
    private static double totalRevenue = 0;

    public Product() {
        this.productCode = String.format("P-%04d", counter);
        this.name = "Unknown";
        this.price = 0;
        this.quantity = 0;

        counter++;
        totalProducts++;
    }

    public Product(String name, double price) {
        this.productCode = String.format("P-%04d", counter);
        this.name = name;
        this.price = price;
        this.quantity = 0;

        counter++;
        totalProducts++;
    }

    public Product(String name, double price, int quantity) {
        this.productCode = String.format("P-%04d", counter);
        this.name = name;
        this.price = price;
        this.quantity = quantity;

        counter++;
        totalProducts++;
    }

    public String getCode(){
        return this.productCode;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setName(String name){
        if (ProductValidator.isValidName(name)) {
            this.name = name;
        } else{
            System.out.println("Ten san pham khong duoc de trong");
        }
    }

    public void setPrice(double price){
        if(ProductValidator.isValidPrice(price)){
            this.price = price;
        } else{
            System.out.println("Gia san pham khong duoc duoi 0d");
        }
    }

    public void setQuantity(int quantity){
        if(ProductValidator.isValidQuantity(quantity)){
            this.quantity = quantity;
        } else{
            System.out.println("So luong san pham khong duoc duoi 0");
        }
    }

    public void sell (int amount){
        if(this.isDiscontinue){
            System.out.println("San pham da bi ngung ban");
            return;
        }

        if(amount < 0){
            System.out.println("So luong san pham khong duoc duoi 0");
        } else if(amount >= this.quantity){
            System.out.println("So luong san pham trong kho khong du");    
        } else{
            this.quantity -= amount;
            totalRevenue += amount * this.price;
        }
    }

    public void restock (int amount){
        if(this.isDiscontinue){
            System.out.println("San pham da bi ngung ban");
            return;
        }

        if(amount > 0){
            this.quantity += amount;
        } else{
            System.out.println("So luong nhap vao khong duoc duoi 0");
        }
    }

    public void displayInfo (){
        System.out.println(
            "Sản phẩm " + this.name + 
            " - " + this.productCode + 
            ". Giá bán: " + this.price +
            "Số lượng trong kho: " + this.quantity
        );
    }

    public static int getTotalProducts(){
        return totalProducts;
    }
    
    public static double getTotalRevenue(){
        return totalRevenue;
    }

    public void applyPromotion(double percent){
        price = price - (price * percent/100);
    }

    public static void applyGlobalPromotion(Product[] products, double percent){
        for (Product p : products) {
            p.applyPromotion(percent);
        }
    }

    //Mình ẩn những sản phẩm bị hủy đi bằng 1 biến isDiscontinue
    //Dùng biến này để xử lí các method khác
    public void discontinue(){
        this.isDiscontinue = true;
    }
}
