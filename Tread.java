package LessonNew;
public class Tread extends Obstructions {

    private int distance;

    public Tread(int distance) {
        this.distance = distance;
    }

    @Override
    public void youCan(Competitor competitor) {
        competitor.run(distance);
    }
}
