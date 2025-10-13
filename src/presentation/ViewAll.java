package presentation;

import domain.PerilousWildsInterface;
import service.GenericFunctions;

import java.util.List;
import java.util.Scanner;

public class ViewAll {

    public <T extends PerilousWildsInterface> T run(Scanner dataInput, List<T> list, T object, Class<T> type){
        int option = 0;
        int itemNumber=0;
        String label = type.getSimpleName().substring(0,type.getSimpleName().length()-5);

        int counter = 1;
        System.out.printf("""
                        *** LIST OF %s ***
                        """,label.toUpperCase());
        for (PerilousWildsInterface o : list){
            System.out.printf("%d) %s\n", counter,o.getOneLiner());
            counter++;
        }
        System.out.println("\n");

        try{
            do {
                System.out.print("""
                        \n
                        1) Detailed view
                        2) Go back 
                        \tOption:\s""");

                option=Integer.parseInt(dataInput.nextLine());

                switch (option){
                    case 1 ->{

                        System.out.printf("Please insert %s number: ",label.toLowerCase());
                        itemNumber=Integer.parseInt(dataInput.nextLine());
                        System.out.println();
                        T selectedItem=list.get(itemNumber-1);
                        if (itemNumber < 0 || itemNumber>list.size()){
                            System.out.println("Please insert a valid number");
                            continue;
                        } else {
                            System.out.printf("TAKE A LOOK AT YOUR CHOSEN %s:\n\n", label.toUpperCase());
                            System.out.println(selectedItem);
                        }

                        int secondOption;
                        do {
                            System.out.printf("""
                                \n
                                1) Export %s
                                2) Select this %s to keep editing
                                3) Go back 
                                \tOption:\s""",label.toLowerCase(),label.toLowerCase());
                            secondOption=Integer.parseInt(dataInput.nextLine());

                            switch (secondOption){
                                case 1 -> GenericFunctions.export(object,label);
                                case 2 -> {
                                    object = selectedItem;
                                    System.out.printf("\n%s SUCCESFULLY LOADED\n",label.toUpperCase());
                                    System.out.println();
                                    return object;
                                }
                                case 3 -> {
                                    System.out.println("\nGoing back to the DUNGEON GENERATOR\n");
                                    return object;
                                }
                            }
                        } while (secondOption != 3);


                    }
                }
            } while (option!=2);

        } catch (Exception e){
            System.out.println("\nAn error has occurred: "+e.getMessage()+"\n");
        }

        return object;
    }
}
