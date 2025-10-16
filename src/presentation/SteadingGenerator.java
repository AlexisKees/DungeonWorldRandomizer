package presentation;

import domain.IPWClass;
import domain.SteadingClass;
import service.GenericFunctions;
import service.SteadingFunctions;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SteadingGenerator {

    public void run(Scanner dataInput, List<SteadingClass> steadingList) {

        int option = 0;
        SteadingClass steading = null;
        System.out.println("WELCOME TO THE STEADING GENERATOR\n");

        try {
            do {
                System.out.print("""
                        Please select an option:
                        1) Create new random steading
                        2) View current
                        3) View list of generated steadings 
                        4) Export current 
                        5) Main menu                        
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option) {
                    case 1 -> {
                        steading = new SteadingClass();
                        SteadingFunctions.rollSteading(steading);
                        steadingList.add(steading);
                        System.out.println(steading);
                    }
                    case 2 -> {
                        if (steading == null) {
                            steading = new SteadingClass();
                            SteadingFunctions.rollSteading(steading);
                            System.out.println(steading);
                            steadingList.add(steading);
                        }
                        System.out.println(steading);
                    }
                    case 3 -> steading = new ViewAll().run(dataInput, steadingList, steading, SteadingClass.class);
                    case 4 -> {
                        if (steading == null) {
                            steading = new SteadingClass();
                            SteadingFunctions.rollSteading(steading);
                            steadingList.add(steading);
                            System.out.println(steading);
                        }
                        GenericFunctions.exportPW(steading);
                    }
                    case 5 -> System.out.println("\nReturning to main menu...\n");

                }

            } while (option != 5);
        } catch (Exception e) {
            System.out.println("An error ocurred: " + e.getMessage());
        }

    }
}
