package me.retro.npcCalculator.util.enums;

public enum NpcPreference {
    LOVE        (0.88f),
    LIKE        (0.94f),
    DISLIKE     (1.06f),
    HATE        (1.12f),
    SOLITUDE    (0.95f),
    OVERCROWDED (1.05f);

    public final float value;

    NpcPreference (float value) {
        this.value = value;
    }
}
