package me.ktpark.javaTest.levelOne;

import net.bytebuddy.implementation.bind.annotation.Empty;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RepeatTest {

    @DisplayName("테스트 반복 실행")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}, {totalRepetitions}")
    void repeat_test(RepetitionInfo repetitionInfo) {
        System.out.println("print repeat" + repetitionInfo.getCurrentRepetition() + " / " + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("반복 테스트 실행 : 파라미터 바꾸면서 실행해보기")
    @ParameterizedTest(name = "{index} : {displayName} => message : {0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    @EmptySource // 비어있는 문자열 추가하여 테스트
    @NullSource // NULL 파라미터 추가하여 테스트
    void repeat_parameterized_test(String message) {

        System.out.println(message);

    }

    @DisplayName("반복 테스트 실행 : 파라미터 바꾸면서 실행해보기")
    @ParameterizedTest(name = "{index} : {displayName} => message : {0}")
    @ValueSource(ints = {12, 24, 36})
    void repeat_parameterized_test(Study study) {

        System.out.println(study.getLimit());

    }

}
