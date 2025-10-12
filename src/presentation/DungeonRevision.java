package presentation;

import domain.DungeonClass;
import service.DungeonFunctions;

import java.util.List;
import java.util.Scanner;

public class DungeonRevision {

    public DungeonClass run(Scanner dataInput, List<DungeonClass> dungeonList, DungeonClass dungeon){
        int option = 0;
        int dungeonNumber=0;

        int counter = 1;
        System.out.println("""
                                *** LIST OF DUNGEONS ***""");
        for (DungeonClass d : dungeonList){
            System.out.printf("%d) %s\n", counter,d.getName());
            counter++;
        }
        System.out.println("\n");

        try{
            do {
                System.out.print("""
                        1) Detailed view
                        2) Go back to DUNGEON GENERATOR
                        \tOption:\s""");

                option=Integer.parseInt(dataInput.nextLine());

                switch (option){
                    case 1 ->{

                        System.out.print("Please insert Dungeon number: ");
                        dungeonNumber=Integer.parseInt(dataInput.nextLine());
                        System.out.println();
                        DungeonClass selectedDungeon=dungeonList.get(dungeonNumber-1);
                        System.out.println("TAKE A LOOK AT YOUR CHOSEN DUNGEON:\n\n");
                        System.out.println(selectedDungeon);

                        int secondOption;
                        do {
                            System.out.print("""
                                1) Export dungeon
                                2) Select this dungeon to keep editing
                                3) Go back to DUNGEON GENERATOR
                                \tOption:\s""");
                            secondOption=Integer.parseInt(dataInput.nextLine());

                            switch (secondOption){
                                case 1 -> DungeonFunctions.exportDungeon(selectedDungeon);
                                case 2 -> {
                                    dungeon = selectedDungeon;
                                    System.out.println("You can now go back to the DUNGEON GENERATOR");
                                    System.out.println("and keep editing your dungeon");
                                }
                                case 3 -> {
                                    System.out.println("Going back to the DUNGEON GENERATOR");
                                    return dungeon;
                                }
                            }
                        } while (secondOption != 3);


                    }
                }
            } while (option!=2);

        } catch (Exception e){
            System.out.println("An error has occurred: "+e.getMessage());
        }

        return dungeon;
    }
}
