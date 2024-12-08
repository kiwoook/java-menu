package menu.controller;

import menu.model.Crew;
import menu.model.Crews;
import menu.utils.RecoveryUtils;
import menu.view.InputViewer;
import menu.view.OutputViewer;

public class MenuController {

    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;

    private final Crews crews = Crews.create();

    public MenuController(InputViewer inputViewer, OutputViewer outputViewer) {
        this.inputViewer = inputViewer;
        this.outputViewer = outputViewer;
    }

    public void execute() {
        getCrew();
        getPickyFoodsByCrews();
        System.out.println(crews);
    }

    public void getCrew() {
        RecoveryUtils.executeWithRetry(inputViewer::promptCrewNames, crews::addCrews);
    }

    public void getPickyFoodsByCrews() {
        for (Crew crew : crews.getCrews()) {
            RecoveryUtils.executeWithRetry(() -> inputViewer.promptPickyFoods(crew.getName()), crew::addPickyFoods);
        }
    }


}
