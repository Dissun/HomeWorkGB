package LessonNew;
public class Man implements Runable,Jumpable, Competitor {
    private String name;

    private int maxRunDistance;
    private int maxJumpHeight;

    private boolean onDistance;

    public Man(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    public Man(String name) {
        this(name , 4500, 2);
    }

    @Override
    public void jump(int height) {

        if (height <= maxJumpHeight) {
            System.out.println(name + " подпрыгнет на " + height + " метров" );
        } else {
            System.out.println(name + " не способен перепрыгнуть " + height + " метров" );
            onDistance = false;
        }
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежит " + distance + " метров" );
        } else {
            System.out.println(name + " не сможет пробежать " + distance + " метров" );
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