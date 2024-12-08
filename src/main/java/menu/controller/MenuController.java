package menu.controller;

import java.util.List;
import menu.model.Category;
import menu.model.Crew;
import menu.model.Crews;
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
    }

    public void getCrew() {
        RecoveryUtils.executeWithRetry(inputViewer::promptCrewNames, crews::addCrews);
    }

    public void getPickyFoodsByCrews() {
        for (Crew crew : crews.getCrews()) {
            RecoveryUtils.executeWithRetry(() -> inputViewer.promptPickyFoods(crew.getName()), crew::addPickyFoods);
        }
    }

    public void createWeeklyFood() {
        for (int i = 0; i < 5; i++) {
            for (Crew crew : crews.getCrews()) {
                crew.recommendFoodByDay(i, categories.get(i));
            }
        }
    }


}
