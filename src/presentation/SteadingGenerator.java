package presentation;

import domain.SteadingClass;
import service.SteadingFunctions;

import java.util.List;
import java.util.Scanner;

public class SteadingGenerator {

    public void run(Scanner dataInput, List<SteadingClass> steadingList){

        int option = 0;
        SteadingClass steading = null;
        System.out.println("WELCOME TO THE STEADING GENERATOR");

        try{
            do {
                System.out.print("""
                        Please select an option:
                        1) Create new random steading
                        2) See previously generated steadings
                        3) Print steading
                        4) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());

                switch (option){
                    case 1 ->{
                        steading = new SteadingClass();
                        SteadingFunctions.rollSteading(steading);
                        System.out.println(steading);
                        steadingList.add(steading);
                    }
                    case 2 -> {
                        int counter = 1;
                        System.out.println("""
                                *** LIST OF STEADINGS ***""");
                        for (SteadingClass s : steadingList){
                            System.out.printf("%d) %s\n", counter, s.getName());
                            counter++;
                        }
                        System.out.println("\n");
                    }
                    case 3 -> {
                        if (steading==null){
                            steading = new SteadingClass();
                            SteadingFunctions.rollSteading(steading);
                            steadingList.add(steading);
                            System.out.println(steading);
                        }
                        SteadingFunctions.exportSteading(steading);
                    }
                    case 4 -> System.out.println("Going back to main menu");

                    }
            }while (option !=4);
        }catch (Exception e){
            System.out.println("An error ocurred: "+e.getMessage());
        }

    }
}
