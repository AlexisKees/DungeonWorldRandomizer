package presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import domain.DangerClass;
import domain.DangerClass;
import domain.PerilousWildsInterface;
import service.DangerFunctions;
import service.DiscoveryFunctions;


public class DangerGenerator {

    public void run(Scanner dataInput, List<DangerClass> dangerList) throws IOException {

        int option = 0;
        DangerClass danger = null;
        System.out.println("WELCOME TO THE DANGER GENERATOR");

        try{
            do {
                System.out.print("""
                            Please select an option:
                            1) Create new random danger
                            2) See previously generated dangers
                            3) Print danger
                            4) Main menu
                            
                            \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());

                switch (option){
                    case 1 ->{
                        danger = new DangerClass();
                        DangerFunctions.rollDanger(danger);
                        System.out.println(danger);
                    }
                    case 2 -> {
                        int counter = 1;
                        System.out.println("""
                                    *** LIST OF DANGERS ***""");
                        for (DangerClass d : dangerList){
                            System.out.printf("%d) %s\n", counter, d.getFinalResult());
                            counter++;
                        }
                        System.out.println("\n");
                    }
                    case 3 -> {
                        if (danger==null){
                            danger = new DangerClass();
                            DangerFunctions.rollDanger(danger);
                            System.out.println(danger);
                        }
                        DangerFunctions.exportDanger(danger);
                        System.out.println("""
                                ***********************
                                *  Check your files!  *
                                ***********************
                                """);
                    }
                    case 4 -> System.out.println("Going back to main menu");

                }
            }while (option !=4);
        }catch (Exception e){
            System.out.println("An error occurred: "+e.getMessage());
        }

    }

}