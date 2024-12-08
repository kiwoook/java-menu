package menu.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategoryHistoryTest {

    @DisplayName("같은 카테고리가 2개가 있으면 false를 반환한다.")
    @Test
    void test1() {
        CategoryHistory categoryHistory = CategoryHistory.create();
        categoryHistory.add(Category.KOR);
        categoryHistory.add(Category.KOR);

        assertThat(categoryHistory.canUseCategory(Category.KOR)).isFalse();
    }
}
