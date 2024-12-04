package org.buildozers.junitadvanced.kata.heroes;

import lombok.experimental.UtilityClass;
import static org.apache.commons.lang3.Validate.*;

@UtilityClass
public class HeroFactory {

    // TODO: to be tested
    public static Hero createHero(Guild guild, String nickName, int experience) {
        // preconditions
        notNull(guild, "Guild must not be null");
        notBlank(nickName, "Nick name must not be blank");
        isTrue(experience >= 0, "Experience must be positive");

        // create hero
        return Hero.builder()
                .guild(guild)
                .nickName(nickName.toUpperCase())
                .experience(experience)
                .build();
    }

}
