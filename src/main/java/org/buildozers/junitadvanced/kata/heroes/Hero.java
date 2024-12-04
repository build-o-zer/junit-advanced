package org.buildozers.junitadvanced.kata.heroes;

import lombok.Builder;
import lombok.Getter;


@Builder(access = lombok.AccessLevel.PACKAGE)
public class Hero {

    @Getter
    private final Guild guild;

    @Getter
    private final String nickName;

    @Getter
    int experience;

    // TODO: to be tested
    public void increaseLevel(int reward) {
       if (reward < 0) {
           throw new IllegalArgumentException("Reward must be positive");
       } 
       this.experience += reward;
    }

    // TODO: to be tested
    public Guild.Power getPower() {
        return guild.getPower();
    }

    // TODO: to be tested
    public String toString() {
        return String.format("Hero %s from guild %s has %d experience points", nickName, guild.getName(), experience);
    }

}
