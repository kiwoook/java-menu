package menu.view;

import static menu.utils.Constants.ENTER;

public class OutputViewer {

    private static final String ERROR_SIGN = "[ERROR] ";

    public void printError(Exception e) {
        System.out.println(ERROR_SIGN + e.getMessage());
    }

    public void printResult(String categoryDivision, String crewsResult) {
        System.out.println(ENTER + "메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(categoryDivision);
        System.out.println(crewsResult);
        System.out.println(ENTER + "추천을 완료했습니다.");
    }

}
