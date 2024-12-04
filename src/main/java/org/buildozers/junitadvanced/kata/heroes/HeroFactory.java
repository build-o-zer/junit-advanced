package org.buildozers.junitadvanced.kata.heroes;

import lombok.experimental.UtilityClass;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.buildozers.junitadvanced.preconditions.Precondition;

@UtilityClass
public class HeroFactory {

    // TODO: to be tested
    public static Hero createHero(Guild guild, String nickName, int experience) {
        // preconditions
        Precondition.checkNotNull(guild, "guild");
        Precondition.checkPredicate(nickName, "nickName", StringUtils::isNotBlank, "cannot be blank");
        Precondition.checkPredicate(experience, "experience", xp -> xp >= 0, "must be greater than 0");
        
        // create hero
        return Hero.builder()
                .guild(guild)
                .nickName(nickName.toUpperCase())
                .experience(experience)
                .build();
    }

}
