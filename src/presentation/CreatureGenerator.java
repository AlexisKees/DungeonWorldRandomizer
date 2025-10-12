package presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import domain.CreatureClass;
import service.CreatureFunctions;


public class CreatureGenerator {
    public void run(Scanner dataInput, List<CreatureClass> creatureList) throws IOException {
        var option = 0;
        CreatureClass creature = null;

        System.out.println("\nWELCOME TO THE CREATURE GENERATOR");

        do {
            try {
                System.out.print("""
                        Please select an option:
                        1) Create new random creature
                        2) Reroll Subcategory
                        3) Reroll Prompt
                        4) Reroll Stats
                        5) Export creature
                        6) View generated creature list
                        7) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());

                switch (option) {
                    case 1 -> {
                        creature = new CreatureClass();
                        CreatureFunctions.rollAttributes(creature);
                        creatureList.add(creature);
                    }
                    case 2 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            CreatureFunctions.rollAttributes(creature);
                            creatureList.add(creature);
                        } else {
                            CreatureFunctions.reRollSubcategory(creature);
                            creatureList.add(creature);
                        }
                    }
                    case 3 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            CreatureFunctions.rollAttributes(creature);
                            creatureList.add(creature);
                        } else {
                            CreatureFunctions.reRollPrompt(creature);
                            creatureList.add(creature);
                        }
                    }
                    case 4 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            CreatureFunctions.rollAttributes(creature);
                            creatureList.add(creature);
                        } else {
                            CreatureFunctions.rollStats(creature);
                            creatureList.add(creature);
                        }
                    }
                    case 5 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            CreatureFunctions.rollAttributes(creature);
                            creatureList.add(creature);
                        }
                        CreatureFunctions.exportCreature(creature);
                        System.out.println("""
                                ***********************
                                *  Check your files!  *
                                ***********************
                                """);
                    }
                    case 6 -> {
                        int printOption;
                        int counter = 1;
                        System.out.println("""
                                *** LIST OF CREATURES ***""");
                        for (CreatureClass c : creatureList){
                            System.out.printf("%d) %s\n", counter, c.getPrompt());
                            counter++;
                        }
                        try {
                            do {
                                System.out.print("""
                                        %n1) Print a creature from the list
                                        2) Go back to CREATURE GENERATOR
                                        \tOption:\s""");
                                printOption = Integer.parseInt(dataInput.nextLine());
                                switch (printOption) {
                                    case 1 -> {
                                        int creatureIndex;
                                        System.out.print("Creature number:\s");
                                        creatureIndex = Integer.parseInt(dataInput.nextLine());
                                        System.out.printf("\nCreature number %d:\n",creatureIndex);
                                        creatureList.get(creatureIndex - 1).printMonster();
                                    }
                                    case 2 -> System.out.println("Going back to CREATURE GENERATOR");
                                    default -> System.out.println("Please chose a number in the list:\s");
                                }
                            } while (printOption != 2);
                        } catch (Exception e){
                            System.out.println("Please chose a number in the list:\s");
                        }
                    }
                    case 7 -> System.out.println("\nReturning to main menu...\n");
                    default -> System.out.print("\nInvalid number!\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nAn error occurred!\n");
            }
        }
        while (option != 7);

    }
}