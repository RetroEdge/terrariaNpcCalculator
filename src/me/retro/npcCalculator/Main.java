package me.retro.npcCalculator;

import me.retro.npcCalculator.util.Npc;
import me.retro.npcCalculator.util.Town;
import me.retro.npcCalculator.util.singletons.BiomeIds;
import me.retro.npcCalculator.util.singletons.Npcs;

public class Main {

    public static void main(String[] args) {
        Town town = new Town(BiomeIds.CAVERN, Npcs.GOBLIN_TINKERER, Npcs.MECHANIC, Npcs.DYE_TRADER);

        System.out.println("Town Biome: " + town.getBiome());
        System.out.println();
        for (Npc npc: town.getNpcs()) {
            System.out.println(npc.id() + " happiness: " + npc.getHappiness(town));
        }
        System.out.println();
        System.out.println("Average happiness:          " + town.getAverageHappiness());
        System.out.println("Weighted average happiness: " + town.getWeightedAverageHappiness());
    }
}

/*
 TODO:
  Given minimum per group, maximum per group, and available npcs, determine all possible groupings, and an optimal biome provided average happiness and individual npc importance
  Combine groupings into sets encompassing all npcs, and score based off average happiness for each importance, and for the full set
  Display results by highest weighted average
*/
