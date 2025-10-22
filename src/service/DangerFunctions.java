package service;

import data.DangerArrays;
import data.DetailsArrays;
import domain.*;
import domain.util.Rolls;
import presentation.ViewAll;

import java.util.List;
import java.util.Scanner;

public class DangerFunctions implements IAllServices<Danger> {


    public static void rollDanger(Danger danger){
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
            Creature c = new Creature();
            CreatureFunctions.rollAttributes(c);
            c.setDisposition(DetailsArrays.DISPOSITION[0]); //SET DISPOSITION TO "ATTACKING"
            danger.setFinalResult(c.getPrintableBlock());
        }
            default -> danger.setFinalResult(danger.getPrompt());
        }

        danger.setOneLiner(danger.getFinalResult());

    }



    @Override
    public void showOptions(Scanner dataInput, Danger danger, List<Danger> dangerList) {
        int option = 0;
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
                        danger = new Danger();
                        DangerFunctions.rollDanger(danger);
                        System.out.println(danger);
                    }
                    case 2 -> {
                        if (danger == null){
                            danger = new Danger();
                            DangerFunctions.rollDanger(danger);
                        }
                        System.out.println(danger);
                    }
                    case 3 -> danger = new ViewAll().run(dataInput,dangerList,danger, Danger.class);
                    case 4 -> {
                        if (danger == null){
                            danger = new Danger();
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
