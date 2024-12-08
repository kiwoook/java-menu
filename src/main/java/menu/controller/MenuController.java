package menu.controller;

import menu.model.Category;
import menu.model.CategoryHistory;
import menu.model.Crew;
import menu.model.Crews;
import menu.model.DayOfTheWeek;
import menu.utils.RecoveryUtils;
import menu.view.InputViewer;
import menu.view.OutputViewer;

public class MenuController {

    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;

    private final Crews crews = Crews.create();
    private final CategoryHistory categoryHistory = CategoryHistory.create();

    public MenuController(InputViewer inputViewer, OutputViewer outputViewer) {
        this.inputViewer = inputViewer;
        this.outputViewer = outputViewer;
    }

    public void execute() {
        getCrew();
        getPickyFoodsByCrews();
        createWeeklyFood();
        result();
    }

    public void getCrew() {
        RecoveryUtils.executeWithRetry(inputViewer::promptCrewNames, crews::addAll);
    }

    public void getPickyFoodsByCrews() {
        for (Crew crew : crews.getCrews()) {
            RecoveryUtils.executeWithRetry(() -> inputViewer.promptPickyFoods(crew.getName()), crew::addPickyFoods);
        }
    }

    public void createWeeklyFood() {
        for (DayOfTheWeek dayOfTheWeek : DayOfTheWeek.values()) {
            createFoodByDayOfTheWeek(dayOfTheWeek);
        }
    }

    private void createFoodByDayOfTheWeek(DayOfTheWeek dayOfTheWeek) {
        Category category = Category.getCategory();

        if (!categoryHistory.canUseCategory(category)) {
            createFoodByDayOfTheWeek(dayOfTheWeek);
            return;
        }

        categoryHistory.add(category);

        for (Crew crew : crews.getCrews()) {
            crew.recommendFoodByDay(dayOfTheWeek, category);
        }
    }

    public void result() {
        String categoryDivision = categoryHistory.toDivision();
        String crewsResult = crews.toResult();

        outputViewer.printResult(categoryDivision, crewsResult);
    }


}
