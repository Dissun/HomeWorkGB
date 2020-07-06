package lesson2;

public class WhileExample {

    public static void main(String[] args) {

        int i = 0;
        while (i < ForExample.LIMIT) {
            System.out.println(i);
            i++;
        }

        do {
            System.out.println(i);
            i++;
        } while (i < ForExample.LIMIT);

    }
}
