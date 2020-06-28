import java.util.Random;
import java.util.Scanner;

public class lesson3hw {
    public static void main(String[] args) {


        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int guess = -1;
        int rightAnswer = random.nextInt(10);
        String reset = new String();

        while (count < 3 && guess != rightAnswer) {
            System.out.print("Угадайте число от 0 до 9: ");
            guess = scanner.nextInt();
            if (rightAnswer != guess) {
                System.out.println("Вы выбрали " + guess + "\n" +
                        ((guess > rightAnswer) ? "Загаданное число должно быть меньше" : "Загаданное число должно быть больше"));
                count++;
            }
        }

        System.out.println("ВЫ " + ((guess == rightAnswer)? "УГАДАЛИ! ПОЗДРАВЛЯЮ!" : "НЕ УГАДАЛИ. ВЕРНОЕ ЧИСЛО: " + rightAnswer));

    }
}
