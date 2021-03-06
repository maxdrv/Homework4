package app;

import app.sweets.Sweet;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class Box{

    CurrencyEnum currentCurrency;

    private double price;
    private double weight;
    private ArrayList<Sweet> sweetsList;

    public Box() {
        this.price = 0;
        this.weight = 0;
        this.sweetsList = new ArrayList<>();
        this.currentCurrency = CurrencyEnum.RU;
    }

    public double getPrice() {
        return price;
    }

    /**
     *  2)  Policity для коробочки
     */
    Predicate<Sweet> predicate = sweet -> sweet.getWeight() > 0;

    public void setPolicy(Predicate<Sweet> predicate) {
        this.predicate = predicate;
    }

    public void addPolicy(Predicate<Sweet> predicate) {
        this.predicate = this.predicate.and(predicate);
    }

    public void add(Sweet sweet) {
        if (predicate.test(sweet)) {
            sweetsList.add(sweet);
            this.price += sweet.getPrice();
            this.weight += sweet.getWeight();
        }
    }

    public void remove(Sweet sweet) {
        if (sweetsList.remove(sweet)) {
            this.price -= sweet.getPrice();
            this.weight -= sweet.getWeight();
        }
    }

    public void clear() {
        sweetsList.clear();
    }

    public void getInfo() {
        for (Sweet sweet : sweetsList) {
            System.out.println(sweet.toString());
        }
        getInfoSimple();
    }

    public void getInfoSimple() {
        System.out.format("Вес коробки: %.3f. Стоимость коробки: %.2f %s\n", weight, price, currentCurrency);
    }


    /**
     * 3) Конвертация в другие валюты
     *
     */
    Function<CurrencyEnum, Double> test = currencyEnum -> this.getPrice() / currencyEnum.getCurrencyValue();

    public void convert(CurrencyEnum currencyEnum) {
        System.out.format("Коробка сладостей стоит: %.2f %s\n", test.apply(currencyEnum), currencyEnum);
    }

/*

    CostCalculator toRubles = new CostCalculator() {
        @Override
        public Double convert(Double cost) {
            return cost *= EURO;
        }
    };

    CostCalculator toEuro = cost -> cost /= EURO;

    public void convertValue(String value) {
        switch (value) {
            case "Rub":
                if (this.currentCurrency != "Rub") {
                    this.price = toRubles.convert(this.price);
                    this.currentCurrency = "Rub";
                }
                break;

            case "Euro":
                if(this.currentCurrency != "Euro"){
                    this.price = toEuro.convert(this.price);
                    this.currentCurrency = "Euro";
                }
                break;
            default: break;
        }
    }
*/

    /**
     *  4)  Методы с использованием Stream API
     */
    public void classNamesOfSweets() {

        Stream.of("\n-----Вызов метода для вывода имен классов сладостей в коробке").forEach(x -> System.out.println(x));

        sweetsList.stream().forEach(x -> System.out.println(x.getClass().getSimpleName()));

    }

    public void countSweets(String className){
        System.out.println("-----Вызов метода для подсчета количества определенного вида сладостей в коробке по точному названию класса");

        long i = sweetsList.stream().filter(x -> x.getClass().getSimpleName().equals(className)).count();
        System.out.format("Количество %s в коробке: %d\n", className, i);
    }

    public void countSweets(Sweet sweet) {
        System.out.println("-----Вызов метода для подсчета количества определенного вида сладостей в коробке по ссылке на сладость");

        long i = sweetsList.stream().filter(x -> x.getClass().getSimpleName().equals(sweet.getClass().getSimpleName())).count();
        System.out.format("Количество %s в коробке: %d\n", sweet.getClass().getSimpleName(), i);
    }

    public void countSweets() {
        System.out.println("-----Вызов метода для подсчета количества каждого вида сладостей в коробке");

        Map<String, Long> map = sweetsList.stream().collect(Collectors.groupingBy(x -> x.getClass().getSimpleName(), counting()));
        System.out.println(map);

    }
}
