package me.ktpark.javaTest.levelOne;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {
    
    // AssertJ, Hemcrest, Truth 써드 파티 라이브러리도 사용 가능
    @Test
    void usingAssertJ() {

        Study study = new Study(15);
        assertThat(study.getLimit()).isGreaterThan(25);

    }

    @Test
    @DisplayName("Timeout 설정하여 테스트하기 (성능 시간 테스트)")
    void test_timeout() {

        // assertTimeout : 오래 걸리지만 안전함

        // assertTimeoutPreemptively : 주의해서 사용
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(1);
            Thread.sleep(350);
        });
        // TODO ThreadLocal
        
        // ThreadLocal : 쓰레드 공유가 되지 않음 (Spring 기본 Transaction 전략)

    }

    @Test
    @DisplayName("Assertion 한번에 모두 체크 하기 (assertAll 사용)")
    void testAssertionCheckAllInOnetime() {

        Supplier<String> printMsg = () -> "스터디를 처음 만들었을때의 상태는 " + StudyStatus.DRAFT.name() + " 이여야 합니다.";

        Study study = new Study(-10);

        // 한번에 여러개의 Assertion 수행
        assertAll(

                () -> assertNotNull(study),
                // Message 인자값에 문자열 연산 비용이 크다면 람다식으로 쓰느게 유용함 (성능상)
                () -> assertEquals(StudyStatus.END, study.getStatus(), printMsg.get()),
                () -> assertTrue(study.getLimit() > 0, "Limit 값은 0보다 커야한다.")

        );

    }

    @Test
    @DisplayName("Assertion 하나씩 체크하기")
    void testAssertionCheck() {

        Supplier<String> printMsg = () -> "스터디를 처음 만들었을때의 상태는 " + StudyStatus.DRAFT.name() + " 이여야 합니다.";

        Study study = new Study(-10);

        assertNotNull(study);
        assertEquals(StudyStatus.END, study.getStatus(), printMsg.get());
        assertTrue(study.getLimit() > 0, "Limit 값은 0보다 커야한다.");

    }

    @Test
    @DisplayName("기대했던 Throws 가 발생하는지 확인")
    void testAssertionThrows() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-2));
        assertEquals("LIMIT은 0보다 커야한다.", exception.getMessage());

    }


}
