package lesson2.homework;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
        System.out.println(Arrays.toString(array));
    }
}
