package menu.exception;

public enum ErrorMessage {

    INVALID_INPUT("잘못된 입력입니다. 다시 입력해 주세요."),
    INVALID_NAME("사용할 수 없는 이름입니다. 2~4자리의 이름으로 설정해주세요."),
    EXCEED_PICKY_FOOD_SIZE("최대 2개까지만 설정 가능합니다."),
    EXCEED_CREW_SIZE("2~5명까지만 식사할 수 있습니다!"),
    NOT_FOUND_MENU("존재하지 않는 메뉴가 존재합니다. 다시 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}