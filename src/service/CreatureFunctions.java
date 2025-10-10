package service;

import data.CreatureArrays;
import data.DetailsArrays;

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
}
