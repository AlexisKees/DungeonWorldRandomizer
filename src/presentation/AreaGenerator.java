package presentation;

import domain.BiomeClass;
import domain.DungeonAreaClass;
import domain.DungeonClass;
import service.DungeonAreaFunctions;
import service.GenericFunctions;

import java.util.List;
import java.util.Scanner;

public class AreaGenerator {
    public void run(Scanner dataInput, List<DungeonAreaClass> areaList){
        DungeonAreaClass area = null;

        int option = 0;
        System.out.println("WELCOME TO THE AREA GENERATOR\n");

        try{

            do {
                System.out.print("""
                        \nPlease select an option:
                        1) Create new random area
                        2) View current area
                        3) Reroll this area
                        4) View list of generated area
                        5) Export current area
                        6) Main menu
                        
                        \tOption:\s""");

                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option){
                    case 1 -> {
                        area = new DungeonAreaClass();
                        DungeonAreaFunctions.rollArea(area);
                        System.out.println(area);
                    }
                    case 2 ->{
                        if (area==null){
                            area = new DungeonAreaClass();
                            DungeonAreaFunctions.rollArea(area);
                        }
                        System.out.println(area);
                    }
                    case 3 ->{
                        if (area==null){
                            area = new DungeonAreaClass();
                            DungeonAreaFunctions.rollArea(area);
                        } else {
                            DungeonAreaFunctions.rollAreaDetails(area);
                        }
                        System.out.println(area);
                    }
                    case 4 -> area = new ViewAll().run(dataInput, areaList, area, DungeonAreaClass.class);
                    case 5 -> {
                        if (area==null){
                            area = new DungeonAreaClass();
                            DungeonAreaFunctions.rollArea(area);
                        }
                        GenericFunctions.exportPW(area);
                    }
                    case 6 -> System.out.println("Going back to DUNGEON GENERATOR");
                }
            } while (option!=6);


        }catch (Exception e){
            System.out.println("There has been a problem during DUNGEON AREA GENERATOR excecution: "+e.getMessage());
        }

    }
}
