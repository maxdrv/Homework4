package app.sweets;

import app.CurrencyEnum;

public class Cookie extends Sweet {

    enum uniqueCokie {SOLT, SWEET, NEUTRAL};

    public Cookie(double weight) {
        super(weight, CurrencyEnum.COOKIE.getCurrencyValue());
    }

    public Cookie(double weight, String uniqueProperty) {
        super(weight, CurrencyEnum.COOKIE.getCurrencyValue(), uniqueProperty);
    }
}
