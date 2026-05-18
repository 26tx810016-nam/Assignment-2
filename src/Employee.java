public class Employee {
    // Employee.getAverageSalary() vẫn sẽ chạy được vì đây là hàm static thuộc
    // class Employee chứ không phải của object cụ thể nào
    
    private int id;
    private String name;
    private double salary;

    private static int employeeCount = 0;
    private static int nextId = 1000;
    public static String companyName = "TechCorp";
    private static double totalSalary = 0;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;

        this.id = nextId;
        nextId++;
        employeeCount++;

        totalSalary += salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        totalSalary = totalSalary - this.salary + salary;
        this.salary = salary;
    }

     public int getEmployeeCount() {
        return employeeCount;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public static double getAverageSalary() {
        if (employeeCount == 0) {
            return 0;
        }

        return totalSalary / employeeCount;
    }

    public static void changeCompanyName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            companyName = newName;
            System.out.println("Doi ten thanh cong");
        } else {
            System.out.println("Ten khong duoc de trong");
        }

    }

    public void raiseSalary(double percent){
        double newSalary = this.salary + (this.salary * percent / 100);

        totalSalary = totalSalary - this.salary + newSalary;

        this.salary = newSalary;
    }
}
