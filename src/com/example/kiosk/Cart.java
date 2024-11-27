package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    // 장바구니에 항목 추가
    public void addItem(MenuItem item) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getMenuItem().equals(item)) {
                cartItem.incrementQuantity();
                return;
            }
        }
        cartItems.add(new CartItem(item));
    }

    // 장바구니 출력
    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }

        System.out.println("== 장바구니 ==");
        int index = 1;
        for (CartItem cartItem : cartItems) {
            MenuItem item = cartItem.getMenuItem();
            int quantity = cartItem.getQuantity();
            double itemTotal = item.getPrice() * quantity;

            System.out.println(index++ + ". " + item.getName() + " (x" + quantity + ") - $" + itemTotal);
        }
    }

    // 총 금액 계산 (할인 적용 전)
    public double calculateTotalBeforeDiscount() {
        return cartItems.stream()
                .mapToDouble(cartItem -> cartItem.getMenuItem().getPrice() * cartItem.getQuantity())
                .sum();
    }

    // 총 금액 계산 (할인율 적용)
    public double calculateTotal(UserType userType) {
        double total = cartItems.stream()
                .mapToDouble(cartItem -> cartItem.getMenuItem().getPrice() * cartItem.getQuantity())
                .sum();
        return total * (1 - userType.getDiscountRate());
    }

    // 장바구니에서 항목 삭제
    public void removeItem(int index) {
        if (index < 0 || index >= cartItems.size()) {
            System.out.println("유효하지 않은 항목 번호입니다.");
            return;
        }
        System.out.println(cartItems.get(index).getMenuItem().getName() + "이(가) 삭제되었습니다.");
        cartItems.remove(index);
    }

    // 장바구니 비우기
    public void clearCart() {
        cartItems.clear();
    }

    // 장바구니가 비어있는지 확인
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}

// 장바구니 항목 클래스
class CartItem {
    private final MenuItem menuItem;
    private int quantity;

    public CartItem(MenuItem menuItem) {
        this.menuItem = menuItem;
        this.quantity = 1;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }
}
