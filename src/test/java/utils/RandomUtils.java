package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String[] getRandomItemsFromArray(String[] array) {
        int size = getRandomInt(1, array.length);
        ArrayList<String> source = new ArrayList<>(Arrays.asList(array));
        ArrayList<String> result = new ArrayList<>();

        for (int i = 1; i <= size; ++i) {
            int index = getRandomInt(0, source.size() - 1);
            result.add(source.get(index));
            source.remove(index);
        }
        return result.toArray(new String[size]);
    }
}