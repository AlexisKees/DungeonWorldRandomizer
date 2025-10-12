package presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import domain.*;
import service.*;


public class QuestGenerator {
    public void run(Scanner dataInput, List<QuestClass> questList, List<NPCClass> npcList, List<DungeonClass> dungeonList, List<BiomeClass> biomeList) throws IOException {
        var option = 0;
        QuestClass quest = null;


        System.out.println("\nWELCOME TO THE QUEST GENERATOR");

        do {
            try {
                System.out.print("""
                        Please select an option:
                        1) Create new random quest
                        2) See previously generated quests
                        3) Print quest
                        4) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());

                switch (option) {
                    case 1 -> {
                        quest = new QuestClass();
                        QuestFunctions.rollQuest(quest);
                        quest.setQuestGiver(new NPCClass());
                        quest.setDungeon(new DungeonClass());
                        quest.setBiome(new BiomeClass());
                        DungeonFunctions.rollDungeon(quest.getDungeon());
                        NPCFunctions.rollFeatures(quest.getQuestGiver());
                        BiomeFunctions.rollBiome(quest.getBiome());
                        questList.add(quest);
                        npcList.add(quest.getQuestGiver());
                        dungeonList.add(quest.getDungeon());
                        biomeList.add(quest.getBiome());
                        System.out.println(quest);
                    }
                    case 2 -> {
                        int counter = 1;
                        System.out.println("""
                                *** LIST OF QUESTS ***""");
                        for (QuestClass c : questList){
                            System.out.printf("%d) %s\n", counter, c.getTask());
                            counter++;
                        }
                        System.out.println("\n");
                    }
                    case 3 -> {
                        if (quest == null) {
                            quest = new QuestClass();
                            QuestFunctions.rollQuest(quest);
                            quest.setQuestGiver(new NPCClass());
                            quest.setDungeon(new DungeonClass());
                            quest.setBiome(new BiomeClass());
                            DungeonFunctions.rollDungeon(quest.getDungeon());
                            NPCFunctions.rollFeatures(quest.getQuestGiver());
                            BiomeFunctions.rollBiome(quest.getBiome());
                            questList.add(quest);
                            npcList.add(quest.getQuestGiver());
                            dungeonList.add(quest.getDungeon());
                            biomeList.add(quest.getBiome());
                        }
                        QuestFunctions.exportQuest(quest);
                        System.out.println("""
                                ***********************
                                *  Check your files!  *
                                ***********************
                                """);

                        System.out.println(quest);
                        System.out.println(quest.getDungeon());
                    }
                    case 4 -> System.out.println("\nReturning to main menu...\n");
                    default -> System.out.print("\nInvalid number!\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nPlease choose a valid option.\nError: "+e.getMessage());
            }
        }
        while (option != 4);



    }
}