package menu.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    @DisplayName("숫자에 따라 맞는 카테고리를 반환해야 한다.")
    void test2() {
        List<Category> expect = List.of(Category.JPN, Category.KOR, Category.CHN, Category.ASIAN, Category.WEST);

        for (int number = 1; number <= 5; number++) {
            assertThat(Category.getCategoryByNumber(number)).isEqualTo(expect.get(number - 1));
        }
    }

    @RepeatedTest(1000)
    @DisplayName("정해진 카테고리 내에 음식을 반환해야 한다.")
    void test1() {
        List<String> menus = Category.JPN.getMenus();

        assertThat(menus).contains(Category.JPN.recommendFoodByRecommend());
    }


}
