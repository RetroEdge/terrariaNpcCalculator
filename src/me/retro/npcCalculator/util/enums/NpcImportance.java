package me.retro.npcCalculator.util.enums;

public enum NpcImportance {
    ZERO    (0.0f),
    ONE     (0.07f),
    TWO     (0.13f),
    THREE   (0.27f),
    FOUR    (0.53f);

    public final float value;

    NpcImportance(float value) {
        this.value = value;
    }
}
