package learning.mjia;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

public class Example {

    // From Book Modern Java in Action
    // Review  (High value items): 3.3, 5.8 (files), 6.2 and 6.3

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

        List<String> title = asList("Modern", "Java", "in", "action");

        Stream<String> s = title.stream();

        s.forEach(System.out::println);
        // s.forEach(System.out::println);

        List<Integer> numbers = asList(1, 2, 1, 3, 3, 2, 4);

        numbers.stream()
            .filter(n -> n % 2 == 0)
            .distinct()
            .forEach(System.out::println);

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

        // 6.6
    }
    // As you can see, this enum is not even part of the Dish class, and we can use it to group dishes
    public enum CaloricLevel { DIET, NORMAL, FAT }

    public boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.range(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }
}
