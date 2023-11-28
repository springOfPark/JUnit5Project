package me.ktpark.myOwnTest;

import me.ktpark.javaTest.levelOne.Study;
import me.ktpark.javaTest.levelOne.StudyStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class OptionalTest {

    @Test
    void optionalOrElseGetTest() {

        Study makeStudy = getStudyOptional().orElseGet(this::createNewStudy);
        System.out.println(makeStudy);

        Assertions.assertThat(makeStudy).isNotNull();

    }

    @Test
    void optionalOrElseThrowTest() {

        // DEFAULT : java.util.NoSuchElementException: No value present
        // Study makeStudy = getStudyOptional().orElseThrow();

        Study makeStudy = getStudyOptional().orElseThrow(() -> new IllegalArgumentException("Study 객체를 가져올 수 없습니다."));

    }

    private Optional<Study> getStudyOptional() {
        return Optional.ofNullable(null);
    }

    private Study createNewStudy() {
        Study study = new Study(1000);
        study.setStudyStatus(StudyStatus.STARTED);
        study.setName("KTPARK");
        return study;
    }
}
