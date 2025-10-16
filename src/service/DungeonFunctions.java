package service;

import data.DungeonArrays;
import domain.DungeonClass;
import domain.IPWClass;
import domain.util.Rolls;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Objects;

public class DungeonFunctions {
    public static void rollDungeon(DungeonClass dungeon){

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
            default ->{
                dungeon.setRooms((int)Math.random()*6+1+1);
                dungeon.setThemesAmount(2);
            }
            case "medium" -> {
                dungeon.setRooms((int)Math.random()*8+1+7);
                dungeon.setThemesAmount(3);
            }
            case "large" ->{
                dungeon.setRooms((int)Math.random()*10+1+15);
                dungeon.setThemesAmount(4);
            }
            case "huge" -> {
                dungeon.setRooms((int)Math.random()*12+1+25);
                dungeon.setThemesAmount(5);
            }
            case "megadungeon" ->{
                dungeon.setRooms((int)Math.random()*20+1+50);
                dungeon.setThemesAmount(10);
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
         case "ruins of 1d8+3" -> {
             dungeon.setForm("Ruins of a "+DungeonArrays.DUNGEON_FORM[(int)Math.random()*8+4]);
         }
         case "roll 1d10, add oddity [p55]" ->{
             dungeon.setForm(DungeonArrays.DUNGEON_FORM[(int)Math.random()*10+1]+" + "+ CreatureFunctions.rollOddity());
         }
         case "ruins of steading [p50]" ->{ //VOLVER A HACER CUANDO TENGA STEADING HECHOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO

         }
            default -> dungeon.setForm(dungeon.getForm());
        }

        dungeon.setSituation(DungeonArrays.DUNGEON_SITUATION[Rolls.UniversalRoll(DungeonArrays.DUNGEON_SITUATION)]);
        dungeon.setBuilder(DungeonArrays.DUNGEON_BUILDER[Rolls.UniversalRoll(DungeonArrays.DUNGEON_BUILDER)]);
        dungeon.setFunction(DungeonArrays.DUNGEON_FUNCTION[Rolls.UniversalRoll(DungeonArrays.DUNGEON_FUNCTION)]);
        if (Objects.equals(dungeon.getFunction(),"roll 1d10+1 twice, combine")){
                dungeon.setFunction(DungeonArrays.DUNGEON_FUNCTION[Rolls.UniversalRoll(DungeonArrays.DUNGEON_FUNCTION)] +" and "+DungeonArrays.DUNGEON_FUNCTION[Rolls.UniversalRoll(DungeonArrays.DUNGEON_FUNCTION)]);
        }

        dungeon.setCauseOfRuin(DungeonArrays.DUNGEON_CAUSE_OF_RUIN[Rolls.UniversalRoll(DungeonArrays.DUNGEON_CAUSE_OF_RUIN)]);
        dungeon.setAccessibility(DungeonArrays.DUNGEON_ACCESSIBILITY[Rolls.UniversalRoll(DungeonArrays.DUNGEON_ACCESSIBILITY)]);

        dungeon.setExits(DungeonArrays.AREA_EXITS_NUMBER[Rolls.UniversalRoll(DungeonArrays.AREA_EXITS_NUMBER)]);

        dungeon.setOneLiner(dungeon.getName());

    }


}
