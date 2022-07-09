package learning.mjia;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class Example {

    // From Book Modern Java in Action
    // Review  (High value items): 3.3, 5.8 (files), 6.2 and 6.3

    public static void main(String[] args) {

        Map<Boolean, List<Integer>> booleanListMap = partitionPrimesWithCustomCollector(100);
        System.out.println(booleanListMap);

        // 6.6
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }
}
