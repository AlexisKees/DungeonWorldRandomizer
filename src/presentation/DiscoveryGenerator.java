package presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import domain.DiscoveryClass;
import service.DiscoveryFunctions;
import service.GenericFunctions;

public class DiscoveryGenerator {
    public void run(Scanner dataInput, List<DiscoveryClass> discoveryList) throws IOException { int option = 0;
        DiscoveryClass discovery = null;
        System.out.println("WELCOME TO THE DISCOVERY GENERATOR\n");

        try{
            do {
                System.out.print("""
                        Please select an option:
                        1) Create new random discovery
                        2) View current discovery
                        3) View list of generated discoveries
                        4) Export current
                        5) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option){
                    case 1 ->{
                        discovery = new DiscoveryClass();
                        DiscoveryFunctions.rollDiscovery(discovery);
                        discoveryList.add(discovery);
                        System.out.println(discovery);
                    }
                    case 2 -> {
                        if(discovery==null){
                            discovery = new DiscoveryClass();
                            DiscoveryFunctions.rollDiscovery(discovery);
                            discoveryList.add(discovery);
                        }
                        System.out.println(discovery);
                        System.out.println("\n");
                    }
                    case 3 -> discovery = new ViewAll().run(dataInput,discoveryList,discovery,DiscoveryClass.class);
                    case 4 -> {
                        if(discovery==null){
                            discovery = new DiscoveryClass();
                            DiscoveryFunctions.rollDiscovery(discovery);
                            discoveryList.add(discovery);
                        }
                        GenericFunctions.exportPW(discovery);
                    }
                    case 5 -> System.out.println("\nReturning to main menu...\n");

                }
            }while (option !=5);
        }catch (Exception e){
            System.out.println("An error occurred: "+e.getMessage());
        }

    }
}