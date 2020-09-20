import java.util.ArrayList;
import java.util.Arrays;


public class main {
    public static void main(String[] args) {
        //Задание 1
        Integer[] arrInt = {13, 3, 16};
        String[] arrString = {"angeloni", "diretodecampo", "mercadolibre"};
        changeArrays(arrInt, 2, 0);
        changeArrays(arrString, 0, 2);

        //Задание 2.
        ArrayList<String> arrayList = arrayToList(arrString);
        ArrayList<Integer> arrayList1 = arrayToList(arrInt);
        System.out.println(arrayList +"\n" + arrayList1 );

        //Задание 3.
        Box<Orange> box1 = new Box<>();
        Box<Apple> box2 = new Box<>();
    }

    public static void changeArrays(Object[] arr, int firstElement, int secondElement) {
        if (firstElement <= arr.length && secondElement <= arr.length) {
            Object changeElement = arr[firstElement];
            arr[firstElement] = arr[secondElement];
            arr[secondElement] = changeElement;
        } else {
            System.out.println("It's impossible too.");
        }
        for (Object c : arr) {
            System.out.print(c.toString() + " ");
        }
        System.out.println("");
    }
    //Задание 1 выполнено. Знаю, наверняка можно сделать код короче, но только такое пришло на ум.

    //Задание 2, метод
    public static <T> ArrayList<T> arrayToList(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));}
}

