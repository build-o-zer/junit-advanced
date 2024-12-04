package org.buildozers.junitadvanced.kata.rewards;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.buildozers.junitadvanced.kata.heroes.Hero;
import org.buildozers.junitadvanced.kata.quests.Quest;

import lombok.Getter;
import lombok.experimental.UtilityClass;

/**
 * Rewarder class is responsible for rewarding heroes with experience points.
 */
public class Rewarder {

    // TODO : to be tested
    @Getter
    private LocalDateTime startupDateTime = LocalDateTime.now();

    @Getter
    private AtomicInteger rewardedHeroesCounter = new AtomicInteger(0);

    @Getter
    private AtomicInteger rewardedTeamsCounter = new AtomicInteger(0);

    // TODO : to be tested
    /**
     * Reward a hero with experience points.
     * @param hero the hero to reward
     * @param quest the quest that the hero completed
     */
    public void rewardHero(Hero hero, Quest quest) {
        hero.increaseLevel(quest.getReward());
        rewardedHeroesCounter.incrementAndGet();
    }

     // TODO : to be tested
    /**
     * Reward a team of heroes with the epxerience points of a quest.
     * @param heroes list of heroes
     * @param quest quest that the heroes completed
     */
    public void rewardTeam(List<Hero> heroes, Quest quest) {
        heroes.forEach(hero -> rewardHero(hero, quest));
        rewardedTeamsCounter.incrementAndGet();
    }

     // TODO : to be tested
    /**
     * Calculate the total reward of a team of heroes.
     * @param heroes list of heroes
     * @return the total experience of the team
     */
    public int calculateTotalExperience(List<Hero> heroes) {
        return heroes.stream().mapToInt(Hero::getExperience).sum();
    }

}
