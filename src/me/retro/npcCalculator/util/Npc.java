package me.retro.npcCalculator.util;

import me.retro.npcCalculator.util.enums.BiomePreference;
import me.retro.npcCalculator.util.enums.NpcImportance;
import me.retro.npcCalculator.util.enums.NpcPreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public record Npc(String id, NpcImportance importance,
                  String[] lovedNeighbors,
                  String[] likedNeighbors,
                  String[] dislikedNeighbors,
                  String[] hatedNeighbors,
                  String[] lovedBiomes,
                  String[] likedBiomes,
                  String[] dislikedBiomes,
                  String[] hatedBiomes) {

    @Override
    public String toString() {
        return "Npc{" +
                "id='" + id + '\'' +
                '}';
    }

    public Npc(String id, NpcImportance importance,
               String[] lovedNeighbors,
               String[] likedNeighbors,
               String[] dislikedNeighbors,
               String[] hatedNeighbors,
               String[] likedBiomes,
               String[] dislikedBiomes) {
        this(id, importance, lovedNeighbors, likedNeighbors, dislikedNeighbors, hatedNeighbors, null, likedBiomes, dislikedBiomes, null);
    }

    public float getHappiness(Npc[] neighbors, String biome) {
        float maxHappiness = 1.5f;  // These var names are somewhat misleading; 0.75 is a better, or "happier" case then 1.5.
        float minHappiness = 0.75f; // for readability of code, however, they are called by the numerical value instead.
        float happiness = 1.0f;

        Map<String[], NpcPreference> npcTable = new HashMap<>();
        npcTable.put(this.lovedNeighbors, NpcPreference.LOVE);
        npcTable.put(this.likedNeighbors, NpcPreference.LIKE);
        npcTable.put(this.dislikedNeighbors, NpcPreference.DISLIKE);
        npcTable.put(this.hatedNeighbors, NpcPreference.HATE);

        Map<String[], BiomePreference> biomeTable = new HashMap<>();
        biomeTable.put(this.lovedBiomes, BiomePreference.LOVE);
        biomeTable.put(this.likedBiomes, BiomePreference.LIKE);
        biomeTable.put(this.dislikedBiomes, BiomePreference.DISLIKE);
        biomeTable.put(this.hatedBiomes, BiomePreference.HATE);

        for (Npc neighbor: neighbors){
            for (String[] list: npcTable.keySet()) {
                if (HelperMethods.notNullOrEmpty(list)) {
                    if (Arrays.asList(list).contains(neighbor.id())) {
                        happiness *= npcTable.get(list).value;
                        break;
                    }
                }
            }
        }

        for (String[] list: biomeTable.keySet()) {
            if (HelperMethods.notNullOrEmpty(list)) {
                if (Arrays.asList(list).contains(biome)) {
                    happiness *= biomeTable.get(list).value;
                    break;
                }
            }
        }

        if (neighbors.length >= 3) {
            happiness = HelperMethods.clamp(happiness * NpcPreference.OVERCROWDED.value, minHappiness, maxHappiness);
            return Math.round(happiness * 100) / 100.0f;
        }
        happiness = HelperMethods.clamp(happiness * NpcPreference.SOLITUDE.value, minHappiness, maxHappiness);
        return Math.round(happiness * 100) / 100.0f;
    }

    public float getHappiness(Town town) {
        ArrayList<Npc> townNpcs = new ArrayList<>(Arrays.asList(town.getNpcs()));
        townNpcs.remove(this);
        return getHappiness(townNpcs.toArray(new Npc[0]), town.getBiome());
    }
}
