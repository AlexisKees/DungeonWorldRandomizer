package service;

import data.DungeonArrays;
import domain.AreaDiscovery;
import domain.util.Rolls;

import java.util.List;
import java.util.Scanner;

public class DungeonDiscoveryFunctions implements IGenericService<AreaDiscovery> {

    public static void rollDungeonDiscovery(AreaDiscovery discovery){
        int roll;

        roll = Rolls.UniversalRoll(DungeonArrays.DUNGEON_DISCOVERY_CATEGORIES);
        discovery.setCategory(DungeonArrays.DUNGEON_DISCOVERY_CATEGORIES[roll]);

        switch (discovery.getCategory()){
            case "Feature" ->  discovery.setPromptTable(DungeonArrays.DUNGEON_DISCOVERY_FEATURE_PROMPTS);
            case "Find" -> discovery.setPromptTable(DungeonArrays.DUNGEON_DISCOVERY_FIND_PROMPTS);
        }

        roll = Rolls.UniversalRoll(discovery.getPromptTable());
        discovery.setPrompt(discovery.getPromptTable()[roll]);

        switch (discovery.getPrompt()) {

            case "roll 1d8, add magic type" -> {
                roll = Rolls.Roll1d8();
                String magicType = CreatureFunctions.rollMagicType();
                discovery.setFinalResult(discovery.getPromptTable()[roll]+". "+magicType);
            }
            case "roll feature, add magic type" -> {
                roll = Rolls.UniversalRoll(DungeonArrays.DUNGEON_DISCOVERY_FEATURE_PROMPTS);
                String feature = DungeonArrays.DUNGEON_DISCOVERY_FEATURE_PROMPTS[roll];
                String magicType = CreatureFunctions.rollMagicType();
                discovery.setFinalResult(feature+". "+magicType);
            }
            case "roll 1d10 twice, combine" -> {
                roll = Rolls.Roll1d10();
                String find1 = discovery.getPromptTable()[roll];
                roll = Rolls.Roll1d10();
                String find2 = discovery.getPromptTable()[roll];
                discovery.setFinalResult(find1+" + "+find2);
            }
            default -> discovery.setFinalResult(discovery.getPrompt());
        }

        discovery.setOneLiner(discovery.getFinalResult());

    }

    @Override
    public void showOptions(Scanner dataInput, AreaDiscovery object, List<AreaDiscovery> list) {

    }
}
