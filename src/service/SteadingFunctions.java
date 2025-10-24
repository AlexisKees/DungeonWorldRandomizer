package service;

import data.DetailsArrays;
import data.SteadingArrays;
import domain.Steading;
import domain.util.Rolls;
import presentation.ViewAll;

import java.util.List;
import java.util.Scanner;


public class SteadingFunctions implements IGenericService<Steading> {

    public static void rollSteading(Steading steading){
        steading.setSize(SteadingArrays.SETTLEMENT_SIZE[Rolls.UniversalRoll(SteadingArrays.SETTLEMENT_SIZE)]);
        rollDetails(steading);
    }

    public static void rollSteading(Steading steading, String size){
        steading.setSize(size);
        rollDetails(steading);
    }

    private static void rollDetails(Steading steading){
        steading.setName(SteadingArrays.STEADING_NAMES[Rolls.UniversalRoll(SteadingArrays.STEADING_NAMES)]);
        switch (steading.getSize()){
            case "VILLAGE" ->{
                steading.setTags("Poor, steady, militia, resource (GM's choice)");
                steading.setFeature(SteadingArrays.VILLAGE_FEATURES[Rolls.UniversalRoll(SteadingArrays.VILLAGE_FEATURES)]);
                steading.setProblem(SteadingArrays.VILLAGE_PROBLEMS[Rolls.UniversalRoll(SteadingArrays.VILLAGE_PROBLEMS)]);
            }
            case "TOWN" -> {
                steading.setTags("Moderate, steady, watch, and trade (with 2 places of GM’s choice).");
                steading.setFeature(SteadingArrays.TOWN_FEATURES[Rolls.UniversalRoll(SteadingArrays.TOWN_FEATURES)]);
                steading.setProblem(SteadingArrays.TOWN_PROBLEMS[Rolls.UniversalRoll(SteadingArrays.TOWN_PROBLEMS)]);
            }
            case "KEEP" -> {
                steading.setTags("Poor, steady, militia, resource (GM decides or rolls)");
                steading.setFeature(SteadingArrays.KEEP_FEATURES[Rolls.UniversalRoll(SteadingArrays.KEEP_FEATURES)]);
                steading.setProblem(SteadingArrays.KEEP_PROBLEMS[Rolls.UniversalRoll(SteadingArrays.KEEP_PROBLEMS)]);
            }
            case "CITY"-> {
                steading.setTags("Poor, steady, militia, resource (GM decides or rolls)");
                steading.setFeature(SteadingArrays.CITY_FEATURES[Rolls.UniversalRoll(SteadingArrays.CITY_FEATURES)]);
                steading.setProblem(SteadingArrays.CITY_PROBLEMS[Rolls.UniversalRoll(SteadingArrays.CITY_PROBLEMS)]);
            }
        }

        steading.setRaceOfBuilders(CreatureFunctions.rollHumanoid());
        steading.setAlignment(DetailsArrays.ALIGNMENT[Rolls.UniversalRoll(DetailsArrays.ALIGNMENT)]);
        steading.setDangerLevel(SteadingArrays.DANGER_LEVEL[Rolls.UniversalRoll(SteadingArrays.DANGER_LEVEL)]);
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
