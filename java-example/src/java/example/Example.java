package java.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Example {

    public static void main(String[] args) {

    }

    public  Map<Currency, List<Transaction>> filterLargeTransactionsByCurrency (List<Transaction> transactions){

        return transactions.stream()
                .filter((Transaction t) -> t.getPrice() > 1000)
                .collect(groupingBy(Transaction::getCurrency));
    }
}
