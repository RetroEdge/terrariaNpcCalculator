package me.retro.npcCalculator.util;

import me.retro.npcCalculator.ConfigValues;
import me.retro.npcCalculator.util.singletons.BiomeIds;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Collection;
import java.util.stream.Stream;

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

    public static <T> boolean notNullOrEmpty(T[] list) {
        if (list == null) {
            return false;
        }
        return !(list.length == 0);
    }

    public static <T extends Collection<?>> boolean notNullOrEmpty(T list) {
        if (list == null) {
            return false;
        }
        return !(list.isEmpty());
    }

    public static float clamp(float value, float min, float max) {
        if (min > max) {
            throw new IllegalArgumentException("min value greater than max value");
        }
        return Math.min(max, Math.max(min, value));
    }

    public static <T> LinkedHashSet<LinkedHashSet<T>> generateCombinations(LinkedHashSet<T> originalSet, int r) {
        LinkedHashSet<T> set = new LinkedHashSet<>(originalSet);
        if (r > set.size()) {
            throw new IllegalArgumentException("r cannot be greater than size of set.");
        }
        if (r == set.size()) {
            return new LinkedHashSet<>(List.of(set));  // If set size equals r, return set.
        }
        if (r == 1) {
            LinkedHashSet<LinkedHashSet<T>> a = new LinkedHashSet<>();
            for (T element: set) {
                LinkedHashSet<T> b = new LinkedHashSet<>(List.of(element));
                a.add(b);
            }
            return a;  // If r = 1, return each element individually
        }

        LinkedHashSet<LinkedHashSet<T>> finalSet = new LinkedHashSet<>();

        T head = set.iterator().next();
        set.remove(head);

        for (LinkedHashSet<T> subSet: generateCombinations(set, r-1)) {
            subSet.add(head);
            finalSet.add(subSet);
        }
        finalSet.addAll(generateCombinations(set, r));
        return finalSet;
    }

    public static HashSet<String> reducedBiomeList(Set<Npc> npcSet) {
        HashSet<String> posBiomes = new HashSet<>();
        HashSet<String> negBiomes = new HashSet<>();

        for (Npc npc: npcSet) {
            if (notNullOrEmpty(npc.likedBiomes())){
                posBiomes.addAll(List.of(npc.likedBiomes()));
            }
            if (notNullOrEmpty(npc.lovedBiomes())){
                posBiomes.addAll(List.of(npc.lovedBiomes()));
            }
            if (notNullOrEmpty(npc.dislikedBiomes())){
                negBiomes.addAll(List.of(npc.dislikedBiomes()));
            }
            if (notNullOrEmpty(npc.hatedBiomes())){
                negBiomes.addAll(List.of(npc.hatedBiomes()));
            }
        }


        HashSet<String> biomeList;
        if (ConfigValues.biomeBlacklist) {
            biomeList = new HashSet<>(BiomeIds.allBiomes);
            List.of(ConfigValues.availableBiomes).forEach(biomeList::remove);
        }  else {
            biomeList = new HashSet<>(List.of(ConfigValues.availableBiomes));
        }
        List<String> biomesWithModifier = new ArrayList<>(posBiomes.size()+negBiomes.size());
        biomesWithModifier.addAll(posBiomes);
        biomesWithModifier.addAll(negBiomes);
        biomesWithModifier.forEach(biomeList::remove);

        return new HashSet<>(List.of(Stream.concat(Stream.of(biomeList.iterator().next()), posBiomes.stream()).toArray(String[]::new)));
    }

    public static Town optimalTownFromNpcSet(Set<Npc> npcSet, HashSet<String> biomeList) {
        Town bestTown = null;
        float bestHappiness = 0.0f;
        for (String biome: biomeList) {

            Town testTown = new Town(biome, npcSet.toArray(new Npc[0]));
            float happiness = testTown.getWeightedAverageHappiness();

            if (bestTown == null) {
                bestTown = testTown;  // set bestTown to first testTown to ensure it isn't null during later checks
            }

            if (happiness < bestHappiness) {
                bestHappiness = happiness;
                bestTown = testTown;
                continue;
            }
            if (happiness == bestHappiness && testTown.getAverageHappiness() < bestTown.getAverageHappiness()) {
                bestTown = testTown;
            }
        }
        return bestTown;
    }

    public static Town optimalTownFromNpcSet(Set<Npc> npcSet) {
        return optimalTownFromNpcSet(npcSet, reducedBiomeList(npcSet));
    }
}
