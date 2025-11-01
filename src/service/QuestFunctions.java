package service;

import data.QuestArrays;
import domain.*;
import presentation.ViewAll;

import java.util.List;
import java.util.Scanner;

import static domain.util.Rolls.PickFrom;
import static service.GenericFunctions.printWithFlair;

public class QuestFunctions {

    public static void rollQuest(Quest quest){
        quest.setTask(PickFrom(QuestArrays.TASK));
        quest.setRelevance(PickFrom(QuestArrays.RELEVANCE));
        quest.setReward(PickFrom(QuestArrays.REWARD));

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
                        4) See current quest
                        5) See previously generated quests
                        6) Print quest
                        7) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option) {
                    case 1 -> {
                        quest = new Quest();
                        QuestFunctions.rollQuest(quest);
                        questList.add(quest.clone());
                        npcList.add(quest.getQuestGiver().clone());
                        dungeonList.add(quest.getDungeon().clone());
                        biomeList.add(quest.getBiome().clone());
                        printWithFlair(quest.getBrief());
                    }
                    case 2 -> {
                        if(quest.getTask()==null){
                            quest = new Quest();
                            QuestFunctions.rollQuest(quest);
                            questList.add(quest.clone());
                            npcList.add(quest.getQuestGiver().clone());
                            dungeonList.add(quest.getDungeon().clone());
                            biomeList.add(quest.getBiome().clone());
                        }
                        printWithFlair("QUEST GIVER:\n\n"+quest.getQuestGiver());
                    }
                    case 3 -> {
                        if(quest.getTask()==null){
                            quest = new Quest();
                            QuestFunctions.rollQuest(quest);
                            questList.add(quest.clone());
                            npcList.add(quest.getQuestGiver().clone());
                            dungeonList.add(quest.getDungeon().clone());
                            biomeList.add(quest.getBiome().clone());
                        }
                        printWithFlair("QUEST LOCATION - BIOME:\n\n"+quest.getBiome()+"\n\n"+"QUEST LOCATION - DUNGEON:\n\n"+quest.getDungeon());
                    }
                    case 4 -> {
                        if(quest.getTask()==null){
                            quest = new Quest();
                            QuestFunctions.rollQuest(quest);
                            questList.add(quest.clone());
                            npcList.add(quest.getQuestGiver().clone());
                            dungeonList.add(quest.getDungeon().clone());
                            biomeList.add(quest.getBiome().clone());
                        }
                        printWithFlair(quest);
                    }
                    case 5-> quest = new ViewAll().run(dataInput,questList,quest, Quest.class);
                    case 6 -> {
                        if(quest.getTask() == null) {
                            quest = new Quest();
                            QuestFunctions.rollQuest(quest);
                            questList.add(quest.clone());
                            npcList.add(quest.getQuestGiver().clone());
                            dungeonList.add(quest.getDungeon().clone());
                            biomeList.add(quest.getBiome().clone());
                        }
                        GenericFunctions.exportPW(quest);
                    }
                    case 7 -> System.out.println("\nReturning to main menu...\n");
                    default -> System.out.print("\nInvalid number!\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nPlease choose a valid option.\n");
            }
        }
        while (option != 7);
    }


}
