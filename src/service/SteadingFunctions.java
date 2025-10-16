package service;

import data.DetailsArrays;
import data.SteadingArrays;
import domain.SteadingClass;
import domain.util.Rolls;


public class SteadingFunctions {

    public static void rollSteading(SteadingClass steading){
        steading.setSize(SteadingArrays.SETTLEMENT_SIZE[Rolls.UniversalRoll(SteadingArrays.SETTLEMENT_SIZE)]);
        rollDetails(steading);
    }

    public static void rollSteading(SteadingClass steading, String size){
        steading.setSize(size);
        rollDetails(steading);
    }

    private static void rollDetails(SteadingClass steading){
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

}
