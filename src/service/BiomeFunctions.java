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
    }

    public static void exportBiome(BiomeClass biome) throws IOException {
        String prefix = "Biome_";
        int biomeNumber = 1;
        String fileName = String.format(prefix+"%04d.txt",biomeNumber);
        File file = new File(fileName);

        while (file.exists()){
            biomeNumber++;
            fileName = String.format(prefix+"%04d.txt",biomeNumber);
            file = new File(fileName);
        }

        PrintWriter salida = new PrintWriter(new FileWriter(file, true));
        salida.println(biome);
        salida.close();
    }
}
