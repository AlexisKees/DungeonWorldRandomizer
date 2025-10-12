package presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import domain.DungeonClass;
import service.DungeonFunctions;


public class DungeonGenerator {
    public void run(Scanner dataInput, List<DungeonClass> dungeonList) throws IOException {
        var option = 0;
        DungeonClass dungeon = null;

        System.out.println("\nWELCOME TO THE DUNGEON GENERATOR");

        do {
            try {
                System.out.print("""
                        Please select an option:
                        1) Create new random dungeon
                        2) Add areas
                        3) View generated dungeons list
                        4) View current dungeon
                        5) Export dungeon
                        6) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());

                switch (option) {
                    case 1 -> {
                        dungeon = new DungeonClass();
                        DungeonFunctions.rollDungeon(dungeon);
                        dungeonList.add(dungeon);
                        System.out.println(dungeon);
                    }
                    case 2 -> new DungeonAreaGenerator().run(dataInput, dungeon);
                    case 3 -> dungeon = new DungeonRevision().run(dataInput,dungeonList,dungeon);
                    case 4 -> {
                        if (dungeon==null){
                            System.out.println("\nGenerating dungeon...\n");
                            dungeon = new DungeonClass();
                            DungeonFunctions.rollDungeon(dungeon);
                            dungeonList.add(dungeon);
                        }
                        System.out.println(dungeon);
                    }
                    case 5 -> {
                        if (dungeon == null) {
                            dungeon = new DungeonClass();
                            DungeonFunctions.rollDungeon(dungeon);
                            dungeonList.add(dungeon);
                        }
                        DungeonFunctions.exportDungeon(dungeon);
                        System.out.println("""
                                ***********************
                                *  Check your files!  *
                                ***********************
                                """);
                    }
                    case 6 -> System.out.println("\nReturning to main menu...\n");
                    default -> System.out.print("\nInvalid number!\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nPlease choose a valid option.\n");
            }
        }
        while (option != 6);


    }
}