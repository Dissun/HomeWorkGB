import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class MainLesson6Test {

    MainLesson6 mainL6;

    public MainLesson6Test() {
        mainL6 = new MainLesson6();
    }

    @BeforeEach
    public void init() {
        mainL6 = new MainLesson6();
    }


    @Test
    public void task2Test1() {
        int[] arr1 = {7, 8, 0};
        int[] arr2 = new int[0];
        Assertions.assertArrayEquals(arr1, MainLesson6.task2(new int[] {2, 4, 5, 6, 2, 4, 7, 8, 0}));
        Assertions.assertArrayEquals(arr2, MainLesson6.task2(new int[] {2, 4, 5, 6, 2, 4}));
        Assertions.assertThrows(RuntimeException.class, () -> MainLesson6.task2(new int[] {2, 5, 6, 2, 7, 8, 0}));
    }


    @Test
    public void task3Test() {
        int[] falseNull = {};
        int[] false1 = {1, 6, 4, 4, 1, 4};
        int[] false2 = {1, 1, 3, 5, 6};
        int[] false3 = {0, 2, 3, 4, 5};
        int[] true1 = {1, 4, 4, 1, 1, 4};
        int[] false4 = {1, 1, 1, 1};
        int[] false5 = {4, 4, 4, 4};

        Assertions.assertNotEquals(true, MainLesson6.task3(falseNull), "Массив пустой");
        Assertions.assertEquals(false, MainLesson6.task3(false1), "В массиве содержатся не только 1 и 4");
        Assertions.assertEquals(false, MainLesson6.task3(false2), "Нет 4, посторонние цифры");
        Assertions.assertNotEquals(true, MainLesson6.task3(false3));
        Assertions.assertEquals(true, MainLesson6.task3(true1), "Верный массив");
        Assertions.assertEquals(true, MainLesson6.task3(false4));
        Assertions.assertEquals(true, MainLesson6.task3(false5), "Только 4");
    }
}