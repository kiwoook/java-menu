package menu.model;

import static menu.utils.Constants.SEPARATOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import menu.exception.CustomIllegalArgumentException;
import menu.exception.ErrorMessage;
import menu.utils.StringUtils;

public class Crew {

    private final String name;
    private final List<String> pickyFoods;
    private final List<String> menu;

    public Crew(String name) {
        validName(name);
        this.name = name;
        this.pickyFoods = new ArrayList<>();
        this.menu = new ArrayList<>(List.of("", "", "", "", ""));
    }

    public void recommendFoodByDay(DayOfTheWeek day, Category category) {

        String food = category.recommendFoodByRecommend();

        if (isContainPickyFoods(food) || isContainFood(food)) {
            recommendFoodByDay(day, category);
        }

        menu.set(day.getIndex(), food);
    }

    private boolean isContainPickyFoods(String food) {
        return pickyFoods.contains(food);
    }

    private boolean isContainFood(String food) {
        return menu.contains(food);
    }

    public void addPickyFoods(String input) {
        if (input.isBlank()) {
            return;
        }

        List<String> split = Arrays.stream(StringUtils.split(SEPARATOR, input, null))
                .collect(Collectors.toList());

        split.forEach(this::validMenu);
        validPickyFoods(split);

        pickyFoods.addAll(split);
    }

    public void validMenu(String menu) {
        if (!Category.getAllMenu().contains(menu)) {
            throw new CustomIllegalArgumentException(ErrorMessage.NOT_FOUND_MENU);
        }
    }

    public void validPickyFoods(List<String> menus) {
        if (menus.size() > 2) {
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

    public String toResult() {
        StringJoiner joiner = new StringJoiner("|", "[", "]");
        joiner.add(StringUtils.formatString(name));

        for (String food : menu) {
            joiner.add(StringUtils.formatString(food));
        }

        return joiner.toString();
    }

}
