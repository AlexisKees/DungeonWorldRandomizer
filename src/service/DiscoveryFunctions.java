package service;

import data.DetailsArrays;
import data.DiscoveryArrays;
import domain.*;
import domain.util.Rolls;
import presentation.ViewAll;

import java.util.List;
import java.util.Scanner;

public class DiscoveryFunctions implements IGenericService<Discovery> {

    public static void rollDiscovery(Discovery discovery){
        discovery.setCategory(DiscoveryArrays.DISCOVERY_CATEGORIES[Rolls.UniversalRoll(DiscoveryArrays.DISCOVERY_CATEGORIES)]);
//        if(discovery.getCategory()!=null) System.out.println("Category established"); else System.out.println("Failed trying to set category");
        switch (discovery.getCategory()){
             case "UNNATURAL FEATURE" -> discovery.setSubcategoriesTable(DiscoveryArrays.UNNATURAL_FEATURE_SUBCATEGORIES);
             case "NATURAL FEATURE" -> discovery.setSubcategoriesTable(DiscoveryArrays.NATURAL_FEATURE_SUBCATEGORIES);
             case "EVIDENCE" -> discovery.setSubcategoriesTable(DiscoveryArrays.EVIDENCE_SUBCATEGORIES);
             case "CREATURE" -> {
                 discovery.setSubcategoriesTable(DiscoveryArrays.CREATURE_SUBCATEGORIES);
                 discovery.setPromptTable(DiscoveryArrays.CREATURE_SUBCATEGORIES);
                 discovery.setPrompt("Creature");
             }
             case "STRUCTURE" -> discovery.setSubcategoriesTable(DiscoveryArrays.STRUCTURE_SUBCATEGORIES);
        }

        discovery.setSubcategory(discovery.getSubcategoriesTable()[Rolls.UniversalRoll(discovery.getSubcategoriesTable())]);
//        if(discovery.getSubcategory()!=null) System.out.println("Subcategory established"); else System.out.println("Failed trying to set subcategory. Category was: "+discovery.getCategory());

        switch (discovery.getSubcategory()){
            case "Divine" -> discovery.setPromptTable(DiscoveryArrays.DIVINE_PROMPTS);
            case "Planar" -> discovery.setPromptTable(DiscoveryArrays.PLANAR_PROMPTS);
            case "Arcane" -> discovery.setPromptTable(DiscoveryArrays.ARCANE_PROMPTS);
            case "Lair" -> discovery.setPromptTable(DiscoveryArrays.LAIR_PROMPTS);
            case "Terrain Change" -> discovery.setPromptTable(DiscoveryArrays.TERRAIN_CHANGE_PROMPTS);
            case "Water Feature" -> discovery.setPromptTable(DiscoveryArrays.WATER_FEATURE_PROMPTS);
            case "Landmark" -> discovery.setPromptTable(DiscoveryArrays.LANDMARK_PROMPTS);
            case "Flora" -> discovery.setPromptTable(DiscoveryArrays.FLORA_PROMPTS);
            case "Fauna" -> discovery.setPromptTable(DiscoveryArrays.FAUNA_PROMPTS);
            case "Resource" -> discovery.setPromptTable(DiscoveryArrays.RESOURCE_PROMPTS);
            case "Tracks" -> discovery.setPromptTable(DiscoveryArrays.TRACKS_PROMPTS);
            case "Remains" -> discovery.setPromptTable(DiscoveryArrays.REMAINS_PROMPTS);
            case "Debris" -> discovery.setPromptTable(DiscoveryArrays.DEBRIS_PROMPTS);
            case "Stash" -> discovery.setPromptTable(DiscoveryArrays.STASH_PROMPTS);
            case "Enigmatic" -> discovery.setPromptTable(DiscoveryArrays.ENIGMATIC_PROMPTS);
            case "Infrastructure" -> discovery.setPromptTable(DiscoveryArrays.INFRASTRUCTURE_PROMPTS);
            case "Dwelling" -> discovery.setPromptTable(DiscoveryArrays.DWELLING_PROMPTS);
            case "Religious" -> discovery.setPromptTable(DiscoveryArrays.RELIGIOUS_PROMPTS);
            case "Ruin" -> discovery.setPromptTable(DiscoveryArrays.RUIN_PROMPTS);
            case "Steading" -> discovery.setPromptTable(DiscoveryArrays.STEADING_PROMPTS);
        }

        discovery.setPrompt(discovery.getPromptTable()[Rolls.UniversalRoll(discovery.getPromptTable())]);

        switch (discovery.getPrompt()){
            case "Lair RUIN" -> {
                String ruin = rollRuins().toLowerCase();
                discovery.setFinalResult("A lair in a "+ruin);
                discovery.setOneLiner(discovery.getFinalResult());
            }
            case "pocket of TERRAIN" -> {
                String terrain = DetailsArrays.TERRAIN[Rolls.UniversalRoll(DetailsArrays.TERRAIN)];
                discovery.setFinalResult("Pocket of "+terrain);
                discovery.setOneLiner(discovery.getFinalResult());
            }
            case "Landmark ODDITY" -> {
                String oddity = CreatureFunctions.rollOddity();
                discovery.setFinalResult("Landmark "+oddity);
                discovery.setOneLiner(discovery.getFinalResult());
            }
            case "notable BEAST" -> {
                String beast = CreatureFunctions.rollBeast();
                discovery.setFinalResult("Notable "+beast);
                discovery.setOneLiner(discovery.getFinalResult());
            }
            case "useful BEAST" -> {
                String beast = CreatureFunctions.rollBeast();
                discovery.setFinalResult("Useful "+beast);
                discovery.setOneLiner(discovery.getFinalResult());
            }
            case "bones of CREATURE" -> {
                Creature c = new Creature();
                CreatureFunctions.rollAttributes(c);
                discovery.setFinalResult(String.format("""
                        Bones of a creature:
                        %s""", c.getPrintableBlock()));
                discovery.setOneLiner("Bones of a "+c.getOneLiner());
            }
            case "CREATURE carcass" -> {
                Creature c = new Creature();
                CreatureFunctions.rollAttributes(c);
                discovery.setFinalResult(String.format("""
                        Creature carcass:
                        %s""", c.getPrintableBlock()));
                discovery.setOneLiner("Carcass of a "+c.getOneLiner());
            }
            case "Creature" -> {
                Creature c = new Creature();
                CreatureFunctions.rollAttributes(c);
                discovery.setFinalResult(c.getPrintableBlock());
                discovery.setOneLiner(c.getOneLiner());
            }
            case "treasure" -> {
                int n1 = Rolls.UniversalRoll(DiscoveryArrays.TREASURE_TABLE);
                int n2 = Rolls.UniversalRoll(DiscoveryArrays.TREASURE_TABLE);
                int n3 = (n1 + n2) / 2;
                discovery.setPrompt(DiscoveryArrays.TREASURE_TABLE[n3]);
                discovery.setOneLiner(discovery.getFinalResult());
            }
            case "Enigmatic ODDITY" -> {
                String oddity = CreatureFunctions.rollOddity();
                discovery.setFinalResult("Enigmatic "+oddity);
                discovery.setOneLiner(discovery.getFinalResult());
            }
            case "DUNGEON" -> {
                Dungeon d = new Dungeon();
                DungeonFunctions.rollDungeon(d);
                discovery.setFinalResult("Dungeon in ruins:\n"+d);
                discovery.setOneLiner("Dungeon in ruins: "+d.getName());
            }
            case "STEADING" -> {
                Steading s = new Steading();
                SteadingFunctions.rollSteading(s);
                discovery.setFinalResult("Steading in ruins:\n"+s);
                discovery.setOneLiner("Steading in ruins: "+s.getName());
            }
            case "religious" -> {
                int roll = Rolls.Roll1d8()+4;
                String structure = DiscoveryArrays.RELIGIOUS_PROMPTS[roll];
                discovery.setFinalResult(structure+" in ruins");
                discovery.setOneLiner(discovery.getFinalResult());
            }
            case "dwelling" -> {
                int roll = Rolls.Roll1d8()+4;
                String structure = DiscoveryArrays.DWELLING_PROMPTS[roll];
                discovery.setFinalResult(structure+" in ruins");
                discovery.setOneLiner(discovery.getFinalResult());
            }
            case "infrastructure" -> {
                int roll = Rolls.Roll1d8()+4;
                String structure = DiscoveryArrays.INFRASTRUCTURE_PROMPTS[roll];
                discovery.setFinalResult(structure+" in ruins");
                discovery.setOneLiner(discovery.getFinalResult());
            }
            case "village" -> {
                Steading s = new Steading();
                SteadingFunctions.rollSteading(s,"VILLAGE");
                discovery.setFinalResult(s.toString());
                discovery.setOneLiner("Village: "+s.getName());
            }
            case "town" -> {
                Steading s = new Steading();
                SteadingFunctions.rollSteading(s,"TOWN");
                discovery.setFinalResult(s.toString());
                discovery.setOneLiner("Town: "+s.getName());
            }
            case "keep" -> {
                Steading s = new Steading();
                SteadingFunctions.rollSteading(s,"KEEP");
                discovery.setFinalResult(s.toString());
                discovery.setOneLiner("Keep: "+s.getName());
            }
            case "city" -> {
                Steading s = new Steading();
                SteadingFunctions.rollSteading(s,"CITY");
                discovery.setFinalResult(s.toString());
                discovery.setOneLiner("City: "+s.getName());
            }
            default -> {
                discovery.setFinalResult(discovery.getPrompt());
                discovery.setOneLiner(discovery.getFinalResult());
            }

        }


    }


    private static String rollRuins(){

        String ruin = DiscoveryArrays.RUIN_PROMPTS[Rolls.UniversalRoll(DiscoveryArrays.RUIN_PROMPTS)];

        switch (ruin) {

            case "DUNGEON" -> {
                Dungeon d = new Dungeon();
                DungeonFunctions.rollDungeon(d);
                return String.format("Dungeon in ruins:\n" + d);
            }
            case "STEADING" -> {
                Steading s = new Steading();
                SteadingFunctions.rollSteading(s);
                return String.format("Steading in ruins:\n" + s);
            }
            case "religious" -> {
                int roll = Rolls.Roll1d8() + 4;
                String structure = DiscoveryArrays.RELIGIOUS_PROMPTS[roll];
                return String.format(structure + " in ruins");
            }
            case "dwelling" -> {
                int roll = Rolls.Roll1d8() + 4;
                String structure = DiscoveryArrays.DWELLING_PROMPTS[roll];
                return String.format(structure + " in ruins");
            }
            case "infrastructure" -> {
                int roll = Rolls.Roll1d8() + 4;
                String structure = DiscoveryArrays.INFRASTRUCTURE_PROMPTS[roll];
                return String.format(structure + " in ruins");
            }
        }

        return ruin;

    }



    @Override
    public void showOptions(Scanner dataInput, Discovery discovery, List<Discovery> discoveryList) {
        int option;
        System.out.println("WELCOME TO THE DISCOVERY GENERATOR\n");

        try{
            do {
                System.out.print("""
                        Please select an option:
                        1) Create new random discovery
                        2) View current discovery
                        3) View list of generated discoveries
                        4) Export current
                        5) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option){
                    case 1 ->{
                        discovery = new Discovery();
                        DiscoveryFunctions.rollDiscovery(discovery);
                        discoveryList.add(discovery);
                        System.out.println(discovery);
                    }
                    case 2 -> {
                        if(discovery==null){
                            discovery = new Discovery();
                            DiscoveryFunctions.rollDiscovery(discovery);
                            discoveryList.add(discovery);
                        }
                        System.out.println(discovery);
                        System.out.println("\n");
                    }
                    case 3 -> discovery = new ViewAll().run(dataInput,discoveryList,discovery, Discovery.class);
                    case 4 -> {
                        if(discovery==null){
                            discovery = new Discovery();
                            DiscoveryFunctions.rollDiscovery(discovery);
                            discoveryList.add(discovery);
                        }
                        GenericFunctions.exportPW(discovery);
                    }
                    case 5 -> System.out.println("\nReturning to main menu...\n");

                }
            }while (option !=5);
        }catch (Exception e){
            System.out.println("An error occurred: "+e.getMessage());
        }
    }


}
