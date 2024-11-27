package com.example.kiosk;

public enum UserType {
    SOLDIER("군인", 0.2),   // 20% 할인
    STUDENT("학생", 0.15), // 15% 할인
    GENERAL("일반인", 0.0); // 할인 없음

    private final String description;
    private final double discountRate;

    UserType(String description, double discountRate) {
        this.description = description;
        this.discountRate = discountRate;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
