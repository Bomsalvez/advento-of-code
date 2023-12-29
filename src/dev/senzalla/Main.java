package dev.senzalla;

import dev.senzalla.dayone.Trebuchet;
import dev.senzalla.daytwo.CubeConundrum;

public class Main {
    public static void main(String[] args) {
        new Trebuchet().start();
        int result = new CubeConundrum().start();
        System.out.println(result);

    }
}