package LessonNew;
public class Cat implements Runable,Jumpable, Competitor {

    private String name;

    private int maxRunDistance;
    private int maxJumpHeight;

    private boolean onDistance;

    public Cat(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    public Cat(String name) {
        this(name, 1500, 4);
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " подпрыгивает на " + height + " метров");
        } else {
            System.out.println(name + " не может перепрыгнуть " + height + " метров");
            onDistance = false;
        }
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробегает " + distance + " метров");
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
