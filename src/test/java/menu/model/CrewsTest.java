package menu.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import menu.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CrewsTest {

    @ParameterizedTest
    @DisplayName("크루원 수가 범위밖이면 에러 발생")
    @ValueSource(strings = {"기욱", "기욱1,기욱2,기욱3,기욱4,기욱5,기욱6"})
    void test1(String input) {
        Crews crews = Crews.create();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> crews.addAll(input));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.EXCEED_CREW_SIZE.getMessage());
    }
}
