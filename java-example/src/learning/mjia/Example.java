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
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
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

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        numbers.stream()
            .filter(n -> n % 2 == 0)
            .distinct()
            .forEach(System.out::println);

        List<Dish> specialMenu = Arrays.asList(
                new Dish("Seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("Prawn crackers", false, 240, Dish.Type.FISH),
                new Dish("Salmon fide", false, 300, Dish.Type.FISH),
                new Dish("Lamb chops", false, 400, Dish.Type.MEAT),
                new Dish("Peking duck", false, 800, Dish.Type.MEAT),
                new Dish("Instant Noodle with Egg", true, 150, Dish.Type.OTHER),
                new Dish("Jiaozi", false, 380, Dish.Type.OTHER),
                new Dish("Ice-cream", true, 120, Dish.Type.OTHER),
                new Dish("Coffee", true, 50, Dish.Type.OTHER)
        );

        List<Dish> filteredMenu = specialMenu.stream()
                .filter(d -> d.getCalories() < 320)
                .collect(toList());

        filteredMenu.forEach(System.out::println);

        // keep reading until the condition is satisfied, stop when the condition is not satisfied
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(d -> d.getCalories() < 400)
                .collect(toList());

        slicedMenu1.forEach(System.out::println);

        // skip as long as the condition is satisfied, start when the condition is not satisfied
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(d -> d.getCalories() < 400)
                .collect(toList());

        slicedMenu2.forEach(System.out::println);

        List<Dish> dishes = specialMenu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());

        List<Dish> dishes2 = specialMenu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(3)
                .collect(toList());

        List<Dish> firstTwoMeatDishes = specialMenu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList());

        List<Integer> dishNames = specialMenu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        List<String> words = Arrays.asList("Java8", "Lambda", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());

        List<String> letters = words.stream()
                .flatMap(w -> Arrays.stream(w.split("")))
                .distinct()
                .collect(toList());

        letters.stream()
                .forEach(System.out::print);

        String[] wordsArray = {"Java8", "Lambda", "In", "Action"};

        Stream<String> streamOfWords = Arrays.stream(wordsArray);

         List<String> distinctLetters = streamOfWords.map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println(distinctLetters);

        List<Integer> firstTenNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> squares = firstTenNumbers.stream()
                .map(n -> n * n)
                .collect(toList());

        List<Integer> firstList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> secondList = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);

        List<Integer[]> couples = firstList.stream()
                .flatMap(n -> secondList.stream()
                        .map(m -> new Integer[] {n, m}))
                .peek(arr -> System.out.println("(" + arr[0] + ", " + arr[1] + ")"))
                .collect(toList());

        List<Integer[]> pairs = firstList.stream()
                .flatMap(n -> secondList.stream()
                        .filter(m -> (n + m) % 3 == 0)
                        .map(m -> new Integer[] {n, m}))
                .peek(arr -> System.out.println("(" + arr[0] + ", " + arr[1] + ")"))
                .collect(toList());

        // checks if any of the elements in the list is vegetarian
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);

        boolean isHealthy2 = menu.stream().noneMatch(d -> d.getCalories() > 1000);

        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        dish.ifPresent(d -> System.out.println("Found vegetarian dish: " + d.getName()));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();

        int sum = 0;
        for (int x: numbers) {
            sum += x;
        }

        int sum2 = numbers.stream().reduce(0, (a, b) -> a + b);
        int sum3 = numbers.stream().reduce(0, Integer::sum);
        int product = numbers.stream().reduce(0, (a, b) -> a * b);

        Optional<Integer> sum4 = numbers.stream().reduce(Integer::sum);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);

        Optional<Integer> numberOfDishes = menu.stream()
                .map(i -> 1)
                .reduce(Integer::sum);

        long numberOfDishes2 = menu.stream()
                .count();

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Q1.
        List<Transaction> allTransactions2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparingInt(Transaction::getValue))
                .collect(toList());

        // Q2.
        List<String> uniqueCities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        Set<String> uniqueCitiesSet = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());

        // Q3.
        List<Trader> tradersFromCambridge = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        // Q4.
        List<String> tradersNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(toList());

        String tradersNamesAsSingleString = String.valueOf(tradersNames.stream()
                .reduce(String::concat));

        String tradersNamesAsSingleStringMoreEfficient = String.valueOf(tradersNames.stream()
                .collect(joining()));

        // Q5.
        transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        // Q6.
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // Q7.

        // Are both correct?
        transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max);

        // Q8.
        transactions.stream()
                .min(comparingInt(Transaction::getValue));

        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

        // By avoiding Integer boxing and unboxing (uses int)
        int calories2 = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        IntStream intStream = menu.stream().
                mapToInt(Dish::getCalories);

        Stream<Integer> stream = intStream.boxed();

        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        // or a default
        int maximumCalories = maxCalories.orElse(1);

        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n %  2 == 0);
        System.out.println(evenNumbers.count());

        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                        .boxed()
                        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        pythagoreanTriples.limit(5).forEach(arr -> System.out.println("(" + arr[0] + ", " + arr[1] + ", " + arr[2] + ")"));

        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                        .filter(t -> t[2] % 1 == 0));

        Stream<String> streamOf = Stream.of("Modern", "Java", "In", "Action");
        streamOf.map(String::toUpperCase).forEach(System.out::println);

        // empty stream
        Stream<String> emptyStream = Stream.empty();



    }
}
