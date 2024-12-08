package menu.controller;

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
    }

    public void getCrew() {
        RecoveryUtils.executeWithRetry(inputViewer::promptCrewNames, crews::addCrews);
    }

    


}
