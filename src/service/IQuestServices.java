package service;

import domain.Biome;
import domain.Dungeon;
import domain.NPC;
import domain.Quest;

import java.util.List;
import java.util.Scanner;

public non-sealed interface IQuestServices extends IGenericServices{
    void showOptions(Scanner dataInput, Quest quest, List<Quest> questList, List<NPC> npcList, List<Dungeon> dungeonList, List<Biome> biomeList);
}
