package app.sweets;

public class Chocolate extends Sweet {

    public Chocolate(double weight) {
        super(weight, 500);
    }

    public Chocolate(double weight, String uniqueProperty) {
        super(weight, 500, uniqueProperty);
    }
}
