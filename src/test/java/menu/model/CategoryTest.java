package menu.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    @DisplayName("같은 카테고리가 3개 이상 들어가면 true를 반환한다.")
    void test1() {
        List<Category> categories = List.of(Category.KOR, Category.KOR, Category.KOR, Category.CHN, Category.JPN);

        assertThat(Category.isNotValidWeeklyCategory(categories)).isTrue();
    }

    @Test
    @DisplayName("숫자에 따라 맞는 카테고리를 반환해야 한다.")
    void test2() {
        List<Category> expect = List.of(Category.JPN, Category.KOR, Category.CHN, Category.ASIAN, Category.WEST);

        for (int number = 1; number <= 5; number++) {
            assertThat(Category.getCategoryByNumber(number)).isEqualTo(expect.get(number - 1));
        }
    }

}
