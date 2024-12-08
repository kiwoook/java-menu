package menu.exception;

public enum ErrorMessage {
    // 에러 메시지 추가하기
    INVALID_INPUT("잘못된 입력입니다. 다시 입력해 주세요."),
    INVALID_NAME("사용할 수 없는 이름입니다. 2~4자리의 이름으로 설정해주세요."),
    EXCEED_PICKY_FOOD_SIZE("최대 2개까지만 설정 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}