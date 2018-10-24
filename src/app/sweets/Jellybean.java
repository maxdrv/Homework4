package app.sweets;

public class Jellybean extends Sweet{

    public Jellybean(double weight) {
        super(weight, 300);
    }

    public Jellybean(double weight, String uniqueProperty) {
        super(weight, 300, uniqueProperty);
    }
}
