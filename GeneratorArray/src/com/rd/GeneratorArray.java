package com.rd;

import java.util.Random;
import java.util.stream.Stream;

public class GeneratorArray {

    // Size of Array
    private int size;

    // Constructor
    public GeneratorArray(int size) {
        this.size = size;
    }

    /**
     * Method to generate random number
     * under specified range
     * @return array of random numbers
     */
    public Double[] generate() {
        Double[] x = Stream.generate(new Random()::nextDouble).distinct().limit(size).toArray(Double[]::new);
        for (int i = 0; i < size; i++) {
            x[i] *= (int)Math.pow(10,((int)(Math.random()*((7-5)+1))+5));
            x[i] = Double.valueOf(Math.round(x[i]*100.0)/100.0);
        }
        return x;
    }

    public static void main(String[] args) {
        Double[] array = new GeneratorArray(10).generate();

        for(Double d: array) {
            System.out.println(d);
        }
    }
}
