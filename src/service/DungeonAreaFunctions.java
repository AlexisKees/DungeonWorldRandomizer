package service;

import data.DungeonArrays;
import domain.DungeonAreaClass;
import domain.DungeonDangerClass;
import domain.DungeonDiscoveryClass;
import domain.util.Rolls;
import presentation.ViewAll;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class DungeonAreaFunctions implements IPWService<DungeonAreaClass>{

    public static void rollArea(DungeonAreaClass area) {
        area.setAreaType(DungeonArrays.AREA_TYPE[Rolls.UniversalRoll(DungeonArrays.AREA_TYPE)]);
        rollAreaDetails(area);
    }

    public static void rollAreaDetails(DungeonAreaClass area){

        int rollRarity = Rolls.UniversalRoll(DungeonArrays.AREA_RARITY);
        area.setRarity(DungeonArrays.AREA_RARITY[rollRarity]);

        switch (rollRarity){
            case 0 ->{
                area.setDangersAmount(Rolls.Roll1d4());
                area.setDiscoveriesAmount(0);
            }
            case 1,2 ->{
                area.setDangersAmount(1);
                area.setDiscoveriesAmount(0);
            }
            case 3,4,5->{
                area.setDangersAmount(0);
                area.setDiscoveriesAmount(0);
            }
            case 6->{
                area.setDangersAmount(1);
                area.setDiscoveriesAmount(1);
            }
            case 7->{
                area.setDangersAmount(Rolls.Roll1d4());
                area.setDiscoveriesAmount(1);
            }
            case 8->{
                area.setDangersAmount(0);
                area.setDiscoveriesAmount(1);
            }
            case 9->{
                area.setDangersAmount(Rolls.Roll1d4());
                area.setDiscoveriesAmount(Rolls.Roll1d4());
            }
            case 10->{
                area.setDangersAmount(1);
                area.setDiscoveriesAmount(Rolls.Roll1d4());
            }
            case 11->{
                area.setDangersAmount(0);
                area.setDiscoveriesAmount(Rolls.Roll1d4());
            }

        }

        area.initializeDiscoveriesList(area.getDiscoveriesAmount());
        area.initializeDangersList(area.getDangersAmount());

        area.setRarity(DungeonArrays.AREA_RARITY[rollRarity]);

        area.setAreaDressing(DungeonArrays.AREA_DRESSING[Rolls.UniversalRoll(DungeonArrays.AREA_DRESSING)]);
        if (Objects.equals(area.getAreaDressing(),"roll 1d10 twice, combine")){
            area.setAreaDressing(DungeonArrays.AREA_DRESSING[Rolls.Roll1d10()]+" and "+DungeonArrays.AREA_DRESSING[Rolls.Roll1d10()]);
        }

        int i;
        if (area.getDangersAmount()>0) {
            for (i = 1; i <= area.getDangersAmount(); i++) {
                DungeonDangerClass danger = new DungeonDangerClass();
                DangerFunctions.rollDungeonDanger(danger);
                area.addDanger(danger);
            }
        }

        if (area.getDiscoveriesAmount()>0){
            for(i=1; i<=area.getDiscoveriesAmount();i++) {
                DungeonDiscoveryClass discovery = new DungeonDiscoveryClass();
                DiscoveryFunctions.rollDungeonDiscovery(discovery);
                area.addDiscovery(discovery);
            }
        }
    }

    @Override
    public void showOptions(Scanner dataInput, DungeonAreaClass area, List<DungeonAreaClass> areaList) {
        int option = 0;
        System.out.println("WELCOME TO THE AREA GENERATOR\n");

        try{

            do {
                System.out.print("""
                        \nPlease select an option:
                        1) Create new random area
                        2) View current area
                        3) Reroll this area
                        4) View list of generated area
                        5) Export current area
                        6) Main menu
                        
                        \tOption:\s""");

                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option){
                    case 1 -> {
                        area = new DungeonAreaClass();
                        DungeonAreaFunctions.rollArea(area);
                        areaList.add(area);
                        System.out.println(area);
                    }
                    case 2 ->{
                        if (area==null){
                            area = new DungeonAreaClass();
                            areaList.add(area);
                            DungeonAreaFunctions.rollArea(area);
                        }
                        System.out.println(area);
                    }
                    case 3 ->{
                        if (area==null){
                            area = new DungeonAreaClass();
                            DungeonAreaFunctions.rollArea(area);
                            areaList.add(area);
                        } else {
                            DungeonAreaFunctions.rollAreaDetails(area);
                            areaList.add(area);
                        }
                        System.out.println(area);
                    }
                    case 4 -> area = new ViewAll().run(dataInput, areaList, area, DungeonAreaClass.class);
                    case 5 -> {
                        if (area==null){
                            area = new DungeonAreaClass();
                            DungeonAreaFunctions.rollArea(area);
                        }
                        GenericFunctions.exportPW(area);
                    }
                    case 6 -> System.out.println("Going back to DUNGEON GENERATOR");
                }
            } while (option!=6);


        }catch (Exception e){
            System.out.println("There has been a problem during DUNGEON AREA GENERATOR excecution: "+e.getMessage());
        }
    }
}