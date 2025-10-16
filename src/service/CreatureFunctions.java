package service;

import data.CreatureArrays;
import data.DetailsArrays;
import domain.CreatureClass;
import domain.util.Rolls;


import java.util.Arrays;

public class CreatureFunctions {

    public static String rollOddity(){
        var r1 = Rolls.UniversalRoll(DetailsArrays.ODDITY);
        String result;
        switch (r1){
            case 10,11 -> {
                var r2 = Rolls.Roll1d10();
                var r3 = Rolls.Roll1d10();
                result = "Oddity: " + DetailsArrays.ODDITY[r2] + " , " + DetailsArrays.ODDITY[r3];
            }
            default -> result = "Oddity: " + DetailsArrays.ODDITY[r1];
        }
        return result;
    }

    public static String rollAberrance(){
        var r1 = Rolls.UniversalRoll(DetailsArrays.ABERRANCE);
        String result;
        switch (r1){
            case 2,3 -> {
                var oddity = rollOddity();
                result = "Anatomical "+oddity;
            }
            case 10,11 ->{
                var r2 = Rolls.Roll1d10();
                var r3 = Rolls.Roll1d10();
                result = String.join(" ","Aberrance: " ,DetailsArrays.ABERRANCE[r2],",",DetailsArrays.ABERRANCE[r3]);
            }
            default -> result = "Aberrance: " + DetailsArrays.ABERRANCE[r1];
        }
        return result;
    }

    public static String rollElement(){
        var r1 = Rolls.UniversalRoll(DetailsArrays.ELEMENT);
        return "Element: " + DetailsArrays.ELEMENT[r1];
    }

    public static String rollMagicType(){
        var r1 = Rolls.UniversalRoll(DetailsArrays.MAGIC_TYPE);
        String result;
        switch (r1){
            case 8,9 -> result = "Magic type: " + rollElement();
            default -> result = "Magic type: " + DetailsArrays.MAGIC_TYPE[r1];
        }
        return result;
    }

    public static String rollAspect(){
    var r1 = Rolls.UniversalRoll(DetailsArrays.ASPECT);
    return "(Aspect) " + DetailsArrays.ASPECT[r1];
    }

    public static String rollAbility(){
        var r1 = Rolls.UniversalRoll(DetailsArrays.ABILITY);
        String result;
        switch (r1){
            case 7 -> result = "Based on " + rollAspect();
            case 8 -> result = "Based on " + rollElement();
            case 10 -> result = "(Magic ability) " + rollMagicType();
            case 11 -> {
                var r2 = Rolls.Roll1d10()+1;
                var r3 = Rolls.Roll1d10()+1;
                result = String.join(" ","(Abilities)",DetailsArrays.ABILITY[r2], "and", DetailsArrays.ABILITY[r3]);
            }
            default -> result = "(Ability)" + DetailsArrays.ABILITY[r1];
        }
        return result;
    }

    public static String rollBeast(){
        var r1 = Rolls.UniversalRoll(CreatureArrays.SUBCATEGORIES_BEAST);
        var beastSubcategory = new String[12];

        beastSubcategory = switch (r1){
                case 0, 1 -> CreatureArrays.PROMPTS_BEAST_WATER_GOING;
                case 2, 3, 4 -> CreatureArrays.PROMPTS_BEAST_AIRBORNE;
                case 5, 6, 7, 8, 9, 10, 11 -> CreatureArrays.PROMPTS_BEAST_EARTHBOUND;
                default -> new String[12];
        };

        var r2 = Rolls.UniversalRoll(beastSubcategory);

        return beastSubcategory[r2];

    }

    public static String rollHumanoid(){
        var r1 = Rolls.UniversalRoll(CreatureArrays.SUBCATEGORIES_HUMANOID);

        String[] humanoidSubcategory = switch (r1){
            case 0 -> CreatureArrays.PROMPTS_HUMANOID_RARE;
            case 1,2, 3, 4 -> CreatureArrays.PROMPTS_HUMANOID_UNCOMMON;
            case 5, 6, 7, 8, 9, 10, 11 -> CreatureArrays.PROMPTS_HUMANOID_COMMON;
            default -> new String[12];
        };
        var r2 = Rolls.UniversalRoll(humanoidSubcategory);
        if (Arrays.equals(humanoidSubcategory, CreatureArrays.PROMPTS_HUMANOID_UNCOMMON)){
            return switch (r2) {
                case 0, 1, 2 -> String.join(" ", "Human", rollBeast());
                default -> humanoidSubcategory[r2];
            };
        } else {
            return humanoidSubcategory[r2];
        }


    }































    public static void rollAttributes(CreatureClass creature) {
        //Se asigna tabla de categorías (siempre igual) y de ahí se toma para el length de universalRoll
        creature.setCategoryTable(CreatureArrays.CATEGORIES);
        int r1 = Rolls.UniversalRoll(creature.getCategoryTable());

        // Se extrae el elemento string del array de categorías para impresión
        creature.setCategory(creature.getCategoryTable()[r1]);

        //Se asigna tabla de subcategoría en base a subcategoría obtenida en roll anterior
        assignSubcategoryTable(creature);

        //Se saca número aleatorio en base al largo de la tabla de subcategorías y se asigna String de subcategoría
        int r2 = Rolls.UniversalRoll(creature.getSubcategoryTable());
        creature.setSubcategory(creature.getSubcategoryTable()[r2]);

        //Se asigna tabla de Prompts
        assignPromptTable(creature);

        //Se saca número aleatorio en base al largo de la tabla de prompts y se asigna prompt
        int r3 = Rolls.UniversalRoll(creature.getPromptTable());
        creature.setPrompt(creature.getPromptTable()[r3]);

        reviseRolls(creature);

        rollStats(creature);

        creature.setPrintableBlock(String.format("""
                    Creature category: %s
                    Creature subcategory: %s
                    Creature prompt: %s
                    Group size: %s
                    Individual size: %s
                    %dHP (%d armor: %s)
                    %s damage (%s, %s)
                    Tags: %s
                    Alignment: %s
                    Disposition: %s
                        """, creature.getCategory(), creature.getSubcategory(), creature.getPrompt(),creature.getGroupSize(),creature.getSize(),creature.getHitPoints(),creature.getArmor(),creature.getArmorType(),
                    creature.getDamage(),creature.getReach(),creature.getDamageType(),creature.getTags(),creature.getAlignment(),creature.getDisposition()));
        creature.setOneLiner(creature.getPrompt());
    }



    private static void assignSubcategoryTable(CreatureClass creature){
        switch (creature.getCategory()) {
            case "Monster" -> creature.setSubcategoryTable(CreatureArrays.SUBCATEGORIES_MONSTER);
            case "Beast" -> creature.setSubcategoryTable(CreatureArrays.SUBCATEGORIES_BEAST);
            default -> creature.setSubcategoryTable(CreatureArrays.SUBCATEGORIES_HUMANOID);
        };

    }

    private static void assignPromptTable(CreatureClass creature){
        if (Arrays.equals(creature.getSubcategoryTable(), CreatureArrays.SUBCATEGORIES_MONSTER)) {
            switch (creature.getSubcategory()) {
                case "Extraplanar" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_EXTRAPLANAR);
                case "Legendary" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_LEGENDARY);
                case "Undead" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_UNDEAD);
                case "Unusual" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_UNUSUAL);
                case "Beastly" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_BEASTLY);
                case "Wild humanoid" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_WILD_HUMANOID);
                default -> creature.setPromptTable(new String[12]);

            }
        } else if (Arrays.equals(creature.getSubcategoryTable(), CreatureArrays.SUBCATEGORIES_BEAST)) {
            switch (creature.getSubcategory()) {
                case "Water-going" -> creature.setPromptTable(CreatureArrays.PROMPTS_BEAST_WATER_GOING);
                case "Airborne" -> creature.setPromptTable(CreatureArrays.PROMPTS_BEAST_AIRBORNE);
                case "Earthbound" -> creature.setPromptTable(CreatureArrays.PROMPTS_BEAST_EARTHBOUND);
                default -> creature.setPromptTable(new String[12]);
            }
        } else {
            switch (creature.getSubcategory()) {
                case "Rare" -> creature.setPromptTable(CreatureArrays.PROMPTS_HUMANOID_RARE);
                case "Uncommon" -> creature.setPromptTable(CreatureArrays.PROMPTS_HUMANOID_UNCOMMON);
                case "Common" -> creature.setPromptTable(CreatureArrays.PROMPTS_HUMANOID_COMMON);
                default -> creature.setPromptTable(new String[12]);
            }
        }
    }

    public static void reRollSubcategory(CreatureClass creature){

        int r1 = Rolls.UniversalRoll(creature.getSubcategoryTable());


        creature.setSubcategory(creature.getSubcategoryTable()[r1]);

        if (Arrays.equals(creature.getSubcategoryTable(), CreatureArrays.SUBCATEGORIES_MONSTER)){
            switch (creature.getSubcategory()) {
                case "Extraplanar" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_EXTRAPLANAR);
                case "Legendary" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_LEGENDARY);
                case "Undead" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_UNDEAD);
                case "Unusual" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_UNUSUAL);
                case "Beastly" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_BEASTLY);
                case "Humanoid" -> creature.setPromptTable(CreatureArrays.PROMPTS_MONSTER_WILD_HUMANOID);
                default -> creature.setPromptTable(new String[12]);

            }
        } else if (Arrays.equals(creature.getSubcategoryTable(), CreatureArrays.SUBCATEGORIES_BEAST)) {
            switch (creature.getSubcategory()) {
                case "Water-going" -> creature.setPromptTable(CreatureArrays.PROMPTS_BEAST_WATER_GOING);
                case "Airborne" -> creature.setPromptTable(CreatureArrays.PROMPTS_BEAST_AIRBORNE);
                case "Earthbound" -> creature.setPromptTable(CreatureArrays.PROMPTS_BEAST_EARTHBOUND);
                default -> creature.setPromptTable(new String[12]);
            }
        } else {
            switch (creature.getSubcategory()) {
                case "Rare" -> creature.setPromptTable(CreatureArrays.PROMPTS_HUMANOID_RARE);
                case "Uncommon" -> creature.setPromptTable(CreatureArrays.PROMPTS_HUMANOID_UNCOMMON);
                case "Common" -> creature.setPromptTable(CreatureArrays.PROMPTS_HUMANOID_COMMON);
                default -> creature.setPromptTable(new String[12]);
            }
        }

        //Se asigna prompt
        int r2 = Rolls.UniversalRoll(creature.getPromptTable());
        creature.setPrompt(creature.getPromptTable()[r2]);

        reviseRolls(creature);

        creature.setPrintableBlock(String.format("""
                    Creature category: %s
                    Creature subcategory: %s
                    Creature prompt: %s
                    Group size: %s
                    Individual size: %s
                    %dHP (%d armor: %s)
                    %s damage (%s, %s)
                    Tags: %s
                    Alignment: %s
                    Disposition: %s
                        """, creature.getCategory(), creature.getSubcategory(), creature.getPrompt(),creature.getGroupSize(),creature.getSize(),creature.getHitPoints(),creature.getArmor(),creature.getArmorType(),
                creature.getDamage(),creature.getReach(),creature.getDamageType(),creature.getTags(),creature.getAlignment(),creature.getDisposition()));

    }

    public static void reRollPrompt(CreatureClass creature){

        int r1 = Rolls.UniversalRoll(creature.getPromptTable());

        creature.setPrompt(creature.getPromptTable()[r1]);
        reviseRolls(creature);

        creature.setPrintableBlock(String.format("""
                    Creature category: %s
                    Creature subcategory: %s
                    Creature prompt: %s
                    Group size: %s
                    Individual size: %s
                    %dHP (%d armor: %s)
                    %s damage (%s, %s)
                    Tags: %s
                    Alignment: %s
                    Disposition: %s
                        """, creature.getCategory(), creature.getSubcategory(), creature.getPrompt(),creature.getGroupSize(),creature.getSize(),creature.getHitPoints(),creature.getArmor(),creature.getArmorType(),
                creature.getDamage(),creature.getReach(),creature.getDamageType(),creature.getTags(),creature.getAlignment(),creature.getDisposition()));
    }

    private static void reviseRolls(CreatureClass creature){
        if (Arrays.equals(creature.getPromptTable(), CreatureArrays.PROMPTS_HUMANOID_UNCOMMON)){
            if (creature.getPrompt().equals("Human + Beast")){
                creature.setPrompt(String.join(" ","Human", CreatureFunctions.rollBeast()));
            }
        }

        if (Arrays.equals(creature.getSubcategoryTable(), CreatureArrays.SUBCATEGORIES_MONSTER)) {
            if (Arrays.equals(creature.getPromptTable(), CreatureArrays.PROMPTS_MONSTER_EXTRAPLANAR)) {
                if (creature.getPrompt().equals("Elemental")) {
                    creature.setPrompt(CreatureFunctions.rollElement() + " elemental");
                }
            } else if (Arrays.equals(creature.getPromptTable(), CreatureArrays.PROMPTS_MONSTER_LEGENDARY)) {
                switch (creature.getPrompt()) {
                    case "Huge + oddity" -> creature.setPrompt(String.join(" ", "Huge", CreatureFunctions.rollOddity()));
                    case "Dragon/Gian + beast" -> creature.setPrompt(String.join(" ", "Dragon/Giant", CreatureFunctions.rollBeast()));
                    case "Huge + beast" -> creature.setPrompt(String.join(" ", "Huge", CreatureFunctions.rollBeast()));
                    default -> creature.setPrompt(creature.getPrompt());
                };

            } else if (Arrays.equals(creature.getPromptTable(), CreatureArrays.PROMPTS_MONSTER_BEASTLY)) {
                switch (creature.getPrompt()) {
                    case "Beast+aberrance" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollBeast(), CreatureFunctions.rollAberrance()));
                    case "Beast+element" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollElement(), CreatureFunctions.rollBeast()));
                    case "Beast+oddity" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollOddity(), CreatureFunctions.rollBeast()));
                    case "Beast+ability" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollAbility(), CreatureFunctions.rollBeast()));
                    case "Beast+Beast" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollBeast(), CreatureFunctions.rollBeast()));
                    default -> creature.setPrompt(creature.getPrompt());
                };

            } else if (Arrays.equals(creature.getPromptTable(), CreatureArrays.PROMPTS_MONSTER_WILD_HUMANOID)) {
                switch (creature.getPrompt()) {
                    case "Humanoid+Oddity" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollOddity(), CreatureFunctions.rollHumanoid()));
                    case "Human+Beast" -> creature.setPrompt(String.join(" ", CreatureFunctions.rollHumanoid(), CreatureFunctions.rollBeast()));
                    default -> creature.setPrompt(creature.getPrompt());
                };
            }
        }
    }

    public static void rollStats(CreatureClass creature){
        rollGroupSize(creature);
        rollSize(creature);
        rollArmor(creature);
        rollDamageType(creature);
        rollTags(creature);
        rollAlignment(creature);
        rollDisposition(creature);
        creature.setPrintableBlock(String.format("""
                    Creature category: %s
                    Creature subcategory: %s
                    Creature prompt: %s
                    Group size: %s
                    Individual size: %s
                    %dHP (%d armor: %s)
                    %s damage (%s, %s)
                    Tags: %s
                    Alignment: %s
                    Disposition: %s
                        """, creature.getCategory(), creature.getSubcategory(), creature.getPrompt(),creature.getGroupSize(),creature.getSize(),creature.getHitPoints(),creature.getArmor(),creature.getArmorType(),
                creature.getDamage(),creature.getReach(),creature.getDamageType(),creature.getTags(),creature.getAlignment(),creature.getDisposition()));
    }


    private static void rollGroupSize(CreatureClass creature){
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
    private static void rollSize(CreatureClass creature){
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
    private static void rollArmor(CreatureClass creature){
        int r1 = Rolls.UniversalRoll(DetailsArrays.ARMOR);
        creature.setArmorType(DetailsArrays.ARMOR[r1]);
        switch (r1){
            case 0,1 -> creature.setArmor(0);
            case 2,3,4,5,6 ->  creature.setArmor(1);
            case 7,8,9 -> creature.setArmor(2);
            case 10 -> creature.setArmor(3);
            case 11 -> creature.setArmor(4);

        }
    }
    private static void rollDamageType(CreatureClass creature){
        int r1 = Rolls.UniversalRoll(DetailsArrays.DAMAGE_TYPE);
        creature.setDamageType(DetailsArrays.DAMAGE_TYPE[r1]);
        switch (creature.getDamageType()){
            case "element" -> {
                String element = DetailsArrays.ELEMENT[Rolls.UniversalRoll(DetailsArrays.ELEMENT)];
                creature.setDamageType("Elemental damage: "+element);
            }
            case "roll 1d10 twice" -> {
                /*
                se vuelve a rolear el array, quitando la posibilidad de que salgan los últimos
                 dos elementos (que son los que dicen "roll 1d10 twice")
                 */
                int r2;
                do{
                    r2 = Rolls.UniversalRoll(DetailsArrays.DAMAGE_TYPE) -2;
                } while (r2<0);

                int r3;
                do{
                    r3 = Rolls.UniversalRoll(DetailsArrays.DAMAGE_TYPE) -2;
                } while (r2<0);

                creature.setDamageType(DetailsArrays.DAMAGE_TYPE[r2]+", "+DetailsArrays.DAMAGE_TYPE[r3]);
            }
        }
    }
    private static void rollTags(CreatureClass creature){
        int r1 = Rolls.UniversalRoll(DetailsArrays.TAG);
        creature.setTags(DetailsArrays.TAG[r1]);
        switch (creature.getTags()){
            case "roll 1d10 twice" ->{
                String tag1 = DetailsArrays.TAG[Rolls.Roll1d10()];
                String tag2 = DetailsArrays.TAG[Rolls.Roll1d10()];
                creature.setTags( tag1 + ", " + tag2);
            }
            default -> creature.setTags(DetailsArrays.TAG[r1]);
        }

    }

    private static void rollAlignment(CreatureClass creature) {
        int r1 = Rolls.UniversalRoll(DetailsArrays.ALIGNMENT);
        creature.setAlignment(DetailsArrays.ALIGNMENT[r1]);
    }

    private static void rollDisposition(CreatureClass creature) {
        int r1 = Rolls.UniversalRoll(DetailsArrays.DISPOSITION);
        creature.setDisposition(DetailsArrays.DISPOSITION[r1]);
    }


}
