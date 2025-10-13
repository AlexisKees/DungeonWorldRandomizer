package service;

import data.DangerArrays;
import data.DetailsArrays;
import domain.CreatureClass;
import domain.DangerClass;
import domain.DiscoveryClass;
import domain.util.Rolls;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    }

    public static void exportDanger(DangerClass danger) throws IOException {
        String prefix = "Danger_";
        int dangerNumber = 1;
        String fileName = String.format(prefix+"%04d.txt",dangerNumber);
        File file = new File(fileName);

        while (file.exists()){
            dangerNumber++;
            fileName = String.format(prefix+"%04d.txt",dangerNumber);
            file = new File(fileName);
        }

        PrintWriter salida = new PrintWriter(new FileWriter(file, true));
        salida.println(danger);
        salida.close();
    }
}
