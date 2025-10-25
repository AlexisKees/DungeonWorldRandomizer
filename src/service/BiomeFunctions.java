package service;

import data.BiomeArrays;
import data.DetailsArrays;
import domain.Biome;
import static domain.util.Rolls.*;
import presentation.ViewAll;
import java.util.List;
import java.util.Scanner;


public class BiomeFunctions implements IGenericService<Biome> {

    public static void rollBiome(Biome biome){
//        private String biome;
        biome.setBiome(PickFrom(BiomeArrays.BIOME));
//        private String weather;
        biome.setWeather(PickFrom(BiomeArrays.WEATHER));
//        private String weatherIntensity;
        biome.setWeatherIntensity(PickFrom(BiomeArrays.WEATHER_INTENSITY));
//        private String wildlife;
        biome.setWildlife(PickFrom(BiomeArrays.WILDLIFE));
//        private String population;
        biome.setPopulation(PickFrom(BiomeArrays.POPULATION));
//        private String roads;
        biome.setRoads(PickFrom(BiomeArrays.ROADS));
//        private String alignment;
        biome.setAlignment(PickFrom(DetailsArrays.ALIGNMENT));
//        private String distance;
        biome.setDistance(PickFrom(BiomeArrays.DISTANCE));
        biome.setOneLiner(String.format("%s %s",biome.getPopulation(),biome.getBiome()));
    }

    public static void reRollDetails(Biome biome){
        //        private String weather;
        biome.setWeather(PickFrom(BiomeArrays.WEATHER));
//        private String weatherIntensity;
        biome.setWeatherIntensity(PickFrom(BiomeArrays.WEATHER_INTENSITY));
//        private String wildlife;
        biome.setWildlife(PickFrom(BiomeArrays.WILDLIFE));
//        private String population;
        biome.setPopulation(PickFrom(BiomeArrays.POPULATION));
//        private String roads;
        biome.setRoads(PickFrom(BiomeArrays.ROADS));
//        private String alignment;
        biome.setAlignment(PickFrom(DetailsArrays.ALIGNMENT));
//        private String distance;
        biome.setDistance(PickFrom(BiomeArrays.DISTANCE));
        biome.setOneLiner(String.format("%s %s",biome.getPopulation(),biome.getBiome()));

    }

    @Override
    public void showOptions(Scanner dataInput, Biome biome, List<Biome> biomeList) {
        int option;
        System.out.println("WELCOME TO THE BIOME GENERATOR\n");

        try{
            do {
                System.out.print("""
                        \nPlease select an option:
                        1) Create new random Biome
                        2) View current
                        3) Reroll this biome
                        4) View list of generated biomes
                        5) Export current biome
                        6) Main menu
                        
                        \tOption:\s""");
                option = Integer.parseInt(dataInput.nextLine());
                System.out.println();

                switch (option){
                    case 1 ->{
                        biome = new Biome();
                        BiomeFunctions.rollBiome(biome);
                        System.out.println(biome);
                        biomeList.add(biome.clone());
                    }
                    case 2 -> {
                        if(biome==null){
                            biome = new Biome();
                            BiomeFunctions.rollBiome(biome);
                            biomeList.add(biome.clone());
                        }
                        System.out.println(biome);
                    }
                    case 3 -> {
                        if(biome==null){
                            biome = new Biome();
                            BiomeFunctions.rollBiome(biome);
                            biomeList.add(biome.clone());
                        } else {
                            BiomeFunctions.reRollDetails(biome);
                            biomeList.add(biome.clone());
                        }
                        System.out.println(biome);
                    }
                    case 4 -> biome = new ViewAll().run(dataInput,biomeList,biome, Biome.class);
                    case 5 -> {
                        if(biome==null){
                            biome = new Biome();
                            BiomeFunctions.rollBiome(biome);
                            biomeList.add(biome.clone());
                        }
                        GenericFunctions.exportPW(biome);
                    }
                    case 6 -> System.out.println("\nReturning to main menu...\n");

                }
            }while (option !=6);
        }catch (Exception e){
            System.out.println("\nPlease choose a valid option.\n");
        }
    }

}
