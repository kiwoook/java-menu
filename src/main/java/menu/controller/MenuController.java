package menu.controller;

import java.util.List;
import menu.model.Category;
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
    private final List<Category> categories = Category.getWeeklyCategory();

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
        for (Crew crew : crews.getCrews()) {
            crew.recommendFoodByDay(dayOfTheWeek, categories.get(dayOfTheWeek.index));
        }
    }

    public void result() {
        String categoryDivision = Category.toDivision(categories);
        String crewsResult = crews.toResult();

        outputViewer.printResult(categoryDivision, crewsResult);
    }


}
