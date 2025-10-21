package service;

import domain.DungeonAreaClass;
import domain.DungeonClass;
import domain.IPWClass;

import java.util.Scanner;

public interface IAreaServices <T extends IPWClass> {
    void showAreaOptions(Scanner dataInput, T object, DungeonAreaClass area);
}
