package domain.util;


import java.util.Random;

public class Rolls {

    public static int UniversalRoll(String[] a){
     return (int) (Math.random()*a.length);
    }


    public static int Roll1d12() {
        Random azar = new Random();
        int resultado = azar.nextInt(12);
        return resultado;
    }

    public static int Roll1d10(){
        Random azar = new Random();
        int resultado = azar.nextInt(10);
        return resultado;
    }


}
