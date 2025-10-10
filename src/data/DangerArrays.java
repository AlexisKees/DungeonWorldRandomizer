package data;

public class DangerArrays {
    /* ========== 1) CATEGORIES (d12 → 0..11) ========== */

    public static final String[] DANGER_CATEGORIES = {
            "UNNATURAL ENTITY", // 0  (1)
            "HAZARD",           // 1  (2)
            "HAZARD",           // 2  (3)
            "HAZARD",           // 3  (4)
            "HAZARD",           // 4  (5)
            "HAZARD",           // 5  (6)
            "CREATURE",         // 6  (7)
            "CREATURE",         // 7  (8)
            "CREATURE",         // 8  (9)
            "CREATURE",         // 9  (10)
            "CREATURE",         // 10 (11)
            "CREATURE"          // 11 (12)
    };


    /* ========== 2) SUBCATEGORIES POR CATEGORÍA (d12) ========== */

    /* ---- UNNATURAL ENTITY ---- */
    public static final String[] UNNATURAL_ENTITY_SUBCATEGORIES = {
            "Divine",  // 0 (1)
            "Planar",  // 1 (2)
            "Planar",  // 2 (3)
            "Planar",  // 3 (4)
            "Undead",  // 4 (5)
            "Undead",  // 5 (6)
            "Undead",  // 6 (7)
            "Undead",  // 7 (8)
            "Undead",  // 8 (9)
            "Undead",  // 9 (10)
            "Undead",  // 10 (11)
            "Undead"   // 11 (12)
    };

    /* ---- HAZARD ---- */
    public static final String[] HAZARD_SUBCATEGORIES = {
            "Unnatural", // 0 (1)
            "Unnatural", // 1 (2)
            "Natural",   // 2 (3)
            "Natural",   // 3 (4)
            "Natural",   // 4 (5)
            "Natural",   // 5 (6)
            "Natural",   // 6 (7)
            "Natural",   // 7 (8)
            "Natural",   // 8 (9)
            "Natural",   // 9 (10)
            "Natural",   // 10 (11)
            "Natural"    // 11 (12)
    };

    /* ---- CREATURE ---- (sin subtítulos propios) */
    public static final String[] CREATURE_SUBCATEGORIES = {
            "Creature","Creature","Creature","Creature",
            "Creature","Creature","Creature","Creature",
            "Creature","Creature","Creature","Creature"
    };


    /* ========== 3) PROMPTS POR SUBTÍTULO (d12) ========== */
    /* ---- UNNATURAL ENTITY → DIVINE ---- */
    public static final String[] DIVINE_PROMPTS = {
            "agent",             // 0 (1–5)
            "agent",             // 1
            "agent",             // 2
            "agent",             // 3
            "agent",             // 4
            "champion",          // 5 (6–9)
            "champion",          // 6
            "champion",          // 7
            "champion",          // 8
            "army/force",        // 9 (10–11)
            "army/force",        // 10
            "avatar/embodiment"  // 11 (12)
    };

    /* ---- UNNATURAL ENTITY → PLANAR ---- */
    public static final String[] PLANAR_PROMPTS = {
            "imp/sprite",               // 0 (1–3)
            "imp/sprite",               // 1
            "imp/sprite",               // 2
            "lesser demon/elemental",   // 3 (4–6)
            "lesser demon/elemental",   // 4
            "lesser demon/elemental",   // 5
            "demon/elemental",          // 6 (7–9)
            "demon/elemental",          // 7
            "demon/elemental",          // 8
            "greater demon/elemental",  // 9 (10–11)
            "greater demon/elemental",  // 10
            "devil/elemental lord"      // 11 (12)
    };

    /* ---- UNNATURAL ENTITY → UNDEAD ---- */
    public static final String[] UNDEAD_PROMPTS = {
            "haunt/wisp",               // 0 (1–4)
            "haunt/wisp",               // 1
            "haunt/wisp",               // 2
            "haunt/wisp",               // 3
            "phantom/shadow",           // 4 (5–6)
            "phantom/shadow",           // 5
            "ghost/specter",            // 6 (7–9)
            "ghost/specter",            // 7
            "ghost/specter",            // 8
            "wight/wraith/revenant",    // 9 (10–11)
            "wight/wraith/revenant",    // 10
            "spirit lord/lich"          // 11 (12)
    };

    /* ---- HAZARD → UNNATURAL ---- */
    public static final String[] UNNATURAL_PROMPTS = {
            "taint/blight/curse",                          // 0 (1–5)
            "taint/blight/curse",                          // 1
            "taint/blight/curse",                          // 2
            "taint/blight/curse",                          // 3
            "taint/blight/curse",                          // 4
            "magical: natural + MAGIC TYPE [p55]",         // 5 (6–9)
            "magical: natural + MAGIC TYPE [p55]",         // 6
            "magical: natural + MAGIC TYPE [p55]",         // 7
            "magical: natural + MAGIC TYPE [p55]",         // 8
            "planar: natural + ELEMENT [p55]",             // 9 (10–11)
            "planar: natural + ELEMENT [p55]",             // 10
            "divine: natural + deity"                      // 11 (12)
    };

    /* ---- HAZARD → NATURAL ---- */
    public static final String[] NATURAL_PROMPTS = {
            "oddity-based [p55]",                                            // 0 (1)
            "tectonic/volcanic",                                             // 1 (2)
            "unseen pitfall (chasm, crevasse, abyss, rift)",                 // 2 (3–4)
            "unseen pitfall (chasm, crevasse, abyss, rift)",                 // 3
            "ensnaring (bog, mire, tarpit, quicksand, etc.)",                // 4 (5–6)
            "ensnaring (bog, mire, tarpit, quicksand, etc.)",                // 5
            "defensive (created by local creature)",                         // 6 (7)
            "meteorological (blizzard, thunderstorm, sandstorm, etc.)",      // 7 (8–10)
            "meteorological (blizzard, thunderstorm, sandstorm, etc.)",      // 8
            "meteorological (blizzard, thunderstorm, sandstorm, etc.)",      // 9
            "seasonal (fire, flood, avalanche, etc.)",                       // 10 (11)
            "impairing (mist, fog, murk, gloom, miasma, etc.)"               // 11 (12)
    };

}
