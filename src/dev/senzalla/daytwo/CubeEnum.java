package dev.senzalla.daytwo;

public enum CubeEnum {
    RED(12, "red"),
    GREEN(13, "green"),
    BLUE(14, "blue");

    private final int number;
    private final String cor;

    CubeEnum(int number, String cor) {
        this.number = number;
        this.cor = cor;
    }

    public int getNumber() {
        return number;
    }

    public String getCor() {
        return cor;
    }
}
