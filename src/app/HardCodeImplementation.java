package app;

import app.sweets.*;

import java.util.function.Predicate;

public class HardCodeImplementation {

    public void go(){

        Box box = new Box();

        // 1)   Функциональные интерфейсы фабрик сладостей
        // Создание фабрики через лямюда выражения
        SweetsFactory<Sweet> candyFactory = Candy::new;
        SweetsFactory<Sweet> chocolateFactory = Chocolate::new;

        // Создание фабрики через анонимный класс
        SweetsFactory<Sweet> jellybeanFactory = new SweetsFactory() {
            @Override
            public Sweet createSweets(double weight) {
                return new Jellybean(weight);
            }
        };
        SweetsFactory<Sweet> cookieFactory = new SweetsFactory<Sweet>() {
            @Override
            public Sweet createSweets(double weight) {
                return new Cookie(weight);
            }
        };

        // Получение объектов сладостей с помощью фабрик
        Sweet candy = candyFactory.createSweets(1);
        Sweet chocolate = chocolateFactory.createSweets(3);
        Sweet jellybean = jellybeanFactory.createSweets(0.5);
        Sweet cookie = cookieFactory.createSweets(2);
        Sweet cookieW25 = cookieFactory.createSweets(2.5);

        // 2) Policy for box
        // базовая политика для коробочки weight > 0
        System.out.println("**********Часть 2*********");
        System.out.println("-----Устанавливаем несклько политик для коробочки");
        box.addPolicy(s -> s.getWeight() <= 3);
        box.addPolicy(s -> s.getWeight() > 1);
        box.addPolicy(new Predicate<Sweet>() {
            @Override
            public boolean test(Sweet sweet) {
                return sweet.getWeight() != 2.5;
            }
        });
        // пробуем добавить все виды сладостей при текущей политике
        box.add(chocolate);
        box.add(jellybean);
        box.add(cookie);
        box.add(cookieW25);
        box.add(candy);
        // выводим информацию
        box.getInfo();
        // очищаем коробку
        box.clear();
        System.out.println("-----Устанавливаем одну политику");
        // объявляем только одну политику
        box.setPolicy(s-> s.getWeight() > 0.7);
        // снова пробуем добавить все виды сладостей
        box.add(chocolate);
        box.add(jellybean);
        box.add(cookie);
        box.add(cookieW25);
        box.add(candy);
        // выводим инофрмацию
        box.getInfo();

        // 3)   CostCalculator для коробочки
        System.out.println("**********Часть 3*********");
        System.out.println("-----Вызов метода конвертора валют и инфо");
        box.convertValue("Euro");
        box.getInfoSimple();
        System.out.println("-----Добавляем дополнительную сладость в коробку и выводим инфо");
        box.add(candy);
        box.getInfoSimple();
        System.out.println("-----Вызов метода конвертора валют и инфо");
        box.convertValue("Rub");
        box.getInfoSimple();

        // 4)   Методы использующие Stream API
        // вывести названия классов всех сладостей в коробке
        System.out.println("**********Часть 4*********");
        box.classNamesOfSweets();
        // подсчитать количество определенной сладости в коробке по точному названию класса
        box.countSweets("Candy");
        // подсчитать количество определенной сладости в коробке по точному ссылке на объект
        box.countSweets(chocolate);
        // подсчитать количество всех сладостей в коробке
        box.countSweets();

    }
}


