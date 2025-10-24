package service;

import data.DungeonArrays;
import domain.Area;
import domain.Dungeon;
import domain.Steading;
import domain.util.Rolls;
import presentation.SubMenu;
import presentation.ViewAll;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DungeonFunctions {
    public static void rollDungeon(Dungeon dungeon){

        //set name template and name
        dungeon.setNameTemplate(DungeonArrays.DUNGEON_NAME_TEMPLATES[Rolls.UniversalRoll(DungeonArrays.DUNGEON_NAME_TEMPLATES)]);
        String adjective = DungeonArrays.DUNGEON_ADJECTIVES[Rolls.UniversalRoll(DungeonArrays.DUNGEON_ADJECTIVES)];
        String noun = DungeonArrays.DUNGEON_NOUNS[Rolls.UniversalRoll(DungeonArrays.DUNGEON_NOUNS)];
        String place = DungeonArrays.DUNGEON_PLACES[Rolls.UniversalRoll(DungeonArrays.DUNGEON_PLACES)];

        dungeon.setName(dungeon.getNameTemplate().replace("[PLACE]",place).replace("[NOUN]",noun).replace("[ADJECTIVE]",adjective));

        //set overview: size, themes, form, situation, builder, function, cause of ruin
        dungeon.setSize(DungeonArrays.DUNGEON_SIZE[Rolls.UniversalRoll(DungeonArrays.DUNGEON_SIZE)]);
        //based on size, set the amount of rooms and themes
        switch (dungeon.getSize()){
            case "medium" -> {
                dungeon.setRooms((int)(Math.random()*8)+1+7);
                dungeon.setThemesAmount(3);
            }
            case "large" ->{
                dungeon.setRooms((int)(Math.random()*10)+1+15);
                dungeon.setThemesAmount(4);
            }
            case "huge" -> {
                dungeon.setRooms((int)(Math.random()*12)+1+25);
                dungeon.setThemesAmount(5);
            }
            case "megadungeon" ->{
                dungeon.setRooms((int)(Math.random()*20)+1+50);
                dungeon.setThemesAmount(10);
            }
            default ->{
                dungeon.setRooms((int)(Math.random()*6)+1+1);
                dungeon.setThemesAmount(2);
            }
        }

        dungeon.initializeAreas(dungeon.getRooms());

        dungeon.initializeThemes(dungeon.getThemesAmount());
        int i;
        for (i = 1; i<=dungeon.getThemesAmount(); i++ ){
          String themeCategory = DungeonArrays.DUNGEON_THEME_CATEGORIES[Rolls.UniversalRoll(DungeonArrays.DUNGEON_THEME_CATEGORIES)];
          String theme;
          switch (themeCategory){
              case "HOPEFUL" -> theme =  DungeonArrays.HOPEFUL_PROMPTS[Rolls.UniversalRoll(DungeonArrays.HOPEFUL_PROMPTS)];
              case "MYSTERIOUS" -> theme =  DungeonArrays.MYSTERIOUS_PROMPTS[Rolls.UniversalRoll(DungeonArrays.MYSTERIOUS_PROMPTS)];
              case "GRIM" -> theme =  DungeonArrays.GRIM_PROMPTS[Rolls.UniversalRoll(DungeonArrays.GRIM_PROMPTS)];
              default -> theme =  DungeonArrays.GONZO_PROMPTS[Rolls.UniversalRoll(DungeonArrays.GONZO_PROMPTS)];
          }
          if (Objects.equals(theme,"element")){
              theme = CreatureFunctions.rollElement();
          }
          if (Objects.equals(theme, "magic type")){
              theme = CreatureFunctions.rollMagicType();
          }
          if(Objects.equals(theme, "roll 1d10 twice, combine")){
              theme = (DungeonArrays.GONZO_PROMPTS[Rolls.Roll1d10()]+" and "+DungeonArrays.GONZO_PROMPTS[Rolls.Roll1d10()]);
          }
          dungeon.addTheme(theme);
        }

        dungeon.setForm(DungeonArrays.DUNGEON_FORM[Rolls.UniversalRoll(DungeonArrays.DUNGEON_FORM)]);
        switch (dungeon.getForm()){
         case "ruins of (roll again)" -> dungeon.setForm("Ruins of a "+DungeonArrays.DUNGEON_FORM[Rolls.CustomRoll(17)]);
         case "roll again, add oddity" ->dungeon.setForm(DungeonArrays.DUNGEON_FORM[Rolls.CustomRoll(17)]+" + "+ CreatureFunctions.rollOddity());
         case "ruins of steading" ->{
            Steading s = new Steading();
            SteadingFunctions.rollSteading(s);
            dungeon.setForm("Ruins of "+s.getOneLiner());
         }
            default -> dungeon.setForm(dungeon.getForm());
        }

        dungeon.setSituation(DungeonArrays.DUNGEON_SITUATION[Rolls.UniversalRoll(DungeonArrays.DUNGEON_SITUATION)]);
        dungeon.setBuilder(DungeonArrays.DUNGEON_BUILDER[Rolls.UniversalRoll(DungeonArrays.DUNGEON_BUILDER)]);
        dungeon.setFunction(DungeonArrays.DUNGEON_FUNCTION[Rolls.UniversalRoll(DungeonArrays.DUNGEON_FUNCTION)]);
        if (Objects.equals(dungeon.getFunction(),"roll twice")) Rolls.rollTwice(DungeonArrays.DUNGEON_FUNCTION);

        dungeon.setCauseOfRuin(DungeonArrays.DUNGEON_CAUSE_OF_RUIN[Rolls.UniversalRoll(DungeonArrays.DUNGEON_CAUSE_OF_RUIN)]);
        dungeon.setAccessibility(DungeonArrays.DUNGEON_ACCESSIBILITY[Rolls.UniversalRoll(DungeonArrays.DUNGEON_ACCESSIBILITY)]);

        dungeon.setExits(DungeonArrays.AREA_EXITS_NUMBER[Rolls.UniversalRoll(DungeonArrays.AREA_EXITS_NUMBER)]);

        dungeon.setOneLiner(dungeon.getName());

    }



    public static void showOptions(Scanner dataInput, Dungeon dungeon, List<Dungeon> dungeonList,List<Area> areaList) {
        int option = 0;
        System.out.println("WELCOME TO THE DUNGEON GENERATOR\n");

        do {
            try {
                System.out.print("""
                        Please select an option:
                        1) Create new random dungeon
                        2) Add areas
                        3) View generated dungeons list
                        4) View current dungeon
                        5) Export dungeon
                        6) Main menu
                      
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option) {
                    case 1 -> {
                        dungeon = new Dungeon();
                        DungeonFunctions.rollDungeon(dungeon);
                        dungeonList.add(dungeon);
                        System.out.println(dungeon);
                    }
                    case 2 -> {
                        Area area = null;
                        SubMenu.run(dataInput, area, dungeon,areaList);
                    }
                    case 3 -> dungeon = new ViewAll().run(dataInput,dungeonList,dungeon, Dungeon.class);
                    case 4 -> {
                        if (dungeon==null){
                            System.out.println("\nGenerating dungeon...\n");
                            dungeon = new Dungeon();
                            DungeonFunctions.rollDungeon(dungeon);
                            dungeonList.add(dungeon);
                        }
                        System.out.println(dungeon);
                    }
                    case 5 -> {
                        if (dungeon == null) {
                            dungeon = new Dungeon();
                            DungeonFunctions.rollDungeon(dungeon);
                            dungeonList.add(dungeon);
                        }
                        GenericFunctions.exportPW(dungeon);
                    }
                    case 6 -> System.out.println("\nReturning to main menu...\n");
                    default -> System.out.print("\nInvalid number!\n\n");
                }
            } catch (Exception e) {
                System.out.println("\nPlease choose a valid option.\n");
            }
        }
        while (option != 6);
    }
}
