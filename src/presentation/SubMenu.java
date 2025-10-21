package presentation;

import domain.*;
import service.util.ClassIdentifier;

import java.util.List;
import java.util.Scanner;

public class SubMenu {
    public static <T extends IPWClass> void run(Scanner dataInput, T object, List<T> list){
        var serviceInterface = ClassIdentifier.getServiceFile((Class <T>) object.getClass());
        if (serviceInterface != null){
            serviceInterface.showOptions(dataInput,object,list);
        } else {
            System.out.println("No service registered for class '"+object.getClass()+"'.");
        }
    }

    public static <T extends IPWClass> void run(Scanner dataInput, T object, DungeonClass dungeon){

    }

    public static <T extends IPWClass> void run(Scanner dataInput, List<QuestClass>questList, List<NPCClass> npcList, List<DungeonClass> dungeonList, List<BiomeClass> biomeList){

    }


}
