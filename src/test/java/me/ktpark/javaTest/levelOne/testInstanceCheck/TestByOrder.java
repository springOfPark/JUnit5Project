package me.ktpark.javaTest.levelOne.testInstanceCheck;

import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // MethodOrderer : Alphanmumeric, OrderAnnotation 외 1개
public class TestByOrder { // 순서 테스트 : 순서가 있는 시나리오 테스트 하기에 유용함 (회원가입 -> 등록 -> 조회)

    int value = 0;

    @BeforeAll
    void beforeAll() {
        value++;
        System.out.println("Before ALL Method Do Something..");
    }

    @BeforeEach
    void beforeEach() {
        value++;
    }

    @Test
    @Order(3) // jUnit Import
    void third_test() {
        System.out.println("테스트 메소드 입니다. 03 ==> " + value);
    }

    @Test
    @Order(2)
    void second_test() {
        System.out.println("테스트 메소드 입니다. 02 ==> " + value);
    }

    @Test
    @Order(1)
    void first_test() {
        System.out.println("테스트 메소드 입니다. 01 ==> " + value);;
    }

}
