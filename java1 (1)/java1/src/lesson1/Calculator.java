package lesson1;

public class Calculator {

    public String name;

    public Calculator(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Калькулятор зовут: " + name;
    }

    public int add (int a, int b) {
        return a + b;
    }

    public int mul (int a, int b) {
        return a * b;
    }
}
