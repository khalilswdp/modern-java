package java.example;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Transaction {

    private int price;

    private Currency currency;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Map<Currency, List<Transaction>> filterLargeTransactionsByCurrency (List<Transaction> transactions){

        return transactions.stream()
                .filter((Transaction t) -> t.getPrice() > 1000)
                .collect(groupingBy(Transaction::getCurrency));
    }
}
