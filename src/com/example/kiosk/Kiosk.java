package com.example.kiosk;

import java.util.Arrays;
import java.util.Scanner;

public class Kiosk {
    private final Cart cart;

    public Kiosk() {
        this.cart = new Cart();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);


        // 사용자 유형 입력
        System.out.println("[ 사용자 유형 설정 ]");
        System.out.println("1. 군인(할인 20%)");
        System.out.println("2. 학생(할인 15%)");
        System.out.println("3. 일반인");
        System.out.print("사용자 유형을 선택하세요: ");
        int userTypeChoice = scanner.nextInt();
        UserType userType = UserType.values()[userTypeChoice - 1];

        System.out.println("선택한 사용자 유형: " + userType.getDescription());

        while (true) {
            // 메인 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            Arrays.stream(MenuCategory.values())
                    .forEach(category -> System.out.println((category.ordinal() + 1) + ". " + category.getCategoryName()));
            System.out.println("4. 장바구니 보기");
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (choice == 4) {
                // 장바구니 보기 및 관리
                manageCart(scanner, userType);
                continue;
            }

            // 유효한 선택인지 확인
            if (choice > 0 && choice <= MenuCategory.values().length) {
                MenuCategory selectedCategory = MenuCategory.values()[choice - 1];

                while (true) {
                    // 하위 메뉴 출력
                    System.out.println("[" + selectedCategory.getCategoryName() + "]");
                    selectedCategory.getItems()
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

                        // 장바구니 추가 여부
                        System.out.println("선택한 메뉴: " + selectedItem.getName());
                        System.out.print("장바구니에 추가하시겠습니까? (1: 추가, 0: 취소): ");
                        int addToCart = scanner.nextInt();

                        if (addToCart == 1) {
                            cart.addItem(selectedItem);
                            System.out.println(selectedItem.getName() + "이(가) 장바구니에 추가되었습니다.");
                        } else {
                            System.out.println("선택한 메뉴를 추가하지 않았습니다.");
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

    // 장바구니 관리
    private void manageCart(Scanner scanner,  UserType userType) {
        while (true) {
            cart.displayCart();
            if (cart.isEmpty()) {
                System.out.println("메인 메뉴로 돌아갑니다.");
                break;
            }
            double totalBeforeDiscount = cart.calculateTotalBeforeDiscount();
            System.out.println("총 금액 (할인 전): $" + totalBeforeDiscount);

            System.out.println("1. 항목 삭제");
            System.out.println("2. 결제하기");
            System.out.println("0. 메인 메뉴로 돌아가기");
            System.out.print("선택하세요: ");

            int cartChoice = scanner.nextInt();

            if (cartChoice == 0) {
                System.out.println("메인 메뉴로 돌아갑니다.");
                break;
            } else if (cartChoice == 1) {
                System.out.print("삭제할 항목 번호를 입력하세요: ");
                int itemToRemove = scanner.nextInt() - 1;
                cart.removeItem(itemToRemove);
            } else if (cartChoice == 2) {
                double total = cart.calculateTotal(userType);
                System.out.println("총 금액 :" + total+"원");
                System.out.print("결제하시겠습니까? (1: 결제, 0: 취소): ");
                int checkout = scanner.nextInt();





                if (checkout == 1) {
                    System.out.println("결제가 완료되었습니다!");
                    cart.clearCart();
                    break;
                } else {
                    System.out.println("결제를 취소했습니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }
}
