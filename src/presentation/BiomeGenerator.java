package presentation;

import domain.BiomeClass;
import service.BiomeFunctions;
import service.GenericFunctions;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BiomeGenerator {
    public void run(Scanner dataInput, List<BiomeClass> biomeList) throws IOException { int option = 0;
        BiomeClass biome = null;
        System.out.println("\nWELCOME TO THE BIOME GENERATOR\n");

        try{
            do {
                System.out.print("""
                        Please select an option:
                        1) Create new random Biome
                        2) View current
                        3) View list of generated biomes
                        4) Export current
                        5) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option){
                    case 1 ->{
                        biome = new BiomeClass();
                        BiomeFunctions.rollBiome(biome);
                        System.out.println(biome);
                        biomeList.add(biome);
                    }
                    case 2 -> {
                        if(biome==null){
                            biome = new BiomeClass();
                            BiomeFunctions.rollBiome(biome);
                            biomeList.add(biome);
                        }
                        System.out.println(biome);
                    }
                    case 3 -> biome = new ViewAll().run(dataInput,biomeList,biome,BiomeClass.class);
                    case 4 -> {
                        if(biome==null){
                            biome = new BiomeClass();
                            BiomeFunctions.rollBiome(biome);
                            biomeList.add(biome);
                        }
                        GenericFunctions.exportPW(biome);
                    }
                    case 5 -> System.out.println("\nReturning to main menu...\n");

                }
            }while (option !=5);
        }catch (Exception e){
            System.out.println("An error occurred: "+e.getMessage());
        }

    }
}
