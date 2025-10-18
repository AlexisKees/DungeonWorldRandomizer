package presentation;

import domain.FollowerClass;
import service.DungeonAreaFunctions;
import service.FollowerFunctions;
import service.GenericFunctions;

import java.util.List;
import java.util.Scanner;

public class FollowerGenerator {
    public static void run(Scanner dataInput, List<FollowerClass> followerList){
        FollowerClass follower = null;

        int option = 0;
        System.out.println("WELCOME TO THE FOLLOWER GENERATOR\n");

        try{

            do {
                System.out.print("""
                        \nPlease select an option:
                        1) Create new random follower
                        2) View current follower
                        3) Reroll this follower
                        4) View list of generated follower
                        5) Export current follower
                        6) Main menu
                        
                        \tOption:\s""");

                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option){
                    case 1 -> {
                        follower = new FollowerClass();
                        FollowerFunctions.rollFollower(follower);
                        System.out.println(follower);
                    }
                    case 2 ->{
                        if (follower==null){
                            follower = new FollowerClass();
                            FollowerFunctions.rollFollower(follower);
                        }
                        System.out.println(follower);
                    }
                    case 3 ->{
                        if (follower==null){
                            follower = new FollowerClass();
                            FollowerFunctions.rollFollower(follower);
                        } else {
                            FollowerFunctions.rollFollowerDetails(follower);
                        }
                        System.out.println(follower);
                    }
                    case 4 -> follower = new ViewAll().run(dataInput, followerList, follower, FollowerClass.class);
                    case 5 -> {
                        if (follower==null){
                            follower = new FollowerClass();
                            FollowerFunctions.rollFollower(follower);
                        }
                        GenericFunctions.exportPW(follower);
                    }
                    case 6 -> System.out.println("Going back to DUNGEON GENERATOR");
                }
            } while (option!=6);


        }catch (Exception e){
            System.out.println("There has been a problem during FOLLOWER GENERATOR excecution: "+e.getMessage());
        }
    }
}
