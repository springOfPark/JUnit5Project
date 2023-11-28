package me.ktpark.javaTest.levelOne.testInstanceCheck;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 클래스마다 인스턴스가 생성되기 때문에 각 메소드가 하나의 인스턴스를 공유하게 됨
public class TestInstanceCheckOther {

    // 이제 더이상 @BeforeAll, @AfterAll => static 메소드가 아니어도 됨 (Because TestInstance.Lifecycle.PER_CLASS)
    @BeforeAll
    void staticBeforeAll() {
        System.out.println("print before All");
    }

    @Test
    void print() {
        System.out.println("Print Test");
    }

}
