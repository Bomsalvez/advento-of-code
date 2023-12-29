package dev.senzalla.daytwo;

public class Cube {
    private final int number;
    private final String cor;

    public Cube(int number, String cor) {
        this.number = number;
        this.cor = cor;
    }

    public int getNumber() {
        return number;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "number=" + number +
                ", cor='" + cor + '\'' +
                '}';
    }
}
