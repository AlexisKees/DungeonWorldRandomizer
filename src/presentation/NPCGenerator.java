package presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import domain.NPCClass;
import service.GenericFunctions;
import service.NPCFunctions;


public class NPCGenerator {
    public void run(Scanner dataInput, List<NPCClass> npcList) throws IOException {
        var option = 0;
        NPCClass npc = null;

        System.out.println("\nWELCOME TO THE NPC GENERATOR\n");

        do {
            try {
                System.out.print("""
                        Please select an option:
                        1) Create new random NPC
                        2) View current
                        3) View list of generated NPCs
                        4) Export current
                        5) Main menu
                                                
                        Option:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option) {
                    case 1 -> {
                            npc = new NPCClass();
                            NPCFunctions.rollFeatures(npc);
                            NPCFunctions.printNPC(npc);
                            npcList.add(npc);
                    }
                    case 2 -> {
                        if (npc==null) {
                            npc = new NPCClass();
                            NPCFunctions.rollFeatures(npc);
                            NPCFunctions.printNPC(npc);
                            npcList.add(npc);
                        }
                        System.out.println(npc);
                    }
                    case 3 -> npc = new ViewAll().run(dataInput,npcList,npc,NPCClass.class);
                    case 4 -> GenericFunctions.exportPW(npc);
                    case 5 -> System.out.println("\nReturning to main menu...\n");
                    default -> System.out.print("\nInvalid number!\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nPlease choose a valid option.\n");
            }
        }
        while (option != 5);


    }
}