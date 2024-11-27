package com.example.kiosk;

import java.util.Arrays;
import java.util.Scanner;

public class Kiosk {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 메인 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            Arrays.stream(MenuCategory.values())
                    .forEach(category -> System.out.println((category.ordinal() + 1) + ". " + category.getCategoryName()));
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 유효한 선택인지 확인
            if (choice > 0 && choice <= MenuCategory.values().length) {
                MenuCategory selectedCategory = MenuCategory.values()[choice - 1];

                while (true) {
                    // 하위 메뉴 출력
                    System.out.println("[" + selectedCategory.getCategoryName() + "]");
                    selectedCategory.getItems().stream()
                            .forEach(item -> System.out.println((selectedCategory.getItems().indexOf(item) + 1) + ". " + item));
                    System.out.println("0. 뒤로가기");
                    System.out.print("메뉴를 선택하세요: ");

                    int subChoice = scanner.nextInt();

                    if (subChoice == 0) {
                        System.out.println("메인 메뉴로 돌아갑니다.");
                        break;
                    }

                    // 유효한 선택인지 확인
                    if (subChoice > 0 && subChoice <= selectedCategory.getItems().size()) {
                        MenuItem selectedItem = selectedCategory.getItems().get(subChoice - 1);
                        System.out.println("선택한 메뉴: " + selectedItem.getName());
                        System.out.println("가격: $" + selectedItem.getPrice());
                        System.out.println("설명: " + selectedItem.getDescription());
                        System.out.println("뒤로가려면 0을 눌러주세요");

                        // 뒤로가기 입력 대기
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
