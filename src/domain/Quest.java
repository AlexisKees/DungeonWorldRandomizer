package domain;

public class Quest implements IPWClass {
    private String task;
    private String relevance;
    private String reward;
    private NPC questGiver;
    private Dungeon dungeon;
    private Biome biome;
    private String oneLiner;
    private String brief;


    public String getOneLiner(){
        return oneLiner;
    }

    @Override
    public void setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Override
    public String toString(){
        return String.format("""
                QUEST:
                TASK: %s\n
                RELEVANCE: %s\n
                REWARD: %s\n
                QUEST GIVER:
                %s\n
                QUEST LOCATION:
                %s\n
                %s\n""", this.task, this.relevance, this.reward, this.questGiver, this.biome,this.dungeon);

    }

    public Biome getBiome() {
        return biome;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }

    public NPC getQuestGiver() {
        return questGiver;
    }

    public void setQuestGiver(NPC questGiver) {
        this.questGiver = questGiver;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getBrief() {
        return brief;
    }
}
