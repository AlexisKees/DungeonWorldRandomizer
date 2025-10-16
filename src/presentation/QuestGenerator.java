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
                        quest = new QuestClass();
                        QuestFunctions.rollQuest(quest);
                        questList.add(quest);
                        npcList.add(quest.getQuestGiver());
                        dungeonList.add(quest.getDungeon());
                        biomeList.add(quest.getBiome());
                        System.out.println(quest.getBrief());
                    }
                    case 2 -> {
                        if(quest==null){
                            quest = new QuestClass();
                            QuestFunctions.rollQuest(quest);
                            questList.add(quest);
                            npcList.add(quest.getQuestGiver());
                            dungeonList.add(quest.getDungeon());
                            biomeList.add(quest.getBiome());
                            System.out.println(quest);
                            System.out.println("\n");
                        }
                        System.out.println("QUEST GUIVER:\n\n"+quest.getQuestGiver());
                    }
                    case 3 -> {
                        if(quest==null){
                            quest = new QuestClass();
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
                    case 4 -> quest = new ViewAll().run(dataInput,questList,quest,QuestClass.class);
                    case 5 -> {
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