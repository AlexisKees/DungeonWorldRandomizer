package service;

import data.SteadingArrays;
import domain.SteadingClass;
import domain.util.Rolls;

public class SteadinFunctions {

    public static void rollSteading(SteadingClass steading){
//        size
//        tags
//        feature
//        problem
//        raceOfBuilders
//        alignment
//        dangerLevel
        steading.setSize(SteadingArrays.SETTLEMENT_SIZE[Rolls.UniversalRoll(SteadingArrays.SETTLEMENT_SIZE)]);
        switch (steading.getSize()){
            case "VILLAGE" ->{}
            case "TOWN" -> {}
            case "KEEP" -> {}
            case "CITY"-> {}
        }

    }
}
