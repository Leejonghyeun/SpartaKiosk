package com.example.kiosk;




public class Main {
        public static void main(String[] args) {
                // 각 카테고리 메뉴 생성
                Menu burgers = new Menu("Burgers");
                burgers.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
                burgers.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼, 쉑소스가 토핑된 치즈버거"));
                burgers.addMenuItem(new MenuItem("ShroomBurger", 7.9, "포르토벨로 버섯, 멜팅 치즈, 쉑소스가 토핑된 버거"));

                Menu drinks = new Menu("Drinks");
                drinks.addMenuItem(new MenuItem("Coke", 2.5, "시원한 코카콜라"));
                drinks.addMenuItem(new MenuItem("Sprite", 2.5, "상쾌한 스프라이트"));
                drinks.addMenuItem(new MenuItem("Iced Tea", 2.0, "아이스 티"));

                Menu desserts = new Menu("Desserts");
                desserts.addMenuItem(new MenuItem("Ice Cream", 3.5, "바닐라 아이스크림"));
                desserts.addMenuItem(new MenuItem("Chocolate Cake", 4.5, "진한 초콜릿 케이크"));

                // Kiosk 객체 생성 및 메뉴 추가
                Kiosk kiosk = new Kiosk();
                kiosk.addMenu(burgers);
                kiosk.addMenu(drinks);
                kiosk.addMenu(desserts);

                // Kiosk 시작
                kiosk.start();


        }
}