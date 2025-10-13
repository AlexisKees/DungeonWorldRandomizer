package presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import domain.DiscoveryClass;
import service.DiscoveryFunctions;

public class DiscoveryGenerator {
    public void run(Scanner dataInput, List<DiscoveryClass> discoveryList) throws IOException { int option = 0;
        DiscoveryClass discovery = null;
        System.out.println("WELCOME TO THE DISCOVERY GENERATOR");

        try{
            do {
                System.out.print("""
                        Please select an option:
                        1) Create new random discovery
                        2) See previously generated discoveries
                        3) Print discovery
                        4) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());

                switch (option){
                    case 1 ->{
                        discovery = new DiscoveryClass();
                        DiscoveryFunctions.rollDiscovery(discovery);
                        System.out.println(discovery);
                    }
                    case 2 -> {
                        int counter = 1;
                        System.out.println("""
                                *** LIST OF DISCOVERIES ***""");
                        for (DiscoveryClass d : discoveryList){
                            System.out.printf("%d) %s\n", counter, d.getPrompt());
                            counter++;
                        }
                        System.out.println("\n");
                    }
                    case 3 -> {
                        if (discovery==null){
                            discovery = new DiscoveryClass();
                            DiscoveryFunctions.rollDiscovery(discovery);
                            System.out.println(discovery);
                        }
                        DiscoveryFunctions.exportDiscovery(discovery);
                    }
                    case 4 -> System.out.println("Going back to main menu");

                }
            }while (option !=4);
        }catch (Exception e){
            System.out.println("An error occurred: "+e.getMessage());
        }

    }
}