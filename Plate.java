package lesson7;

public class Plate {
    private int food;
    private int moreFood;

    public Plate(int food) {
        this.food = food;
        this.moreFood = 10;
    }

    public void addFood(int appetite) {
        if(appetite > food)
        food += moreFood;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "In plate is " +
                + food +
                " food.";
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int appetite) {
        if (appetite > food){
            food = food;
            System.out.println("Cat don't wanna eat less than he need. " + "His appetite: " + appetite + ".");
        }
        food -= appetite;
        return false;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
