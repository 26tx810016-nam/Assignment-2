public class Book {
    private String title;
    private String author;
    private int year;
    private double price;

    public Book(){
        this.title = "Unknown";
        this.author = "Unknown";
        this.year = 2000;
        this.price = 0;
    }

    public Book(String title, String author, int year, double price){
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;    
    }

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.year = 2026;
        this.price = 100000;    
    }

    public void displayInfo(){
        System.out.println(
            "Sách: " + this.title 
            + " - Tác giả: " + this.author 
            + " - Năm: " + this.year 
            + " - Giá: " + this.price);
    }

    public double applyDiscount(double percent){
        return price = price - (price * percent / 100);
    }
}