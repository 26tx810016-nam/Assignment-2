package util;

public class ProductValidator {
    public static boolean isValidName(String name){
        if(name != null && !name.trim().isEmpty() && name.length() >=2){
            return true;
        }

        return false;
    }

    public static boolean isValidPrice(double price){
        if(price >= 0){
            return true;
        }

        return false;
    }

    public static boolean isValidQuantity(int quantity){
        if(quantity >= 0){
            return true;
        }

        return false;
    }
}