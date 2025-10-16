package service;

import data.DangerArrays;
import data.DetailsArrays;
import data.DungeonArrays;
import domain.CreatureClass;
import domain.DangerClass;
import domain.DungeonDangerClass;
import domain.util.Rolls;

public class DangerFunctions {

    public static void rollDanger(DangerClass danger){
        int roll;

        roll = Rolls.UniversalRoll(DangerArrays.DANGER_CATEGORIES);
        danger.setCategory(DangerArrays.DANGER_CATEGORIES[roll]);

        switch (danger.getCategory()){
            case "UNNATURAL ENTITY" ->  danger.setSubcategoriesTable(DangerArrays.UNNATURAL_ENTITY_SUBCATEGORIES);
            case "HAZARD" -> danger.setSubcategoriesTable(DangerArrays.HAZARD_SUBCATEGORIES);
            case "CREATURE" -> danger.setSubcategoriesTable(DangerArrays.CREATURE_SUBCATEGORIES);
        }

        roll = Rolls.UniversalRoll(danger.getSubcategoriesTable());
        danger.setSubcategory(danger.getSubcategoriesTable()[roll]);

        switch (danger.getSubcategory()){
            case "Divine" -> danger.setPromptTable(DangerArrays.DIVINE_PROMPTS);
            case "Planar" -> danger.setPromptTable(DangerArrays.PLANAR_PROMPTS);
            case "Undead" -> danger.setPromptTable(DangerArrays.UNDEAD_PROMPTS);
            case "Unnatural" -> danger.setPromptTable(DangerArrays.UNNATURAL_PROMPTS);
            case "Natural" -> danger.setPromptTable(DangerArrays.NATURAL_PROMPTS);
            case "Creature" -> danger.setPromptTable(DangerArrays.CREATURE_SUBCATEGORIES);
        }

        roll = Rolls.UniversalRoll(danger.getPromptTable());
        danger.setPrompt(danger.getPromptTable()[roll]);

        switch (danger.getPrompt()) {
        case "lesser demon/elemental" -> {
            String element = CreatureFunctions.rollElement();
            danger.setFinalResult("lesser demon/ "+element+" elemental");
        }
        case "demon/elemental" -> {
            String element = CreatureFunctions.rollElement();
            danger.setFinalResult("demon/ "+element+" elemental");
        }
        case "greater demon/elemental" -> {
            String element = CreatureFunctions.rollElement();
            danger.setFinalResult("Greater demon/ "+element+" elemental");
        }
        case "devil/elemental lord" -> {
            String element = CreatureFunctions.rollElement();
            danger.setFinalResult("Demon / "+element+" elemental Lord");
        }
        case "magical: natural + MAGIC TYPE" -> {
            String magicType = CreatureFunctions.rollMagicType();
            danger.setFinalResult("Magical natural phenomenon: "+magicType);
        }
        case "planar: natural + ELEMENT" -> {
            String magicType = CreatureFunctions.rollMagicType();
            danger.setFinalResult("Planar natural phenomenon: "+magicType);
        }
        case "divine: natural + deity" -> {}
        case "oddity-based" -> {
            String oddity = CreatureFunctions.rollOddity();
            danger.setFinalResult("Natural "+oddity.toLowerCase());
        }
        case "Creature"->{
            CreatureClass c = new CreatureClass();
            CreatureFunctions.rollAttributes(c);
            c.setDisposition(DetailsArrays.DISPOSITION[0]); //SET DISPOSITION TO "ATTACKING"
            danger.setFinalResult(c.getPrintableBlock());
        }
            default -> danger.setFinalResult(danger.getPrompt());
        }

        danger.setOneLiner(danger.getFinalResult());

    }

    public static void rollDungeonDanger(DungeonDangerClass danger){
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
                CreatureClass c = new CreatureClass();
                CreatureFunctions.rollAttributes(c);
                c.setDisposition(DetailsArrays.DISPOSITION[0]); //SET DISPOSITION TO "ATTACKING"
                danger.setFinalResult(c.getPrintableBlock());
            }
            case "Creature" -> {
                CreatureClass c = new CreatureClass();
                CreatureFunctions.rollAttributes(c);
                c.setDisposition(DetailsArrays.DISPOSITION[0]); //SET DISPOSITION TO "ATTACKING"
                CreatureFunctions.setGroupSize(c,"solitary (1)");
                danger.setFinalResult("CREATURE LORD:\n"+c.getPrintableBlock());
            }
            default -> danger.setFinalResult(danger.getPrompt());
        }

        danger.setOneLiner(danger.getFinalResult());

    }

}
