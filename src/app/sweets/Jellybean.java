package app.sweets;

import app.CurrencyEnum;

public class Jellybean extends Sweet{

    enum uniqueJellybean {RED, GREEN, YELLOW};

    public Jellybean(double weight) {
        super(weight, CurrencyEnum.JELLYBEAN.getCurrencyValue());
    }

    public Jellybean(double weight, String uniqueProperty) {
        super(weight, CurrencyEnum.JELLYBEAN.getCurrencyValue(), uniqueProperty);
    }
}
