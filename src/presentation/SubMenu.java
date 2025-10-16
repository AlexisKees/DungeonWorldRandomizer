package presentation;

import domain.IPWClass;
import service.GenericFunctions;

import java.util.List;
import java.util.Scanner;

public class SubMenu {
    /*
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


//        1) Create new random *
//        2) View list of generated * -> ViewAll
//        3) View current -> nueva función
//        4) Export current
//        5) Main menu

        try{
            do {
//                showOptions(type);

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

     */
}
