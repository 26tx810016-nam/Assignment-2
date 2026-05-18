public class BankAccount {
    // Số tài khoản không nên có hàm setter vì đây là dữ liệu định danh bất biến
    // Không cho phép sửa đổi đảm bảo tính toàn vẹn và tránh rủi ro bảo mật
    
    private String accountNum;
    private String name;
    private double balance;

    public BankAccount(String accountNum, String name, double balance) {
        this.accountNum = accountNum;
        this.name = name;

        if (balance < 0) {
            this.balance = 0;
            System.out.println("So du phai lon hon 0");
        } else {
            this.balance = balance;
        }
    }
    
    public String getAccountNum() {
        return accountNum;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Ten tai khoan chi chap nhan ten khong rong!");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Nap tien thanh cong");
        } else {
            System.out.println("So tien nap phai lon hon 0");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Rut tien thanh cong");
        } else {
            System.out.println("So tien rut phai lon hon 0 và be hon so du tai khoan");
        }
    }

    public void transfer(BankAccount other, double amount) {
        if (amount <= 0) {
            System.out.println("So tien chuyen phai lon hon 0");
            return;
        } else if (amount > this.balance){
            System.out.println("So tien chuyen phai be hon so du");
            return;
        } else{
            this.balance -= amount;
            other.balance += amount;

            System.out.println("Giao dich thanh cong - Chuyen " + amount + " toi " + other.maskAccountNumber(other.accountNum));
        }
    }


    public String maskAccountNumber(String accountNum) {
        if (accountNum == null || accountNum.length() <= 4) {
            return accountNum; 
        }
        String last4 = accountNum.substring(accountNum.length() - 4);
        return "*".repeat(accountNum.length() - 4) + last4;
    }

    public void displayInfo() {
        System.out.println("Số tài khoản: " + maskAccountNumber(this.accountNum));
        System.out.println("Chủ tài khoản: " + this.name);
        System.out.println("Số dư: " + this.balance);
    }
}