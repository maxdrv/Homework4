package app.sweets;

public class Candy extends Sweet {

    public Candy(double weight) {
        super(weight, 330);
    }

    public Candy(double weight, double costForKg, String uniqueProperty) {
        super(weight, 330, uniqueProperty);
    }
}

