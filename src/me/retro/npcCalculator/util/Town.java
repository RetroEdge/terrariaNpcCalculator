package me.retro.npcCalculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Town {
    private final Npc[] townNpcs;
    private final String biome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return Arrays.equals(townNpcs, town.townNpcs) && Objects.equals(getBiome(), town.getBiome());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(biome);
        result = 31 * result + Arrays.hashCode(townNpcs);
        return result;
    }

    @Override
    public String toString() {
        return "Town{" +
                "townNpcs=" + Arrays.toString(townNpcs) +
                ", biome='" + biome + '\'' +
                ", averageHappiness=" + this.getAverageHappiness() +
                ", averageWeightedHappiness=" + this.getWeightedAverageHappiness() +
                '}';
    }

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
