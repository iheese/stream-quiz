package com.mangkyu.stream.Quiz2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz2 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    // 2.1 List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라.
    // ex) ("T", 1), ("a", 2) ...
    public Map<String, Integer> quiz1() {
        return WORDS.stream()
                .map(word -> word.substring(0,1)) // 배열 내 단어들 첫 번째 글자 추출
                .collect(Collectors.toMap(
                        prefix -> prefix, prefix -> 1,
                        (oldValue, newValue) -> (newValue += oldValue)
                )); // 첫 번째 글자에 대한 map 만들기
    }

    // 2.2 List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라.
    // ex) ["Hello", "a", "Island", "b"] -> “H I”
    public String quiz2() {
        return WORDS.stream()
                .filter(word -> word.length() >= 2) // if(조건문) 같은 역할
                .map(word -> word.substring(0, 1)) // 첫 글자만 String으로 자르기
                .map(String::toUpperCase) // 해당 String 값 대문자로 변환
                .collect(Collectors.joining(" ")); // 하나의 String 타입으로 값 묶기, 구분자 " "
    }
}
