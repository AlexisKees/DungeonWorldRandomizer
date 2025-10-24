package service;

import data.DetailsArrays;
import data.SteadingArrays;
import domain.Steading;
import presentation.ViewAll;

import java.util.List;
import java.util.Scanner;

import static domain.util.Rolls.PickFrom;


public class SteadingFunctions implements IGenericService<Steading> {

    public static void rollSteading(Steading steading){
        steading.setSize(PickFrom(SteadingArrays.SETTLEMENT_SIZE));
        rollDetails(steading);
    }

    public static void rollSteading(Steading steading, String size){
        steading.setSize(size);
        rollDetails(steading);
    }

    private static void rollDetails(Steading steading){
        steading.setName(PickFrom(SteadingArrays.STEADING_NAMES));
        switch (steading.getSize()){
            case "VILLAGE" ->{
                steading.setTags("Poor, steady, militia, resource (GM's choice)");
                steading.setFeature(PickFrom(SteadingArrays.VILLAGE_FEATURES));
                steading.setProblem(PickFrom(SteadingArrays.VILLAGE_PROBLEMS));
            }
            case "TOWN" -> {
                steading.setTags("Moderate, steady, watch, and trade (with 2 places of GM’s choice).");
                steading.setFeature(PickFrom(SteadingArrays.TOWN_FEATURES));
                steading.setProblem(PickFrom(SteadingArrays.TOWN_PROBLEMS));
            }
            case "KEEP" -> {
                steading.setTags("Poor, steady, militia, resource (GM decides or rolls)");
                steading.setFeature(PickFrom(SteadingArrays.KEEP_FEATURES));
                steading.setProblem(PickFrom(SteadingArrays.KEEP_PROBLEMS));
            }
            case "CITY"-> {
                steading.setTags("Poor, steady, militia, resource (GM decides or rolls)");
                steading.setFeature(PickFrom(SteadingArrays.CITY_FEATURES));
                steading.setProblem(PickFrom(SteadingArrays.CITY_PROBLEMS));
            }
        }

        steading.setRaceOfBuilders(CreatureFunctions.rollHumanoid());
        steading.setAlignment(PickFrom(DetailsArrays.ALIGNMENT));
        steading.setDangerLevel(PickFrom(SteadingArrays.DANGER_LEVEL));
        steading.setOneLiner(steading.getName()+", "+steading.getRaceOfBuilders()+" "+steading.getSize());
    }

    @Override
    public void showOptions(Scanner dataInput, Steading steading, List<Steading> steadingList) {
        int option;
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
                        steading = new Steading();
                        SteadingFunctions.rollSteading(steading);
                        steadingList.add(steading);
                        System.out.println(steading);
                    }
                    case 2 -> {
                        if (steading == null) {
                            steading = new Steading();
                            SteadingFunctions.rollSteading(steading);
                            System.out.println(steading);
                            steadingList.add(steading);
                        }
                        System.out.println(steading);
                    }
                    case 3 -> steading = new ViewAll().run(dataInput, steadingList, steading, Steading.class);
                    case 4 -> {
                        if (steading == null) {
                            steading = new Steading();
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
            System.out.println("\nPlease choose a valid option.\n");
        }
    }
}
