import model.Product;
import model.Category;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("----------------- Bài 1 ----------------");

        Book b1 = new Book();
        Book b2 = new Book("Kinh van hoa", "Nguyen Nhat Anh", 1995 , 25000);

        Book bookList[] = {b1,b2};

       for (Book book : bookList) {
            book.displayInfo();
        }

        System.out.println("----------------- Bài 2 ----------------");

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(23);
        Rectangle r3 = new Rectangle(30, 30);

        Rectangle[] rectList = {r1,r2,r3};
        for (Rectangle r : rectList) {
            r.displayInfo();
        }
        
        System.out.println("----------------- Bài 3 ----------------");
        
        BankAccount a1 = new BankAccount("4829182941", "Nam Nguyen", -23);
        BankAccount a2 = new BankAccount("9238401", "Nam Pham", 1000);
        BankAccount a3 = new BankAccount("123", "Nam Nguyen", 1000);

        a1.displayInfo();

        a2.deposit(-3);
        a2.withdraw(2000);

        a3.displayInfo();
        a3.transfer(a1, 100);


        System.out.println("----------------- Bài 4 ----------------");

        Employee e1 = new Employee("Nguyen Thi Thu", 12500);
        Employee e2 = new Employee("Bui To Anh", 10000);
        Employee e3 = new Employee("Hoang Van Tien", 18000);

        Employee[] empList = {e1,e2,e3};
        for (Employee e : empList) {
            System.out.println(e.getId());
        }

        System.out.println("Tong so nhan vien: " + e1.getEmployeeCount());
        System.out.println("Tong luong: " + e1.getTotalSalary());
        System.out.println("Luong trung binh: " + Employee.getAverageSalary());

        e1.setSalary(13000);
        System.out.println("Tong luong sau khi setSalary: " + e1.getTotalSalary());

        e2.raiseSalary(10);
        System.out.println("Tong luong sau khi raiseSalary: " + e2.getTotalSalary());
    

        System.out.println("----------------- Bài 5 ----------------");

        Product p1 = new Product();
        Product p2 = new Product("Mu", 1000);
        Product p3 = new Product("Ao phong", 2000, 10);
        Product p4 = new Product("Giay", 1500, 5);

        Product[] productList = {p1,p2,p3,p4};
        for (Product p : productList) {
            System.out.println(p.getCode());
        }

        p2.sell(1); //fail
        p3.sell(2);
        p2.restock(3);
        p2.sell(1);
        p4.sell(2);

        System.out.println("So san pham: " + Product.getTotalProducts());
        System.out.println("Tong doanh thu: " + Product.getTotalRevenue());


        Category category = new Category("Quan ao");
        
        category.addProduct(p1);
        p1.setCategory(category);

        System.out.println(p1.category.getCategoryName());
    
    }
}
