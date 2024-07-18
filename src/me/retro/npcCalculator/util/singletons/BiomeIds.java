package me.retro.npcCalculator.util.singletons;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
This class exists purely to consolidate biome references.
 */
public abstract class BiomeIds {
    public static final String FOREST = "Forest";
    public static final String SNOW = "Snow";
    public static final String DESERT = "Desert";
    public static final String CAVERN = "Cavern";
    public static final String OCEAN = "Ocean";
    public static final String JUNGLE = "Jungle";
    public static final String HALLOW = "Hallow";
    public static final String MUSHROOM = "Mushroom";

    public static final Set<String> allBiomes = new HashSet<>(List.of(FOREST, SNOW, DESERT, CAVERN, OCEAN, JUNGLE, HALLOW, MUSHROOM));
}
