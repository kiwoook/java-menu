package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
    JPN(1, "일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOR(2, "한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHN(3, "중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", " 토마토 달걀볶음", "고추잡채")),
    ASIAN(4, "아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WEST(5, "양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));


    private final int number;
    private final String korean;
    private final List<String> menus;

    Category(int number, String korean, List<String> menus) {
        this.number = number;
        this.korean = korean;
        this.menus = menus;
    }

    public static List<String> getAllMenu() {
        return Arrays.stream(values())
                .map(Category::getMenus)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static Category getCategory() {
        int number = Randoms.pickNumberInRange(1, 5);
        return getCategoryByNumber(number);
    }

    public static Category getCategoryByNumber(int number) {
        return Arrays.stream(values()).filter(category -> category.number == number)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    public String recommendFoodByRecommend() {
        List<String> menus = this.getMenus();

        return Randoms.shuffle(menus).get(0);
    }

    public List<String> getMenus() {
        return new ArrayList<>(menus);
    }

    public String getKorean() {
        return korean;
    }


}
