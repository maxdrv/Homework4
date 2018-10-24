package app;

public enum CurrencyEnum {

    RU(1), EURO(75.11), CHOCOLATE(500), COOKIE(250), CANDY(330), JELLYBEAN(300);

    private double currencyValue;

    CurrencyEnum(double currencyValue) {
        this.currencyValue = currencyValue;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }
}
