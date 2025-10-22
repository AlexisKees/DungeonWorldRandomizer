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

    public static <T extends IPWClass> void run(Scanner dataInput, T object, Dungeon dungeon){
        var serviceInterface = ClassIdentifier.getServiceFile((Class <T>) object.getClass());
        if (serviceInterface != null){
            serviceInterface.showOptions(dataInput,object,dungeon);
        } else {
            System.out.println("No service registered for class '"+object.getClass()+"'.");
        }

    }

    public static <T extends IPWClass> void run(Scanner dataInput, Quest object, List<Quest>questList, List<NPC> npcList, List<Dungeon> dungeonList, List<Biome> biomeList){
        var serviceInterface = ClassIdentifier.getServiceFile((Class <T>) object.getClass());
        if (serviceInterface != null){
            serviceInterface.showOptions(dataInput, object, questList,npcList, dungeonList, biomeList);
        } else {
            System.out.println("No service registered for class '"+object.getClass()+"'.");
        }
    }


}
