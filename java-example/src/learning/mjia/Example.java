package learning.mjia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;
import static learning.mjia.Apple.*;
import static learning.mjia.Apple.COLOR.GREEN;
import static learning.mjia.Apple.COLOR.RED;

public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

        List<Dish> menu = Dish.getDishes();

        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish: menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloricDishNames = new ArrayList<>();
        for (Dish dish: lowCaloricDishes) {
            lowCaloricDishNames.add(dish.getName());
        }

        // Alternatively:
        List<String> lowCaloricDishNames2 = menu.stream()
            .filter(d -> d.getCalories() < 400)
            .sorted(comparingInt(Dish::getCalories))
            .map(Dish::getName)
            .collect(toList());

        // Multicore:
        List<String> lowCaloricDishNames3 = menu.parallelStream()
            .filter(d -> d.getCalories() < 400)
            .sorted(comparingInt(Dish::getCalories))
            .map(Dish::getName)
            .collect(toList());

        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
            .collect(Collectors.groupingBy(Dish::getType));

        dishesByType.forEach((type, dishes) -> {
            System.out.println(type);
            dishes.forEach(dish -> System.out.println("\t" + dish.getName()));
        });

        List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 300)
            .map(Dish::getName)
            .limit(3)
            .collect(toList());

        System.out.println(threeHighCaloricDishNames);

        List<String> title = Arrays.asList("Modern", "Java", "in", "action");

        Stream<String> s = title.stream();

        s.forEach(System.out::println);
        // s.forEach(System.out::println);

        List<String> names = new ArrayList<>();
        for(Dish dish: menu) {
            names.add(dish.getName());
        }

        System.out.println(names);

        // Same using iterators
        List<String> names2 = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            names2.add(dish.getName());
        }

        // Using streams
        List<String> names3 = menu.stream()
            .map(Dish::getName)
            .collect(toList());

        List<String> highCaloricDishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .collect(toList());

        List<String> namesExplained = menu.stream()
                .filter(d -> {
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());

        List<Dish> vegetarianDishes = new ArrayList<>();
        for (Dish d: menu) {
            if (d.isVegetarian()) {
                vegetarianDishes.add(d);
            }
        }

        List<Dish> vegetarianDishes2 = menu.stream()
            .filter(Dish::isVegetarian)
            .collect(toList());


    }

}
