package domain;

public class DungeonAreaClass implements IPWClass {
    private String rarity;
    private String areaType;
    private String areaDressing;
    private int discoveriesAmount;
    private DungeonDiscoveryClass[] discoveries;
    private int dangersAmount;
    private DungeonDangerClass[] dangers;
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
        this.discoveries = new DungeonDiscoveryClass[i];
   }

   public void addDiscovery(DungeonDiscoveryClass discovery){
        int i;
        boolean added=false;
        for (i=0;i<this.getDiscoveriesAmount();i++){
            if (this.discoveries[i]==null){
                this.discoveries[i]=discovery;
                added=true;
                break;
            }
        }
   }

    public void initializeDangersList(int i){
        this.dangers = new DungeonDangerClass[i];
    }

    public void addDanger(DungeonDangerClass danger){
        int i;
        boolean added=false;
        for (i=0;i<this.dangersAmount;i++){
            if (this.dangers[i]==null){
                this.dangers[i]=danger;
                added=true;
                break;
            }
        }
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

    public String getDiscoveries() {

            if (this.getDiscoveriesAmount()==0){
                return "no discoveries";
            } else {
                String str = "";
                int i;
                for(i=0;i<this.getDiscoveriesAmount();i++){
                    str+= String.format("""
                        \n%d) %S""",i+1,this.discoveries[i].getFinalResult());
                }
                return str;
            }

    }

    public void setDiscoveries(DungeonDiscoveryClass[] discoveries) {
        this.discoveries = discoveries;
    }

    public String getDangers() {
        if (this.getDangersAmount()==0){
            return "no dangers.";
        } else {
            String str = "";
            int i;
            for(i=0;i<this.getDangersAmount();i++){
                str+= String.format("""
                        \n%d) %S""",i+1,this.dangers[i].getFinalResult());
            }
            return str;
        }
    }

    public void setDangers(DungeonDangerClass[] dangers) {
        this.dangers = dangers;
    }

    @Override
    public String toString(){

     return String.format("""
                Area: %s
                Dressing: %s
                Rarity: %s
                Discoveries: %s
                Dangers: %s""",this.areaType, this.areaDressing,this.rarity,this.getDiscoveries(),this.getDangers());
    }
}
