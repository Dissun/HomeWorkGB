package lesson7;

import lesson7.Cat;
import lesson7.Plate;

public class Test {

        public static void main(String[] args) throws InterruptedException {

        Cat[] cats = new Cat[3];
        cats[0] = new Cat ("Sunny", 5);
        cats[1] = new Cat ("Snowwhite", 6);
        cats[2] = new Cat ("Thomas", 8);

        int foodCount = 20;
        Plate plate1 = new Plate(foodCount);

        plate1.info();
        catsEat(cats,plate1);

        

    }

    private static void catsEat(Cat[] cats, Plate plate1) {
        for (int i = 0; i < 3; i++) {
            cats[i].eat(plate1);
            System.out.println(cats[i].getName() + " was finish eat.");
            plate1.info();
        }
        System.out.print("We have: ");
        plate1.info();
    }
}
