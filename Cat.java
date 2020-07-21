package lesson7;

public class Cat {

    protected final String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = true;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    void eat(Plate plate) {
        if (plate.decreaseFood(appetite))
            if (satiety) {
                satiety = false
                ;
            }
    }


    public void doEat(Plate plate) {
        plate.decreaseFood(appetite);
    }

    void info() {
        String isHungry = !satiety ? "full" : "hungry";
        System.out.println(name + ": " + isHungry);
    }
}


