package service.util;

import domain.*;
import service.*;

import java.util.HashMap;
import java.util.Map;

public class ClassIdentifier {
    private static final Map<Class<?>, IGenericServices<?>> map = new HashMap<>();
    private static final Map<Class<?>, IDungeonServices<?>> mapDungeon = new HashMap<>();
    static {
        map.put(Area.class,new DungeonAreaFunctions());
        map.put(Biome.class,new BiomeFunctions());
        map.put(Creature.class,new CreatureFunctions());
        map.put(Danger.class,new DangerFunctions());
        map.put(Discovery.class,new DiscoveryFunctions());
        map.put(Dungeon.class,new DungeonFunctions());
        map.put(AreaDanger.class,new DungeonDangerFunctions());
        map.put(AreaDiscovery.class,new DungeonDiscoveryFunctions());
        map.put(Follower.class,new FollowerFunctions());
        map.put(NPC.class,new NPCFunctions());
        map.put(Quest.class,new QuestFunctions());
        map.put(Steading.class,new SteadingFunctions());

        mapDungeon.put(Area.class, new DungeonAreaFunctions());

    }

    @SuppressWarnings("unchecked")
    public static <T extends IPWClass> IGenericServices<T> getServiceFile(Class<T> c) {



        return (IGenericServices<T>) map.get(c);
    }
}


