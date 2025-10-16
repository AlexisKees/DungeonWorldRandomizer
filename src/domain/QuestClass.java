package domain;

public class QuestClass implements IPWClass {
    private String task;
    private String relevance;
    private String reward;
    private NPCClass questGiver;
    private DungeonClass dungeon;
    private BiomeClass biome;
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

    public BiomeClass getBiome() {
        return biome;
    }

    public void setBiome(BiomeClass biome) {
        this.biome = biome;
    }

    public NPCClass getQuestGiver() {
        return questGiver;
    }

    public void setQuestGiver(NPCClass questGiver) {
        this.questGiver = questGiver;
    }

    public DungeonClass getDungeon() {
        return dungeon;
    }

    public void setDungeon(DungeonClass dungeon) {
        this.dungeon = dungeon;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getBrief() {
        return brief;
    }
}
