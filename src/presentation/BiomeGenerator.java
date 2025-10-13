package presentation;

import domain.BiomeClass;
import domain.PerilousWildsInterface;
import service.BiomeFunctions;
import service.DiscoveryFunctions;

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
                        1) Create new random biome
                        2) See previously generated biomes
                        3) Print biome
                        4) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());

                switch (option){
                    case 1 ->{
                        biome = new BiomeClass();
                        BiomeFunctions.rollBiome(biome);
                        System.out.println(biome);
                        biomeList.add(biome);
                    }
                    case 2 -> {
                        int counter = 1;
                        System.out.println("""
                                *** LIST OF BIOMES ***""");
                        for (BiomeClass b : biomeList){
                            System.out.printf("%d) %s\n", counter, b.getBiome());
                            counter++;
                        }
                        System.out.println("\n");
                    }
                    case 3 -> {
                        if (biome==null){
                            biome = new BiomeClass();
                            BiomeFunctions.rollBiome(biome);
                            System.out.println(biome);
                        }
                        BiomeFunctions.exportBiome(biome);
                        System.out.println("""
                                ***********************
                                *  Check your files!  *
                                ***********************
                                """);
                    }
                    case 4 -> System.out.println("Going back to main menu");

                }
            }while (option !=4);
        }catch (Exception e){
            System.out.println("An error occurred: "+e.getMessage());
        }

    }
}
