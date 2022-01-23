package example.page24.refactor;

public abstract class Price {

    abstract int getPriceCode();

    abstract double getCharge(int dayRented);

    public int getFrequentRenterPoints(int dayRented) {
        return 1;
    }
}
