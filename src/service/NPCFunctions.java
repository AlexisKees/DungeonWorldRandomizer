package service;

import data.CreatureArrays;
import data.DetailsArrays;
import data.NPCArrays;
import data.NPCNamesArrays;
import domain.NPCClass;
import domain.util.Rolls;
import presentation.ViewAll;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class NPCFunctions implements IPWService<NPCClass>{

    public static void rollFeatures(NPCClass npc){
        //set race rarity, races array and race
        int rarity = Rolls.Roll1d12();
        switch (rarity) {
            case 6,7,8,9 -> npc.setRaceTable(CreatureArrays.PROMPTS_HUMANOID_UNCOMMON);
            case 10,11 -> npc.setRaceTable(CreatureArrays.PROMPTS_HUMANOID_RARE);
            default -> npc.setRaceTable(CreatureArrays.PROMPTS_HUMANOID_COMMON);
        };

        npc.setRace(npc.getRaceTable()[Rolls.UniversalRoll(npc.getRaceTable())]);
        // set gender, ethnics and name
        npc.setGender(NPCNamesArrays.GENDER[Rolls.UniversalRoll(NPCNamesArrays.GENDER)]);
        npc.setEthnics(NPCNamesArrays.ETHNICS[Rolls.UniversalRoll(NPCNamesArrays.ETHNICS)]);
        switch (npc.getEthnics()){
            case "Yoruba" -> npc.setNamesTable(NPCNamesArrays.NAMES_YORUBA_BASED);
            case "Finnish" -> npc.setNamesTable(NPCNamesArrays.NAMES_FINNISH_BASED);
            case "Indonesian" -> npc.setNamesTable(NPCNamesArrays.NAMES_INDONESIAN_BASED);
            default -> npc.setNamesTable(NPCNamesArrays.NAMES_HUNGARIAN_BASED);
        };
        //Male names use the first half of each 50 elements array, while female names use the second half
        switch (npc.getGender()){
            case "Male" ->{
                int roll = (int)(Math.random() * 24);
                npc.setName(npc.getNamesTable()[roll]);
            }
            case "Female" -> {
                int roll = (int)(Math.random() * 24 + 25);
                npc.setName(npc.getNamesTable()[roll]);
            }
            default -> {
                npc.setName(npc.getNamesTable()[Rolls.UniversalRoll(npc.getNamesTable())]);
            }
        }

        //Set age using DetailArrays
        int ageRoll = (int)(Math.random()*7+3);
        npc.setAge(DetailsArrays.AGE[ageRoll]);

        npc.setCategory(NPCArrays.CATEGORY[Rolls.UniversalRoll(NPCArrays.CATEGORY)]);
        switch (npc.getCategory()){
            case "Outsider" -> npc.setJobList(NPCArrays.OUTSIDER);
            case "Criminal" -> npc.setJobList(NPCArrays.CRIMINAL);
            case "Tradesperson" -> npc.setJobList(NPCArrays.TRADESPERSON);
            case "Merchant" -> npc.setJobList(NPCArrays.MERCHANT);
            case "Specialist" -> npc.setJobList(NPCArrays.SPECIALIST);
            case "Religious" -> npc.setJobList(NPCArrays.RELIGIOUS);
            case "Security" -> npc.setJobList(NPCArrays.SECURITY);
            case "Authority" -> npc.setJobList(NPCArrays.AUTHORITY);
            default ->  npc.setJobList(NPCArrays.COMMONER);
        };

        npc.setJob(npc.getJobList()[Rolls.UniversalRoll(npc.getJobList())]);

        npc.setAppearance(NPCArrays.APPEARANCE[Rolls.UniversalRoll(NPCArrays.APPEARANCE)]);
        npc.setPersonality(NPCArrays.PERSONALITY[Rolls.UniversalRoll(NPCArrays.PERSONALITY)]);
        npc.setQuirk(NPCArrays.QUIRK[Rolls.UniversalRoll(NPCArrays.QUIRK)]);

        if (Objects.equals(npc.getAppearance(), "roll twice, reroll any 12 result")){
            npc.setAppearance(NPCArrays.APPEARANCE[(int)Math.random()*(NPCArrays.APPEARANCE.length-1)]+" and "+NPCArrays.APPEARANCE[(int)Math.random()*(NPCArrays.APPEARANCE.length-1)]);
        }

        if (Objects.equals(npc.getPersonality(), "roll twice, reroll any 12 result")){
            npc.setPersonality(NPCArrays.PERSONALITY[(int)Math.random()*(NPCArrays.PERSONALITY.length-1)]+" and "+NPCArrays.PERSONALITY[(int)Math.random()*(NPCArrays.PERSONALITY.length-1)]);
        }

        if (Objects.equals(npc.getQuirk(), "roll twice, reroll any 12 result")){
            npc.setQuirk(NPCArrays.QUIRK[(int)Math.random()*(NPCArrays.QUIRK.length-1)]+" and "+NPCArrays.QUIRK[(int)Math.random()*(NPCArrays.QUIRK.length-1)]);
        }

        npc.setOneLiner(String.format("%s, the %s %s", npc.getName(), npc.getRace(), npc.getJob()));
    }

    public static void printNPC(NPCClass npc){
        System.out.println(npc);
    }


    @Override
    public void showOptions(Scanner dataInput, NPCClass npc, List<NPCClass> npcList) {
        var option = 0;
        System.out.println("\nWELCOME TO THE NPC GENERATOR\n");

        do {
            try {
                System.out.print("""
                        Please select an option:
                        1) Create new random NPC
                        2) View current
                        3) View list of generated NPCs
                        4) Export current
                        5) Main menu
                                                
                        Option:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option) {
                    case 1 -> {
                        npc = new NPCClass();
                        NPCFunctions.rollFeatures(npc);
                        NPCFunctions.printNPC(npc);
                        npcList.add(npc);
                    }
                    case 2 -> {
                        if (npc==null) {
                            npc = new NPCClass();
                            NPCFunctions.rollFeatures(npc);
                            NPCFunctions.printNPC(npc);
                            npcList.add(npc);
                        }
                        System.out.println(npc);
                    }
                    case 3 -> npc = new ViewAll().run(dataInput,npcList,npc,NPCClass.class);
                    case 4 -> GenericFunctions.exportPW(npc);
                    case 5 -> System.out.println("\nReturning to main menu...\n");
                    default -> System.out.print("\nInvalid number!\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nPlease choose a valid option.\n");
            }
        }
        while (option != 5);
    }
}
