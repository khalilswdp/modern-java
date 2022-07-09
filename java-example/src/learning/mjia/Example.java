package learning.mjia;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class Example {

    // From Book Modern Java in Action
    // Review  (High value items): 3.3, 5.8 (files), 6.2 and 6.3

    public static void main(String[] args) {

        // 6.6
    }

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
