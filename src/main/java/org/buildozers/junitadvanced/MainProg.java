package org.buildozers.junitadvanced;

import org.buildozers.junitadvanced.kata.heroes.Guild;
import org.buildozers.junitadvanced.kata.heroes.Hero;
import org.buildozers.junitadvanced.kata.heroes.HeroFactory;

public class MainProg {

    public static void main(String... args) {
        System.out.println(MainProg.getMessage());
        Hero hero = HeroFactory.createHero(Guild.ROGUES, "Kevin", 0);
        System.out.println(hero);
    }

    public static String getMessage() {
        return "Hello from Java : " + System.getProperty("java.version");
    }

}
