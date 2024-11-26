package com.example.kiosk;

public class MenuItem {
    private final String name;        // 이름
    private final double price;       // 가격
    private final String description; // 설명

    // 생성자
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ") - " + description;
    }
}
