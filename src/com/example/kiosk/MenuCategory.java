package com.example.kiosk;

import java.util.Arrays;
import java.util.List;

public enum MenuCategory {
    BURGERS("Burgers", Arrays.asList(
            new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
            new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼, 쉑소스가 토핑된 치즈버거"),
            new MenuItem("ShroomBurger", 7.9, "포르토벨로 버섯, 멜팅 치즈, 쉑소스가 토핑된 버거")
    )),
    DRINKS("Drinks", Arrays.asList(
            new MenuItem("Coke", 2.5, "시원한 코카콜라"),
            new MenuItem("Sprite", 2.5, "상쾌한 스프라이트"),
            new MenuItem("Iced Tea", 2.0, "아이스 티")
    )),
    DESSERTS("Desserts", Arrays.asList(
            new MenuItem("Ice Cream", 3.5, "바닐라 아이스크림"),
            new MenuItem("Chocolate Cake", 4.5, "진한 초콜릿 케이크")
    ));

    private final String categoryName;
    private final List<MenuItem> items;

    MenuCategory(String categoryName, List<MenuItem> items) {
        this.categoryName = categoryName;
        this.items = items;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem> getItems() {
        return items;
    }
}
