package service;

import data.DetailsArrays;
import data.DiscoveryArrays;
import data.DungeonArrays;
import domain.*;
import domain.util.Rolls;
import presentation.ViewAll;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DiscoveryFunctions implements IPWService<DiscoveryClass>{

    public static void rollDiscovery(DiscoveryClass discovery){
        discovery.setCategory(DiscoveryArrays.DISCOVERY_CATEGORIES[Rolls.UniversalRoll(DiscoveryArrays.DISCOVERY_CATEGORIES)]);
//        if(discovery.getCategory()!=null) System.out.println("Category stablished"); else System.out.println("Failed trying to set category");
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
//        if(discovery.getSubcategory()!=null) System.out.println("Subategory stablished"); else System.out.println("Failed trying to set subcategory. Category was: "+discovery.getCategory());

        switch (discovery.getSubcategory()){
            case "Divine" -> {discovery.setPromptTable(DiscoveryArrays.DIVINE_PROMPTS);}
            case "Planar" -> {discovery.setPromptTable(DiscoveryArrays.PLANAR_PROMPTS);}
            case "Arcane" -> {discovery.setPromptTable(DiscoveryArrays.ARCANE_PROMPTS);}
            case "Lair" -> {discovery.setPromptTable(DiscoveryArrays.LAIR_PROMPTS);}
            case "Terrain Change" -> {discovery.setPromptTable(DiscoveryArrays.TERRAIN_CHANGE_PROMPTS);}
            case "Water Feature" -> {discovery.setPromptTable(DiscoveryArrays.WATER_FEATURE_PROMPTS);}
            case "Landmark" -> {discovery.setPromptTable(DiscoveryArrays.LANDMARK_PROMPTS);}
            case "Flora/Fauna" -> {discovery.setPromptTable(DiscoveryArrays.FLORA_FAUNA_PROMPTS);}
            case "Resource" -> {discovery.setPromptTable(DiscoveryArrays.RESOURCE_PROMPTS);}
            case "Tracks/Spoor" -> {discovery.setPromptTable(DiscoveryArrays.TRACKS_SPOOR_PROMPTS);}
            case "Remains/Debris" -> {discovery.setPromptTable(DiscoveryArrays.REMAINS_DEBRIS_PROMPTS);}
            case "Stash/Cache" -> {discovery.setPromptTable(DiscoveryArrays.STASH_CACHE_PROMPTS);}
            case "Enigmatic" -> {discovery.setPromptTable(DiscoveryArrays.ENIGMATIC_PROMPTS);}
            case "Infrastructure" -> {discovery.setPromptTable(DiscoveryArrays.INFRASTRUCTURE_PROMPTS);}
            case "Dwelling" -> {discovery.setPromptTable(DiscoveryArrays.DWELLING_PROMPTS);}
            case "Religious" -> {discovery.setPromptTable(DiscoveryArrays.RELIGIOUS_PROMPTS);}
            case "Ruin" -> {discovery.setPromptTable(DiscoveryArrays.RUIN_PROMPTS);}
            case "Steading" -> {discovery.setPromptTable(DiscoveryArrays.STEADING_PROMPTS);}
        }

//        if(discovery.getPromptTable()!=null) System.out.println("Prompt table stablished"); else System.out.println("Failed trying to set prompt table. Subcategory was: "+discovery.getSubcategory());

        discovery.setPrompt(discovery.getPromptTable()[Rolls.UniversalRoll(discovery.getPromptTable())]);

        switch (discovery.getPrompt()){
        case "Lair RUIN" -> {
            String ruin = rollRuins().toLowerCase(Locale.ROOT);
            discovery.setFinalResult("A lair in a "+ruin);
        }
        case "pocket of TERRAIN" -> {
            String terrain = DetailsArrays.TERRAIN[Rolls.UniversalRoll(DetailsArrays.TERRAIN)];
            discovery.setFinalResult("Pocket of "+terrain);
        }
        case "Landmark ODDITY" -> {
            String oddity = CreatureFunctions.rollOddity();
            discovery.setFinalResult("Landmark "+oddity);
        }
        case "notable BEAST" -> {
            String beast = CreatureFunctions.rollBeast();
            discovery.setFinalResult("Notable "+beast);
        }
        case "useful BEAST" -> {
            String beast = CreatureFunctions.rollBeast();
            discovery.setFinalResult("Useful "+beast);
        }
        case "bones of CREATURE" -> {
            CreatureClass c = new CreatureClass();
            CreatureFunctions.rollAttributes(c);
            discovery.setFinalResult(String.format("""
                    Bones of a creature:
                    %s""", c.getPrintableBlock()));
        }
        case "CREATURE carcass" -> {
            CreatureClass c = new CreatureClass();
            CreatureFunctions.rollAttributes(c);
            discovery.setFinalResult(String.format("""
                    Creature carcass:
                    %s""", c.getPrintableBlock()));
        }
        case "Creature" -> {
            CreatureClass c = new CreatureClass();
            CreatureFunctions.rollAttributes(c);
            discovery.setFinalResult(c.getPrintableBlock());
        }
        case "treasure" -> {
            int n1 = Rolls.UniversalRoll(DiscoveryArrays.TREASURE_TABLE);
            int n2 = Rolls.UniversalRoll(DiscoveryArrays.TREASURE_TABLE);
            int n3 = (n1 + n2) / 2;
            discovery.setPrompt(DiscoveryArrays.TREASURE_TABLE[n3]);
        }
        case "Enigmatic ODDITY" -> {
            String oddity = CreatureFunctions.rollOddity();
            discovery.setFinalResult("Enigmatic "+oddity);}

        case "DUNGEON" -> {
            DungeonClass d = new DungeonClass();
            DungeonFunctions.rollDungeon(d);
            discovery.setFinalResult("Dungeon in ruins:\n"+d.toString());
        }
        case "STEADING" -> {
            SteadingClass s = new SteadingClass();
            SteadingFunctions.rollSteading(s);
            discovery.setFinalResult("Steading in ruins:\n"+s.toString());
        }
        case "religious" -> {
            int roll = Rolls.Roll1d8()+4;
            String structure = DiscoveryArrays.RELIGIOUS_PROMPTS[roll];
            discovery.setFinalResult(structure+" in ruins");
        }
        case "dwelling" -> {
            int roll = Rolls.Roll1d8()+4;
            String structure = DiscoveryArrays.DWELLING_PROMPTS[roll];
            discovery.setFinalResult(structure+" in ruins");
        }
        case "infrastructure" -> {
            int roll = Rolls.Roll1d8()+4;
            String structure = DiscoveryArrays.INFRASTRUCTURE_PROMPTS[roll];
            discovery.setFinalResult(structure+" in ruins");
        }

        case "village" -> {
            SteadingClass s = new SteadingClass();
            SteadingFunctions.rollSteading(s,"VILLAGE");
            discovery.setFinalResult(s.toString());
        }
        case "town" -> {
            SteadingClass s = new SteadingClass();
            SteadingFunctions.rollSteading(s,"TOWN");
            discovery.setFinalResult(s.toString());
        }
        case "keep" -> {
            SteadingClass s = new SteadingClass();
            SteadingFunctions.rollSteading(s,"KEEP");
            discovery.setFinalResult(s.toString());
        }
        case "city" -> {
            SteadingClass s = new SteadingClass();
            SteadingFunctions.rollSteading(s,"CITY");
            discovery.setFinalResult(s.toString());
        }
            default -> discovery.setFinalResult(discovery.getPrompt());

        }

        discovery.setOneLiner(discovery.getFinalResult());
    }


    private static String rollRuins(){

        String ruin = DiscoveryArrays.RUIN_PROMPTS[Rolls.UniversalRoll(DiscoveryArrays.RUIN_PROMPTS)];

        switch (ruin) {

            case "DUNGEON" -> {
                DungeonClass d = new DungeonClass();
                DungeonFunctions.rollDungeon(d);
                return String.format("Dungeon in ruins:\n" + d.toString());
            }
            case "STEADING" -> {
                SteadingClass s = new SteadingClass();
                SteadingFunctions.rollSteading(s);
                return String.format("Steading in ruins:\n" + s.toString());
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

    };

    public static void rollDungeonDiscovery(DungeonDiscoveryClass discovery){
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
    public void showOptions(Scanner dataInput, DiscoveryClass discovery, List<DiscoveryClass> discoveryList) {
        int option = 0;
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
                        discovery = new DiscoveryClass();
                        DiscoveryFunctions.rollDiscovery(discovery);
                        discoveryList.add(discovery);
                        System.out.println(discovery);
                    }
                    case 2 -> {
                        if(discovery==null){
                            discovery = new DiscoveryClass();
                            DiscoveryFunctions.rollDiscovery(discovery);
                            discoveryList.add(discovery);
                        }
                        System.out.println(discovery);
                        System.out.println("\n");
                    }
                    case 3 -> discovery = new ViewAll().run(dataInput,discoveryList,discovery,DiscoveryClass.class);
                    case 4 -> {
                        if(discovery==null){
                            discovery = new DiscoveryClass();
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
