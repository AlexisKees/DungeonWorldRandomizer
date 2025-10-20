package service;

import domain.IPWClass;

import java.util.List;
import java.util.Scanner;

public interface IPWService <T extends IPWClass> {
    void showOptions(Scanner dataInput,T object, List<T> list);

}
