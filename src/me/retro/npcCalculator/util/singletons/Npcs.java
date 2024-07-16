package me.retro.npcCalculator.util.singletons;

import me.retro.npcCalculator.util.Npc;
import me.retro.npcCalculator.util.enums.NpcImportance;

public abstract class Npcs {
    public static Npc GUIDE = new Npc(NpcIds.GUIDE, NpcImportance.ZERO,
            null,
            new String[] {NpcIds.ZOOLOGIST, NpcIds.CLOTHIER, NpcIds.PRINCESS},
            new String[] {},
            new String[] {NpcIds.PAINTER},
            new String[] {BiomeIds.FOREST},
            new String[] {BiomeIds.OCEAN}
    );
    public static Npc MERCHANT = new Npc(NpcIds.MERCHANT, NpcImportance.THREE,
            null,
            new String[] {NpcIds.NURSE, NpcIds.GOLFER, NpcIds.PRINCESS},
            new String[] {NpcIds.TAX_COLLECTOR},
            new String[] {NpcIds.ANGLER},
            new String[] {BiomeIds.FOREST},
            new String[] {BiomeIds.DESERT}
    );
    public static Npc NURSE = new Npc(NpcIds.NURSE, NpcImportance.TWO,
            new String[] {NpcIds.ARMS_DEALER},
            new String[] {NpcIds.PARTY_GIRL, NpcIds.WIZARD, NpcIds.PRINCESS},
            new String[] {NpcIds.DRYAD},
            new String[] {NpcIds.ZOOLOGIST},
            new String[] {BiomeIds.HALLOW},
            new String[] {BiomeIds.SNOW}
    );
    public static Npc DEMOLITIONIST = new Npc(NpcIds.DEMOLITIONIST, NpcImportance.TWO,
            new String[] {NpcIds.TAVERNKEEP},
            new String[] {NpcIds.MECHANIC, NpcIds.PRINCESS},
            new String[] {NpcIds.ARMS_DEALER, NpcIds.GOBLIN_TINKERER},
            null,
            new String[] {BiomeIds.CAVERN},
            new String[] {BiomeIds.OCEAN}
    );
    public static Npc DYE_TRADER = new Npc(NpcIds.DYE_TRADER, NpcImportance.ONE,
            null,
            new String[] {NpcIds.PAINTER, NpcIds.ARMS_DEALER, NpcIds.PRINCESS},
            new String[] {NpcIds.STEAM_PUNKER},
            new String[] {NpcIds.PIRATE},
            new String[] {BiomeIds.DESERT},
            new String[] {BiomeIds.FOREST}
    );
    public static Npc ANGLER = new Npc(NpcIds.ANGLER, NpcImportance.TWO,
            null,
            new String[] {NpcIds.DEMOLITIONIST, NpcIds.PARTY_GIRL, NpcIds.TAX_COLLECTOR, NpcIds.PRINCESS},
            null,
            new String[] {NpcIds.TAVERNKEEP},
            new String[] {BiomeIds.OCEAN},
            new String[] {BiomeIds.DESERT}
    );
    public static Npc ZOOLIGIST = new Npc(NpcIds.ZOOLOGIST, NpcImportance.ONE,
            new String[] {NpcIds.WITCH_DOCTOR},
            new String[] {NpcIds.GOLFER, NpcIds.PRINCESS},
            new String[] {NpcIds.ANGLER},
            new String[] {NpcIds.ARMS_DEALER},
            new String[] {BiomeIds.FOREST},
            new String[] {BiomeIds.DESERT}
    );
    public static Npc DRYAD = new Npc(NpcIds.DRYAD, NpcImportance.TWO,
            null,
            new String[] {NpcIds.WITCH_DOCTOR, NpcIds.TRUFFLE, NpcIds.PRINCESS},
            new String[] {NpcIds.ANGLER},
            new String[] {NpcIds.GOLFER},
            new String[] {BiomeIds.JUNGLE},
            new String[] {BiomeIds.DESERT}
    );
    public static Npc PAINTER = new Npc(NpcIds.PAINTER, NpcImportance.ONE,
            new String[] {NpcIds.DRYAD},
            new String[] {NpcIds.PARTY_GIRL, NpcIds.PRINCESS},
            new String[] {NpcIds.TRUFFLE, NpcIds.CYBORG},
            null,
            new String[] {BiomeIds.JUNGLE},
            new String[] {BiomeIds.FOREST}
    );
    public static Npc GOLFER = new Npc(NpcIds.GOLFER, NpcImportance.ONE,
            new String[] {NpcIds.ANGLER},
            new String[] {NpcIds.ZOOLOGIST, NpcIds.PAINTER, NpcIds.PRINCESS},
            new String[] {NpcIds.PIRATE},
            new String[] {NpcIds.MERCHANT},
            new String[] {BiomeIds.FOREST},
            new String[] {BiomeIds.CAVERN}
    );
    public static Npc ARMS_DEALER = new Npc(NpcIds.ARMS_DEALER, NpcImportance.THREE,
            new String[] {NpcIds.NURSE},
            new String[] {NpcIds.STEAM_PUNKER, NpcIds.PRINCESS},
            new String[] {NpcIds.GOLFER},
            new String[] {NpcIds.DEMOLITIONIST},
            new String[] {BiomeIds.DESERT},
            new String[] {BiomeIds.SNOW}
    );
    public static Npc TAVERNKEEP = new Npc(NpcIds.TAVERNKEEP, NpcImportance.TWO,
            new String[] {NpcIds.DEMOLITIONIST},
            new String[] {NpcIds.GOBLIN_TINKERER, NpcIds.PRINCESS},
            new String[] {NpcIds.GUIDE},
            new String[] {NpcIds.DYE_TRADER},
            new String[] {BiomeIds.HALLOW},
            new String[] {BiomeIds.SNOW}
    );
    public static Npc STYLIST = new Npc(NpcIds.STYLIST, NpcImportance.ONE,
            new String[] {NpcIds.DYE_TRADER},
            new String[] {NpcIds.PIRATE, NpcIds.PRINCESS},
            new String[] {NpcIds.TAVERNKEEP},
            new String[] {NpcIds.GOBLIN_TINKERER},
            new String[] {BiomeIds.OCEAN},
            new String[] {BiomeIds.SNOW}
    );
    public static Npc GOBLIN_TINKERER = new Npc(NpcIds.GOBLIN_TINKERER, NpcImportance.FOUR,
            new String[] {NpcIds.MECHANIC},
            new String[] {NpcIds.DYE_TRADER, NpcIds.PRINCESS},
            new String[] {NpcIds.CLOTHIER},
            new String[] {NpcIds.STYLIST},
            new String[] {BiomeIds.CAVERN},
            new String[] {BiomeIds.JUNGLE}
    );
    public static Npc WITCH_DOCTOR = new Npc(NpcIds.WITCH_DOCTOR, NpcImportance.ONE,
            null,
            new String[] {NpcIds.DRYAD, NpcIds.GUIDE, NpcIds.PRINCESS},
            new String[] {NpcIds.GUIDE},
            new String[] {NpcIds.TRUFFLE},
            new String[] {BiomeIds.JUNGLE},
            new String[] {BiomeIds.HALLOW}
    );
    public static Npc CLOTHIER = new Npc(NpcIds.CLOTHIER, NpcImportance.ONE,
            new String[] {NpcIds.TRUFFLE},
            new String[] {NpcIds.TAX_COLLECTOR, NpcIds.PRINCESS},
            new String[] {NpcIds.NURSE},
            new String[] {NpcIds.MECHANIC},
            new String[] {BiomeIds.CAVERN},
            new String[] {BiomeIds.HALLOW}
    );
    public static Npc MECHANIC = new Npc(NpcIds.MECHANIC, NpcImportance.TWO,
            new String[] {NpcIds.GOBLIN_TINKERER},
            new String[] {NpcIds.CYBORG, NpcIds.PRINCESS},
            new String[] {NpcIds.ARMS_DEALER},
            new String[] {NpcIds.CLOTHIER},
            new String[] {BiomeIds.SNOW},
            new String[] {BiomeIds.CAVERN}
    );
    public static Npc PARTY_GIRL = new Npc(NpcIds.PARTY_GIRL, NpcImportance.TWO,
            new String[] {NpcIds.WIZARD, NpcIds.ZOOLOGIST},
            new String[] {NpcIds.STYLIST, NpcIds.PRINCESS},
            new String[] {NpcIds.MERCHANT},
            new String[] {NpcIds.TAX_COLLECTOR},
            new String[] {BiomeIds.HALLOW},
            new String[] {BiomeIds.CAVERN}
    );
    public static Npc WIZARD = new Npc(NpcIds.WIZARD, NpcImportance.TWO,
            new String[] {NpcIds.GOLFER},
            new String[] {NpcIds.PRINCESS},
            new String[] {NpcIds.WITCH_DOCTOR, NpcIds.MERCHANT},
            new String[] {NpcIds.CYBORG},
            new String[] {BiomeIds.HALLOW},
            new String[] {BiomeIds.OCEAN}
    );
    public static Npc TAX_COLLECTOR = new Npc(NpcIds.TAX_COLLECTOR, NpcImportance.FOUR,
            new String[] {NpcIds.MERCHANT},
            new String[] {NpcIds.PARTY_GIRL, NpcIds.PRINCESS},
            new String[] {NpcIds.DEMOLITIONIST, NpcIds.MECHANIC},
            new String[] {NpcIds.SANTA_CLAUS},
            new String[] {BiomeIds.SNOW},
            new String[] {BiomeIds.HALLOW}
    );
    public static Npc TRUFFLE = new Npc(NpcIds.TRUFFLE, NpcImportance.ONE,
            new String[] {NpcIds.GUIDE},
            new String[] {NpcIds.DRYAD, NpcIds.PRINCESS},
            new String[] {NpcIds.CLOTHIER},
            new String[] {NpcIds.GOBLIN_TINKERER},
            new String[] {BiomeIds.MUSHROOM},
            null
    );
    public static Npc PIRATE = new Npc(NpcIds.PIRATE, NpcImportance.TWO,
            new String[] {NpcIds.ANGLER},
            new String[] {NpcIds.TAVERNKEEP, NpcIds.PRINCESS},
            new String[] {NpcIds.STYLIST},
            new String[] {NpcIds.GUIDE},
            new String[] {BiomeIds.OCEAN},
            new String[] {BiomeIds.CAVERN}
    );
    public static Npc STEAM_PUNKER = new Npc(NpcIds.STEAM_PUNKER, NpcImportance.THREE,
            new String[] {NpcIds.CYBORG},
            new String[] {NpcIds.PAINTER, NpcIds.PRINCESS},
            new String[] {NpcIds.DRYAD, NpcIds.MECHANIC, NpcIds.PARTY_GIRL},
            null,
            new String[] {BiomeIds.DESERT},
            new String[] {BiomeIds.JUNGLE}
    );
    public static Npc CYBORG = new Npc(NpcIds.CYBORG, NpcImportance.TWO,
            null,
            new String[] {NpcIds.PIRATE, NpcIds.STEAM_PUNKER, NpcIds.STYLIST, NpcIds.PRINCESS},
            new String[] {NpcIds.ZOOLOGIST},
            new String[] {NpcIds.WIZARD},
            new String[] {BiomeIds.SNOW},
            new String[] {BiomeIds.JUNGLE}
    );
    public static Npc SANTA_CLAUS = new Npc(NpcIds.SANTA_CLAUS, NpcImportance.ZERO,
            null,
            new String[] {NpcIds.PRINCESS},
            null,
            new String[] {NpcIds.TAX_COLLECTOR},
            new String[] {BiomeIds.SNOW},
            null,
            null,
            new String[] {BiomeIds.DESERT}
    );
    public static Npc PRINCESS = new Npc(NpcIds.PRINCESS, NpcImportance.ZERO,
            new String[] {NpcIds.GUIDE, NpcIds.MERCHANT, NpcIds.NURSE, NpcIds.DEMOLITIONIST, NpcIds.DYE_TRADER, NpcIds.ANGLER, NpcIds.ZOOLOGIST, NpcIds.DRYAD, NpcIds.PAINTER, NpcIds.GOLFER, NpcIds.ARMS_DEALER, NpcIds.TAVERNKEEP, NpcIds.STYLIST, NpcIds.GOBLIN_TINKERER, NpcIds.WITCH_DOCTOR, NpcIds.CLOTHIER, NpcIds.MECHANIC, NpcIds.PARTY_GIRL, NpcIds.WIZARD, NpcIds.TAX_COLLECTOR, NpcIds.TRUFFLE, NpcIds.PIRATE, NpcIds.STEAM_PUNKER, NpcIds.CYBORG, NpcIds.SANTA_CLAUS},
            null,
            null,
            null,
            new String[] {BiomeIds.FOREST, BiomeIds.SNOW, BiomeIds.DESERT, BiomeIds.CAVERN, BiomeIds.OCEAN, BiomeIds.JUNGLE, BiomeIds.HALLOW, BiomeIds.MUSHROOM},
            null
    );
}
