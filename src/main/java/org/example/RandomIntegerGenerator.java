package org.example;

import java.util.Random;

public class RandomIntegerGenerator {

    public RandomIntegerGenerator() {
    }

    public int getRandomNumberUsingInts() {
        Random random = new Random();
        return random.ints(1, 151).findFirst().getAsInt();
    }
}
