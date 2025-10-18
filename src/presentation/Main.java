package presentation;

import domain.*;
import service.FollowerFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dataInput = new Scanner(System.in);
        List<QuestClass> questList = new ArrayList<>();
        List<NPCClass> npcList = new ArrayList<>();
        List<FollowerClass> followerList = new ArrayList<>();
        List<SteadingClass> steadingList = new ArrayList<>();
        List<DungeonClass> dungeonList = new ArrayList<>();
        List<DungeonAreaClass> areaList = new ArrayList<>();
        List<BiomeClass> biomeList = new ArrayList<>();
        List<DiscoveryClass> discoveryList = new ArrayList<>();
        List<DangerClass> dangerList = new ArrayList<>();
        List<CreatureClass> creatureList = new ArrayList<>();

        try {
            int option;
            do {
                System.out.println("""
                
                
                *********************************
                  Welcome to the Dungeon World
                  random content generator
                *********************************
                Created by Alexis Kees Bahl
                Based on "The Perilous Wilds, revised edition".
                """);

                System.out.print("""
                        Chose what you'd like to generate:
                        1) Generate Quest
                        2) Generate NPC
                        3) Generate Follower
                        4) Generate Steading
                        5) Generate Dungeon
                        6) Generate Area
                        7) Generate Biome
                        8) Generate Discovery
                        9) Generate Danger
                        10) Generate Creature
                        11) Exit
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                 switch (option){
                     case 1 -> new QuestGenerator().run(dataInput, questList,npcList,dungeonList,biomeList);
                     case 2 -> new NPCGenerator().run(dataInput,npcList);
                     case 3 -> new FollowerGenerator().run(dataInput,followerList);
                     case 4 -> new SteadingGenerator().run(dataInput,steadingList);
                     case 5 -> new DungeonGenerator().run(dataInput, dungeonList);
                     case 6 -> new AreaGenerator().run(dataInput, areaList);
                     case 7 -> new BiomeGenerator().run(dataInput,biomeList);
                     case 8 -> new DiscoveryGenerator().run(dataInput, discoveryList);
                     case 9 -> new DangerGenerator().run(dataInput, dangerList);
                     case 10 -> new CreatureGenerator().run(dataInput, creatureList);
                     case 11 -> System.out.println("Come back soon!");
                     default -> System.out.println("Please, chose a valid option");
                 }

            } while (option != 10);
        } catch (Exception e){
            System.out.println("Please, chose a valid option");
        }
    }
}
