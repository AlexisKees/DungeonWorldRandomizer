package service;

import data.QuestArrays;
import domain.*;
import domain.util.Rolls;
import presentation.ViewAll;

import java.util.List;
import java.util.Scanner;

public class QuestFunctions {

    public static void rollQuest(Quest quest){
        quest.setTask(QuestArrays.TASK[Rolls.UniversalRoll(QuestArrays.TASK)]);
        quest.setRelevance(QuestArrays.RELEVANCE[Rolls.UniversalRoll(QuestArrays.RELEVANCE)]);
        quest.setReward(QuestArrays.REWARD[Rolls.UniversalRoll(QuestArrays.REWARD)]);

        quest.setQuestGiver(new NPC());
        quest.setDungeon(new Dungeon());
        quest.setBiome(new Biome());
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



    public static void showOptions(Scanner dataInput, Quest quest, List<Quest> questList, List<NPC> npcList, List<Dungeon> dungeonList, List<Biome> biomeList) {
        var option = 0;

        System.out.println("WELCOME TO THE QUEST GENERATOR\n");

        do {
            try {
                System.out.print("""
                        \nPlease select an option:
                        1) Create new random quest
                        2) Quest giver details
                        3) Quest location details
                        4) See previously generated quests
                        5) Print quest
                        6) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option) {
                    case 1 -> {
                        quest = new Quest();
                        QuestFunctions.rollQuest(quest);
                        questList.add(quest);
                        npcList.add(quest.getQuestGiver());
                        dungeonList.add(quest.getDungeon());
                        biomeList.add(quest.getBiome());
                        System.out.print(quest.getBrief());
                    }
                    case 2 -> {
                        if(quest==null){
                            quest = new Quest();
                            QuestFunctions.rollQuest(quest);
                            questList.add(quest);
                            npcList.add(quest.getQuestGiver());
                            dungeonList.add(quest.getDungeon());
                            biomeList.add(quest.getBiome());
                            System.out.println(quest);
                        }
                        System.out.println("QUEST GUIVER:\n\n"+quest.getQuestGiver());
                    }
                    case 3 -> {
                        if(quest==null){
                            quest = new Quest();
                            QuestFunctions.rollQuest(quest);
                            questList.add(quest);
                            npcList.add(quest.getQuestGiver());
                            dungeonList.add(quest.getDungeon());
                            biomeList.add(quest.getBiome());
                            System.out.println(quest);
                        }
                        System.out.println("QUEST LOCATION - BIOME:\n\n"+quest.getBiome());
                        System.out.println("QUEST LOCATION - DUNGEION:\n\n"+quest.getDungeon());
                    }
                    case 4 -> quest = new ViewAll().run(dataInput,questList,quest, Quest.class);
                    case 5 -> {
                        if (quest == null) {
                            quest = new Quest();
                            QuestFunctions.rollQuest(quest);
                            quest.setQuestGiver(new NPC());
                            quest.setDungeon(new Dungeon());
                            quest.setBiome(new Biome());
                            DungeonFunctions.rollDungeon(quest.getDungeon());
                            NPCFunctions.rollFeatures(quest.getQuestGiver());
                            BiomeFunctions.rollBiome(quest.getBiome());
                            questList.add(quest);
                            npcList.add(quest.getQuestGiver());
                            dungeonList.add(quest.getDungeon());
                            biomeList.add(quest.getBiome());
                        }
                        GenericFunctions.exportPW(quest);
                    }
                    case 6 -> System.out.println("\nReturning to main menu...\n");
                    default -> System.out.print("\nInvalid number!\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nPlease choose a valid option.\nError: "+e.getMessage());
            }
        }
        while (option != 6);
    }


}
