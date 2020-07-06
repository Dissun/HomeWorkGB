package lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] args) {
        final int SIZE = 7;

        int[][] data = new int[SIZE][SIZE];

//        data[0] = new int[] {1, 2, 3, 4, 5};
//        data[1] = 1;
//        data[-1] = 5;

/*        Arrays.fill(data, 5);

        System.out.println(Arrays.toString(data));*/
        int n = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                data[i][j] = n++;
            }
        }

/*        for (int i = 0; i < SIZE; i++) {
            System.out.println(data[i]);
        }*/

/*        for (int[] datum : data) {
            System.out.println(Arrays.toString(datum));
        }*/

        for (int[] datum : data) {
            for (int i : datum) {
                System.out.printf("%4d", i);
            }
            System.out.println();
        }

        char[] charArr = {'H', 'e', 'l', 'l', 'o', '!'};
        String str = new String(charArr);
        System.out.println(str);

        int i = 0;
        for (char ch : str.toCharArray()) {
            System.out.println("Элемент с индексом " + i++ + ": " + ch);
        }
    }
}
