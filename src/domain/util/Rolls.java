package domain.util;


import java.util.Random;

public class Rolls {

    public static String rollTwice(String[] a){
        int n = Rolls.UniversalRoll(a);
        String s1 = a[n];
        String s2;
        do{
            n=Rolls.UniversalRoll(a);
            s2 = a[n];
        } while (s1.equals(s2));

        return s1+" + "+s2;
    }

    public static int UniversalRoll(String[] a){
     return (int) (Math.random()*a.length);
    }

    public static boolean rollBoolean(){
        return java.util.concurrent.ThreadLocalRandom.current().nextBoolean();
    };

    public static int Roll1d2() {
        Random azar = new Random();
        int resultado = azar.nextInt(2);
        return resultado;
    }

    public static int Roll1d4() {
        Random azar = new Random();
        int resultado = azar.nextInt(4);
        return resultado;
    }
    public static int Roll1d6() {
        Random azar = new Random();
        int resultado = azar.nextInt(6);
        return resultado;
    }

    public static int Roll1d8() {
        Random azar = new Random();
        int resultado = azar.nextInt(8);
        return resultado;
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
