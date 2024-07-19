package me.retro.npcCalculator;

import me.retro.npcCalculator.util.HelperMethods;
import me.retro.npcCalculator.util.Npc;
import me.retro.npcCalculator.util.Town;
import me.retro.npcCalculator.util.singletons.Npcs;

import java.util.HashSet;
import java.util.List;

public class Main {

    static HashSet<Npc> npcSet = new HashSet<>(List.of(Npcs.MECHANIC, Npcs.GOBLIN_TINKERER, Npcs.DYE_TRADER));

    public static void main(String[] args) {
        Town optimalTown = HelperMethods.optimalTownFromNpcSet(npcSet);
        System.out.printf("Biome: %s%n", optimalTown.getBiome());
        System.out.printf("Average Weighted Happiness: %f%n", optimalTown.getWeightedAverageHappiness());
        System.out.printf("Average Happiness: %f%n", optimalTown.getAverageHappiness());
        System.out.println();
        for (Npc npc : optimalTown.getNpcs()) {
            System.out.printf("%1$s: %2$f%n", npc.id(), npc.getHappiness(optimalTown));
        }
    }
}

/*
 TODO:
  Given minimum per group, maximum per group, and available npcs, determine all possible groupings, and an optimal biome provided average happiness and individual npc importance
  Combine groupings into sets encompassing all npcs, and score based off average happiness for each importance, and for the full set
  Display results by highest weighted average
*/
