package dev.senzalla.dayone;

public enum Numbers {
    ZERO(0, "zero"),
    ONE(1, "one"),
    TWO(2, "two"),
    THREE(3, "three"),
    FOUR(4, "four"),
    FIVE(5, "five"),
    SIX(6, "six"),
    SEVEN(7, "seven"),
    EIGHT(8, "eight"),
    NINE(9, "nine");

    private final int digit;
    private final String name;

    Numbers(int digit, String name) {
        this.digit = digit;
        this.name = name;
    }

    public int getDigit() {
        return digit;
    }

    public String getName() {
        return name;
    }
}
