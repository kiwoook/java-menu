package menu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import menu.utils.StringUtils;

public class CategoryHistory {

    private final List<Category> categories;

    public CategoryHistory() {
        this.categories = new ArrayList<>();
    }

    public static CategoryHistory create() {
        return new CategoryHistory();
    }

    public void add(Category category) {
        categories.add(category);
    }

    public boolean canUseCategory(Category category) {
        return countCategory(category) != 2;
    }

    private long countCategory(Category sameCategory) {
        return categories.stream()
                .filter(category -> category.equals(sameCategory))
                .count();
    }

    public String toDivision() {
        StringJoiner joiner = new StringJoiner("|", "[", "]");
        joiner.add(StringUtils.formatString("카테고리"));

        for (Category category : categories) {
            String korean = category.getKorean();
            joiner.add(StringUtils.formatString(korean));
        }

        return joiner.toString();
    }
}
