package org.buildozers.junitadvanced.kata.heroes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Guild 
{
    WARRIORS("Warriors", Power.NO),
    MAGES("Mages", Power.YES),
    ROGUES("Rogues", Power.NO),
    HUNTERS("Hunters", Power.NO),
    WITCHES("Witches", Power.UNKNOWN);

    public enum Power {
        YES,
        NO,
        UNKNOWN;
    }

    @Getter
    private final String name;

    @Getter
    private final Power power;

}
