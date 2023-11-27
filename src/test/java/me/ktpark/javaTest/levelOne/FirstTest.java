package me.ktpark.javaTest.levelOne;

import me.ktpark.javaTest.levelOne.Study;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FirstTest {

    @Test
    void create() {
        Study study = new Study(-5);
        assertNotNull(study);
        System.out.println("1. Create First");
    }

    @Test
    @Disabled // 테스트 실행하지 않도록 설정
    void createOther() {
        System.out.println("2. Create Other!");
        Study study = new Study();
        assertNull(study);
    }

    // 해당 테스트 클래스 메소드 실행 전 단 한 번 실행
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before ALL");
    }

    // 해당 테스트 클래스 메소드 실행 후 단 한 번 실행
    @AfterAll
    static void afterAll() {
        System.out.println("After ALL");
    }

    // 각 메소드 실행 하기 전
    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each Call");
    }

    // 각 메소드 실행 후
    @AfterEach
    void afterEach() {
        System.out.println("After Each Call");
    }

}