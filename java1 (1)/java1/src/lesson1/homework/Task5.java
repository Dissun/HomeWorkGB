package lesson1.homework;

public class Task5 {

    public static void main(String[] args) {
        testTern(-5);
        testTern(0);
        testTern(5);
        
    }

    static void digitIdentifier(int digit) {
        if (digit < 0) {
            System.out.println(digit + " is negative digit");
        }
        else {
            System.out.println(digit + " is positive digit");
        }
    }

    static void testTern (int digit) {

        // (условие) ? (true) : (false)

        String word = (digit < 0) ? "negativ" : "positive";
        System.out.println(digit + " is " + word + " good digit!");


    }

}
