package java.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.example.Apple.COLOR.GREEN;

public class Apple {

    private COLOR color;
    private int weight;

    enum COLOR {
        RED,
        GREEN
    }

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

    public static List<Apple> filterHeavyApplesSequential(List<Apple> inventory, int weight) {
        List<Apple> heavyApples = inventory.stream().filter((Apple a) -> a.getWeight() > weight)
                .collect(Collectors.toList());

        return heavyApples;
    }

    public static List<Apple> filterHeavyApplesParallel(List<Apple> inventory, int weight) {
        List<Apple> heavyApples = inventory.parallelStream().filter((Apple a) -> a.getWeight() > weight)
                .collect(Collectors.toList());

        return heavyApples;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, COLOR color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

}
