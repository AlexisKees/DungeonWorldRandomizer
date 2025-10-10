package data;

public class SteadingArrays {

    /* ========= 1) NIVEL SUPERIOR: SETTLEMENT SIZE (d12) ========= */

    public static final String[] SETTLEMENT_SIZE = {
            "VILLAGE", "VILLAGE", "VILLAGE", "VILLAGE", "VILLAGE", // 0–4 → 1–5
            "TOWN", "TOWN", "TOWN",                                 // 5–7 → 6–8
            "KEEP", "KEEP", "KEEP",                                 // 8–10 → 9–11
            "CITY"                                                  // 11 → 12
    };


    /* ========= 2) NIVEL POR TIPO: FEATURES & PROBLEMS ========= */

    /* ----- VILLAGE ----- */

    public static final String[] VILLAGE_FEATURES = {
            "Natural defenses: safe, +defenses",                        // 0 (1–3)
            "Natural defenses: safe, +defenses",                        // 1
            "Natural defenses: safe, +defenses",                        // 2
            "Abundant resources: +prosperity, resource (GM choice), enmity (GM choice)", // 3 (4–6)
            "Abundant resources: +prosperity, resource (GM choice), enmity (GM choice)", // 4
            "Abundant resources: +prosperity, resource (GM choice), enmity (GM choice)", // 5
            "Protected by another steading: oath (that steading), +defenses",            // 6 (7–8)
            "Protected by another steading: oath (that steading), +defenses",            // 7
            "On a major road: trade (GM choice), +prosperity",          // 8 (9–10)
            "On a major road: trade (GM choice), +prosperity",          // 9
            "Built around a wizard’s tower: personage (the wizard), blight (arcane creatures)", // 10 (11)
            "Built on a site of religious significance: divine, history (GM choice)"             // 11 (12)
    };

    public static final String[] VILLAGE_PROBLEMS = {
            "Surrounded by arid or uncultivable land: need (food)",              // 0 (1–2)
            "Surrounded by arid or uncultivable land: need (food)",              // 1
            "Dedicated to a deity: religious (that deity), enmity (steading of opposing deity)", // 2 (3–4)
            "Dedicated to a deity: religious (that deity), enmity (steading of opposing deity)", // 3
            "Recently at war: -population, -prosperity if fought to the end, -defenses if lost", // 4 (5–6)
            "Recently at war: -population, -prosperity if fought to the end, -defenses if lost", // 5
            "Monster problem: blight (that monster), need (adventurers)",         // 6 (7–8)
            "Monster problem: blight (that monster), need (adventurers)",         // 7
            "Absorbed another village: +population, lawless",                     // 8 (9–10)
            "Absorbed another village: +population, lawless",                     // 9
            "Remote or unwelcoming: -prosperity, dwarven or elven or other non-human", // 10 (11–12)
            "Remote or unwelcoming: -prosperity, dwarven or elven or other non-human"  // 11
    };


    /* ----- TOWN ----- */

    public static final String[] TOWN_FEATURES = {
            "Booming: +booming, lawless",                         // 0 (1)
            "At a crossroads: market, +prosperity",               // 1 (2–3)
            "At a crossroads: market, +prosperity",               // 2
            "Defended by another steading: oath (that steading), +defenses", // 3 (4–5)
            "Defended by another steading: oath (that steading), +defenses", // 4
            "Built around a church: power (divine)",              // 5 (6–7)
            "Built around a church: power (divine)",              // 6
            "Center of craft: craft (your choice), resource (something required for that craft)", // 7 (8–10)
            "Center of craft: craft (your choice), resource (something required for that craft)", // 8
            "Center of craft: craft (your choice), resource (something required for that craft)", // 9
            "Stands around a military post: +defenses",           // 10 (11–12)
            "Stands around a military post: +defenses"            // 11
    };

    public static final String[] TOWN_PROBLEMS = {
            "Outgrowing a vital resource: need (that resource), trade (a steading with that resource)", // 0 (1–2)
            "Outgrowing a vital resource: need (that resource), trade (a steading with that resource)", // 1
            "Offers defense to others: oath (GM choice), -defenses",              // 2 (3–4)
            "Offers defense to others: oath (GM choice), -defenses",              // 3
            "Outlaw rumored to live there: personage (the outlaw), enmity (steading preyed upon)", // 4 (5–6)
            "Outlaw rumored to live there: personage (the outlaw), enmity (steading preyed upon)", // 5
            "Controls a good/service: exotic (that good/service), enmity (steading with ambition)", // 6 (7–8)
            "Controls a good/service: exotic (that good/service), enmity (steading with ambition)", // 7
            "Suffers from disease: -population",                  // 8 (9–10)
            "Suffers from disease: -population",                  // 9
            "Popular meeting place: +population, lawless",        // 10 (11–12)
            "Popular meeting place: +population, lawless"         // 11
    };


    /* ----- KEEP ----- */

    public static final String[] KEEP_FEATURES = {
            "Belongs to a noble family: +prosperity, power (political)",        // 0 (1–2)
            "Belongs to a noble family: +prosperity, power (political)",        // 1
            "Run by a skilled commander: personage (the commander), +defenses", // 2 (3–4)
            "Run by a skilled commander: personage (the commander), +defenses", // 3
            "Stands watch over a trade road: +prosperity, guild (trade)",       // 4 (5–6)
            "Stands watch over a trade road: +prosperity, guild (trade)",       // 5
            "Used to train special troops: arcane, +population",                // 6 (7–8)
            "Used to train special troops: arcane, +population",                // 7
            "Surrounded by fertile land: remove need (Supplies)",               // 8 (9–10)
            "Surrounded by fertile land: remove need (Supplies)",               // 9
            "Stands on a border: +defenses, enmity (steading on the other side of the border)", // 10 (11–12)
            "Stands on a border: +defenses, enmity (steading on the other side of the border)"  // 11
    };

    public static final String[] KEEP_PROBLEMS = {
            "Built on a naturally defensible position: safe, -population", // 0 (1–3)
            "Built on a naturally defensible position: safe, -population", // 1
            "Built on a naturally defensible position: safe, -population", // 2
            "Formerly occupied by another power: enmity (steadings of that power)", // 3 (4)
            "Safe haven for brigands: lawless",                               // 4 (5)
            "Built to defend from a specific threat: blight (that threat)",   // 5 (6)
            "Has seen horrible bloody war: history (battle), blight (restless spirits)", // 6 (7)
            "Is given the worst of the worst: need (skilled recruits)",       // 7 (8)
            "Suffers from disease: -population",                              // 8 (9–10)
            "Suffers from disease: -population",                              // 9
            "Popular meeting place: +population, -law",                       // 10 (11–12)
            "Popular meeting place: +population, -law"                        // 11
    };


    /* ----- CITY ----- */

    public static final String[] CITY_FEATURES = {
            "Permanent defenses, such as walls: +defenses, oath (GM’s choice)",     // 0 (1–3)
            "Permanent defenses, such as walls: +defenses, oath (GM’s choice)",     // 1
            "Permanent defenses, such as walls: +defenses, oath (GM’s choice)",     // 2
            "Ruled by a single individual: personage (the ruler), power (political)", // 3 (4–6)
            "Ruled by a single individual: personage (the ruler), power (political)", // 4
            "Ruled by a single individual: personage (the ruler), power (political)", // 5
            "Diverse: dwarven or elven or both",                                    // 6 (7)
            "Trade hub: trade (every nearby steading), +prosperity",                 // 7 (8–10)
            "Trade hub: trade (every nearby steading), +prosperity",                 // 8
            "Trade hub: trade (every nearby steading), +prosperity",                 // 9
            "Ancient, built on top of its own ruins: history (your choice), divine", // 10 (11)
            "Center of learning: arcane, craft (your choice), power (arcane)"        // 11 (12)
    };

    public static final String[] CITY_PROBLEMS = {
            "Outgrown its resources: +population, need (food)",               // 0 (1–3)
            "Outgrown its resources: +population, need (food)",               // 1
            "Outgrown its resources: +population, need (food)",               // 2
            "Designs on nearby territory: enmity (nearby steadings), +defenses", // 3 (4–6)
            "Designs on nearby territory: enmity (nearby steadings), +defenses", // 4
            "Designs on nearby territory: enmity (nearby steadings), +defenses", // 5
            "Ruled by a theocracy: -defenses, power (divine)",                // 6 (7–8)
            "Ruled by a theocracy: -defenses, power (divine)",                // 7
            "Ruled by the people: -defenses, +population",                    // 8 (9–10)
            "Ruled by the people: -defenses, +population",                    // 9
            "Supernatural defenses: +defenses, blight (related supernatural creatures)", // 10 (11)
            "Occupies a place of power: arcane, personage (watcher of the place of power), blight (arcane creatures)" // 11 (12)
    };

}
