package me.ktpark.javaTest.levelOne;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

// 전체 메소드 네이밍 전략 설정 
// 메소드명에 _ 공백으로 치환하여 가독성 증가
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class SecondTest {

    @Test
    void do_display_method_naming() {
        System.out.println("테스트");
    }

    @Test
    @DisplayName("메소드명 출력 수정해보기")
    void do_display_annotation() {
        System.out.println("이거는 한글도 입력이 가능");
    }

}