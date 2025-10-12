package presentation;

import domain.DungeonAreaClass;
import domain.DungeonClass;
import service.DungeonAreaFunctions;

import java.util.Scanner;

public class DungeonAreaGenerator {
    public void run(Scanner dataInput, DungeonClass dungeon){
        DungeonAreaClass area = null;

        int option = 0;
        System.out.println("PROCEED TO ADD AREAS\n");

        try{

            do {
                System.out.print("""
                        1) Generate random area
                        2) Add area to dungeon
                        3) Back to DUNGEON GENERATOR
                        
                        \tOption:\s
                        """);

                option = Integer.parseInt(dataInput.nextLine());

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
                            System.out.println(area);
                        }
                        dungeon.addArea(area);
                    }
                    case 3 -> System.out.println("Going back to DUNGEON GENERATOR");
                }
            } while (option!=3);


        }catch (Exception e){
            System.out.println("There has been a problem during DUNGEON AREA GENERATOR excecution: "+e.getMessage());
        }

    }
}
