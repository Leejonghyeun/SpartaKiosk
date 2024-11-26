package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus; // Menu 리스트

    // 생성자
    public Kiosk() {
        this.menus = new ArrayList<>();
    }

    // 메뉴 추가
    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    // 프로그램 시작
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 메인 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (choice > 0 && choice <= menus.size()) {
                Menu selectedMenu = menus.get(choice - 1);

                while (true) {
                    // 하위 메뉴 출력
                    selectedMenu.displayMenu();
                    System.out.print("메뉴를 선택하세요: ");
                    int subChoice = scanner.nextInt();

                    if (subChoice == 0) {
                        System.out.println("메인 메뉴로 돌아갑니다.");
                        break;
                    }

                    if (subChoice > 0 && subChoice <= selectedMenu.getMenuItems().size()) {
                        MenuItem selectedItem = selectedMenu.getMenuItems().get(subChoice - 1);
                        System.out.println("선택한 메뉴: " + selectedItem.getName());
                        System.out.println("가격: $" + selectedItem.getPrice());
                        System.out.println("설명: " + selectedItem.getDescription());
                        System.out.println("뒤로가려면 0을 눌러주세요");

                        // 뒤로가기 대기
                        while (scanner.nextInt() != 0) {
                            System.out.println("0을 눌러 뒤로 갈 수 있습니다.");
                        }
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                    }
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }

        scanner.close();
    }
}
