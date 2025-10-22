package service;

import domain.Dungeon;
import domain.IPWClass;
import java.util.Scanner;

public non-sealed interface  IDungeonServices <T extends IPWClass> extends IGenericServices {
    void showOptions(Scanner dataInput, T object, Dungeon dungeon);
}