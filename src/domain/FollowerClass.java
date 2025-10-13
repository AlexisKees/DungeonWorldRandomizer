package domain;

public class FollowerClass implements PerilousWildsInterface{
    private String oneLiner;

    @Override
    public String getOneLiner(){
        return oneLiner;
    }

    @Override
    public void setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
    }
}
