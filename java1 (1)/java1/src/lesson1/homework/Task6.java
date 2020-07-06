package lesson1.homework;

public class Task6 {

    public static void main(String[] args) {
        System.out.println(isNegative(-5));
        System.out.println(isNegative(0));
        System.out.println(isNegative(5));
    }

    private static boolean isNegative(int digit) {
        return digit < 0 ;
    }
}
