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
        List<DungeonClass> dungeonList = new ArrayList<>();
        List<BiomeClass> biomeList = new ArrayList<>();
        List<DiscoveryClass> discoveryList = new ArrayList<>();
        List<DangerClass> dangerList = new ArrayList<>();
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
                        1) Generate Quest
                        2) Generate NPC
                        3) Generate Steading
                        4) Generate Dungeon
                        5) Generate Biome
                        6) Generate Discovery
                        7) Generate Danger
                        8) Generate Creature
                        9) Exit
                        
                        \tOption:\s""");

                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                 switch (option){
                     case 1 -> new QuestGenerator().run(dataInput, questList,npcList,dungeonList,biomeList);
                     case 2 -> new NPCGenerator().run(dataInput,npcList);
                     case 3 -> new SteadingGenerator().run(dataInput,steadingList);
                     case 4 -> new DungeonGenerator().run(dataInput, dungeonList);
                     case 5 -> new BiomeGenerator().run(dataInput,biomeList);
                     case 6 -> new DiscoveryGenerator().run(dataInput, discoveryList);
                     case 7 -> new DangerGenerator().run(dataInput, dangerList);
                     case 8 -> new CreatureGenerator().run(dataInput, creatureList);
                     case 9 -> System.out.println("Come back soon!");
                     default -> System.out.println("Please, chose a valid option");
                 }

            } while (option != 9);
        } catch (Exception e){
            System.out.println("Please, chose a valid option");
        }
    }
}
