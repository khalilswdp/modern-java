package java.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Example {

    public static void main(String[] args) {

    }

    public  Map<Currency, List<Transaction>> filterLargeTransactionsByCurrency (List<Transaction> transactions){
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();

        for (Transaction transaction : transactions) {
            if (transaction.getPrice() > 1000) {
                Currency currency = transaction.getCurrency();
                List<Transaction> transactionsForCurrency = transactionsByCurrencies.computeIfAbsent(currency, k -> new ArrayList<>());

                transactionsForCurrency.add(transaction);
            }
        }

        return transactionsByCurrencies;
    }
}
