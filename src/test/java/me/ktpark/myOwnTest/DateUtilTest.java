package me.ktpark.myOwnTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DateUtilTest {

    @Test
    void oldDateUtilTest() throws InterruptedException {

        Date date = new Date();
        long time = date.getTime();

        System.out.println(date);
        System.out.println(time);

        Thread.sleep(1000 * 3);

        Date afterDate = new Date();
        System.out.println(afterDate);

        afterDate.setTime(time);
        // 같은 인스턴스인데 3초 이전으로 돌아감..
        // Mutable : 객체의 상태를 변경할 수 있다. (멀티 쓰레드 환경에서 위험)
        //   ==> 스레드가 값을 사용하고 있는데 다른 스레드가 값을 변경할 수 있음
        //  반대 <--> Immutable
        System.out.println(afterDate);

    }

    @Test
    void JDK8_IN_INSTANT() {

        // 1. 컴퓨터 사용 시간
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 (UTC == GMT)
        System.out.println(instant.atZone(ZoneId.of("UTC"))); // 기준시 (UTC == GMT)

        // 로컬 기준 시간으로 보기
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);
        
        // Instant : 시간 비교 또는 시간 측정 등에 사용

    }

    @Test
    void JDK8_IN_LOCAL_DATE_TIME() {

        // 로컬 기준 시간
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // 시간 생성
        LocalDateTime birthday = LocalDateTime.of(1994, Month.JULY, 1, 12, 30, 45);
        System.out.println(birthday);

        // 특정 지역 현재 시간 가져오기
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime);

        // Instant ==> ZonedDateTime 변환 가능
        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime2 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime2);

    }

    @Test
    void JDK8_IN_PERIOD_AND_DURATION() {

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(2024, Month.JUNE, 1);

        System.out.println(today);
        System.out.println(birthday);

        Stream<LocalDate> localDateStream = today.datesUntil(birthday);
        long count = localDateStream.count();
        System.out.println(count);

        // 차이가 나는 일 수 구하기
        Period period = Period.between(today, birthday);
        System.out.println(period.getDays());

        // 차이가 나는 월
        Period until = today.until(birthday);
        System.out.println(until.get(ChronoUnit.MONTHS));

        // Duration (기계용 시간 측정)
        Instant nowInstant = Instant.now();
        Instant plus = nowInstant.plus(10, ChronoUnit.SECONDS);

        Duration duration = Duration.between(nowInstant, plus);
        System.out.println(duration.getSeconds());

    }

    @Test
    void JDK8_IN_FORMATTING_AND_PARSING() {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(localDateTime.format(MMddyyyy));

        LocalDate parse = LocalDate.parse("06/01/1994", MMddyyyy);
        System.out.println(parse);

    }

    @BeforeEach
    void printBeforeEach() {
        System.out.println();
        System.out.println("===============================================");
        System.out.println();
    }

}
