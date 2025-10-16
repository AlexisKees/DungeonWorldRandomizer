package service;

import data.BiomeArrays;
import data.DetailsArrays;
import domain.BiomeClass;
import domain.util.Rolls;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BiomeFunctions {

    public static void rollBiome(BiomeClass biome){
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

    public static void reRollDetails(BiomeClass biome){
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

}
