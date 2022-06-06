package learning.mjia;

import java.util.*;
import java.util.function.Predicate;

import static learning.mjia.Apple.*;
import static learning.mjia.Apple.COLOR.GREEN;
import static learning.mjia.Apple.COLOR.RED;

public class Example {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(GREEN, 200));
        inventory.add(new Apple(RED, 10));

        List<Apple> greenApples = filterApplesByColor(inventory, GREEN);
        List<Apple> redApples = filterApplesByColor(inventory, RED);

        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());


        prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimpleFormatter());


        List<Apple> redApplesAnonymousClass = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });

        List<Apple> resultLambda = filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));

        List<Apple> redApplesGeneric = filter(inventory, (Apple apple) -> RED.equals(apple.getColor()));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9);

        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        inventory.sort(Comparator.comparing(Apple::getWeight));

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Anonymous Class World!");
            }
        });

        t.run();

        Thread t2 = new Thread(() -> System.out.println("Hello Lambda Expression World!"));
        t2.run();
    }

    public static <T> List <T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e: list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
