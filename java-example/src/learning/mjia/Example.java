package learning.mjia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
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
            .collect(groupingBy(Dish::getType));

        dishesByType.forEach((type, dishes) -> {
            System.out.println(type);
            dishes.forEach(dish -> System.out.println("\t" + dish.getName()));
        });

        List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 300)
            .map(Dish::getName)
            .limit(3)
            .collect(toList());

        System.out.println(threeHighCaloricDishNames);

        List<String> title = asList("Modern", "Java", "in", "action");

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

        List<Integer> numbers = asList(1, 2, 1, 3, 3, 2, 4);

        numbers.stream()
            .filter(n -> n % 2 == 0)
            .distinct()
            .forEach(System.out::println);

        List<Dish> specialMenu = asList(
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

        List<String> words = asList("Java8", "Lambda", "In", "Action");
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

        List<Integer> firstTenNumbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> squares = firstTenNumbers.stream()
                .map(n -> n * n)
                .collect(toList());

        List<Integer> firstList = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> secondList = asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);

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

        Optional<Dish> dish1 = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        dish1.ifPresent(d -> System.out.println("Found vegetarian dish: " + d.getName()));

        List<Integer> someNumbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

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

        List<Transaction> transactions = asList(
                new Transaction(brian, 2011, 300, new Currency("USD")),
                new Transaction(raoul, 2012, 1000, new Currency("GBP")),
                new Transaction(raoul, 2011, 400, new Currency("GBP")),
                new Transaction(mario, 2012, 789, new Currency("EUR")),
                new Transaction(mario, 2012, 345, new Currency("USD")),
                new Transaction(alan, 2012, 123, new Currency("USD"))
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

        // Java prior to v9
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream = homeValue == null ? Stream.empty() : Stream.of(homeValue);

        // Java post v9
        Stream<String> homeValueStream2 = Stream.ofNullable(System.getProperty("home"));

        // How to get multiple values from potential properties
        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        int[] primeNumbers = {2, 3, 5, 7, 11, 13};
        int primeSum = Arrays.stream(primeNumbers).sum();

        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("resources/data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {

        }
        System.out.println("Unique Words: " + uniqueWords);

        // The seed is applied (initial value) giving us the next initial value, the output is reapplied, and so on and so forth
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // The key difference between a stream and a collection is boundedness, a stream is unbounded and can be infinite

        // Quiz 5.4: Fibonacci tuples series:
        Stream.iterate(new int[] {0, 1}, n -> new int[] {n[1], n[0] + n[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);

        // iterate with a predicate is so much more concise! than filtering (which keeps filterig indefinitely) or using takewhile or dropwhile or whatever the alternative which are more verbose
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);

        // instead of feeding the output as input over and over again, just use a supplier lambda to provide new values
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        // A supplier is usually stateless, but we might choose to make it stateful sometimes

        IntStream ones = IntStream.generate(() -> 1);

        // We can make it stateful by using an anonymous class (we can define state via fields) - impossible to do so using lambdas...
        // Extremely dangerous to depend on state
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();

        for (Transaction transaction: transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);

            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }

        // Or simply:
        // just check how simple it can become to use a map to group the transactions by currency
        Map<Currency, List<Transaction>> transactionsByCurrencies2 = transactions.stream()
                .collect(groupingBy(Transaction::getCurrency));

        System.out.println("First way");
        for (Currency currency: transactionsByCurrencies.keySet()) {
            System.out.println("Currency is " + currency.getName());
            for (Transaction transaction: transactionsByCurrencies.get(currency)) {
                System.out.println("   " + transaction.toString());
            }
        }

        System.out.println("Second way");
        for (Currency currency: transactionsByCurrencies2.keySet()) {
            System.out.println("Currency is " + currency.getName());
            for (Transaction transaction: transactionsByCurrencies2.get(currency)) {
                System.out.println("   " + transaction.toString());
            }
        }

        // Both are the same (collectors or direct way)
        long howManyDishes = menu.stream().collect(counting());
        long howManyDishes2 = menu.stream().count();
        System.out.println("The number of dishes in the menu is " + howManyDishes);

        // To get the max for example, we can use a custom comparator with the maxBy collector
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));

        // To sum, we can also use a collector - alternatively there are also summingLong and summingDouble for the different types
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        // or using the alternative (reducing is the most general form of collector)
        int totalCalories2 = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
//        -- Any of these are also good enough: --
//         int calories = menu.stream()
//                        .map(Dish::getCalories)
//                        .reduce(0, Integer::sum);
//         -- or --
//        int calories3 = menu.stream()
//                .mapToInt(Dish::getCalories)
//                .sum();

        // For averages: (as usual replace int with long or double for the different types)
        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println("Average Calories: " + avgCalories);

        // To get a full summary: - as usual, there are corresponding summarizingLong and Double factory methods for associated types of SummaryStatistics
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("Summary of the menu: " + menuStatistics);

        // Joining Strings
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        System.out.println(shortMenu);

        // It was said in the book that this could work if Dish had a toString method, it didn't work for me
        // String shortMenu2 = menu.stream().collect(joining());

        // More beautifully delimited Strings
        String shortMenu2 = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu2);

        Optional<Dish> mostCaloriesDish = menu.stream().collect(reducing(
                (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2
        ));

        // To showcase how we can do .collect(toList()) but instead, using reduce... (immutable reduction, instead of an accumulative reduction like with collect)
        // As you can see, it can't work in parallel using reduce for fear of data corruption - (the process can't work in parallel due to concurrent modifications)
        Stream<Integer> stream1 = asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers1 = stream1.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l; },
                (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1;
                });

        // We can use the reducing method within the collector (all are very good alternatives, the difference is just in the conciseness and readability
        int totalCalories1 = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));

        int totalCalories3 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        // This last solution is the most preferable as it avoids unnecessary conversions from Integer to int and vice versa
        int totalCalories4 = menu.stream().mapToInt(Dish::getCalories).sum();
        // We usually have multiple ways to perform the same operations

        // Quiz 6.1
        String shortMenu1 = menu.stream().map(Dish::getName)
                .collect( reducing( (s1, s2) -> s1 + s2 ) ).get();
        System.out.println(shortMenu1);

        String shortMenu3 = menu.stream()
                .collect( reducing( "", Dish::getName, (s1, s2) -> s1 + s2 ) );
        System.out.println(shortMenu3);

        // a custom made grouping, in case the class doesn't provide a method that helps group the items
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(aDish -> {
                    if (aDish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (aDish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })
        );

        System.out.println(dishesByCaloricLevel);

        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream().filter(aDish -> aDish.getCalories() > 500)
                .collect(groupingBy(Dish::getType));

        System.out.println(caloricDishesByType);

        // If you want to have all the groups (even if there are no elements within them due to the filtering), you can use a collect(groupingBy(, filtering(,)))
        Map<Dish.Type, List<Dish>> caloricDishesByType2 = menu.stream().collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
        System.out.println(caloricDishesByType2);

        // you can also map after grouping by (to get a map of key values, where values are something other than the inputs...
        Map<Dish.Type, List<String>> dishNamesByType = menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        System.out.println(dishNamesByType);

        // Each dish has a list of tags linked to it
        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));

        // We can now return a key value pair (key is type) and value is the set of tags of any dish of said type
        // We use flatmap to avoid repetition of tags
        Map<Dish.Type, Set<String>> dishNamesByType1 = menu.stream()
                .collect(groupingBy(Dish::getType,
                        flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));
        System.out.println(dishNamesByType1);

        // Nested groupings, where we first group by types, and then within each type by CaloricLevel
        // The collector can be toList, toSet or even another Collertor (grouper)
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }))
        );

        System.out.println(dishesByTypeCaloricLevel);

        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting()));

        System.out.println(typesCount);

        // We can get the most caloric dish by type!
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        maxBy(comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);

        // We can use collectingAndThen to remove the unuseful Optional (because we're sure there's atleast one element per type, and also because the max in that case returns atleast an element
        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricByType2);

        // Man, this is fascinating, I want to see how all of this is done under the hood!

        // total calories by type (hehe self explanatory)
        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

        // A list of caloric levels by dish types
        // A custom mapping that's impossible otherwise (or extremely hard) or just plain inefficient (imagine mapping them before you even grouped them or filtered them, how would you order them otherwise)
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
                .collect(groupingBy(Dish::getType, mapping(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }, toSet())));

        System.out.println(caloricLevelsByType);


        // 6.3.2
    }
    // As you can see, this enum is not even part of the Dish class, and we can use it to group dishes
    public enum CaloricLevel { DIET, NORMAL, FAT }
}
