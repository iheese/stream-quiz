package com.mangkyu.stream.Quiz3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz3 {

    private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static final List<Integer> numbers2 = Arrays.asList(3, 4);

    // 3.1 모든 숫자 쌍의 배열 리스트를 반환하여라.
    // ex) numbers1 = [1,2,3], numbers2 = [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
    public List<Integer[]> quiz1() {
        // 2차원 배열을 여러개 만들어서 2차원 배열들의 스트림을 1차원으로 만들기
        // 리스트화
        return numbers1.stream()
                .flatMap(n -> numbers2.stream().map(m -> new Integer[]{n, m}))
                .collect(Collectors.toList());
    }

    // 3.2 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라.
    // ex) numbers1 = [1,2,3], numbers2 = [3,4] -> 12
    public int quiz2() {
        // 2차원 배열을 여러개 만들어서 2차원 배열들의 스트림을 1차원으로 만들기
        // 2차원 배열을 만들어서 해당 값들을 다 곱하고 intStream 변환
        // 곱한 값 중 최대값 리턴 아니면 0
        return numbers1.stream()
                .flatMap(n -> numbers2.stream().map(m -> new Integer[]{n, m}))
                .mapToInt(a -> a[0] * a[1])
                .max().orElse(0);
    }
}
