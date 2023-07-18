package com.mangkyu.stream.Quiz5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    // 5.1 모든 문자열의 길이를 더한 결과를 출력하여라.
    public int quiz1() {
        // 배열 스트림화
        // mapToInt(String::length) 도 가능, 새로운 intStream 변환
        // 합 구하기
        return Arrays.stream(STRING_ARR)
                .mapToInt(s -> s.length())
                .sum();
    }

    // 5.2 문자열 중에서 가장 긴 것의 길이를 출력하시오.
    public int quiz2() {
        // 배열 스트림화
        // mapToInt(String::length) 도 가능, 새로운 intStream 변환
        // 최대값 출력
        return Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .max().orElse(-1);
    }

    // 5.3 임의의 로또번호(1~45)를 정렬해서 출력하시오.
    public List<Integer> quiz3() {
        // 1~45 랜덤 숫자 객체
        // 중복 없이
        // 6개 제한
        // IntStream -> Stream<Integer> // 원시타입스트림 지원을 클래스 타입으로 전환, int는 Collection에 담지 못하므로
        // 오름차순 정렬
        // 리스트화
        return new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }

    // 5.4 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
    public List<Integer[]> quiz4() {
        // rangeClosed 는 2번째 인자까지 포함해서 범위의 숫자를 차례대로 생성해준다.
        // IntStream -> Stream<Integer>
        // 하나의 i 에 대해 6개의 클래스 타입으로 생성
        // 합이 6인 경우 조건
        // 리스트화
        return IntStream.rangeClosed(1, 6)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(1, 6).boxed().map(j -> new Integer[]{i,j}))
                .filter(arr -> arr[0] + arr[1] == 6)
                .collect(Collectors.toList());
    }

}
