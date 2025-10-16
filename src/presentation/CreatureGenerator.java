package presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import domain.CreatureClass;
import service.CreatureFunctions;
import service.GenericFunctions;


public class CreatureGenerator {
    public void run(Scanner dataInput, List<CreatureClass> creatureList) throws IOException {
        var option = 0;
        CreatureClass creature = null;

        System.out.println("WELCOME TO THE CREATURE GENERATOR");

        do {
            try {
                System.out.print("""
                        Please select an option:
                        1) Create new random creature
                        2) Reroll Subcategory
                        3) Reroll Prompt
                        4) Reroll Stats
                        5) View current creature
                        6) View generated creature list
                        7) Export creature
                        8) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option) {
                    case 1 -> {
                        creature = new CreatureClass();
                        CreatureFunctions.rollAttributes(creature);
                        creatureList.add(creature);
                        System.out.println(creature);
                    }
                    case 2 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            CreatureFunctions.rollAttributes(creature);
                            creatureList.add(creature);
                        } else {
                            CreatureFunctions.reRollSubcategory(creature);
                            creatureList.add(creature);
                            System.out.println(creature);
                        }
                    }
                    case 3 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            CreatureFunctions.rollAttributes(creature);
                            creatureList.add(creature);
                            System.out.println(creature);
                        } else {
                            CreatureFunctions.reRollPrompt(creature);
                            creatureList.add(creature);
                            System.out.println(creature);
                        }
                    }
                    case 4 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            CreatureFunctions.rollAttributes(creature);
                            creatureList.add(creature);
                            System.out.println(creature);
                        } else {
                            CreatureFunctions.rollStats(creature);
                            creatureList.add(creature);
                            System.out.println(creature);
                        }
                    }
                    case 5 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            CreatureFunctions.rollAttributes(creature);
                            creatureList.add(creature);
                        }
                        System.out.println(creature);
                    }
                    case 6 -> creature = new ViewAll().run(dataInput,creatureList,creature,CreatureClass.class);
                    case 7 -> {
                        if (creature == null) {
                            creature = new CreatureClass();
                            CreatureFunctions.rollAttributes(creature);
                            creatureList.add(creature);
                        }
                        GenericFunctions.exportPW(creature);
                    }
                    case 8 -> System.out.println("\nReturning to main menu...\n");
                    default -> System.out.print("\nInvalid number!\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nAn error occurred!\n");
            }
        }
        while (option != 8);

    }
}