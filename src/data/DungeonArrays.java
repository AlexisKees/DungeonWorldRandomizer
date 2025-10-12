package data;

public class DungeonArrays {

    /* ========== 1) NAME TEMPLATES (6 únicos) ========== */
    public static final String[] DUNGEON_NAME_TEMPLATES = {
            "The [PLACE]",
            "(The) [ADJECTIVE] [PLACE]",
            "(The) [PLACE] of the [NOUN]",
            "(The) [NOUN]'s [PLACE]",
            "[PLACE] of the [ADJECTIVE] [NOUN]",
            "(The) [ADJECTIVE] [NOUN]"
    };

    /* ========== 2) PLACES (50 únicos, sin repeticiones) ========== */
    public static final String[] DUNGEON_PLACES = {
            "Archive","Blight","Boneyard","Catacomb","Cave(s)",
            "Cavern(s)","Citadel","Cliff","Crack","Crag",
            "Crypt","Curse","Deep","Delve","Den",
            "Finger","Fist","Fort","Fortress","Grave",
            "Haunt","Hold","Hole(s)","Hollow(s)","Home",
            "House","Jaws","Keep","Lair","Maw",
            "Maze","Mountain","Mouth","Peak","Pit",
            "Remnant","Retreat","Ruin","Shrine","Skull",
            "Spire","Temple","Throne","Tomb","Tooth",
            "Tower","Tunnel(s)","Vault","Warren","Wreck"
    };

    /* ========== 3) ADJECTIVES (50 únicos, sin repeticiones) ========== */
    public static final String[] DUNGEON_ADJECTIVES = {
            "Ancient","Ashen","Black","Bloody","Blue",
            "Broken","Burning","Cracked","Dark","Dead", "Doomed",
            "Endless","Evil","Fallen","Far","Fearsome",
            "Floating","Forbidden","Forgotten","Frozen","Ghostly",
            "Gloomy","Gray","Grim","Hidden","High",
            "Holy","Iron","Jagged","Lonely","Lost",
            "Low","Misty","Petrified","Red","Screaming",
            "Sharp","Shattered","Shifting","Shivering","Shrouded",
            "Stoney","Sunken","Thorny","Thundering","Unholy",
            "White","Wicked","Withered","Yellow"
    };

    /* ========== 4) NOUNS (50 únicos, sin repeticiones) ========== */
    public static final String[] DUNGEON_NOUNS = {
            "Arm","Ash","Beast","Behemoth","Blood",
            "Child","Cinder","Corpse","Crystal","Dagger",
            "Death","Demon","Devil","Doom","Dragon",
            "Eye","Fear","Finger","Fire","Foot",
            "Frog","Ghost","Giant","Goblin","God",
            "Hand","Head","Heart","Horror","Hero",
            "Horn","King","Knave","Priest","Prophet",
            "Queen","Ring","Shard","Skull","Souls",
            "Spear","Spirit","Stone","Sword","Troll",
            "Warrior","Water","Witch","Wizard","Worm"
    };


    /* ================== DUNGEON SIZE (1 nivel) ================== */

    public static final String[] DUNGEON_SIZE = {
            "small","small","small",       // 1–3
            "medium","medium","medium",    // 4–6
            "large","large","large",       // 7–9
            "huge","huge",                 // 10–11
            "megadungeon"                  // 12
    };


    /* ================== DUNGEON THEMES (2 niveles) ================== */

    /* Categorías (según tirada 1d12 → 0..11) */
    public static final String[] DUNGEON_THEME_CATEGORIES = {
            "HOPEFUL","HOPEFUL",   // 1–2
            "MYSTERIOUS","MYSTERIOUS","MYSTERIOUS", // 3–5
            "GRIM","GRIM","GRIM","GRIM","GRIM","GRIM", // 6–11
            "GONZO" // 12
    };

    /* ---- HOPEFUL PROMPTS ---- */
    public static final String[] HOPEFUL_PROMPTS = {
            "nature/growth",
            "law/order",
            "beauty/wonder",
            "healing/recovery",
            "protection/defense",
            "completion",
            "inheritance/legacy",
            "balance/harmony",
            "light/life",
            "prophecy",
            "divine influence",
            "transcendence"
    };

    /* ---- MYSTERIOUS PROMPTS ---- */
    public static final String[] MYSTERIOUS_PROMPTS = {
            "burglary/theft",
            "desire/obsession",
            "secrets/deception",
            "imitation/mimicry",
            "inversion/reversal",
            "element",
            "transformation",
            "shadow/spirits",
            "cryptic knowledge",
            "divination/scrying",
            "madness",
            "magic type"
    };

    /* ---- GRIM PROMPTS ---- */
    public static final String[] GRIM_PROMPTS = {
            "pride/hubris",
            "hunger/gluttony",
            "greed/avarice",
            "wildness/savagery",
            "devotion/sacrifice",
            "forbidden knowledge",
            "control/dominance",
            "pain/torture",
            "wrath/war",
            "tragedy/loss",
            "chaos/corruption",
            "darkness/death"
    };

    /* ---- GONZO PROMPTS ---- */
    public static final String[] GONZO_PROMPTS = {
            "constructs/robots",
            "unexpected sentience",
            "space/time travel",
            "advanced technology",
            "utter insanity",
            "alien life",
            "cosmic alignment",
            "other planes",
            "demons/devils",
            "unspeakable horrors",
            "elder gods",
            "roll 1d10 twice, combine"
    };


    /* ================== DUNGEON FORM (1 nivel) ================== */

    public static final String[] DUNGEON_FORM = {
            "cave/cavern",
            "ruins of 1d8+3",
            "ruins of 1d8+3",
            "mine",
            "prison",
            "crypt/tomb/catacombs",
            "crypt/tomb/catacombs",
            "stronghold/fortress/citadel",
            "temple/sanctuary",
            "tower/spire",
            "roll 1d10, add oddity",
            "ruins of steading",
    };


    /* ================== DUNGEON SITUATION (1 nivel) ================== */

    public static final String[] DUNGEON_SITUATION = {
            "aboveground","aboveground", // 1–2
            "part aboveground, part below","part aboveground, part below", // 3–4
            "belowground","belowground","belowground","belowground","belowground","belowground","belowground", // 5–11
            "extraordinary (floating, ephemeral, etc.)" // 12
    };


    /* ================== DUNGEON ACCESSIBILITY (1 nivel) ================== */

    public static final String[] DUNGEON_ACCESSIBILITY = {
            "sealed shut",
            "purposely hidden",
            "concealed by natural feature/terrain",
            "concealed by natural feature/terrain",
            "buried (in earth, rubble, etc.)",
            "buried (in earth, rubble, etc.)",
            "blocked by obstacle/out of reach",
            "blocked by obstacle/out of reach",
            "clear/obvious",
            "clear/obvious",
            "multiple entrances",
            "multiple entrances"
    };


    /* ================== DUNGEON BUILDER (1 nivel) ================== */

    public static final String[] DUNGEON_BUILDER = {
            "demigod/demon/alien",
            "natural (caves, etc.)","natural (caves, etc.)",
            "religious order/cult","religious order/cult",
            "humanoid society","humanoid society","humanoid society","humanoid society","humanoid society",
            "wizard/lunatic",
            "monarch/warlord"
    };


    /* ================== DUNGEON FUNCTION (1 nivel) ================== */

    public static final String[] DUNGEON_FUNCTION = {
            "indiscernible/mysterious",
            "concealment/camouflage",
            "extraction/production",
            "confinement/containment",
            "lair/den/hideout",
            "archive/library/laboratory",
            "commemoration/funerary",
            "worship/devotion",
            "defense/protection",
            "observation/divination",
            "empowerment/intensification",
            "roll 1d10+1 twice, combine"
    };


    /* ================== DUNGEON CAUSE OF RUIN (1 nivel) ================== */

    public static final String[] DUNGEON_CAUSE_OF_RUIN = {
            "arcane disaster",
            "damnation/curse",
            "natural disaster (earthquake, etc.)","natural disaster (earthquake, etc.)",
            "plague/famine/drought","plague/famine/drought",
            "overrun by monsters","overrun by monsters",
            "hubris","hubris",
            "war/invasion","war/invasion",
            "depleted resources",
            "better prospects elsewhere"
    };

    /* ================== AREA DRESSING ================== */

    public static final String[] AREA_DRESSING = {
            "breeze/sound/echo",                   // 1
            "smell/odor/stench",                   // 2
            "lichen/mold/moss/fungus",             // 3
            "drip/seep/puddle/stream",             // 4
            "tracks/marks/scratches",              // 5
            "sign of activity/struggle/battle",    // 6
            "bones/remains of creature [p53]",     // 7
            "junk/debris/refuse/waste",            // 8
            "broken structure/furniture",          // 9
            "inscription/ornamentation",           // 10
            "roll 1d10 twice, combine",            // 11
            "roll 1d10 twice, combine"             // 12 (repite la regla)
    };


    /* ================== AREA EXITS ================== */
    /* En este caso hay dos columnas: NUMBER y DIRECTION */

    public static final String[] AREA_EXITS_NUMBER = {
            "0","0",     // 1–2
            "1",         // 3
            "1","1",     // 4–5
            "1",         // 6
            "2",         // 7
            "2","2",     // 8–9
            "3",         // 10
            "4",         // 11
            "1d6+1"      // 12
    };

    public static final String[] AREA_EXITS_DIRECTION = {
            "down",      // 1–2
            "back",      // 3
            "forward","forward","forward", // 4–6
            "forward",   // 7
            "left","left", // 8–9
            "right",     // 10
            "right",     // 11
            "up"         // 12
    };


    /* ================== DUNGEON DISCOVERY ================== */

    // Categorías (1–8 = Feature, 9–12 = Find)
    public static final String[] DUNGEON_DISCOVERY_CATEGORIES = {
            "Feature", "Feature", "Feature", "Feature", "Feature", "Feature", "Feature", "Feature",
            "Find", "Find", "Find", "Find"
    };

    // Prompts - Feature (12 elementos)
    public static final String[] DUNGEON_DISCOVERY_FEATURE_PROMPTS = {
            "cave-in/collapse/obstacle",   // 1
            "blocked/locked exit",         // 2
            "pit/shaft/chasm",             // 3
            "pillars/columns",             // 4
            "alcoves/niches",              // 5
            "bridge/stairs/ramp",          // 6
            "well/pool/fountain",          // 7
            "puzzle",                      // 8
            "altar/dais/platform",         // 9
            "statue/idol",                 // 10
            "multi-level/ledges/tiers",    // 11
            "hidden/secret exit"           // 12
    };

    // Prompts - Find (12 elementos)
    public static final String[] DUNGEON_DISCOVERY_FIND_PROMPTS = {
            "trinkets/clothing",                  // 1
            "supplies/tools/gear",                // 2
            "light source/fuel/ammo",             // 3
            "key/clue/map",                       // 4
            "weapons/armor",                      // 5
            "poison/antidote/potion",             // 6
            "adventurer/captive",                 // 7
            "books/scrolls",                      // 8
            "coins/gems/jewelry",                 // 9
            "roll 1d8, add magic type [p55]",     // 10
            "roll feature, add magic type [p55]", // 11
            "roll 1d10 twice, combine"            // 12
    };


    /* ================== DUNGEON DANGER ================== */

    // Categorías (1–4 = Trap, 5–12 = Creature)
    public static final String[] DUNGEON_DANGER_CATEGORIES = {
            "Trap", "Trap", "Trap", "Trap",
            "Creature", "Creature", "Creature", "Creature",
            "Creature", "Creature", "Creature", "Creature"
    };

    // Prompts - Trap (12 elementos)
    public static final String[] DUNGEON_DANGER_TRAP_PROMPTS = {
            "alarm",                   // 1
            "pit",                     // 2
            "ensnaring/paralyzing",    // 3
            "crushing/smashing",       // 4
            "piercing/puncturing",     // 5
            "chopping/slashing/slicing", // 6
            "confusing (maze, etc.)",  // 7
            "gas (poison, etc.)",      // 8
            "ambush",                  // 9
            "based on Element [p55]",  // 10
            "based on Magic Type [p55]", // 11
            "based on Oddity [p55]"    // 12
    };

    // Prompts - Creature (12 elementos)
    public static final String[] DUNGEON_DANGER_CREATURE_PROMPTS = {
            "Creature leader/lord (with minions)", // 1
            "Creature", // 2
            "Creature", // 3
            "Creature", // 4
            "Creature", // 5
            "Creature", // 6
            "Creature", // 7
            "Creature", // 8
            "Creature", // 9
            "Beast vermin (rats, bats, etc.)", // 10
            "Beast vermin (rats, bats, etc.)", // 11
            "Beast vermin (rats, bats, etc.)"  // 12
    };

    public static final String[] AREA_RARITY = {
            "common", // 1
            "common", // 2
            "common", // 3
            "common", // 4
            "common", // 5
            "common", // 6
            "common", // 7
            "common", // 8
            "common", // 9
            "unique", // 10
            "unique", // 11
            "unique"  // 12
    };

    public static final String[] AREA_TYPE = {
            "Armory",
            "Barracks",
            "Chapel",
            "Kitchen",
            "Library",
            "Laboratory",
            "Prison",
            "Treasure Room",
            "Throne Room",
            "Hallway",
            "Courtyard",
            "Crypt",
            "Storage",
            "Workshop",
            "Dining Hall",
            "Guard Post",
            "Shrine",
            "Vault",
            "Garden",
            "Cellar",
            "Exit",
            "Entrance"
    };
}
