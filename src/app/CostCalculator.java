package app;

@FunctionalInterface
public interface CostCalculator<T extends Double> {
    T convert(T price);
}
