package presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import domain.DangerClass;
import service.DangerFunctions;
import service.GenericFunctions;


public class DangerGenerator {

    public void run(Scanner dataInput, List<DangerClass> dangerList) throws IOException {

        int option = 0;
        DangerClass danger = null;
        System.out.println("WELCOME TO THE DANGER GENERATOR\n");

        try{
            do {
                System.out.print("""
                            Please select an option:
                            1) Create new random danger
                            2) View current danger
                            3) View list of generated dangers
                            4) Export current
                            5) Main menu
                            
                            \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option){
                    case 1 ->{
                        danger = new DangerClass();
                        DangerFunctions.rollDanger(danger);
                        System.out.println(danger);
                    }
                    case 2 -> {
                        if (danger == null){
                            danger = new DangerClass();
                            DangerFunctions.rollDanger(danger);
                        }
                        System.out.println(danger);
                    }
                    case 3 -> danger = new ViewAll().run(dataInput,dangerList,danger,DangerClass.class);
                    case 4 -> {
                        if (danger == null){
                            danger = new DangerClass();
                            DangerFunctions.rollDanger(danger);
                        }
                        GenericFunctions.exportPW(danger);
                    }
                    case 5 -> System.out.println("\nReturning to main menu...\n");

                }
            }while (option !=5);
        }catch (Exception e){
            System.out.println("An error occurred: "+e.getMessage());
        }

    }

}