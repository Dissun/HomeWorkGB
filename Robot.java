package LessonNew;
public class Robot implements Runable,Jumpable, Competitor {

    private String name;

    private int maxRunDistance;
    private int maxJumpHeight;

    private boolean onDistance;

    public Robot(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    public Robot(String name) {
        this(name, 2000, 0);
    }



    @Override
    public void jump(int height) {
        if(maxJumpHeight == 0) {
            System.out.println(name + " не прыгает");
            onDistance = false;
            return;
        }
        if (height <= maxJumpHeight) {
            System.out.println(name + " подпрыгнет на " + height + " метров");
        } else {
            System.out.println(name + " не перепрыгнет " + height + " метров");
            onDistance = false;
        }
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежит " + distance + " метров");
        } else {
            System.out.println(name + " не способен пробежать " + distance + " метров");
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {return onDistance; }

    @Override
    public void status() {
        System.out.println(name + " " +
                (onDistance? " Участвует" : " Выбыл"));
    }
}