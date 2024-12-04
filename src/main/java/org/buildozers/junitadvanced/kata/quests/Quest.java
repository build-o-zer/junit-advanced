package org.buildozers.junitadvanced.kata.quests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Quest {

    DEATH_LABYRINTH("Death Labyrinth", 100),
    DRAGON_SLAYER("Dragon Slayer", 200),
    TREASURE_HUNT("Treasure Hunt", 150),
    WIZARD_TOWER("Wizard Tower", 120),
    GOBLIN_INVASION("Goblin Invasion", 180);

    @Getter
    private final String name;

    @Getter
    private final int reward;

    // TODO: to be tested
    public String getDescription() {
        return String.format("The Quest '%s' rewards %d experience points.", name, reward);
    }

}
