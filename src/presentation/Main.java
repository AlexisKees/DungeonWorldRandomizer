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
        List<SteadingClass> steadingList = new ArrayList<>();
        List<DiscoveryClass> discoveryList = new ArrayList<>();
        List<DangerClass> dangerList = new ArrayList<>();
        List<DungeonClass> dungeonList = new ArrayList<>();
        List<BiomeClass> biomeList = new ArrayList<>();
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
                                System.out.print("""
                        Chose what you'd like to generate:
                        1) Generate random Quest
                        2) Generate random NPC
                        3) Generate random Steading
                        4) Generate random Discovery
                        5) Generate random Danger
                        6) Generate random Dungeon
                        7) Generate random Creature
                        8) Exit
                        
                        \tOption:\s""");

                 option = Integer.parseInt(dataInput.nextLine());

                 switch (option){
                     case 1 -> new QuestGenerator().run(dataInput, questList,npcList,dungeonList,biomeList);
                     case 2 -> new NPCGenerator().run(dataInput,npcList);
                     case 3 -> new SteadingGenerator().run(dataInput,steadingList);
                     case 4 -> new DiscoveryGenerator().run(dataInput, discoveryList);
                     case 5 -> new DangerGenerator().run(dataInput, dangerList);
                     case 6 -> new DungeonGenerator().run(dataInput, dungeonList);
                     case 7 -> new CreatureGenerator().run(dataInput, creatureList);
                     case 8 -> System.out.println("Come back soon!");
                     default -> System.out.println("Please, chose a valid option");
                 }

            } while (option != 3);
        } catch (Exception e){
            System.out.println("Please, chose a valid option");
        }
    }
}
