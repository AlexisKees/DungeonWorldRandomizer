package domain;
import data.CreatureArrays;

import data.DetailsArrays;
import data.NPCArrays;
import data.NPCNamesArrays;
import domain.util.Rolls;

import java.util.Objects;

public class NPCClass {
    private String[] raceTable;
    private String race;
    private String gender;
    private String ethnics;
    private String[] namesTable;
    private String name;
    private String age;
    private String category;
    private String[] jobList;
    private String job;
    private String appearence;
    private String personality;
    private String quirk;

    public String getBrief() {
        return this.brief;
    }

    private String brief;

    private void NPCClass(){
    };




    public String getAppearence() {
        return this.appearence;
    }

    public String getPersonality() {
        return this.personality;
    }

    public String getQuirk() {
        return this.quirk;
    }

    @Override
    public String toString(){

        return String.format("""
                NPC: %s, %s %s
                Ethnics: %s
                Gender: %s
                Age: %s
                Appearance: %s
                Personality: %s
                Quirk: %s
                """, this.name, this.race, this.job, this.ethnics, this.gender, this.age, this.appearence,this.personality, this.quirk);
    }

    public String[] getRaceTable() {
        return raceTable;
    }

    public void setRaceTable(String[] raceTable) {
        this.raceTable = raceTable;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnics() {
        return ethnics;
    }

    public void setEthnics(String ethnics) {
        this.ethnics = ethnics;
    }

    public String[] getNamesTable() {
        return namesTable;
    }

    public void setNamesTable(String[] namesTable) {
        this.namesTable = namesTable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String[] getJobList() {
        return jobList;
    }

    public void setJobList(String[] jobList) {
        this.jobList = jobList;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setAppearence(String appearence) {
        this.appearence = appearence;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public void setQuirk(String quirk) {
        this.quirk = quirk;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
