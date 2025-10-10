package domain;

import data.CreatureArrays;
import data.DetailsArrays;
import service.CreatureFunctions;
import service.Rolls;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;

public class CreatureClass {

//    private Boolean wasRolled = false;
    private String category;
    private String subcategory;
    private String prompt;
    private String[] categoryTable;
    private String[] subcategoryTable;
    private String[] promptTable;
    private String printableBlock;
    private String size;
    private String groupSize;
    private int hitPoints;
    private int armor;
    private String damage;
    private String damageType;
    private String reach;
    private String tags;
    private String alignment;
    private String disposition;
    private String armorType;
    private String printableStats;



    public void printMonster(){
        System.out.println(Objects.requireNonNullElse(this.printableBlock + this.printableStats, "Please roll a creature first.\n"));
    }

    public void rollAttributes() {
        //Se asigna tabla de categorías (siempre igual) y de ahí se toma para el length de universalRoll
        this.categoryTable = CreatureArrays.CATEGORIES;
        int r1 = Rolls.UniversalRoll(categoryTable);

        // Se extrae el elemento string del array de categorías para impresión
        this.category = categoryTable[r1];

        //Se asigna tabla de subcategoría en base a subcategoría obtenida en roll anterior
        this.assignSubcategoryTable();

        //Se saca número aleatorio en base al largo de la tabla de subcategorías y se asigna String de subcategoría
        int r2 = Rolls.UniversalRoll(this.subcategoryTable);
        this.subcategory = this.subcategoryTable[r2];

        //Se asigna tabla de Prompts
        this.assignPromptTable();

        //Se saca número aleatorio en base al largo de la tabla de prompts y se asigna prompt
        int r3 = Rolls.UniversalRoll(this.promptTable);
        this.prompt = this.promptTable[r3];

        this.reviseRolls();

        this.rollStats();

        this.printableBlock = String.format("""
                    Creature category: %s
                    Creature subcategory: %s
                    Creature prompt: %s
                    """, this.category, this.subcategory, this.prompt);

        this.printMonster();
        this.printStats();
    }

    private void assignSubcategoryTable(){
        this.subcategoryTable = switch (this.category) {
            case "Monster" -> CreatureArrays.SUBCATEGORIES_MONSTER;
            case "Beast" -> CreatureArrays.SUBCATEGORIES_BEAST;
            case "Humanoid" -> CreatureArrays.SUBCATEGORIES_HUMANOID;
            default -> new String[12];
        };

    }

    private void assignPromptTable(){
        if (Arrays.equals(this.subcategoryTable, CreatureArrays.SUBCATEGORIES_MONSTER)) {
            switch (this.subcategory) {
                case "Extraplanar" -> this.promptTable = CreatureArrays.PROMPTS_MONSTER_EXTRAPLANAR;
                case "Legendary" -> this.promptTable = CreatureArrays.PROMPTS_MONSTER_LEGENDARY;
                case "Undead" -> this.promptTable = CreatureArrays.PROMPTS_MONSTER_UNDEAD;
                case "Unusual" -> this.promptTable = CreatureArrays.PROMPTS_MONSTER_UNUSUAL;
                case "Beastly" -> this.promptTable = CreatureArrays.PROMPTS_MONSTER_BEASTLY;
                case "Wild humanoid" -> this.promptTable = CreatureArrays.PROMPTS_MONSTER_WILD_HUMANOID;
                default -> this.promptTable = new String[12];

            }
        } else if (Arrays.equals(this.subcategoryTable, CreatureArrays.SUBCATEGORIES_BEAST)) {
            switch (this.subcategory) {
                case "Water-going" -> this.promptTable = CreatureArrays.PROMPTS_BEAST_WATER_GOING;
                case "Airborne" -> this.promptTable = CreatureArrays.PROMPTS_BEAST_AIRBORNE;
                case "Earthbound" -> this.promptTable = CreatureArrays.PROMPTS_BEAST_EARTHBOUND;
                default -> this.promptTable = new String[12];
            }
        } else {
            switch (this.subcategory) {
                case "Rare" -> this.promptTable = CreatureArrays.PROMPTS_HUMANOID_RARE;
                case "Uncommon" -> this.promptTable = CreatureArrays.PROMPTS_HUMANOID_UNCOMMON;
                case "Common" -> this.promptTable = CreatureArrays.PROMPTS_HUMANOID_COMMON;
                default -> this.promptTable = new String[12];
            }
        }
    }

    public void reRollSubcategory(){

        int r1 = Rolls.UniversalRoll(this.subcategoryTable);


        this.subcategory = this.subcategoryTable[r1];

        if (Arrays.equals(this.subcategoryTable, CreatureArrays.SUBCATEGORIES_MONSTER)){
            switch (this.subcategory) {
                case "Extraplanar" -> this.promptTable = CreatureArrays.PROMPTS_MONSTER_EXTRAPLANAR;
                case "Legendary" -> this.promptTable = CreatureArrays.PROMPTS_MONSTER_LEGENDARY;
                case "Undead" -> this.promptTable = CreatureArrays.PROMPTS_MONSTER_UNDEAD;
                case "Unusual" -> this.promptTable = CreatureArrays.PROMPTS_MONSTER_UNUSUAL;
                case "Beastly" -> this.promptTable = CreatureArrays.PROMPTS_MONSTER_BEASTLY;
                case "Humanoid" -> this.promptTable = CreatureArrays.PROMPTS_MONSTER_WILD_HUMANOID;
                default -> this.promptTable = new String[12];

            }
        } else if (Arrays.equals(this.subcategoryTable, CreatureArrays.SUBCATEGORIES_BEAST)) {
            switch (this.subcategory) {
                case "Water-going" -> this.promptTable = CreatureArrays.PROMPTS_BEAST_WATER_GOING;
                case "Airborne" -> this.promptTable = CreatureArrays.PROMPTS_BEAST_AIRBORNE;
                case "Earthbound" -> this.promptTable = CreatureArrays.PROMPTS_BEAST_EARTHBOUND;
                default -> this.promptTable = new String[12];
            }
        } else {
            switch (this.subcategory) {
                case "Rare" -> this.promptTable = CreatureArrays.PROMPTS_HUMANOID_RARE;
                case "Uncommon" -> this.promptTable = CreatureArrays.PROMPTS_HUMANOID_UNCOMMON;
                case "Common" -> this.promptTable = CreatureArrays.PROMPTS_HUMANOID_COMMON;
                default -> this.promptTable = new String[12];
            }
        }

        //Se asigna prompt
        int r2 = Rolls.UniversalRoll(this.promptTable);
        this.prompt = this.promptTable[r2];

        this.reviseRolls();

        this.printableBlock= String.format("""
                Creature category: %s
                Creature subcategory: %s
                Creature prompt: %s
                """, this.category, this.subcategory, this.prompt);
        this.printMonster();
        this.printStats();

    }

    public void reRollPrompt(){

            int r1 = Rolls.UniversalRoll(this.promptTable);

            this.prompt = this.promptTable[r1];
            this.reviseRolls();

            this.printableBlock= String.format("""
                    Creature category: %s
                    Creature subcategory: %s
                    Creature prompt: %s
                    """, this.category, this.subcategory, this.prompt);
            this.printMonster();
            this.printStats();

    }

    private void reviseRolls(){
        if (Arrays.equals(this.promptTable, CreatureArrays.PROMPTS_HUMANOID_UNCOMMON)){
            if (this.prompt.equals("Human + Beast")){
                this.prompt=String.join(" ","Human", CreatureFunctions.rollBeast());
            }
        }

        if (Arrays.equals(this.subcategoryTable, CreatureArrays.SUBCATEGORIES_MONSTER)) {
            if (Arrays.equals(this.promptTable, CreatureArrays.PROMPTS_MONSTER_EXTRAPLANAR)) {
                if (this.prompt.equals("Elemental")) {
                    this.prompt = CreatureFunctions.rollElement() + " elemental";
                }
            } else if (Arrays.equals(this.promptTable, CreatureArrays.PROMPTS_MONSTER_LEGENDARY)) {
                this.prompt = switch (this.prompt) {
                    case "Huge + oddity" -> String.join(" ", "Huge", CreatureFunctions.rollOddity());
                    case "Dragon/Gian + beast" -> String.join(" ", "Dragon/Giant", CreatureFunctions.rollBeast());
                    case "Huge + beast" -> String.join(" ", "Huge", CreatureFunctions.rollBeast());
                    default -> this.prompt;
                };

            } else if (Arrays.equals(this.promptTable, CreatureArrays.PROMPTS_MONSTER_BEASTLY)) {
                this.prompt = switch (this.prompt) {
                    case "Beast+aberrance" -> String.join(" ", CreatureFunctions.rollBeast(), CreatureFunctions.rollAberrance());
                    case "Beast+element" -> String.join(" ", CreatureFunctions.rollElement(), CreatureFunctions.rollBeast());
                    case "Beast+oddity" -> String.join(" ", CreatureFunctions.rollOddity(), CreatureFunctions.rollBeast());
                    case "Beast+ability" -> String.join(" ", CreatureFunctions.rollAbility(), CreatureFunctions.rollBeast());
                    case "Beast+Beast" -> String.join(" ", CreatureFunctions.rollBeast(), CreatureFunctions.rollBeast());
                    default -> this.prompt;
                };

            } else if (Arrays.equals(this.promptTable, CreatureArrays.PROMPTS_MONSTER_WILD_HUMANOID)) {
                this.prompt = switch (this.prompt) {
                    case "Humanoid+Oddity" -> String.join(" ", CreatureFunctions.rollOddity(), CreatureFunctions.rollHumanoid());
                    case "Human+Beast" -> String.join(" ", CreatureFunctions.rollHumanoid(), CreatureFunctions.rollBeast());
                    default -> this.prompt;
                };
            }
        }
    }

    public void rollStats(){
        this.rollGroupSize();
        this.rollSize();
        this.rollArmor();
        this.rollDamageType();
        this.rollTags();
        this.rollAlignment();
        this.rollDisposition();
    }
    public void printStats(){
        addStatsToBlock();
        System.out.println(this.printableStats);
    }

    private void addStatsToBlock(){
        this.printableStats="Group size: " + this.groupSize+"\n";
        this.printableStats+="Individual size: "+this.size+"\n";
        this.printableStats+=this.hitPoints +" HP ("+this.armor+" armor: "+this.armorType+")"+"\n";
        this.printableStats+=this.damage + " damage ("+this.reach+", "+this.damageType+")"+"\n";
        this.printableStats+="Tags: "+this.tags+"\n";
        this.printableStats+="Alignment: "+this.alignment+"\n";
        this.printableStats+="Disposition: "+this.disposition+"\n";
    }

    private void rollGroupSize(){
        int r1 = Rolls.UniversalRoll(DetailsArrays.NO_APPEARING);
        this.groupSize = DetailsArrays.NO_APPEARING[r1];

        switch (this.groupSize){
            case "horde (4d6 per wave)" -> {
                this.damage = "1d6";
                this.hitPoints = 3;
            }
            case "group (1d6+2)" -> {
                this.damage = "1d8";
                this.hitPoints = 6;
            }
            case "solitary (1)" ->{
                this.damage="1d10";
                this.hitPoints=12;
            }
        }
    }
    private void rollSize(){
        int r1 = Rolls.UniversalRoll(DetailsArrays.SIZE);
        this.size = DetailsArrays.SIZE[r1];
        switch (this.size){
            case "Tiny" -> {
                this.damage+="-2";
                this.reach ="hand";
            }
            case "Small","Medium-sized" ->
                this.reach = "close";

            case "Large" ->{
                this.reach="Close, reach";
                this.hitPoints+=4;
                this.damage+="+1";
            }
            case "Huge" -> {
                this.reach="Reach";
                this.hitPoints+=8;
                this.damage+="+3";
            }
        }

    }
    private void rollArmor(){
        int r1 = Rolls.UniversalRoll(DetailsArrays.ARMOR);
        this.armorType = DetailsArrays.ARMOR[r1];
        switch (r1){
            case 0,1 -> this.armor=0;
            case 2,3,4,5,6 ->  this.armor =1;
            case 7,8,9 -> this.armor = 2;
            case 10 -> this.armor = 3;
            case 11 -> this.armor = 4;

        }
    }
    private void rollDamageType(){
        int r1 = Rolls.UniversalRoll(DetailsArrays.DAMAGE_TYPE);
        this.damageType = DetailsArrays.DAMAGE_TYPE[r1];
        switch (this.damageType){
            case "element" -> {
                String element = DetailsArrays.ELEMENT[Rolls.UniversalRoll(DetailsArrays.ELEMENT)];
                this.damageType="Elemental damage: "+element;
            }
            case "roll 1d10 twice" -> {
                /*
                se vuelve a rolear el array, quitando la posibilidad de que salgan los últimos
                 dos elementos (que son los que dicen "roll 1d10 twice")
                 */
                int r2 = Rolls.UniversalRoll(DetailsArrays.DAMAGE_TYPE) -2;
                int r3 = Rolls.UniversalRoll(DetailsArrays.DAMAGE_TYPE) -2;
                this.damageType=DetailsArrays.DAMAGE_TYPE[r2]+", "+DetailsArrays.DAMAGE_TYPE[r3];
            }
        }
    }
    private void rollTags(){
        int r1 = Rolls.UniversalRoll(DetailsArrays.TAG);
        this.tags = DetailsArrays.TAG[r1];
        switch (this.tags){
            case "roll 1d10 twice" ->{
                String tag1 = DetailsArrays.TAG[Rolls.Roll1d10()];
                String tag2 = DetailsArrays.TAG[Rolls.Roll1d10()];
                this.tags = tag1 + ", " + tag2;
            }
            default -> this.tags=DetailsArrays.TAG[r1];
        }

    }
    private void rollAlignment() {
        int r1 = Rolls.UniversalRoll(DetailsArrays.ALIGNMENT);
        this.alignment = DetailsArrays.ALIGNMENT[r1];
    }
    private void rollDisposition() {
        int r1 = Rolls.UniversalRoll(DetailsArrays.DISPOSITION);
        this.disposition=DetailsArrays.DISPOSITION[r1];
        switch (this.disposition){
            case "roll 1d10 twice" ->{
                String disp1 = DetailsArrays.DISPOSITION[Rolls.Roll1d10()];
                String disp2 = DetailsArrays.DISPOSITION[Rolls.Roll1d10()];
                this.disposition = disp1 + " and " + disp2;
            }
        }
    }


    public void exportCreature() throws IOException {
        String prefix = "Creature_";
        int creatureNumber = 1;
        String fileName = String.format(prefix+"%04d.txt",creatureNumber);
        File file = new File(fileName);

        while (file.exists()){
            creatureNumber++;
            fileName = String.format(prefix+"%04d.txt",creatureNumber);
            file = new File(fileName);
        }

        PrintWriter salida = new PrintWriter(new FileWriter(file, true));
        salida.println(this.printableBlock);
        salida.println(this.printableStats);
        salida.close();
    }

    public CreatureClass() {}

    public String getPrompt() {
        return prompt;
    }
}






















