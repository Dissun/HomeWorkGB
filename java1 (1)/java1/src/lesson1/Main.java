package lesson1;

public class Main {

    public static void main(String[] args) {

        // Р. Мартин - Чистый код
        // Р. Мартин - Идеальный программист

        int countApple = 7;
        int b = 5;
        int c = countApple / b;

        int d = 7;
        double f = 5;
        double u = d / f;

//        System.out.println(c);


//        char chr = 'f';
//        char chr = 30000;
//        System.out.println(chr);

       /* for (int i = 0; i < 3000; i= i+1) {
             System.out.printf("%4d : %2c \n", i, i);
        }*/

//           0    1 .. 1111 2222

        boolean isFlag = true;

        String str = "Hello!";
        String str2 = new String("Hello!");

//        System.out.printf("Результат: %5d \n", c);
//        System.out.println("Результат: " + c);
//        System.out.println(b + d + "Результат: " + (c + d));

        int i = 0;
//        i = i + 1;
//        i--;

        System.out.println(i++);
        System.out.println(++i);
        System.out.println(i--);
        System.out.println(--i);

//        c %= d; // c = c % d;


/*        if (c > 0) {
            System.out.println("Больше нуля!");
        } else if(c < 0) {
            System.out.println("Меньше нуля!");
        } else {
            System.out.println("Перменная равна нулю!");
        }*/

        String a = new String("Hello!");
        String a2 = "Hello!";

/*        if (a.equals(a2)) {
            System.out.println("Строки равны!");
        }*/


        sayHello();
        double result = add(10000, 15000);
        System.out.println(result);

        Main mainClass = new Main();
        mainClass.ex1();

        Calculator calculator = new Calculator("Борис");
        Calculator calculator1 = new Calculator("Инокентий");
        int result2 = calculator.mul(11, 124);
        System.out.println(result2);
        System.out.println(calculator);
        System.out.println(calculator1);

        String str3 = "Какая-то строка с Текстом";
        System.out.println(str3.toUpperCase());
        System.out.println(str3.toLowerCase());
    }

    public static void sayHello() {
        System.out.println("Hello, world!");
    }

    public static double add (int valueA, int valueB) {
        return (valueA + valueB) * 0.87;

    }

    public void ex1() {

    }
}
