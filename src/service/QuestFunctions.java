package service;

import data.QuestArrays;
import domain.*;
import domain.util.Rolls;

public class QuestFunctions {

    public static void rollQuest(QuestClass quest){
        quest.setTask(QuestArrays.TASK[Rolls.UniversalRoll(QuestArrays.TASK)]);
        quest.setRelevance(QuestArrays.RELEVANCE[Rolls.UniversalRoll(QuestArrays.RELEVANCE)]);
        quest.setReward(QuestArrays.REWARD[Rolls.UniversalRoll(QuestArrays.REWARD)]);

        quest.setQuestGiver(new NPCClass());
        quest.setDungeon(new DungeonClass());
        quest.setBiome(new BiomeClass());
        DungeonFunctions.rollDungeon(quest.getDungeon());
        NPCFunctions.rollFeatures(quest.getQuestGiver());
        BiomeFunctions.rollBiome(quest.getBiome());
        quest.setOneLiner(String.format("%s's %s quest",quest.getQuestGiver().getName(),quest.getTask()));

        quest.setBrief(String.format("""
                \nQUEST
                Task: %s
                Relevance: %s
                Reward: %s
                Tasked by: %s
                To be carried out at: %s, in some %s
                """, quest.getTask(),quest.getRelevance(),quest.getReward(),quest.getQuestGiver().getOneLiner(),quest.getDungeon().getName(), quest.getBiome().getOneLiner()));
    }



}
