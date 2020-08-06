import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] newArray = new float[size];
        Arrays.fill(newArray, 1);

        firstThread(newArray);
        secondThread(newArray);

    }

    private static void firstThread(float[] arr) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Calculation time in one stream: " + (System.currentTimeMillis() - startTime));
    }

    private static void secondThread(float[] array) {
        long startBreakingTime = System.currentTimeMillis();
        float[] arrayOne = new float[h];
        float[] arrayTwo = new float[h];
        System.arraycopy(array, 0, arrayOne, 0, h);
        System.arraycopy(array, h, arrayTwo, 0, h);

        long part1 = System.currentTimeMillis() - startBreakingTime;
        System.out.println("Time of splitting array: " + part1);

        long startTime = System.currentTimeMillis();
        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrayOne.length; i++) {
                    arrayOne[i] = (float) (arrayOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        firstThread.start();

        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrayTwo.length; i++) {
                    arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
                }
            }

        });
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long part2 = System.currentTimeMillis() - startTime;
        System.out.println("Calculation time in two streams: " + part2);

        long unionTime = System.currentTimeMillis();
        System.arraycopy(arrayOne, 0, array, 0, h);
        System.arraycopy(arrayTwo, 0, array, h, h);

        long part3 = System.currentTimeMillis() - unionTime;
        System.out.println("Reverse gluing time : " + part3);

        System.out.println();
        System.out.println("Total working time: " + (part1 + part2 + part3));
    }
}
