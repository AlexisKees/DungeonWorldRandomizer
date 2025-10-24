package service;

import data.CreatureArrays;
import data.DetailsArrays;
import domain.Creature;
import domain.util.Rolls;
import presentation.ViewAll;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CreatureFunctions implements IGenericService<Creature> {

    public static String rollOddity(){
        var r1 = Rolls.UniversalRoll(DetailsArrays.ODDITY);
        return switch (DetailsArrays.ODDITY[r1]){
            case "roll twice" -> Rolls.rollTwice(DetailsArrays.ODDITY);
            default -> DetailsArrays.ODDITY[r1];
        };

    }

    public static String rollAberrance(){
        var r1 = Rolls.UniversalRoll(DetailsArrays.ABERRANCE);
        return switch(DetailsArrays.ABERRANCE[r1]){
            case "anatomical oddity" -> "Anatomical "+ rollOddity();
            case "roll twice" -> Rolls.rollTwice(DetailsArrays.ABERRANCE);
            default ->  DetailsArrays.ABERRANCE[r1];
        };
    }

    public static String rollElement(){
        var r1 = Rolls.UniversalRoll(DetailsArrays.ELEMENT);
        return DetailsArrays.ELEMENT[r1];
    }

    public static String rollMagicType(){
        var r1 = Rolls.UniversalRoll(DetailsArrays.MAGIC_TYPE);
        return switch (DetailsArrays.MAGIC_TYPE[r1]){
            case "elemental" -> rollElement();
            default -> DetailsArrays.MAGIC_TYPE[r1];
        };
    }

    public static String rollAspect(){
    var r1 = Rolls.UniversalRoll(DetailsArrays.ASPECT);
    return "(Aspect) " + DetailsArrays.ASPECT[r1];
    }

    public static String rollAbility(){
        var r1 = Rolls.UniversalRoll(DetailsArrays.ABILITY);
        return switch (DetailsArrays.ABILITY[r1]){
            case "based on aspect" ->  "Based on " + rollAspect();
            case "based on element" ->  "Based on " + rollElement();
            case "magic type" ->  "(Magic ability) " + rollMagicType();
            case "roll twice" -> Rolls.rollTwice(DetailsArrays.ABILITY);
            default ->  DetailsArrays.ABILITY[r1];
        };
    }

    public static String rollBeast(){
        var r1 = Rolls.UniversalRoll(CreatureArrays.SUBCATEGORIES_BEAST);
        var beastSubcategory = new String[12];

        beastSubcategory = switch (CreatureArrays.SUBCATEGORIES_BEAST[r1]){
                case "Water-going" -> CreatureArrays.PROMPTS_BEAST_WATER_GOING;
                case "Airborne"-> CreatureArrays.PROMPTS_BEAST_AIRBORNE;
                default -> CreatureArrays.PROMPTS_BEAST_EARTHBOUND;
        };

        var r2 = Rolls.UniversalRoll(beastSubcategory);

        return beastSubcategory[r2];

    }

    public static String rollHumanoid(){
        var r1 = Rolls.UniversalRoll(CreatureArrays.SUBCATEGORIES_HUMANOID);

        String[] humanoidSubcategory = switch (CreatureArrays.SUBCATEGORIES_HUMANOID[r1]){
            case "Rare" -> CreatureArrays.PROMPTS_HUMANOID_RARE;
            case "Uncommon" -> CreatureArrays.PROMPTS_HUMANOID_UNCOMMON;
            default -> CreatureArrays.PROMPTS_HUMANOID_COMMON;
        };

        var r2 = Rolls.UniversalRoll(humanoidSubcategory);


            return switch (humanoidSubcategory[r2]) {
                case "Human+Beast" -> String.join(" ", "Human", rollBeast());
                default -> humanoidSubcategory[r2];
            };



    }

    public static void rollAttributes(Creature creature) {
        //Se asigna tabla de categorías (siempre igual) y de ahí se toma para el length de universalRoll
        creature.setCategoryTable(CreatureArrays.CATEGORIES);
        int r1 = Rolls.UniversalRoll(creature.getCategoryTable());

        // Se extrae el elemento string del array de categorías para impresión
        creature.setCategory(creature.getCategoryTable()[r1]);

        //Se asigna tabla de subcategoría con base en subcategoría obtenida en roll anterior
        assignSubcategoryTable(creature);

        //Se saca número aleatorio basándonos en el largo de la tabla de subcategorías y se asigna String de subcategoría
        int r2 = Rolls.UniversalRoll(creature.getSubcategoryTable());
        creature.setSubcategory(creature.getSubcategoryTable()[r2]);

        //Se asigna tabla de Prompts
        assignPromptTable(creature);

        //Se saca número aleatorio basándonos en el largo de la tabla de prompts y se asigna prompt
        int r3 = Rolls.UniversalRoll(creature.getPromptTable());
        creature.setPrompt(creature.getPromptTable()[r3]);

        reviseRolls(creature);

        rollStats(creature);

        creature.setPrintableBlock();
        creature.setOneLiner(creature.getPrompt());
    }

    private static void assignSubcategoryTable(Creature creature){
        switch (creature.getCategory()) {
            case "Monster" -> creature.setSubcategoryTable(CreatureArrays.SUBCATEGORIES_MONSTER);
            case "Beast" -> creature.setSubcategoryTable(CreatureArrays.SUBCATEGORIES_BEAST);
            default -> creature.setSubcategoryTable(CreatureArrays.SUBCATEGORIES_HUMANOID);
        }

    }

    private static void assignPromptTable(Creature creature){
        switch (creature.getSubcategory()) {
            case "Extraplanar" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_EXTRAPLANAR);
            case "Legendary" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_LEGENDARY);
            case "Undead" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_UNDEAD);
            case "Unusual" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_UNUSUAL);
            case "Beastly" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_BEASTLY);
            case "Humanoid" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_WILD_HUMANOID);
            case "Water-going" -> creature.setPromptTable(CreatureArrays.PROMPTS_BEAST_WATER_GOING);
            case "Airborne" -> creature.setPromptTable(CreatureArrays.PROMPTS_BEAST_AIRBORNE);
            case "Earthbound" -> creature.setPromptTable(CreatureArrays.PROMPTS_BEAST_EARTHBOUND);
            case "Rare" -> creature.setPromptTable(CreatureArrays.PROMPTS_HUMANOID_RARE);
            case "Uncommon" -> creature.setPromptTable(CreatureArrays.PROMPTS_HUMANOID_UNCOMMON);
            case "Common" -> creature.setPromptTable(CreatureArrays.PROMPTS_HUMANOID_COMMON);
            default -> creature.setPromptTable(new String[12]);
        }

    }

    public static void reRollSubcategory(Creature creature) {
        String previousSubcategory = creature.getSubcategory();
        String currentSubcategory;
        do{

            int r1 = Rolls.UniversalRoll(creature.getSubcategoryTable());


            creature.setSubcategory(creature.getSubcategoryTable()[r1]);
            currentSubcategory = creature.getSubcategory();
        } while (Objects.equals(previousSubcategory,currentSubcategory));


                switch (creature.getSubcategory()) {
                    case "Extraplanar" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_EXTRAPLANAR);
                    case "Legendary" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_LEGENDARY);
                    case "Undead" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_UNDEAD);
                    case "Unusual" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_UNUSUAL);
                    case "Beastly" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_BEASTLY);
                    case "Humanoid" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_WILD_HUMANOID);
                    case "Water-going" -> creature.setPromptTable(CreatureArrays.PROMPTS_BEAST_WATER_GOING);
                    case "Airborne" -> creature.setPromptTable(CreatureArrays.PROMPTS_BEAST_AIRBORNE);
                    case "Earthbound" -> creature.setPromptTable(CreatureArrays.PROMPTS_BEAST_EARTHBOUND);
                    case "Rare" -> creature.setPromptTable(CreatureArrays.PROMPTS_HUMANOID_RARE);
                    case "Uncommon" -> creature.setPromptTable(CreatureArrays.PROMPTS_HUMANOID_UNCOMMON);
                    case "Common" -> creature.setPromptTable(CreatureArrays.PROMPTS_HUMANOID_COMMON);
                    default -> creature.setPromptTable(new String[12]);
                }


            //Se asigna prompt
            int r2 = Rolls.UniversalRoll(creature.getPromptTable());
            creature.setPrompt(creature.getPromptTable()[r2]);

        reviseRolls(creature);

        creature.setPrintableBlock();
        creature.setOneLiner(creature.getPrompt());
    }

    public static void reRollPrompt(Creature creature){
        String previousPrompt = creature.getPrompt();
        String currentPrompt;
        do {
            int r1 = Rolls.UniversalRoll(creature.getPromptTable());

            creature.setPrompt(creature.getPromptTable()[r1]);
            reviseRolls(creature);
            creature.setPrintableBlock();
            creature.setOneLiner(creature.getPrompt());
            currentPrompt = creature.getPrompt();
        } while (Objects.equals(previousPrompt,currentPrompt));

    }

    private static void reviseRolls(Creature creature){

        switch (creature.getPrompt()) {
            case "Human+Beast" -> creature.setPrompt(String.join(" ","Human", CreatureFunctions.rollBeast()));
            case "Elemental" -> creature.setPrompt(CreatureFunctions.rollElement() + " elemental");
            case "Huge+oddity" -> creature.setPrompt(String.join(" ", "Huge", CreatureFunctions.rollOddity()));
            case "Dragon+beast" -> creature.setPrompt(String.join(" ", "Dragon", CreatureFunctions.rollBeast()));
            case "Giant+beast" -> creature.setPrompt(String.join(" ", "Giant", CreatureFunctions.rollBeast()));
            case "Huge+beast" -> creature.setPrompt(String.join(" ", "Huge", CreatureFunctions.rollBeast()));
            case "Beast+aberrance" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollBeast(), CreatureFunctions.rollAberrance()));
            case "Beast+element" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollElement(), CreatureFunctions.rollBeast()));
            case "Beast+oddity" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollOddity(), CreatureFunctions.rollBeast()));
            case "Beast+ability" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollAbility(), CreatureFunctions.rollBeast()));
            case "Beast+Beast" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollBeast(), CreatureFunctions.rollBeast()));
            case "Humanoid+Oddity" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollOddity(), CreatureFunctions.rollHumanoid()));
            case "Humanoid+Beast" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollHumanoid(), CreatureFunctions.rollBeast()));
        }
    }

    public static void rollStats(Creature creature){
        creature.setHitPoints(0);
        rollGroupSize(creature);
        rollSize(creature);
        rollArmor(creature);
        rollDamageType(creature);
        rollTags(creature);
        rollAlignment(creature);
        rollDisposition(creature);
        creature.setPrintableBlock();
    }


    private static void rollGroupSize(Creature creature){
        int r1 = Rolls.UniversalRoll(DetailsArrays.NO_APPEARING);
        creature.setGroupSize(DetailsArrays.NO_APPEARING[r1]);

        switch (creature.getGroupSize()){
            case "horde (4d6 per wave)" -> {
                creature.setDamage("1d6");
                creature.setHitPoints(3);
            }
            case "group (1d6+2)" -> {
                creature.setDamage("1d8");
                creature.setHitPoints(6);
            }
            case "solitary (1)" ->{
                creature.setDamage("1d10");
                creature.setHitPoints(12);
            }
        }
    }

    public static void setGroupSize(Creature creature, String groupSize){
        creature.setGroupSize(groupSize);

        switch (creature.getGroupSize()){
            case "horde (4d6 per wave)" -> {
                creature.setDamage("1d6");
                creature.setHitPoints(3);
            }
            case "group (1d6+2)" -> {
                creature.setDamage("1d8");
                creature.setHitPoints(6);
            }
            case "solitary (1)" ->{
                creature.setDamage("1d10");
                creature.setHitPoints(12);
            }
        }
        creature.setPrintableBlock();
    }


    private static void rollSize(Creature creature){
        int r1 = Rolls.UniversalRoll(DetailsArrays.SIZE);
        creature.setSize(DetailsArrays.SIZE[r1]);
        switch (creature.getSize()){
            case "Tiny" -> {
                creature.setDamage(creature.getDamage()+"-2");
                creature.setReach("hand");
            }
            case "Small","Medium-sized" ->
                    creature.setReach("close");

            case "Large" ->{
                creature.setReach("Close, reach");
                creature.setHitPoints(creature.getHitPoints()+4);
                creature.setDamage(creature.getDamage()+"+1");
            }
            case "Huge" -> {
                creature.setReach("Reach");
                creature.setHitPoints(creature.getHitPoints()+8);
                creature.setDamage(creature.getDamage()+"+3");
            }
        }

    }
    private static void rollArmor(Creature creature){
        int r1 = Rolls.UniversalRoll(DetailsArrays.ARMOR);
        creature.setArmorType(DetailsArrays.ARMOR[r1]);
        switch (DetailsArrays.ARMOR[r1]){
            case "Cloth or flesh" -> creature.setArmor(0);
            case "Leathers or thick hides"->  creature.setArmor(1);
            case "Mail or scales" -> creature.setArmor(2);
            case "Plate or bone" -> creature.setArmor(3);
            case "Magical armor" -> creature.setArmor(4);
        }
    }
    private static void rollDamageType(Creature creature){
        int r1 = Rolls.UniversalRoll(DetailsArrays.DAMAGE_TYPE);
        creature.setDamageType(DetailsArrays.DAMAGE_TYPE[r1]);
        switch (creature.getDamageType()){
            case "element" -> {
                String element = DetailsArrays.ELEMENT[Rolls.UniversalRoll(DetailsArrays.ELEMENT)];
                creature.setDamageType("Elemental damage: "+element);
            }
            case "roll twice" -> Rolls.rollTwice(DetailsArrays.DAMAGE_TYPE);
        }
    }
    private static void rollTags(Creature creature){
        int r1 = Rolls.UniversalRoll(DetailsArrays.TAG);
        creature.setTags(DetailsArrays.TAG[r1]);
        switch (creature.getTags()){
            case "roll twice" ->  creature.setTags(Rolls.rollTwice(DetailsArrays.TAG));
            default -> creature.setTags(DetailsArrays.TAG[r1]);
        }

    }

    private static void rollAlignment(Creature creature) {
        int r1 = Rolls.UniversalRoll(DetailsArrays.ALIGNMENT);
        creature.setAlignment(DetailsArrays.ALIGNMENT[r1]);
    }

    private static void rollDisposition(Creature creature) {
        int r1 = Rolls.UniversalRoll(DetailsArrays.DISPOSITION);
        creature.setDisposition(DetailsArrays.DISPOSITION[r1]);
    }


    @Override
    public void showOptions(Scanner dataInput, Creature creature, List<Creature> creatureList) {
        var option = 0;
        System.out.println("WELCOME TO THE CREATURE GENERATOR");

        do {
            try {
                System.out.print("""
                        Please select an option:
                        1) Create new random creature
                        2) Reroll Subcategory
                        3) Reroll Prompt
                        4) Reroll Stats
                        5) View current creature
                        6) View generated creature list
                        7) Export creature
                        8) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option) {
                    case 1 -> {
                        creature = new Creature();
                        CreatureFunctions.rollAttributes(creature);
                        creatureList.add(creature);
                        System.out.println(creature);
                    }
                    case 2 -> {
                        if (creature == null) {
                            creature = new Creature();
                            CreatureFunctions.rollAttributes(creature);
                            creatureList.add(creature);
                        } else {
                            CreatureFunctions.reRollSubcategory(creature);
                            creatureList.add(creature);
                            System.out.println(creature);
                        }
                    }
                    case 3 -> {
                        if (creature == null) {
                            creature = new Creature();
                            CreatureFunctions.rollAttributes(creature);
                        } else {
                            CreatureFunctions.reRollPrompt(creature);
                        }
                        creatureList.add(creature);
                        System.out.println(creature);
                    }
                    case 4 -> {
                        if (creature == null) {
                            creature = new Creature();
                            CreatureFunctions.rollAttributes(creature);
                        } else {
                            CreatureFunctions.rollStats(creature);
                        }
                        creatureList.add(creature);
                        System.out.println(creature);
                    }
                    case 5 -> {
                        if (creature == null) {
                            creature = new Creature();
                            CreatureFunctions.rollAttributes(creature);
                            creatureList.add(creature);
                        }
                        System.out.println(creature);
                    }
                    case 6 -> creature = new ViewAll().run(dataInput,creatureList,creature, Creature.class);
                    case 7 -> {
                        if (creature == null) {
                            creature = new Creature();
                            CreatureFunctions.rollAttributes(creature);
                            creatureList.add(creature);
                        }
                        GenericFunctions.exportPW(creature);
                    }
                    case 8 -> System.out.println("\nReturning to main menu...\n");
                    default -> System.out.print("\nInvalid number!\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nPlease choose a valid option.\n");
            }
        }
        while (option != 8);
    }
}
