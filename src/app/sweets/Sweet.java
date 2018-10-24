package app.sweets;

public abstract class Sweet {
    private double costForKg;
    private double price;
    private double weight;
    String uniqueProperty;

    public Sweet(double weight, double costForKg) {
        if (weight <= 0 || costForKg <= 0) {
            throw new IllegalArgumentException(String.format("Вы указали не верные значения: вес = %s, цена = %s", weight, costForKg));
        }
        this.costForKg = costForKg;
        this.weight = weight;
        this.price = this.costForKg * weight;
        this.uniqueProperty = "";
    }

    public Sweet(double weight, double costForKg, String uniqueProperty) {
        this(weight, costForKg);
        this.uniqueProperty = ", " + uniqueProperty;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s : вес = %s, цена = %s%s", this.getClass().getSimpleName(), weight, price, uniqueProperty);
    }
}
