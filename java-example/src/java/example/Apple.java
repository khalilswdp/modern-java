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
}
