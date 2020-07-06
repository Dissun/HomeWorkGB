package lesson3.homewok;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Task1 {

    private static final int ATTEMPT_NUMBER = 3;
    private static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        Random random = new Random();
        int targetValue = random.nextInt(MAX_VALUE + 1);

        System.out.println("Я загадал число от 0 до 9! Угадай, какое?");

        Scanner scanner = new Scanner(System.in);
        for (int attempt = 0; attempt < ATTEMPT_NUMBER; attempt++) {
            System.out.printf("Попытка номер %d.%n", attempt + 1);
            int userValue = getUserValue(scanner);
            if (userValue == targetValue) {
                System.out.println("Все верно!");
                break;
            }
            else if (userValue < targetValue) {
                System.out.println("Загаданное число больше " +userValue);
            }
            else {
                System.out.println("Загаданное число меньше " +userValue);
            }
        }
    }

    private static int getUserValue(Scanner scanner) {
        int result = MAX_VALUE+1;
        do {
            try {
                System.out.print("Введите число: ");
                int value = scanner.nextInt();
                if (value < 0 || value > MAX_VALUE) {
                    System.out.println("Число вне диапазона, пробуй еще!");
                    continue;
                }
                result = value;
            } catch (NumberFormatException e) {
                System.out.println("Это не число, в следующий раз давай без фокусов!");
            }
        } while (result == MAX_VALUE+1);

        return result;
    }
}
