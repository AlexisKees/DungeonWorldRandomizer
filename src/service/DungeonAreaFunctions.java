package service;

import domain.Area;
import domain.Dungeon;
import presentation.ViewAll;

import java.util.List;
import java.util.Scanner;

import static service.GenericFunctions.printWithFlair;


public class DungeonAreaFunctions {

    public static void showOptions(Scanner dataInput, Area area, Dungeon dungeon,List<Area> areaList) {
        int option;
        System.out.println("WELCOME TO THE AREA GENERATOR\n");

        try{

            do {
                System.out.print("""
                        \nPlease select an option:
                        1) Create new random area
                        2) View current area
                        3) Reroll this area
                        4) View list of generated area
                        5) Add area to dungeon
                        6) Back to Dungeon menu
                        
                        \tOption:\s""");

                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option){
                    case 1 -> {
                        area = new Area();
                        AreaFunctions.rollArea(area);
                        areaList.add(area.clone());
                        printWithFlair(area);
                    }
                    case 2 ->{
                        if (area==null){
                            area = new Area();
                            AreaFunctions.rollArea(area);
                        }
                        printWithFlair(area);
                    }
                    case 3 ->{
                        if (area==null){
                            area = new Area();
                            AreaFunctions.rollArea(area);
                        } else {
                            AreaFunctions.rollAreaDetails(area);
                        }
                        areaList.add(area.clone());
                        printWithFlair(area);
                    }
                    case 4 -> area = new ViewAll().run(dataInput, dungeon.getAreas(), area, Area.class);
                    case 5 -> {
                        if (area==null){
                            area = new Area();
                            AreaFunctions.rollArea(area);
                        }
                        dungeon.addArea(area.clone());
                    }
                    case 6 -> System.out.println("Going back to DUNGEON GENERATOR");
                }
            } while (option!=6);


        }catch (Exception e){
            System.out.println("\nPlease choose a valid option.\n");
        }
    }


}