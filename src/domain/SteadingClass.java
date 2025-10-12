package domain;

public class SteadingClass {
    private String size = "";
    private String tags = "";
    private String[] featuresTable;
    private String feature = "";
    private String[] problemsTable;
    private String problem = "";
    private String raceOfBuilders = "";
    private String alignment = "";
    private String dangerLevel = "";

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getRaceOfBuilders() {
        return raceOfBuilders;
    }

    public void setRaceOfBuilders(String raceOfBuilders) {
        this.raceOfBuilders = raceOfBuilders;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(String dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public String[] getFeaturesTable() {
        return featuresTable;
    }

    public void setFeaturesTable(String[] featuresTable) {
        this.featuresTable = featuresTable;
    }

    public String[] getProblemsTable() {
        return problemsTable;
    }

    public void setProblemsTable(String[] problemsTable) {
        this.problemsTable = problemsTable;
    }
}
