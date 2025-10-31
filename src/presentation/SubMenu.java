package presentation;

import domain.*;
import service.DungeonAreaFunctions;
import service.DungeonFunctions;
import service.QuestFunctions;
import service.util.ClassIdentifier;

import java.util.List;
import java.util.Scanner;

public class SubMenu {
    public static <T extends IPWClass<T>> void run(Scanner dataInput, T object, List<T> list){
        var serviceInterface = ClassIdentifier.getServiceFile((Class <T>) object.getClass());
        if (serviceInterface != null){
            serviceInterface.showOptions(dataInput,object,list);
        } else {
            System.out.println("No service registered for class '"+object.getClass()+"'.");
        }
    }
    //run para dungeon area
    public static  void run(Scanner dataInput, Area area, Dungeon dungeon,List<Area> areaList){
        DungeonAreaFunctions.showOptions(dataInput,area,dungeon, areaList);
    }
    //run para quest
    public static void run(Scanner dataInput, Quest object, List<Quest>questList, List<NPC> npcList, List<Dungeon> dungeonList, List<Biome> biomeList){
        QuestFunctions.showOptions(dataInput, object, questList,npcList, dungeonList, biomeList);
    }

    public static void run(Scanner dataInput, Dungeon dungeon, List<Dungeon> dungeonList,List<Area> areaList){
        DungeonFunctions.showOptions(dataInput, dungeon, dungeonList, areaList);
    }


}
