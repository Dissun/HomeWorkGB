package LessonNew;

import LessonNew.src.Competitor;
import LessonNew.src.Tread;
import LessonNew.src.Wall;
import LessonNew.src.Obstructions;

public class Main {

    public static <Obstructions> void main(String[] args) {

    Competitor [] competitors = {
            new Man("Мюнгхаузен"),
            new Cat("Чеширский кот"),
            new Robot("3PO")
    };

        Obstructions [] obstructions = {
            new Tread(5000),
            new Wall(200)
    };


    for (Competitor c: competitors) {
        for (Obstructions o: obstructions) {
            o.youCan(c);
            if(!c.isOnDistance()) {
                break;
            }
        }
    }

    for(Competitor c: competitors) {
        c.status();
    }
}
}
