package com.theironyard;

/**
 * The Weight enum contains constants related to weights. Each constant is has
 * a value in grams. We can use the grams as a base unit to convert between. For
 * example, if we know that there are 1,000 grams in a kilogram and 1,000,000 in
 * a metric ton, then we can determine that 1 kilogram must be 0.001 metric
 * tons.
 *
 * Follow the instructions below to build the Weight enum.
 */
public enum Weight {
    TON(907184.74),
    POUND(453.59237),
    OUNCE(28.349523),
    STONE(6350.2932),
    METRIC_TON(1000000),
    KILOGRAM(1000),
    GRAM(1);

    private double grams;

    /**
     * Create a constructor for the Weight enum. It should accept an argument
     * that sets the enum instance's weight in grams.
     * @param grams The enum instance's weight in grams.
     */
    // todo: create constructor
    Weight(double grams) {
        this.grams = grams;
    }


    /**
     * Create a method named getGrams() that accepts no arguments and returns
     * the enum's weight in grams.
     * @return The enum's weight in grams
     */
    // todo: create getGrams() method
    public double getGrams(){
        return grams;
    }



}
