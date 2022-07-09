package learning.mjia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {

//        return () -> {
//            HashMap<Boolean, List<Integer>> initialized = new HashMap<>();
//            initialized.put(false, new ArrayList<>());
//            initialized.put(true, new ArrayList<>());
//            return initialized;
//        };

        // Double braces here mean anonymous inner class derived from the outer class, but used specifically to fill in the hashmap

        return () -> new HashMap<Boolean, List<Integer>>() {{
            put(true, new ArrayList<Integer>());
            put(false, new ArrayList<Integer>());
        }};
    }

    public boolean isPrime(List<Integer> primes, int candidate) {
        // We only check if it is prime against all previously discovered primes
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return primes.stream()
                .takeWhile(i -> i <= candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
//        return (map, e) -> {
//            Boolean isItPrime = isPrime(map.get(true), e);
//            map.get(isItPrime).add(e);
//        };
        // We can specify the types of inputs in the lambda
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            Boolean isItPrime = isPrime(acc.get(true), candidate);
            acc.get(isItPrime).add(candidate);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
//        return (map1, map2) -> {
//            map1.get(true).addAll(map2.get(true));
//            map1.get(false).addAll(map2.get(false));
//            return map1;
//        };

        // We can't really do this in parallel since finding primes is sequential using this implementation (you need all the previous primes to be able to find the next one)

        //        throw new UnsupportedOperationException("Finding Primes is currently not possible in parallel");

        return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>>  map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }
}
