package learning.mjia;

import java.util.*;

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
    }
}
