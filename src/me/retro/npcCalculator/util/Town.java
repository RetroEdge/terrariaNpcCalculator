package me.retro.npcCalculator.util;

import java.util.ArrayList;
import java.util.Arrays;

public class Town {
    private final Npc[] townNpcs;

    private final String biome;

    public Town(String biome, Npc... npcs) {
        this.townNpcs = npcs;
        this.biome = biome;
    }

    public Npc[] getNpcs() {
        return townNpcs;
    }

    public String getBiome() {
        return biome;
    }

    public float getAverageHappiness() {
        float happiness = 0.0f;
        for (Npc npc: townNpcs) {
            ArrayList<Npc> otherNeighbors = new ArrayList<>(Arrays.asList(townNpcs));
            otherNeighbors.remove(npc);
            happiness += npc.getHappiness(otherNeighbors.toArray(new Npc[0]), biome);
        }
        happiness /= townNpcs.length;
        return happiness;
    }

    public float getWeightedAverageHappiness() {
        float happiness = 0.0f;
        float weights = 0.0f;
        for (Npc npc: townNpcs) {
            ArrayList<Npc> otherNeighbors = new ArrayList<>(Arrays.asList(townNpcs));
            otherNeighbors.remove(npc);
            happiness += npc.getHappiness(otherNeighbors.toArray(new Npc[0]), biome) * npc.importance().value;
            weights += npc.importance().value;
        }
        happiness /= weights;
        return happiness;
    }
}
