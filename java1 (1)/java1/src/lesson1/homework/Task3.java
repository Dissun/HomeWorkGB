package lesson1.homework;

public class Task3 {

    public static void main(String[] args) {
        double result = evaluateExpression(2, 1, 2, 0);
        double result1 = evaluateExpression(2, 1, 2, 3);
        double result2 = evaluateExpression(2, 1, 2, -1);

        System.out.println(result);
    }

    private static double evaluateExpression(int a, int b, int c, int d) {
        String str = "Hello!";
        if (d == 0) throw new RuntimeException("НЕЛЬЗЯ ДЕЛИТЬ НА НОЛЬ!");
        return a * (b + ( (double)c / d));
    }


}
