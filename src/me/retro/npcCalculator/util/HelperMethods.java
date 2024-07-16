package me.retro.npcCalculator.util;

import java.util.ArrayList;
import java.util.List;

public class HelperMethods {
    public static List<int[]> pascals = new ArrayList<>();
    public static boolean pascalGenerated = false;

    public static int nCk(int n, int k) {
        if (!pascalGenerated) {
            for (int i = 0; i < 30; i++) {
                int[] currentRow = new int[i+1];

                currentRow[0] = 1;
                currentRow[currentRow.length-1] = 1;

                if (i <= 1) {
                    pascals.add(currentRow);
                    continue;
                }

                for (int index = 1; index < currentRow.length-1; index++) {
                    int entry = pascals.get(i-1)[index] + pascals.get(i-1)[index-1];
                    currentRow[index] = entry;
                }
                pascals.add(currentRow);
            }
        }
        return pascals.get(n)[k];
    }

    public static boolean notNullOrEmpty(String[] list) {
        if (list == null) {
            return false;
        }
        return !(list.length == 0);
    }

    public static float clamp(float value, float min, float max) {
        if (min > max) {
            throw new IllegalArgumentException("min value greater than max value");
        }
        return Math.min(max, Math.max(min, value));
    }
}
