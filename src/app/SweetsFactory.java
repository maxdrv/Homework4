package app;

import app.sweets.Sweet;

@FunctionalInterface
public interface SweetsFactory<S extends Sweet> {
    S createSweets(double weight);
}
