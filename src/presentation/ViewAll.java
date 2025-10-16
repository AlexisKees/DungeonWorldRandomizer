package presentation;

import domain.IPWClass;
import service.GenericFunctions;

import java.util.List;
import java.util.Scanner;

public class ViewAll {

    public <T extends IPWClass> T run(Scanner dataInput, List<T> list, T object, Class<T> type){
        int option = 0;
        int itemNumber=0;
        String label = type.getSimpleName().substring(0,type.getSimpleName().length()-5);

        String labelPlural = switch (label){
            case "Biome" -> "Biomes";
            case "Creature" -> "Creatures";
            case "Danger" -> "Dangers";
            case "Discovery" -> "Discoveries";
            case "Dungeon" -> "Dungeons";
            case "Follower"-> "Followers";
            case "NPC" -> "NPC";
            case "Quest" -> "Quests";
            case "Steading" -> "Steadings";
            default -> "Items";
        };

        int counter = 1;
        System.out.printf("""
                        *** LIST OF %s ***
                        """,labelPlural.toUpperCase());
        for (IPWClass o : list){
            System.out.printf("%d) %s\n", counter,o.getOneLiner());
            counter++;
        }
        System.out.println("\n");

        try{
            do {
                System.out.print("""
                        1) Detailed view
                        2) Go back 
                        \tOption:\s""");

                option=Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option){
                    case 1 ->{

                        System.out.printf("\tPlease insert %s number:\s",label.toLowerCase());
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
                                1) Export %s
                                2) Select this %s to keep editing
                                3) Go back 
                                \tOption:\s""",label.toLowerCase(),label.toLowerCase());
                            secondOption=Integer.parseInt(dataInput.nextLine());
                            System.out.println();

                            switch (secondOption){
                                case 1 -> GenericFunctions.exportPW(object);
                                case 2 -> {
                                    object = selectedItem;
                                    System.out.printf("\n%s SUCCESFULLY LOADED\n",label.toUpperCase());
                                    System.out.println();
                                    return object;
                                }
                                case 3 -> {
                                    System.out.println("\nGoing back...\n");
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
