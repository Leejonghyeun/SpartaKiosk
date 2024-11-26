package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String categoryName;        // 카테고리 이름 (예: Burgers, Drinks)
    private final List<MenuItem> menuItems;  // MenuItem 리스트

    // 생성자
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    // 메뉴 항목 추가
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    // 카테고리 이름 반환
    public String getCategoryName() {
        return categoryName;
    }

    // 메뉴 리스트 반환
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // 메뉴 출력
    public void displayMenu() {
        System.out.println("[" + categoryName + "]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
        System.out.println("0. 뒤로가기");
    }
}
