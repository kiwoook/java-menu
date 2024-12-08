package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import menu.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CrewTest {

    @ParameterizedTest
    @DisplayName("입력 에러 테스트")
    @NullAndEmptySource
    @ValueSource(strings = {"기이이이이욱", "기", "기이이이욱"})
    void test1(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Crew(input));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.INVALID_NAME.getMessage());

    }

    @ParameterizedTest
    @DisplayName("정상 입력 테스트")
    @ValueSource(strings = {"기욱", "기이욱", "기이이욱"})
    void test2(String input) {
        Crew crew = new Crew(input);

        assertThat(crew.getName()).isEqualTo(input);
    }

    @DisplayName("존재하지 않는 음식을 입력하면 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"엄", "1"})
    void test3(String input) {
        Crew crew = new Crew("기욱");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> crew.addPickyFoods(input));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.NOT_FOUND_MENU.getMessage());
    }

    @DisplayName("2개를 초과하는 음식들을 입력하면 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"짜장면,우동,스시"})
    void test4(String input) {
        Crew crew = new Crew("기욱");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> crew.addPickyFoods(input));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.EXCEED_PICKY_FOOD_SIZE.getMessage());
    }

    @DisplayName("정상적인 입력")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"짜장면", "짜장면,우동"})
    void test5(String input) {
        Crew crew = new Crew("기욱");

        crew.addPickyFoods(input);
    }

}
