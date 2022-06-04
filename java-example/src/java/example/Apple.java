package java.example;

import static java.example.Apple.COLOR.GREEN;

public class Apple {

    private COLOR color;
    private int weight;

    enum COLOR {
        RED,
        GREEN
    };

    public COLOR getColor() {
        return this.color;
    }

    public int getWeight() {
        return this.weight;
    }

    public static boolean isGreenApple(Apple apple) {
        return GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}
