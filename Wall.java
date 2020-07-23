package LessonNew;
public class Wall extends Obstructions {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void youCan(Competitor competitor) {
        competitor.jump(height);
    }
}
