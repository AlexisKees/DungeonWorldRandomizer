package service;

import data.DungeonArrays;
import domain.DungeonAreaClass;
import domain.util.Rolls;

import java.util.Objects;


public class DungeonAreaFunctions {

    public static void rollArea(DungeonAreaClass area) {
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

        area.setAreaType(DungeonArrays.AREA_TYPE[Rolls.UniversalRoll(DungeonArrays.AREA_TYPE)]);

        area.setAreaDressing(DungeonArrays.AREA_DRESSING[Rolls.UniversalRoll(DungeonArrays.AREA_DRESSING)]);
        if (Objects.equals(area.getAreaDressing(),"roll 1d10 twice, combine")){
            area.setAreaDressing(DungeonArrays.AREA_DRESSING[Rolls.Roll1d10()]+" and "+DungeonArrays.AREA_DRESSING[Rolls.Roll1d10()]);
        }

    }
}