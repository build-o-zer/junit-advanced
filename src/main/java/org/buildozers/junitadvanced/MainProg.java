package org.buildozers.junitadvanced;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.buildozers.junitadvanced.kata.heroes.Guild;
import org.buildozers.junitadvanced.kata.heroes.Hero;
import org.buildozers.junitadvanced.kata.heroes.HeroFactory;

@Slf4j
public class MainProg {

    public static void main(String... args) {
        log.info(MainProg.getMessage());
        Hero hero = HeroFactory.createHero(Guild.ROGUES, "Kevin", 0);
        log.info(hero.toString());
    }

    public static String getMessage() {
        return "Hello from Java : " + System.getProperty("java.version");
    }

}
