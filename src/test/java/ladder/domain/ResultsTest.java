package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @DisplayName("대상 이름의 결과를 찾기")
    @ParameterizedTest
    @MethodSource(value = "provideResults")
    void resultOf(Results results) {
        assertThat(results.resultOf("pobi")).isEqualTo(new Result("pobi", "a"));
    }

    @DisplayName("대상 이름의 결과를 못 찾으면 예외")
    @ParameterizedTest
    @MethodSource(value = "provideResults")
    void resultOf_fail(Results results) {
        assertThatThrownBy(() -> results.resultOf("pobib"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Results.NOT_FOUND_TARGET_MESSAGE);
    }

    private static Stream<Arguments> provideResults() {
        return Stream.of(
                Arguments.of(new Results(new Result("pobi", "a"), new Result("crong", "b")))
        );
    }

}