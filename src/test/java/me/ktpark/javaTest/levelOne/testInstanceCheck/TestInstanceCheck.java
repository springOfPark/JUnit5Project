package me.ktpark.javaTest.levelOne.testInstanceCheck;

import me.ktpark.javaTest.levelOne.Study;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TestInstanceCheck {

    // JUNIT 의 기본전략은 테스트마다 클래스 인스턴스가 새로 생성됨
    //   => 테스트 메소드 간 의존성을 없애기 위해서 (순서 등 상관없이 테스트 가능 하도록)
    int value = 0;

    @Test
    void test() {
        Study study = new Study(value++);
        System.out.println(this);
        Assertions.assertThat(study).isNotNull();
    }

    void test_two() {
        System.out.println(this);
    }

}
