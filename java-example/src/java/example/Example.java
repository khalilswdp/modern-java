package java.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.example.Apple.COLOR.GREEN;
import static java.example.Apple.COLOR.RED;

public class Example {

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        filterApples(inventory, (Apple a) -> GREEN.equals(a.getColor()));

        filterApples(inventory, (Apple a) -> a.getWeight() > 150);

        filterApples(inventory, (Apple a) -> a.getWeight() < 80 || RED.equals(a.getColor()));
    }
}
