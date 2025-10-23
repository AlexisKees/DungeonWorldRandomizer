package service.util;

import domain.*;
import service.*;

import java.util.HashMap;
import java.util.Map;

public class ClassIdentifier {
    private static final Map<Class<?>, IAllServices<?>> map = new HashMap<>();

    static {
        map.put(Area.class,new AreaFunctions());
        map.put(Biome.class,new BiomeFunctions());
        map.put(Creature.class,new CreatureFunctions());
        map.put(Danger.class,new DangerFunctions());
        map.put(Discovery.class,new DiscoveryFunctions());
        map.put(AreaDanger.class,new DungeonDangerFunctions());
        map.put(AreaDiscovery.class,new DungeonDiscoveryFunctions());
        map.put(Follower.class,new FollowerFunctions());
        map.put(NPC.class,new NPCFunctions());
        map.put(Steading.class,new SteadingFunctions());
    }

    @SuppressWarnings("unchecked")
    public static <T extends IPWClass> IAllServices<T> getServiceFile(Class<T> c) {
        return (IAllServices<T>) map.get(c);
    }
}


