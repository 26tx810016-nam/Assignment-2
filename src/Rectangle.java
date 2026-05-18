public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(double side) {
        this.width = side;
        this.height = side;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle rect) {
        this.width = rect.width;
        this.height = rect.height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public boolean isSquare() {
        return width == height;
    }

    public void scale(double factor){
        this.width = this.width * factor;
        this.height = this.height * factor;
    }

    public void displayInfo() {
        String isSquare = "";

        if(isSquare()){
            isSquare = ". Là hình vuông";
        } else{
            isSquare = ". Không phải hình vuông";
        }

        System.out.println(
                "Hình có diện tich: " + area() + ". Chu vi: " + perimeter() + isSquare
        );
    }
}