package domain;

public interface IPWClass<T extends IPWClass> extends Cloneable {
    String oneLiner ="";


    @Override
    String toString();

    String getOneLiner();

    void setOneLiner(String oneLiner);

    T clone();

}
