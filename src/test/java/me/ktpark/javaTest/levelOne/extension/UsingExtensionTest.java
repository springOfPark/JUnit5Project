package me.ktpark.javaTest.levelOne.extension;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.sql.SQLOutput;

// 익스탠션 사용 방법 01. 선언적 애노테이션 사용
//    - FindSlowTestExtension 확장이 어려운 단점 존재
@ExtendWith(FindSlowTestExtension.class)
public class UsingExtensionTest {

    // 익스탠션 사용 방법 02. 프로그래밍 선언
    //   - 값 수정하여 테스트하기 용이함 (DI)
    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension(10000L);

    @BeforeAll
    static void beforePrint() {
        System.out.println("@Before All Method need Static Methods");
    }

    @Test
    void test01() {
        System.out.println("첫번째 테스트 시작합니다");
    }

    @Test
    void test02() throws InterruptedException {
        System.out.println("두번째 메소드 실행합니다.");
        Thread.sleep(1250L);
    }

    @Test
    void test03() {
        System.out.println("세번째 메소드 실행합니다.");
    }

    @AfterAll
    static void printLast() {
        System.out.println("BEFORE ALL ...");
    }

}
