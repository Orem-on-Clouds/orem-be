package org.example.orem.domain.plant.entity;

public enum Season {
    SPRING("봄"),
    SUMMER("여름"),
    FALL("가을"),
    WINTER("겨울");

    private final String value;

    Season(String value) {
        this.value = value;
    }

    public static Season of(String value){
        return switch (value){
            case "봄" -> Season.SPRING;
            case "여름" -> Season.SUMMER;
            case "가을" -> Season.FALL;
            default -> Season.WINTER;
        };
    }
}
