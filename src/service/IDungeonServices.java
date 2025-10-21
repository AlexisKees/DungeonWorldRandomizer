package service;

import domain.DungeonClass;
import domain.IPWClass;
import java.util.Scanner;

public interface IDungeonServices <T extends IPWClass> {
    void showDungeonOptions(Scanner dataInput, T object, DungeonClass dungeon);
}