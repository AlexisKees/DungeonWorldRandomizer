package presentation;

import domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dataInput = new Scanner(System.in);
        List<Quest> questList = new ArrayList<>();
        List<NPC> npcList = new ArrayList<>();
        List<Follower> followerList = new ArrayList<>();
        List<Steading> steadingList = new ArrayList<>();
        List<Dungeon> dungeonList = new ArrayList<>();
        List<Area> areaList = new ArrayList<>();
        List<Biome> biomeList = new ArrayList<>();
        List<Discovery> discoveryList = new ArrayList<>();
        List<Danger> dangerList = new ArrayList<>();
        List<Creature> creatureList = new ArrayList<>();

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
                     case 1 -> {
                         Quest quest = new Quest();
                         SubMenu.run(dataInput, quest, questList, npcList, dungeonList, biomeList);
                     }
                     case 2 -> {
                         NPC npc = new NPC();
                         SubMenu.run(dataInput,npc, npcList);
                     }
                     case 3 -> {
                         Follower follower = new Follower();
                         SubMenu.run(dataInput,follower, followerList);
                     }
                     case 4 -> {
                         Steading steading = new Steading();
                         SubMenu.run(dataInput, steading, steadingList);
                     }
                     case 5 -> {
                         Dungeon dungeon = new Dungeon();
                         SubMenu.run(dataInput, dungeon, dungeonList);
                     }
                     case 6 -> {
                         Area area = new Area();
                         SubMenu.run(dataInput, area, areaList);
                     }
                     case 7 -> {
                         Biome biome = new Biome();
                         SubMenu.run(dataInput,biome,biomeList);
                     }
                     case 8 -> {
                         Discovery discovery = new Discovery();
                         SubMenu.run(dataInput,discovery, discoveryList);
                     }
                     case 9 -> {
                         Danger danger = new Danger();
                         SubMenu.run(dataInput, danger, dangerList);
                     }
                     case 10 ->{
                         Creature creature = new Creature();
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
