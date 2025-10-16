package service;

import domain.IPWClass;

import java.util.Scanner;

public interface IPWService <T extends IPWClass> {
    public void showOptions(Scanner in,T current);

}
