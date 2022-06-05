package learning.mjia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static learning.mjia.Apple.COLOR.GREEN;

public class Apple {

    private final COLOR color;
    private final int weight;

    enum COLOR {
        RED,
        GREEN
    }

    public Apple(COLOR color, int weight) {
        this.color = color;
        this.weight = weight;
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
    public static boolean isAppleColor(Apple apple, COLOR color) {
        return color.equals(apple.getColor());
    }

    public static boolean isAppleWeightGreaterThan(Apple apple, int weight) {
        return apple.getWeight() > weight;
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterHeavyApplesSequential(List<Apple> inventory, int weight) {

        return inventory.stream().filter((Apple a) -> a.getWeight() > weight)
                .collect(Collectors.toList());
    }

    public static List<Apple> filterHeavyApplesParallel(List<Apple> inventory, int weight) {

        return inventory.parallelStream().filter((Apple a) -> a.getWeight() > weight)
                .collect(Collectors.toList());
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, COLOR color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (isAppleColor(apple, color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (isAppleWeightGreaterThan(apple, weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter function) {
        for (Apple apple: inventory) {
            String output = function.accept(apple);
            System.out.println(output);
        }
    }
}
