package presentation;

import domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dataInput = new Scanner(System.in);
        List<QuestClass> questList = new ArrayList<>();
        List<NPCClass> npcList = new ArrayList<>();
        List<DiscoveryClass> discoveryList = new ArrayList<>();
        List<DangerClass> dangerList = new ArrayList<>();
        List<DungeonClass> dungeonList = new ArrayList<>();
        List<CreatureClass> creatureList = new ArrayList<>();

        System.out.println("""
                
                
                *********************************
                  Welcome to the Dungeon World
                  random content generator
                *********************************
                Created by Alexis Kees Bahl
                Based on "The Perilous Wilds, revised edition".
                """);

        try {
            int option;
            do {
                                System.out.println("""
                        Chose what you'd like to generate:
                        1) Generate random Quest
                        2) Generate random NPC
                        3) Generate random Discovery
                        4) Generate random Danger
                        5) Generate random Dungeon
                        6) Generate random Creature
                        7) Exit
                        
                        Option:\s""");

                 option = Integer.parseInt(dataInput.nextLine());

                 switch (option){
                     case 1 -> new QuestGenerator().run(dataInput, questList);
                     case 2 -> new NPCGenerator().run(dataInput,npcList);
                     case 3 -> new DiscoveryGenerator().run(dataInput, discoveryList);
                     case 4 -> new DangerGenerator().run(dataInput, dangerList);
                     case 5 -> new DungeonGenerator().run(dataInput, dungeonList);
                     case 6 -> new CreatureGenerator().run(dataInput, creatureList);
                     case 7 -> System.out.println("Come back soon!");
                     default -> System.out.println("Please, chose a valid option");
                 }

            } while (option != 7);
        } catch (Exception e){
            System.out.println("Please, chose a valid option");
        }
    }
}
