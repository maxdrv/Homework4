package app.sweets;

import app.CurrencyEnum;

public class Chocolate extends Sweet {

    enum uniqueChocolate {MILK, BITTER, WHITE};

    public Chocolate(double weight) {
        super(weight, CurrencyEnum.CHOCOLATE.getCurrencyValue());
    }

    public Chocolate(double weight, String uniqueProperty) {
        super(weight, CurrencyEnum.CHOCOLATE.getCurrencyValue(), uniqueProperty);
    }
}
