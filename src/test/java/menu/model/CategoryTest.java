package menu.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    @DisplayName("카테고리 셔플 확인 테스트")
    void test1() {
        String food = Category.JPN.recommendFoodByRecommend();

        System.out.println(food);
    }
}
