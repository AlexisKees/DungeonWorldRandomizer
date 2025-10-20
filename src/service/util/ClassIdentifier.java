package service.util;

import domain.*;
import service.*;

import java.util.HashMap;
import java.util.Map;

public class ClassIdentifier {
    private static final Map<Class<?>, IPWService<?>> map = new HashMap<>();
    static {
        map.put(BiomeClass.class,new BiomeFunctions());
        map.put(CreatureClass.class,new CreatureFunctions());
        map.put(DangerClass.class,new DangerFunctions());
        map.put(DiscoveryClass.class,new DiscoveryFunctions());
        map.put(DungeonAreaClass.class,new DungeonAreaFunctions());
        map.put(DungeonClass.class,new DungeonFunctions());
//        map.put(DungeonDangerClass.class,new DungeonDangerFunctions());
//        map.put(DungeonDiscoveryClass.class,new DungeonDiscoveryFunctions());
        map.put(FollowerClass.class,new FollowerFunctions());
        map.put(NPCClass.class,new NPCFunctions());
//        map.put(QuestClass.class,new QuestFunctions());
        map.put(SteadingClass.class,new SteadingFunctions());
    }

    @SuppressWarnings("unchecked")
    public static <T extends IPWClass> IPWService<T> getServiceFile(Class<T> c) {
        return (IPWService<T>) map.get(c);
    }

}


