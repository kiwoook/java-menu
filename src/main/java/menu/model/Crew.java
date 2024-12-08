package menu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.exception.CustomIllegalArgumentException;
import menu.exception.ErrorMessage;
import menu.utils.StringUtils;

public class Crew {

    private final String name;
    private List<String> pickyFoods;
    private List<String> menu;

    public Crew(String name) {
        validName(name);
        this.name = name;
        this.pickyFoods = new ArrayList<>();
        this.menu = new ArrayList<>();
    }

    public void addPickyFoods(String input) {
        if (input.isBlank()) {
            return;
        }

        List<String> split = Arrays.stream(StringUtils.split(",", input, null))
                .collect(Collectors.toList());
        validPickyFoods(split);

        pickyFoods.addAll(split);
    }

    public void validPickyFoods(List<String> split) {
        if (split.size() > 2) {
            throw new CustomIllegalArgumentException(ErrorMessage.EXCEED_PICKY_FOOD_SIZE);
        }
    }

    public void validName(String input) {
        if (input == null || input.isBlank()) {
            throw new CustomIllegalArgumentException(ErrorMessage.INVALID_NAME);
        }

        if (input.length() < 2 || input.length() > 4) {
            throw new CustomIllegalArgumentException(ErrorMessage.INVALID_NAME);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "name='" + name + '\'' +
                ", pickyFoods=" + pickyFoods +
                ", menu=" + menu +
                '}';
    }
}
