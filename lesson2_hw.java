import java.util.Arrays;

public class lesson2_hw {
    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
            System.out.print("Задание 1.\n" + "normalArray\n" + Arrays.toString(arr));
            System.out.println("\n" + "invertArray");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i] = 0;
            else arr[i] = 1;
        }
            System.out.println(Arrays.toString(arr));

            System.out.println("\n" + "Задание 2.");
        int[] arr2 = new int[8];
        int j=0;

        for(int i = 0; i < arr2.length; i++, j = j + 3) {
         arr2[i] = j;
         }
            System.out.println(Arrays.toString(arr2));

            System.out.print("\n" + "Задание 3." + "\n");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            System.out.print(Arrays.toString(arr3));

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6 ) arr3[i] = arr3[i]*2;
        }
            System.out.println("\n" + Arrays.toString(arr3));

            System.out.print("\n" + "Задание 4." + "\n");
        int[][] arr4 = new int[4][4];
        for (int i = 0; i < arr4.length; i++) {
            for (int g = 0; g < arr4.length; g++) {
                if ((i == g) || (i == arr4.length - 1 - g)) {
                    arr4[i][g] = 1;
                    System.out.print(arr4[i][g] + " ");
                }
            }
        }
            System.out.print("\n" + "Задание 5." + "\n");
        int arr5[] = {-1,12,5,43,7,8,10,208};
        Arrays.sort(arr5);

        int min =arr5[0];
            System.out.println("Minimum is: " + min);
        int max= arr5[arr5.length-1];
            System.out.println("Maximum is: " + max);
            //конечно же, изучил варианты в интернете, так как тема интересная и без этого не осилил бы решение

        int[] forCheckBalanceArr = {5, 4, 3, 3, 4, 5};
        System.out.print("\n" + "Задание 6." + "\n");
        System.out.println(checkBalance(forCheckBalanceArr));

        System.out.print("\n" + "Задание 7." + "\n" + "Непосильно к пониманию пока что");
    }

        public static boolean checkBalance(int[] array){


        int leftSum = 0;
            for(int i = 0; i < array.length; i++){
                leftSum += array[i];
           int rightSum = 0;
                for (int j = 0; j < array.length; j++){
                    rightSum += (j > i)? array[j] : 0;
                }
                if(leftSum == rightSum){
                    return true;
                }
            }
            return false;
        }

}

