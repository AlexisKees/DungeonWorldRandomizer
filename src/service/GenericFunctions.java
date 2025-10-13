package service;

import domain.DungeonClass;
import domain.PerilousWildsInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GenericFunctions {

    public static void export(PerilousWildsInterface item, String objectClass) throws IOException {
        String prefix = objectClass+"_";
        int itemNumber = 1;
        String fileName = String.format(prefix+"%04d.txt",itemNumber);
        File file = new File(fileName);

        while (file.exists()){
            itemNumber++;
            fileName = String.format(prefix+"%04d.txt",itemNumber);
            file = new File(fileName);
        }

        PrintWriter salida = new PrintWriter(new FileWriter(file, true));
        salida.println(item);
        salida.close();
    }
}
