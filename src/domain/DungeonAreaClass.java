package domain;

public class DungeonAreaClass implements IPWClass {
    private String rarity;
    private String areaType;
    private String areaDressing;
    private int discoveriesAmount;
    private DiscoveryClass[] discoveries;
    private int dangersAmount;
    private DangerClass[] dangers;
    private String oneLiner;

    public String getOneLiner(){
        return oneLiner;
    }
    @Override
    public void setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
    }

    public String getAreaDressing() {
        return areaDressing;
    }

    public void setAreaDressing(String areaDressing) {
        this.areaDressing = areaDressing;
    }

   public void initializeDiscoveriesList(int i){
        this.discoveries = new DiscoveryClass[i];
   }

   public void addDiscovery(DiscoveryClass discovery){
        int i;
        boolean added=false;
        for (i=0;i<this.discoveries.length;i++){
            if (this.discoveries[i]==null){
                this.discoveries[i]=discovery;
                added=true;
                break;
            }
        }
       if (added) System.out.println("Discovery added successfully!");
       else System.out.println("Seems like the discoveries list is already full!");
   }

    public void initializeDangersList(int i){
        this.dangers = new DangerClass[i];
    }

    public void addDanger(DangerClass danger){
        int i;
        boolean added=false;
        for (i=0;i<this.dangers.length;i++){
            if (this.dangers[i]==null){
                this.dangers[i]=danger;
                added=true;
                break;
            }
        }
        if (added) System.out.println("Danger added successfully!");
        else System.out.println("Seems like the dangers list is already full!");
    }



    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public int getDiscoveriesAmount() {
        return discoveriesAmount;
    }

    public void setDiscoveriesAmount(int discoveriesAmount) {
        this.discoveriesAmount = discoveriesAmount;
    }



    public int getDangersAmount() {
        return dangersAmount;
    }

    public void setDangersAmount(int dangersAmount) {
        this.dangersAmount = dangersAmount;
    }

    public DiscoveryClass[] getDiscoveries() {
        return discoveries;
    }

    public void setDiscoveries(DiscoveryClass[] discoveries) {
        this.discoveries = discoveries;
    }

    public DangerClass[] getDangers() {
        return dangers;
    }

    public void setDangers(DangerClass[] dangers) {
        this.dangers = dangers;
    }

    @Override
    public String toString(){
     return String.format("""
                Area: %s
                Dressing: %s
                Rarity: %s
                Discoveries: %d
                Dangers: %d""",this.areaType, this.areaDressing,this.rarity,this.discoveriesAmount,this.dangersAmount);
    }
}
