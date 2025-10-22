package service;

import data.BiomeArrays;
import data.DetailsArrays;
import domain.Biome;
import domain.util.Rolls;
import presentation.ViewAll;

import java.util.List;
import java.util.Scanner;


public class BiomeFunctions implements IAllServices<Biome> {

    public static void rollBiome(Biome biome){
//        private String biome;
        biome.setBiome(BiomeArrays.BIOME[Rolls.UniversalRoll(BiomeArrays.BIOME)]);
//        private String weather;
        biome.setWeather(BiomeArrays.WEATHER[Rolls.UniversalRoll(BiomeArrays.WEATHER)]);
//        private String weatherIntensity;
        biome.setWeatherIntensity(BiomeArrays.WEATHER_INTENSITY[Rolls.UniversalRoll(BiomeArrays.WEATHER_INTENSITY)]);
//        private String wildlife;
        biome.setWildlife(BiomeArrays.WILDLIFE[Rolls.UniversalRoll(BiomeArrays.WILDLIFE)]);
//        private String population;
        biome.setPopulation(BiomeArrays.POPULATION[Rolls.UniversalRoll(BiomeArrays.POPULATION)]);
//        private String roads;
        biome.setRoads(BiomeArrays.ROADS[Rolls.UniversalRoll(BiomeArrays.ROADS)]);
//        private String alignment;
        biome.setAlignment(DetailsArrays.ALIGNMENT[Rolls.UniversalRoll(DetailsArrays.ALIGNMENT)]);
//        private String distance;
        biome.setDistance(BiomeArrays.DISTANCE[Rolls.UniversalRoll(BiomeArrays.DISTANCE)]);
        biome.setOneLiner(String.format("%s %s",biome.getPopulation(),biome.getBiome()));
    }

    public static void reRollDetails(Biome biome){
        //        private String weather;
        biome.setWeather(BiomeArrays.WEATHER[Rolls.UniversalRoll(BiomeArrays.WEATHER)]);
//        private String weatherIntensity;
        biome.setWeatherIntensity(BiomeArrays.WEATHER_INTENSITY[Rolls.UniversalRoll(BiomeArrays.WEATHER_INTENSITY)]);
//        private String wildlife;
        biome.setWildlife(BiomeArrays.WILDLIFE[Rolls.UniversalRoll(BiomeArrays.WILDLIFE)]);
//        private String population;
        biome.setPopulation(BiomeArrays.POPULATION[Rolls.UniversalRoll(BiomeArrays.POPULATION)]);
//        private String roads;
        biome.setRoads(BiomeArrays.ROADS[Rolls.UniversalRoll(BiomeArrays.ROADS)]);
//        private String alignment;
        biome.setAlignment(DetailsArrays.ALIGNMENT[Rolls.UniversalRoll(DetailsArrays.ALIGNMENT)]);
//        private String distance;
        biome.setDistance(BiomeArrays.DISTANCE[Rolls.UniversalRoll(BiomeArrays.DISTANCE)]);
        biome.setOneLiner(String.format("%s %s",biome.getPopulation(),biome.getBiome()));

    }

    @Override
    public void showOptions(Scanner dataInput, Biome biome, List<Biome> biomeList) {
        int option = 0;
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
                        biomeList.add(biome);
                    }
                    case 2 -> {
                        if(biome==null){
                            biome = new Biome();
                            BiomeFunctions.rollBiome(biome);
                            biomeList.add(biome);
                        }
                        System.out.println(biome);
                    }
                    case 3 -> {
                        if(biome==null){
                            biome = new Biome();
                            BiomeFunctions.rollBiome(biome);
                            biomeList.add(biome);
                        } else {
                            BiomeFunctions.reRollDetails(biome);
                            biomeList.add(biome);
                        }
                        System.out.println(biome);
                    }
                    case 4 -> biome = new ViewAll().run(dataInput,biomeList,biome, Biome.class);
                    case 5 -> {
                        if(biome==null){
                            biome = new Biome();
                            BiomeFunctions.rollBiome(biome);
                            biomeList.add(biome);
                        }
                        GenericFunctions.exportPW(biome);
                    }
                    case 6 -> System.out.println("\nReturning to main menu...\n");

                }
            }while (option !=6);
        }catch (Exception e){
            System.out.println("An error occurred: "+e.getMessage());
        }
    }

}
