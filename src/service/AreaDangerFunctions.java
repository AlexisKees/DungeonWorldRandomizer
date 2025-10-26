package service;

import data.DetailsArrays;
import data.DungeonArrays;
import domain.Creature;
import domain.AreaDanger;

import java.util.List;
import java.util.Scanner;

import static domain.util.Rolls.PickFrom;

public class AreaDangerFunctions implements IGenericService<AreaDanger> {

    public static void rollAreaDanger(AreaDanger danger){
        danger.setCategory(PickFrom(DungeonArrays.DUNGEON_DANGER_CATEGORIES));

        switch (danger.getCategory()){
            case "Trap" ->  danger.setPromptTable(DungeonArrays.DUNGEON_DANGER_TRAP_PROMPTS);
            case "Creature" -> danger.setPromptTable(DungeonArrays.DUNGEON_DANGER_CREATURE_PROMPTS);
        }

        danger.setPrompt(PickFrom(danger.getPromptTable()));
        switch (danger.getPrompt()) {
            case "based on Element" -> {
                String element = CreatureFunctions.rollElement();
                danger.setFinalResult(element+"trap");
                danger.setOneLiner(danger.getFinalResult());
            }
            case "based on Magic Type" -> {
                String magicType = CreatureFunctions.rollMagicType();
                danger.setFinalResult("Magic "+magicType+" trap");
                danger.setOneLiner(danger.getFinalResult());
            }
            case "based on Oddity" -> {
                String oddity = CreatureFunctions.rollOddity();
                danger.setFinalResult(oddity+" trap");
                danger.setOneLiner(danger.getFinalResult());
            }
            case "Creature leader (with minions)" -> {
                Creature c = new Creature();
                CreatureFunctions.rollAttributes(c);
                CreatureFunctions.setGroupSize(c,"solitary (1)");
                c.setDisposition(DetailsArrays.DISPOSITION[0]); //SET DISPOSITION TO "ATTACKING"
                danger.setFinalResult("CREATURE LEADER:\n"+c);
                danger.setOneLiner(c.getOneLiner()+" leader");
            }
            case "Creature lord (with minions)" ->{
                Creature c = new Creature();
                CreatureFunctions.rollAttributes(c);
                c.setDisposition(DetailsArrays.DISPOSITION[0]); //SET DISPOSITION TO "ATTACKING"
                CreatureFunctions.setGroupSize(c,"solitary (1)");
                danger.setFinalResult("CREATURE LORD:\n"+c);
                danger.setFinalResult(c.toString());
                danger.setOneLiner(c.getOneLiner()+" lord");
            }
            case "Creature" -> {
                Creature c = new Creature();
                CreatureFunctions.rollAttributes(c);
                c.setDisposition(DetailsArrays.DISPOSITION[0]); //SET DISPOSITION TO "ATTACKING"
                danger.setFinalResult("CREATURE:\n"+c);
                danger.setOneLiner(c.getOneLiner());
            }
            default -> {
                if (danger.getCategory().equals("Trap")) danger.setFinalResult(danger.getPrompt()+" trap.");
                else danger.setFinalResult(danger.getPrompt());

                danger.setOneLiner(danger.getFinalResult());
            }
        }



    }

    @Override
    public void showOptions(Scanner dataInput, AreaDanger object, List<AreaDanger> list) {

    }
}
