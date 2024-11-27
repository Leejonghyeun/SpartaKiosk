package com.example.kiosk;

import java.util.Arrays;
import java.util.List;

public enum MenuCategory {
    BURGERS("햄버거", Arrays.asList(
            new MenuItem("뷸고기 버거", 5600, "볼륨 가득한 패티와 불고기 소스가 잘 조화된 영양만점의 햄버거"),
            new MenuItem("클래식 치즈버거", 6100, "비프와 치즈 본연의 맛과 딜향의 피클이 조화된 클래식 치즈버거"),
            new MenuItem("핫 크리스피 버거", 6800, "매콤 바삭한 닭가슴살을 통째로 사용한 프리미엄 치킨버거")
    )),
    DRINKS("음료", Arrays.asList(
            new MenuItem("코카콜라", 2900, "시원한 코카콜라"),
            new MenuItem("코카콜라제로", 2900, "시원한 코카콜라 제로"),
            new MenuItem("펩시", 2900, "시원한 펩시콜라"),
            new MenuItem("펩시제로 라임", 2900, "시원한 펩시제로 라임"),
            new MenuItem("스프라이트", 2900, "상쾌한 스프라이트"),
            new MenuItem("스프라이트 제로", 2900, "상쾌한 스프라이트 제로"),
            new MenuItem("아이스티", 3200, "상큼한 아이스 티"),
            new MenuItem("밀크쉐이크", 3500, "달달한 밀크쉐이크")
    )),
    DESSERTS("디저트", Arrays.asList(
            new MenuItem("포테이토", 3200, "바로 튀겨낸 바삭바삭한 후렌치 포테이토"),
            new MenuItem("양념감자", 3300, "시즈닝을 뿌려먹는 포테이토")
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
