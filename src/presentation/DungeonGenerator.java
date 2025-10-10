package presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import domain.DungeonClass;


public class DungeonGenerator {
    public void run(Scanner dataInput, List<DungeonClass> dungeonList) throws IOException {
        var option = 0;
        DungeonClass dungeon = null;

        System.out.println("\nWELCOME TO THE DUNGEON GENERATOR");
/*
        do {
            try {
                System.out.print("""
                        Please select an option:
                        1) Create new random monster
                        2) Reroll Subcategory
                        3) Reroll Prompt
                        4) Reroll Stats
                        5) Export monster
                        6) View generated monster list
                        7) Exit
                        
                        Option:\s""");
                option = Integer.parseInt(dataInput.nextLine());

                switch (option) {
                    case 1 -> {
                        creature = new DungeonClass();
                        creature.rollAttributes();
                        dungeonList.add(creature);
                    }
                    case 2 -> {
                        if (creature == null) {
                            creature = new DungeonClass();
                            creature.rollAttributes();
                            dungeonList.add(creature);
                        } else {
                            creature.reRollSubcategory();
                            dungeonList.add(creature);
                        }
                    }
                    case 3 -> {
                        if (creature == null) {
                            creature = new DungeonClass();
                            creature.rollAttributes();
                            dungeonList.add(creature);
                        } else {
                            creature.reRollPrompt();
                            dungeonList.add(creature);
                        }
                    }
                    case 4 -> {
                        if (creature == null) {
                            creature = new DungeonClass();
                            creature.rollAttributes();
                            dungeonList.add(creature);
                        } else {
                            creature.rollStats();
                            creature.printMonster();
                            creature.printStats();
                            dungeonList.add(creature);
                        }
                    }
                    case 5 -> {
                        if (creature == null) {
                            creature = new DungeonClass();
                            creature.rollAttributes();
                            dungeonList.add(creature);
                        }
                        creature.exportCreature();
                        System.out.println("""
                                ***********************
                                *  Check your files!  *
                                ***********************
                                """);
                    }
                    case 6 -> {
                        int counter = 1;
                        System.out.println("""
                                *** LIST OF MONSTERS ***""");
                        for (DungeonClass c : dungeonList){
                            System.out.printf("%d) %s\n", counter, c.getPrompt());
                            counter++;
                        }
                        System.out.println("\n");
                    }
                    case 7 -> System.out.println("\nReturning to main menu...\n");
                    default -> System.out.print("\nInvalid number!\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nPlease choose a valid option.\n");
            }
        }
        while (option != 7);

 */

    }
}