package service;

import domain.*;

import java.util.List;
import java.util.Scanner;

public non-sealed interface IAllServices<T extends IPWClass> extends IGenericServices {
    void showOptions(Scanner dataInput,T object, List<T> list);
}
