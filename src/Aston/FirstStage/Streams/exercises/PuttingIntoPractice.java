package Aston.FirstStage.Streams.exercises;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPractice {

    public static void main(String... args) {
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


        // 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        System.out.println("\nTask 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).");
        List<Transaction> tr2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(tr2011);

        // 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        System.out.println("\nTask 2. Вывести список неповторяющихся городов, в которых работают трейдеры.");
        List<String> cities =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());
        System.out.println(cities);

        // 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        System.out.println("\nTask 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        List<Trader> traders =
                transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
        System.out.println(traders);


        // 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        System.out.println("\nTask 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.");
        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);

        // 5. Выяснить, существует ли хоть один трейдер из Милана.
        System.out.println("\nTask 5. Выяснить, существует ли хоть один трейдер из Милана.");
        boolean milanBased =
                transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                .getCity()
                                .equals("Milan")
                        );
        System.out.println(milanBased);


        // 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        System.out.println("\nTask 6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .forEach(trader -> trader.setCity("Cambridge"));
        System.out.println(transactions);


        // 7. Какова максимальная сумма среди всех транзакций?
        System.out.println("\nTask 7. Какова максимальная сумма среди всех транзакций?");
        int highestValue =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(0, Integer::max);
        System.out.println(highestValue);

    }
}