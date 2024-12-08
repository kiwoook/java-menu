package menu.view;

import static menu.utils.Constants.ENTER;

import camp.nextstep.edu.missionutils.Console;

public class InputViewer {

    public String promptCrewNames() {
        System.out.println("점심 메뉴 추천을 시작합니다." + ENTER);
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");

        return Console.readLine();
    }

    public String promptPickyFoods(String name) {
        System.out.println(ENTER + name + "(이)가 못 먹는 메뉴를 입력해 주세요.");

        return Console.readLine();
    }
}
