package menu;

import menu.controller.MenuController;
import menu.view.InputViewer;
import menu.view.OutputViewer;

public class Application {
    public static void main(String[] args) {
        InputViewer inputViewer = new InputViewer();
        OutputViewer outputViewer = new OutputViewer();
        MenuController menuController = new MenuController(inputViewer, outputViewer);

        menuController.execute();
    }
}
