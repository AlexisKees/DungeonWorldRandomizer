package domain;

import java.util.Objects;

public class CreatureClass implements PerilousWildsInterface{

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
    private String oneLiner;

    public String getOneLiner(){
        return oneLiner;
    }
    @Override
    public void setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
    }


    @Override
    public String toString(){
        return printableBlock;
    }

    public void printMonster(){
        System.out.println(Objects.requireNonNullElse(this.printableBlock, "Please roll a creature first.\n"));
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String[] getCategoryTable() {
        return categoryTable;
    }

    public void setCategoryTable(String[] categoryTable) {
        this.categoryTable = categoryTable;
    }

    public String[] getSubcategoryTable() {
        return subcategoryTable;
    }

    public void setSubcategoryTable(String[] subcategoryTable) {
        this.subcategoryTable = subcategoryTable;
    }

    public String[] getPromptTable() {
        return promptTable;
    }

    public void setPromptTable(String[] promptTable) {
        this.promptTable = promptTable;
    }

    public String getPrintableBlock() {
        return printableBlock;
    }

    public void setPrintableBlock(String printableBlock) {
        this.printableBlock = printableBlock;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(String groupSize) {
        this.groupSize = groupSize;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public String getReach() {
        return reach;
    }

    public void setReach(String reach) {
        this.reach = reach;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    public String getPrintableStats() {
        return printableStats;
    }

    public void setPrintableStats(String printableStats) {
        this.printableStats = printableStats;
    }

    public CreatureClass() {}

    public String getPrompt() {
        return prompt;
    }
}






















