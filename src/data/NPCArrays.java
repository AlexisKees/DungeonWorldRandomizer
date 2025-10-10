package data;

public class NPCArrays {
    public class NpcOccupation {

        public static final String[] CATEGORY ={
                "Outsider",
                "Criminal",
                "Criminal",
                "Commoner",
                "Commoner",
                "Commoner",
                "Tradesperson",
                "Merchant",
                "Specialist",
                "Religious",
                "Security",
                "Authority"
        };

        public static final String[] OUTSIDER = {
                "hermit/prophet",        // 0
                "fugitive/outlaw/exile", // 1
                "fugitive/outlaw/exile", // 2
                "barbarian",             // 3
                "barbarian",             // 4
                "beggar/vagrant/refugee",// 5
                "beggar/vagrant/refugee",// 6
                "herder/hunter/trapper", // 7
                "herder/hunter/trapper", // 8
                "diplomat/envoy",        // 9
                "rare humanoid",         // 10
                "otherworldly/arcane"    // 11
        };

        public static final String[] CRIMINAL = {
                "bandit/brigand/thug", // 0
                "bandit/brigand/thug", // 1
                "cutpurse/thief",      // 2
                "cutpurse/thief",      // 3
                "bodyguard/tough",     // 4
                "bodyguard/tough",     // 5
                "burglar",             // 6
                "con artist/swindler", // 7
                "dealer/fence",        // 8
                "racketeer",           // 9
                "lieutenant",          // 10
                "boss/kingpin"         // 11
        };

        public static final String[] COMMONER = {
                "layabout/simpleton",  // 0
                "beggar/urchin",       // 1
                "laborer/gravedigger", // 2
                "laborer/fisher",      // 3
                "hunter/fisher",       // 4
                "farmer/herder",       // 5
                "farmer/herder",       // 6
                "miner/quarrier",      // 7
                "servant/page",        // 8
                "driver/porter/sailor",// 9
                "sentry/guard",        // 10
                "apprentice/adventurer"// 11
        };

        public static final String[] TRADESPERSON = {
                "musician/troubadour", // 0
                "artist/actor/acrobat",// 1
                "cobbler/furrier/tailor", // 2
                "weaver/basketmaker",  // 3
                "potter/carpenter",    // 4
                "mason/baker/chandler",// 5
                "cooper/wheelwright",  // 6
                "tanner/ropemaker",    // 7
                "stablekeeper/herbalist", // 8
                "vintner/brewer",      // 9
                "innkeep/tavernkeep",  // 10
                "smith/armorer"        // 11
        };

        public static final String[] MERCHANT = {
                "raw materials/supplies", // 0
                "raw materials/supplies", // 1
                "general goods/outfitter", // 2
                "general goods/outfitter", // 3
                "grain/livestock",        // 4
                "ale/wine/spirits",       // 5
                "clothing/jewelry",       // 6
                "weapons/armor",          // 7
                "spices/tobacco",         // 8
                "labor/slaves",           // 9
                "books/scrolls",          // 10
                "magic supplies/items"    // 11
        };

        public static final String[] SPECIALIST = {
                "clerk/scribe",       // 0
                "undertaker",         // 1
                "perfumer",           // 2
                "navigator/guide",    // 3
                "spy/diplomat",       // 4
                "cartographer",       // 5
                "locksmith/tinker",   // 6
                "architect/engineer", // 7
                "physician/apothecary", // 8
                "sage/scholar",       // 9
                "alchemist/astrologer", // 10
                "illusionist/sorcerer" // 11
        };

        public static final String[] RELIGIOUS = {
                "heretic/apostate",   // 0
                "zealot",             // 1
                "mendicant/pilgrim",  // 2
                "mendicant/pilgrim",  // 3
                "acolyte/novice",     // 4
                "acolyte/novice",     // 5
                "monk/nun/cultist",   // 6
                "preacher/prophet",   // 7
                "missionary",         // 8
                "templar/protector",  // 9
                "priest/cleric",      // 10
                "high priest"         // 11
        };

        public static final String[] SECURITY = {
                "militia",        // 0
                "militia",        // 1
                "scout/warden",   // 2
                "watch/patrol",   // 3
                "watch/patrol",   // 4
                "foot soldier",   // 5
                "foot soldier",   // 6
                "archer",         // 7
                "officer/constable", // 8
                "cavalry/knight", // 9
                "hero/general",   // 10
                "hero/general"    // 11
        };

        public static final String[] AUTHORITY = {
                "merchant/moneymaster", // 0
                "town crier",           // 1
                "tax collector",        // 2
                "clerk/administrator",  // 3
                "clerk/administrator",  // 4
                "armiger/gentry",       // 5
                "armiger/gentry",       // 6
                "magistrate/judge",     // 7
                "guildmaster",          // 8
                "noble",                // 9
                "greater nobility",     // 10
                "ruler/warlord"         // 11
        };

        public static final String[] APPEARANCE = {
                "disfigured (missing teeth, eye, etc.)", // 0
                "lasting injury (bad leg, arm, etc.)",   // 1
                "tattooed/pockmarked/scarred",           // 2
                "unkempt/shabby/grubby",                 // 3
                "big/thick/brawny",                      // 4
                "small/scrawny/emaciated",               // 5
                "notable hair (wild, long, none, etc.)", // 6
                "notable nose (big, hooked, etc.)",      // 7
                "notable eyes (blue, bloodshot, etc.)",  // 8
                "clean/well-dressed/well-groomed",       // 9
                "attractive/handsome/stunning",          // 10
                "roll twice, reroll any 12 result"       // 11
        };

        public static final String[] PERSONALITY = {
                "loner/alienated/antisocial", // 0
                "cruel/belligerent/bully",    // 1
                "anxious/fearful/cowardly",   // 2
                "envious/covetous/greedy",    // 3
                "aloof/haughty/arrogant",     // 4
                "awkward/shy/self-loathing",  // 5
                "orderly/compulsive/controlling", // 6
                "confident/impulsive/reckless",   // 7
                "kind/generous/compassionate",    // 8
                "easygoing/relaxed/peaceful",     // 9
                "cheerful/happy/optimistic",      // 10
                "roll twice, reroll any 12 result"// 11
        };

        public static final String[] QUIRK = {
                "insecure/racist/xenophobic",    // 0
                "addict (sweets, drugs, sex, etc.)", // 1
                "phobia (spiders, fire, darkness, etc.)", // 2
                "allergic/asthmatic/chronically ill", // 3
                "skeptic/paranoid",               // 4
                "superstitious/devout/fanatical", // 5
                "miser/pack-rat",                 // 6
                "spendthrift/wastrel",            // 7
                "smart aleck/know-it-all",        // 8
                "artistic/dreamer/delusional",    // 9
                "naive/falsely wise",             // 10
                "roll twice, reroll any 12 result"// 11
        };

        /* ===================== NPC FOLLOWER ===================== */

        public static final String[] FOLLOWER_COMPETENCE = {
                "A liability: Quality -1, +0 tags", // 0
                "A liability: Quality -1, +0 tags", // 1
                "A liability: Quality -1, +0 tags", // 2
                "Competent: Quality +0, +1 tags",   // 3
                "Competent: Quality +0, +1 tags",   // 4
                "Competent: Quality +0, +1 tags",   // 5
                "Competent: Quality +0, +1 tags",   // 6
                "Competent: Quality +0, +1 tags",   // 7
                "Competent: Quality +0, +1 tags",   // 8
                "Fully capable: Quality +1, +2 tags", // 9
                "Fully capable: Quality +1, +2 tags", // 10
                "Exceptional: Quality +2, +4 tags"    // 11
        };

        public static final String[] FOLLOWER_BACKGROUND = {
                "Life of servitude/oppression: +meek",  // 0
                "Life of servitude/oppression: +meek",  // 1
                "Past prime: -1 to Quality, +1 wise",   // 2
                "Has lived a life of danger: +2 tags",  // 3
                "Has lived a life of danger: +2 tags",  // 4
                "Unremarkable",                         // 5
                "Unremarkable",                         // 6
                "Unremarkable",                         // 7
                "Unremarkable",                         // 8
                "Has lived a life of privilege: +1 tag",// 9
                "Specialist: +1 to Quality, -2 tags",   // 10
                "Roll twice, reroll any 12 result"      // 11
        };

        public static final String[] FOLLOWER_LOYALTY = {
                "Little faith in the cause: Loyalty 0", // 0
                "Little faith in the cause: Loyalty 0", // 1
                "Dutiful: Loyalty +1",                  // 2
                "Dutiful: Loyalty +1",                  // 3
                "Dutiful: Loyalty +1",                  // 4
                "Dutiful: Loyalty +1",                  // 5
                "Dutiful: Loyalty +1",                  // 6
                "Dutiful: Loyalty +1",                  // 7
                "Dutiful: Loyalty +1",                  // 8
                "Dutiful: Loyalty +1",                  // 9
                "Devoted to the cause: Loyalty +2",     // 10
                "Devoted to the cause: Loyalty +2"      // 11
        };

        public static final String[] FOLLOWER_INSTINCT = {
                "Loot, pillage, and burn",       // 0
                "Hold a grudge and seek payback",// 1
                "Question leadership or authority", // 2
                "Lord over others",              // 3
                "Lord over others",             //4
                "Act impulsively",               // 5
                "Act impulsively",               //6
                "Give in to temptation",         // 7
                "Give in to temptation",         // 8
                "Slack off",                     // 9
                "Slack off",                     //10
                "Avoid danger or punishment",    // 11

        };

        public static final String[] FOLLOWER_COST = {
                "Debauchery",   // 0
                "Vengeance",    // 1
                "Vengeance",    // 2
                "Lure",         // 3
                "Lure",         // 4
                "Lure",         // 5
                "Renown",       // 6
                "Glory",        // 7
                "Affection",    // 8
                "Knowledge",    // 9
                "Good",         // 10
                "Good"          // 11
        };

        public static final String[] FOLLOWER_HP_DAMAGE = {
                "3 HP, d4",     // 0  (1–3)
                "3 HP, d4",     // 1
                "3 HP, d4",     // 2
                "6 HP, d6",     // 3  (4–9)
                "6 HP, d6",     // 4
                "6 HP, d6",     // 5
                "6 HP, d6",     // 6
                "6 HP, d6",     // 7
                "6 HP, d6",     // 8
                "9 HP, d8",     // 9  (10–12)
                "9 HP, d8",     // 10
                "9 HP, d8"      // 11
        };

    }

}

