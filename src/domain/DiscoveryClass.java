package domain;

import data.DiscoveryArrays;

import java.util.Objects;

public class DiscoveryClass {

    private String category;
    private String[] subcategoriesTable;
    private String subcategory;
    private String[] promptTable;
    private String prompt;
    private String finalResult;

    public String[] getPromptTable() {
        return promptTable;
    }

    public void setPromptTable(String[] promptTable) {
        this.promptTable = promptTable;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String[] getSubcategoriesTable() {
        return subcategoriesTable;
    }

    public void setSubcategoriesTable(String[] subcategoriesTable) {
        this.subcategoriesTable = subcategoriesTable;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }

    @Override
    public String toString(){
      String str= "\nDISCOVERY: "+this.category+" -> "+this.subcategory+" -> "+this.prompt+"\n";
        if (!Objects.equals(this.prompt,this.finalResult)){
            str+=this.finalResult+"\n";
        }
        return str;
    };
}
