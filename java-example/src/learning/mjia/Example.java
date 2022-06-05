package learning.mjia;

import java.util.*;

import static learning.mjia.Apple.COLOR.GREEN;
import static learning.mjia.Apple.COLOR.RED;
import static learning.mjia.Apple.filterApplesByColor;

public class Example {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(GREEN));
        inventory.add(new Apple(RED));

        List<Apple> greenApples = filterApplesByColor(inventory, GREEN);
        List<Apple> redApples = filterApplesByColor(inventory, RED);
    }
}
