package data;

public class DiscoveryArrays {

    /* ========== 1) CATEGORIES (d12 → índices 0–11) ========== */

    public static final String[] DISCOVERY_CATEGORIES = {
            "UNNATURAL FEATURE",   // 0  (1)
            "NATURAL FEATURE",     // 1  (2)
            "NATURAL FEATURE",     // 2  (3)
            "NATURAL FEATURE",     // 3  (4)
            "EVIDENCE",            // 4  (5)
            "EVIDENCE",            // 5  (6)
            "CREATURE",            // 6  (7)
            "CREATURE",            // 7  (8)
            "STRUCTURE",           // 8  (9)
            "STRUCTURE",           // 9  (10)
            "STRUCTURE",           // 10 (11)
            "STRUCTURE"            // 11 (12)
    };


    /* ========== 2) SUBCATEGORIES POR CATEGORÍA (d12) ========== */
    /* ---- UNNATURAL FEATURE ---- */
    public static final String[] UNNATURAL_FEATURE_SUBCATEGORIES = {
            "Divine",  // 0 (1)
            "Planar",  // 1 (2)
            "Planar",  // 2 (3)
            "Arcane",  // 3 (4)
            "Arcane",  // 4 (5)
            "Arcane",  // 5 (6)
            "Arcane",  // 6 (7)
            "Arcane",  // 7 (8)
            "Arcane",  // 8 (9)
            "Arcane",  // 9 (10)
            "Arcane",  // 10 (11)
            "Arcane"   // 11 (12)
    };

    /* ---- NATURAL FEATURE ---- */
    public static final String[] NATURAL_FEATURE_SUBCATEGORIES = {
            "Lair",           // 0 (1)
            "Lair",           // 1 (2)
            "Terrain Change", // 2 (3)
            "Terrain Change", // 3 (4)
            "Water Feature",  // 4 (5)
            "Water Feature",  // 5 (6)
            "Landmark",       // 6 (7)
            "Landmark",       // 7 (8)
            "Flora/Fauna",    // 8 (9)
            "Flora/Fauna",    // 9 (10)
            "Resource",       // 10 (11)
            "Resource"        // 11 (12)
    };

    /* ---- EVIDENCE ---- */
    public static final String[] EVIDENCE_SUBCATEGORIES = {
            "Tracks/Spoor",    // 0 (1)
            "Tracks/Spoor",    // 1 (2)
            "Tracks/Spoor",    // 2 (3)
            "Tracks/Spoor",    // 3 (4)
            "Tracks/Spoor",    // 4 (5)
            "Tracks/Spoor",    // 5 (6)
            "Remains/Debris",  // 6 (7)
            "Remains/Debris",  // 7 (8)
            "Remains/Debris",  // 8 (9)
            "Remains/Debris",  // 9 (10)
            "Stash/Cache",     // 10 (11)
            "Stash/Cache"      // 11 (12)
    };

    /* ---- CREATURE ----
       (esta categoría no tiene subtítulos propios en la tabla;
        si preferís homogeneidad, podés usar un solo subcategoría repetida)
    */
    public static final String[] CREATURE_SUBCATEGORIES = {
            "Creature","Creature","Creature","Creature",
            "Creature","Creature","Creature","Creature",
            "Creature","Creature","Creature","Creature"
    };

    /* ---- STRUCTURE ---- */
    public static final String[] STRUCTURE_SUBCATEGORIES = {
            "Enigmatic",      // 0 (1)
            "Infrastructure", // 1 (2)
            "Infrastructure", // 2 (3)
            "Dwelling",       // 3 (4)
            "Dwelling",       // 4 (5)
            "Religious",      // 5 (6)
            "Religious",      // 6 (7)
            "Ruin",           // 7 (8)
            "Ruin",           // 8 (9)
            "Ruin",           // 9 (10)
            "Ruin",           // 10 (11)
            "Steading"        // 11 (12)
    };


    /* ========== 3) PROMPTS POR SUBTÍTULO (d12) ========== */
    /* ---- UNNATURAL FEATURE → DIVINE ---- */
    public static final String[] DIVINE_PROMPTS = {
            "presence/manifestation", // 0 (1)
            "protected place",        // 1 (2)
            "protected place",        // 2 (3)
            "protected place",        // 3 (4)
            "protected place",        // 4 (5)
            "protected place",        // 5 (6)
            "protected place",        // 6 (7)
            "cursed/defiled place",   // 7 (8)
            "cursed/defiled place",   // 8 (9)
            "cursed/defiled place",   // 9 (10)
            "blessed/sacred place",   // 10 (11)
            "blessed/sacred place"    // 11 (12)
    };

    /* ---- UNNATURAL FEATURE → PLANAR ---- */
    public static final String[] PLANAR_PROMPTS = {
            "outpost",       // 0 (1)
            "portal/gate",   // 1 (2)
            "portal/gate",   // 2 (3)
            "portal/gate",   // 3 (4)
            "rift/tear",     // 4 (5)
            "rift/tear",     // 5 (6)
            "rift/tear",     // 6 (7)
            "rift/tear",     // 7 (8)
            "distortion/warp", // 8 (9)
            "distortion/warp", // 9 (10)
            "distortion/warp", // 10 (11)
            "distortion/warp"  // 11 (12)
    };

    /* ---- UNNATURAL FEATURE → ARCANE ---- */
    public static final String[] ARCANE_PROMPTS = {
            "blight/mutation",     // 0 (1)
            "blight/mutation",     // 1 (2)
            "blight/mutation",     // 2 (3)
            "blight/mutation",     // 3 (4)
            "enchantment/portal",  // 4 (5)
            "enchantment/portal",  // 5 (6)
            "enchantment/portal",  // 6 (7)
            "taint/residue",       // 7 (8)
            "taint/residue",       // 8 (9)
            "taint/residue",       // 9 (10)
            "source/resource",     // 10 (11)
            "source/resource"      // 11 (12)
    };

    /* ---- NATURAL FEATURE → LAIR ---- */
    public static final String[] LAIR_PROMPTS = {
            "RUIN [p49]",         // 0 (1)
            "RUIN [p49]",         // 1 (2)
            "RUIN [p49]",         // 2 (3)
            "RUIN [p49]",         // 3 (4)
            "cave/tunnel",        // 4 (5)
            "cave/tunnel",        // 5 (6)
            "cave/tunnel",        // 6 (7)
            "nest/hive/aerie",    // 7 (8)
            "nest/hive/aerie",    // 8 (9)
            "den/burrow/warren",  // 9 (10)
            "den/burrow/warren",  // 10 (11)
            "den/burrow/warren"   // 11 (12)
    };

    /* ---- NATURAL FEATURE → TERRAIN CHANGE ---- */
    public static final String[] TERRAIN_CHANGE_PROMPTS = {
            "hollow/cleft/defile",     // 0 (1)
            "hollow/cleft/defile",     // 1 (2)
            "hollow/cleft/defile",     // 2 (3)
            "canyon/valley/vale/dale", // 3 (4)
            "canyon/valley/vale/dale", // 4 (5)
            "canyon/valley/vale/dale", // 5 (6)
            "multilevel/tiered",       // 6 (7)
            "multilevel/tiered",       // 7 (8)
            "pocket of TERRAIN [p55]", // 8 (9)
            "pocket of TERRAIN [p55]", // 9 (10)
            "slope up/down",           // 10 (11)
            "slope up/down"            // 11 (12)
    };

    /* ---- NATURAL FEATURE → WATER FEATURE ---- */
    public static final String[] WATER_FEATURE_PROMPTS = {
            "sea/ocean",        // 0 (1)
            "river",            // 1 (2)
            "river",            // 2 (3)
            "river",            // 3 (4)
            "lake/pond/mere/tarn", // 4 (5)
            "lake/pond/mere/tarn", // 5 (6)
            "brook/stream/rill",   // 6 (7)
            "brook/stream/rill",   // 7 (8)
            "brook/stream/rill",   // 8 (9)
            "brook/stream/rill",   // 9 (10)
            "spring/hot spring",   // 10 (11)
            "spring/hot spring"    // 11 (12)
    };

    /* ---- NATURAL FEATURE → LANDMARK ---- */
    public static final String[] LANDMARK_PROMPTS = {
            "ODDITY [p55]",        // 0 (1)
            "striking landscape",  // 1 (2)
            "striking landscape",  // 2 (3)
            "earth-based",         // 3 (4)
            "earth-based",         // 4 (5)
            "earth-based",         // 5 (6)
            "plant-based",         // 6 (7)
            "plant-based",         // 7 (8)
            "plant-based",         // 8 (9)
            "water-based",         // 9 (10)
            "water-based",         // 10 (11)
            "water-based"          // 11 (12)
    };

    /* ---- NATURAL FEATURE → FLORA/FAUNA ---- */
    public static final String[] FLORA_FAUNA_PROMPTS = {
            "notable plant/flower", // 0 (1)
            "notable plant/flower", // 1 (2)
            "notable plant/flower", // 2 (3)
            "notable tree/brush",   // 3 (4)
            "notable tree/brush",   // 4 (5)
            "notable BEAST [p53]",  // 5 (6)
            "notable BEAST [p53]",  // 6 (7)
            "notable BEAST [p53]",  // 7 (8)
            "useful plant/herb/root", // 8 (9)
            "useful plant/herb/root", // 9 (10)
            "useful BEAST [p53]",     // 10 (11)
            "useful BEAST [p53]"      // 11 (12)
    };

    /* ---- NATURAL FEATURE → RESOURCE ---- */
    public static final String[] RESOURCE_PROMPTS = {
            "game/fruit/vegetable", // 0 (1)
            "game/fruit/vegetable", // 1 (2)
            "game/fruit/vegetable", // 2 (3)
            "timber/stone",         // 3 (4)
            "timber/stone",         // 4 (5)
            "timber/stone",         // 5 (6)
            "herbs/spice/dye source", // 6 (7)
            "herbs/spice/dye source", // 7 (8)
            "herbs/spice/dye source", // 8 (9)
            "copper/tin/iron",      // 9 (10)
            "copper/tin/iron",      // 10 (11)
            "gold/silver/gems"      // 11 (12)
    };

    /* ---- EVIDENCE → TRACKS/SPOOR ---- */
    public static final String[] TRACKS_SPOOR_PROMPTS = {
            "trail of blood/fluid", // 0 (1)
            "trail of blood/fluid", // 1 (2)
            "signs of violence",    // 2 (3)
            "signs of violence",    // 3 (4)
            "multiple/many signs",  // 4 (5)
            "multiple/many signs",  // 5 (6)
            "definite/recent/clear",// 6 (7)
            "definite/recent/clear",// 7 (8)
            "definite/recent/clear",// 8 (9)
            "definite/recent/clear",// 9 (10)
            "faint/old/unclear",    // 10 (11)
            "faint/old/unclear"     // 11 (12)
    };

    /* ---- EVIDENCE → REMAINS/DEBRIS ---- */
    public static final String[] REMAINS_DEBRIS_PROMPTS = {
            "bones of CREATURE [p53]", // 0 (1)
            "bones of CREATURE [p53]", // 1 (2)
            "bones of CREATURE [p53]", // 2 (3)
            "bones of CREATURE [p53]", // 3 (4)
            "CREATURE carcass",        // 4 (5)
            "CREATURE carcass",        // 5 (6)
            "CREATURE carcass",        // 6 (7)
            "junk/refuse",             // 7 (8)
            "junk/refuse",             // 8 (9)
            "junk/refuse",             // 9 (10)
            "lost supplies/gear",      // 10 (11)
            "tools/weapons/armor"      // 11 (12)
    };

    /* ---- EVIDENCE → STASH/CACHE ---- */
    public static final String[] STASH_CACHE_PROMPTS = {
            "trinkets/coins",       // 0 (1)
            "trinkets/coins",       // 1 (2)
            "trinkets/coins",       // 2 (3)
            "trinkets/coins",       // 3 (4)
            "trinkets/coins",       // 4 (5)
            "tools/weapons/armor",  // 5 (6)
            "tools/weapons/armor",  // 6 (7)
            "tools/weapons/armor",  // 7 (8)
            "map/note",             // 8 (9)
            "map/note",             // 9 (10)
            "food/supplies",        // 10 (11)
            "treasure [p47]"        // 11 (12)
    };

    /* ---- STRUCTURE → ENIGMATIC ---- */
    public static final String[] ENIGMATIC_PROMPTS = {
            "ODDITY [p55]",        // 0 (1)
            "ODDITY [p55]",        // 1 (2)
            "mound/earthworks",    // 2 (3)
            "mound/earthworks",    // 3 (4)
            "mound/earthworks",    // 4 (5)
            "mound/earthworks",    // 5 (6)
            "monument/megalith",   // 6 (7)
            "monument/megalith",   // 7 (8)
            "monument/megalith",   // 8 (9)
            "statue/idol/totem",   // 9 (10)
            "statue/idol/totem",   // 10 (11)
            "statue/idol/totem"    // 11 (12)
    };

    /* ---- STRUCTURE → INFRASTRUCTURE ---- */
    public static final String[] INFRASTRUCTURE_PROMPTS = {
            "signpost/marker",     // 0 (1)
            "signpost/marker",     // 1 (2)
            "signpost/marker",     // 2 (3)
            "signpost/marker",     // 3 (4)
            "bridge/aqueduct",     // 4 (5)
            "bridge/aqueduct",     // 5 (6)
            "track/path/trail/road", // 6 (7)
            "track/path/trail/road", // 7 (8)
            "track/path/trail/road", // 8 (9)
            "track/path/trail/road", // 9 (10)
            "mine/quarry",         // 10 (11)
            "mine/quarry"          // 11 (12)
    };

    /* ---- STRUCTURE → DWELLING ---- */
    public static final String[] DWELLING_PROMPTS = {
            "campsite/hovel/hut",  // 0 (1)
            "campsite/hovel/hut",  // 1 (2)
            "campsite/hovel/hut",  // 2 (3)
            "campsite/hovel/hut",  // 3 (4)
            "homestead/farmstead", // 4 (5)
            "homestead/farmstead", // 5 (6)
            "homestead/farmstead", // 6 (7)
            "homestead/farmstead", // 7 (8)
            "inn/toll house/mill", // 8 (9)
            "inn/toll house/mill", // 9 (10)
            "tower/keep/castle",   // 10 (11)
            "tower/keep/castle"    // 11 (12)
    };

    /* ---- STRUCTURE → RELIGIOUS ---- */
    public static final String[] RELIGIOUS_PROMPTS = {
            "grave marker",              // 0 (1)
            "grave marker",              // 1 (2)
            "grave marker",              // 2 (3)
            "graveyard/burial ground",   // 3 (4)
            "graveyard/burial ground",   // 4 (5)
            "graveyard/burial ground",   // 5 (6)
            "tomb/crypt/barrow",         // 6 (7)
            "tomb/crypt/barrow",         // 7 (8)
            "tomb/crypt/barrow",         // 8 (9)
            "temple/monastery",          // 9 (10)
            "temple/monastery",          // 10 (11)
            "great temple/sanctuary"     // 11 (12)
    };

    /* ---- STRUCTURE → RUIN ---- */
    public static final String[] RUIN_PROMPTS = {
            "dungeon [p58]",         // 0 (1)
            "dungeon [p58]",         // 1 (2)
            "dungeon [p58]",         // 2 (3)
            "steading [p50]",        // 3 (4)
            "steading [p50]",        // 4 (5)
            "steading [p50]",        // 5 (6)
            "religious (1d8+4)",     // 6 (7)
            "religious (1d8+4)",     // 7 (8)
            "dwelling (1d8+4)",      // 8 (9)
            "dwelling (1d8+4)",      // 9 (10)
            "infrastructure (1d8+4)",// 10 (11)
            "infrastructure (1d8+4)" // 11 (12)
    };

    /* ---- STRUCTURE → STEADING ---- */
    public static final String[] STEADING_PROMPTS = {
            "village [p50]", // 0 (1)
            "village [p50]", // 1 (2)
            "village [p50]", // 2 (3)
            "village [p50]", // 3 (4)
            "village [p50]", // 4 (5)
            "town [p50]",    // 5 (6)
            "town [p50]",    // 6 (7)
            "town [p50]",    // 7 (8)
            "keep [p51]",    // 8 (9)
            "keep [p51]",    // 9 (10)
            "keep [p51]",    // 10 (11)
            "city [p51]"     // 11 (12)
    };

}
