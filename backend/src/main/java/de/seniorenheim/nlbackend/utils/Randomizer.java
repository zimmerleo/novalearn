package de.seniorenheim.nlbackend.utils;

import java.util.Random;
import java.util.UUID;

public class Randomizer {

    private static final Random rand = new Random();

    public static String randomString() {
        return UUID.randomUUID().toString();
    }

    public static int randomInt() {
        return rand.nextInt();
    }

    public static long randomLong() {
        return rand.nextLong();
    }

    public static long randomLong(long min, long max) {
        return rand.nextLong(min, max + 1);
    }

    public static double randomDouble() {
        return rand.nextDouble();
    }
}
