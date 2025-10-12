package service;

import data.QuestArrays;
import domain.CreatureClass;
import domain.QuestClass;
import domain.util.Rolls;

import java.io.*;

public class QuestFunctions {

    public static void rollQuest(QuestClass quest){
        quest.setTask(QuestArrays.TASK[Rolls.UniversalRoll(QuestArrays.TASK)]);
        quest.setRelevance(QuestArrays.RELEVANCE[Rolls.UniversalRoll(QuestArrays.RELEVANCE)]);
        quest.setReward(QuestArrays.REWARD[Rolls.UniversalRoll(QuestArrays.REWARD)]);
    }

    public static void exportQuest(QuestClass quest) throws IOException {
        String prefix = "Quest_";
        int questNumber = 1;
        String fileName = String.format(prefix + "%04d.txt", questNumber);
        File file = new File(fileName);

        while (file.exists()) {
            questNumber++;
            fileName = String.format(prefix + "%04d.txt", questNumber);
            file = new File(fileName);
        }

        try (PrintWriter salida = new PrintWriter(new FileWriter(file, false))) {
            salida.printf("""
                SUMMARY:%n
                %s%n%n
                DETAILS:%n
                QUEST GIVEN BY:%n
                %s%n
                TO BE CARRIED OUT AT:%n
                %s%n%n
                %s
                """,
                    quest.toString(),
                    quest.getQuestGiver().toString(),
                    quest.getDungeon().toString(),
                    quest.getBiome().toString()
            );
        }
    }

}
