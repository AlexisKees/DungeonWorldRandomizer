package presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import domain.DangerClass;


public class DangerGenerator {
    public void run(Scanner dataInput, List<DangerClass> dangerList) throws IOException {
        var option = 0;
        DangerClass danger = null;

        System.out.println("\nWELCOME TO THE DANGER GENERATOR");
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
                        creature = new CreatureClass();
                        creature.rollAttributes();
                        dangerList.add(creature);
                    }
                    case 2 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            creature.rollAttributes();
                            dangerList.add(creature);
                        } else {
                            creature.reRollSubcategory();
                            dangerList.add(creature);
                        }
                    }
                    case 3 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            creature.rollAttributes();
                            dangerList.add(creature);
                        } else {
                            creature.reRollPrompt();
                            dangerList.add(creature);
                        }
                    }
                    case 4 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            creature.rollAttributes();
                            dangerList.add(creature);
                        } else {
                            creature.rollStats();
                            creature.printMonster();
                            creature.printStats();
                            dangerList.add(creature);
                        }
                    }
                    case 5 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            creature.rollAttributes();
                            dangerList.add(creature);
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
                        for (CreatureClass c : dangerList){
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