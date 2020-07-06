package lesson2.homework;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        int[] array = {1, 1, 0, 0, 1, 1};
        for (int i = 0; i < array.length; i++) {
          /*  if (array[i] == 1) {
                array[i] = 0;
            }
            else {
                array[i] = 1;
            }*/
            array[i] = array[i] == 1 ? 0 : 1 ;
        }

        System.out.println(Arrays.toString(array));


    }
}
