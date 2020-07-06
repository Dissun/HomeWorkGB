package lesson2;

public class ForExample {

    public static final int LIMIT = 15;
    public static final int STOP_DIGIT = 5;
    public static final int DIVIDER = 3;


    public static void main(String[] args) {

        int i = 0;
        for (; i < LIMIT; i++) {
            System.out.println(i);
        }

        System.out.println("Конечный результат - " + i);

        for (int j = LIMIT; j > 0; j--) {
            if (j % DIVIDER == 0) {
                continue;
            }
            if (j == STOP_DIGIT) {
                break;
            }
            System.out.println(j);
        }


    }

}
