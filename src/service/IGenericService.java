package service;

import domain.*;

import java.util.List;
import java.util.Scanner;

public interface IGenericService<T extends IPWClass>  {
    void showOptions(Scanner dataInput,T object, List<T> list);
}
