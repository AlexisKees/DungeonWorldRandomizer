package domain;

import service.AreaDangerFunctions;
import service.AreaDiscoveryFunctions;

import java.util.ArrayList;
import java.util.List;

public class Area implements IPWClass {
    private String rarity;
    private String areaType;
    private String areaDressing;
    private int discoveriesAmount;
    private List<AreaDiscovery> discoveries = new ArrayList<>();
    private int dangersAmount;
    private List<AreaDanger> dangers = new ArrayList<>();
    private String oneLiner;

    public String getOneLiner(){
        return oneLiner;
    }
    @Override
    public void setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
    }

    @Override
    public Area clone() {
        try {
            return (Area) super.clone();
        } catch (Exception e){
            System.out.println("Error cloning object: "+e.getMessage());
            return null;
        }
    }

    public String getAreaDressing() {
        return areaDressing;
    }

    public void setAreaDressing(String areaDressing) {
        this.areaDressing = areaDressing;
    }



   public void addDiscoveries(){
       List<AreaDiscovery> list = new ArrayList<>();

       if (this.getDiscoveriesAmount()>0) {
           int i;
           for (i = 1; i <= this.getDiscoveriesAmount(); i++) {
               AreaDiscovery d = new AreaDiscovery();
               AreaDiscoveryFunctions.rollAreaDiscovery(d);
               list.add(d.clone());
           }
           this.setDiscoveries(list);
       }

   }


    public void addDangers(){
        List<AreaDanger> list = new ArrayList<>();

        if (this.getDangersAmount()>0) {
            int i;
            for (i = 1; i <= this.getDangersAmount(); i++) {
                AreaDanger d = new AreaDanger();
                AreaDangerFunctions.rollAreaDanger(d);
                list.add(d.clone());
            }
        }
        this.setDangers(list);
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
                        \n%d) %S""",i+1,this.discoveries.get(i).getFinalResult());
                }
                return str;
            }

    }

    public void setDiscoveries(List<AreaDiscovery> discoveries) {
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
                        \n%d) %S""",i+1,this.dangers.get(i).getFinalResult());
            }
            return str;
        }
    }

    public void setDangers(List<AreaDanger> dangers) {
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
