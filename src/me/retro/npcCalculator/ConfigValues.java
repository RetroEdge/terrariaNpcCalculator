package me.retro.npcCalculator;

import me.retro.npcCalculator.util.Npc;
import me.retro.npcCalculator.util.singletons.BiomeIds;
import me.retro.npcCalculator.util.singletons.Npcs;

public abstract class ConfigValues {

    // This is the set of biomes the calculator will use.  Set biomeBlacklist to true to change it to a blacklist.
    public static String[] availableBiomes = new String[] {BiomeIds.FOREST, BiomeIds.SNOW, BiomeIds.CAVERN, BiomeIds.DESERT, BiomeIds.JUNGLE, BiomeIds.OCEAN, BiomeIds.HALLOW, BiomeIds.MUSHROOM};
    public static boolean biomeBlacklist = false;

    // This is the set of NPCs the calculator will use.  Set npcBlacklist to true to change it to a blacklist.
    public static Npc[] availableNpcs = new Npc[] {Npcs.STEAM_PUNKER, Npcs.CYBORG, Npcs.PIRATE, Npcs.PRINCESS, Npcs.SANTA_CLAUS, Npcs.STYLIST, Npcs.WIZARD, Npcs.TRUFFLE};
    public static boolean npcBlacklist = true;

    // These values represent the minimum and maximum NPCs per town.  Default is 2 and 3 respectively.
    public static int minPerTown = 2;
    public static int maxPerTown = 3;

    // This is the maximum and minimum happiness values possible in the game.  As of 1.4.4, these values are 1.5 and 0.75 respectively.
    // Note that these are sale price multipliers; in other words, lower numbers are more ideal.  So, the maxHappiness variable actually represents the worst case, not the best.
    public static float maxHappiness = 1.5f;
    public static float minHappiness = 0.75f;
}