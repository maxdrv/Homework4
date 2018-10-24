package app.sweets;

public class Cookie extends Sweet {

    public Cookie(double weight) {
        super(weight, 250);
    }

    public Cookie(double weight, String uniqueProperty) {
        super(weight, 250, uniqueProperty);
    }
}
