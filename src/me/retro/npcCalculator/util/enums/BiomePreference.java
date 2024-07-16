package me.retro.npcCalculator.util.enums;

public enum BiomePreference {

    LOVE    (0.88f),
    LIKE    (0.94f),
    DISLIKE (1.06f),
    HATE    (1.12f);

    BiomePreference(float value) {
        this.value = value;
    }

    public final float value;
}
