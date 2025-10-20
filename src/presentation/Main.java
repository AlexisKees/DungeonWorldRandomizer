package presentation;

import domain.*;
import service.BiomeFunctions;
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
                     case 2 -> {
                         NPCClass npc = new NPCClass();
                         SubMenu.run(dataInput,npc, npcList);
                     }
                     case 3 -> {
                         FollowerClass follower = new FollowerClass();
                         SubMenu.run(dataInput,follower, followerList);
                     }
                     case 4 -> {
                         SteadingClass steading = new SteadingClass();
                         SubMenu.run(dataInput, steading, steadingList);
                     }
                     case 5 -> {
                         DungeonClass dungeon = new DungeonClass();
                         SubMenu.run(dataInput, dungeon, dungeonList);
                     }
                     case 6 -> {
                         DungeonAreaClass area = new DungeonAreaClass();
                         SubMenu.run(dataInput, area, areaList);
                     }
                     case 7 -> {
                         BiomeClass biome = new BiomeClass();
                         SubMenu.run(dataInput,biome,biomeList);
                     }
                     case 8 -> {
                         DiscoveryClass discovery = new DiscoveryClass();
                         SubMenu.run(dataInput,discovery, discoveryList);
                     }
                     case 9 -> {
                         DangerClass danger = new DangerClass();
                         SubMenu.run(dataInput, danger, dangerList);
                     }
                     case 10 ->{
                         CreatureClass creature = new CreatureClass();
                         SubMenu.run(dataInput, creature, creatureList);
                     }
                     case 11 -> System.out.println("Come back soon!");
                     default -> System.out.println("Please, chose a valid option");
                 }

            } while (option != 11);
        } catch (Exception e){
            System.out.println("Please, chose a valid option");
        }
    }
}
