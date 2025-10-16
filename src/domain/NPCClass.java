package domain;


public class NPCClass implements IPWClass {
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
    private String appearance;
    private String personality;
    private String quirk;
    private String oneLiner;


    public String getOneLiner(){
        return oneLiner;
    }

    @Override
    public void setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
    }

    private void NPCClass(){
    };

    public String getAppearance() {
        return this.appearance;
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
               NPC: %s, the %s %s
               Gender: %s
               Age: %s
               Appearance: %s
               Personality: %s
               Quirk: %s""", this.name, this.race, this.job, this.gender, this.age, this.appearance,this.personality, this.quirk);
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

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public void setQuirk(String quirk) {
        this.quirk = quirk;
    }


}
