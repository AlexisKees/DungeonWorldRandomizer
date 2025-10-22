package service;

import data.DetailsArrays;
import data.DungeonArrays;
import domain.Creature;
import domain.AreaDanger;
import domain.util.Rolls;

import java.util.List;
import java.util.Scanner;

public class DungeonDangerFunctions implements IAllServices<AreaDanger> {

    public static void rollDungeonDanger(AreaDanger danger){
        int roll;

        roll = Rolls.UniversalRoll(DungeonArrays.DUNGEON_DANGER_CATEGORIES);
        danger.setCategory(DungeonArrays.DUNGEON_DANGER_CATEGORIES[roll]);

        switch (danger.getCategory()){
            case "Trap" ->  danger.setPromptTable(DungeonArrays.DUNGEON_DANGER_TRAP_PROMPTS);
            case "Creature" -> danger.setPromptTable(DungeonArrays.DUNGEON_DANGER_CREATURE_PROMPTS);
        }

        roll = Rolls.UniversalRoll(danger.getPromptTable());
        danger.setPrompt(danger.getPromptTable()[roll]);

        switch (danger.getPrompt()) {
            case "based on Element" -> {
                String element = CreatureFunctions.rollElement();
                danger.setFinalResult("Elemental trap. "+element);
            }
            case "based on Magic Type" -> {
                String magicType = CreatureFunctions.rollMagicType();
                danger.setFinalResult("Magical trap.  "+magicType);
            }
            case "based on Oddity" -> {
                String oddity = CreatureFunctions.rollOddity();
                danger.setFinalResult("Oddity trap. "+oddity);
            }
            case "Creature leader/lord (with minions)" -> {
                Creature c = new Creature();
                CreatureFunctions.rollAttributes(c);
                c.setDisposition(DetailsArrays.DISPOSITION[0]); //SET DISPOSITION TO "ATTACKING"
                danger.setFinalResult(c.getPrintableBlock());
            }
            case "Creature" -> {
                Creature c = new Creature();
                CreatureFunctions.rollAttributes(c);
                c.setDisposition(DetailsArrays.DISPOSITION[0]); //SET DISPOSITION TO "ATTACKING"
                CreatureFunctions.setGroupSize(c,"solitary (1)");
                danger.setFinalResult("CREATURE LORD:\n"+c.getPrintableBlock());
            }
            default -> danger.setFinalResult(danger.getPrompt());
        }

        danger.setOneLiner(danger.getFinalResult());

    }

    @Override
    public void showOptions(Scanner dataInput, AreaDanger object, List<AreaDanger> list) {

    }
}
