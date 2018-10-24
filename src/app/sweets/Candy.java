package app.sweets;

import app.CurrencyEnum;

public class Candy extends Sweet {

    enum uniqueCandy {CARAMEL, CHOCOLATE, TOFFEE};

    public Candy(double weight) {
        super(weight, CurrencyEnum.CANDY.getCurrencyValue());
    }

    public Candy(double weight, double costForKg, String uniqueProperty) {
        super(weight, CurrencyEnum.CANDY.getCurrencyValue(), uniqueProperty);
    }
}

