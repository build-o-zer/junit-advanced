package org.buildozers.junitadvanced.kata.heroes;

import lombok.experimental.UtilityClass;

@UtilityClass
public class HeroFactory {

    // TODO: to be tested
    public static Hero createHero(Guild guild, String nickName, int experience) {
        return Hero.builder()
                .guild(guild)
                .nickName(nickName)
                .experience(experience)
                .build();
    }

}
