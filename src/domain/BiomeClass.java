package domain;

public class BiomeClass implements IPWClass {
    private String biome;
    private String weather;
    private String weatherIntensity;
    private String wildlife;
    private String population;
    private String roads;
    private String alignment;
    private String distance;
    private String oneLiner;

    public String getOneLiner(){
        return oneLiner;
    }

    @Override
    public void setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
    }

    @Override
    public String toString(){

        return String.format("""
                Biome: %s
                Weather: %s
                Weather Intensity: %s
                Wildlife: %s
                Population: %s
                Roads: %s
                Alignment: %s
                Distance: %s""", this.getBiome(), this.getWeather(),this.getWeatherIntensity(), this.getWildlife(), this.getPopulation(),this.getRoads(),this.getAlignment(),this.getDistance() );

    }

    public String getBiome() {
        return biome;
    }

    public void setBiome(String biome) {
        this.biome = biome;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeatherIntensity() {
        return weatherIntensity;
    }

    public void setWeatherIntensity(String weatherIntensity) {
        this.weatherIntensity = weatherIntensity;
    }

    public String getWildlife() {
        return wildlife;
    }

    public void setWildlife(String wildlife) {
        this.wildlife = wildlife;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getRoads() {
        return roads;
    }

    public void setRoads(String roads) {
        this.roads = roads;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
