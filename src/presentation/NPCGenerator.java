package presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import domain.NPCClass;
import service.NPCFunctions;


public class NPCGenerator {
    public void run(Scanner dataInput, List<NPCClass> npcList) throws IOException {
        var option = 0;
        NPCClass npc = null;

        System.out.println("\nWELCOME TO THE NPC GENERATOR");

        do {
            try {
                System.out.print("""
                        Please select an option:
                        1) Create new random NPC
                        2) View generated NPC list
                        3) Main Menu
                        
                        Option:\s""");
                option = Integer.parseInt(dataInput.nextLine());

                switch (option) {
                    case 1 -> {
                            npc = new NPCClass();
                            NPCFunctions.rollFeatures(npc);
                            NPCFunctions.printNPC(npc);
                            npcList.add(npc);
                    }
                    case 2 -> {
                        int counter = 1;
                        System.out.println("""
                                *** LIST OF NPCs ***""");
                        for (NPCClass c : npcList){
                            System.out.printf("%d) %s\n", counter, c.getBrief());
                            counter++;
                        }
                        System.out.println("\n");
                    }
                    case 3 -> System.out.println("\nReturning to main menu...\n");
                    default -> System.out.print("\nInvalid number!\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nPlease choose a valid option.\n");
            }
        }
        while (option != 3);


    }
}