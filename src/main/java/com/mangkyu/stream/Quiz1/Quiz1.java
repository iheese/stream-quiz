package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz1 {

    private static final String TARGET = "좋아";
    private static final int TARGET_LENGTH = TARGET.length();

    // 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz1() throws IOException {
        List<String[]> csvLines = readCsvLines();
        // 공백 없애는 코드
        // 취미 열에 접근해서 :로 구분되어 있는 것을 스트림 평면화한다.
        // Map<String, Integer>으로 만들고 key, value, mergeFunction 설정
        return csvLines.stream()
                .map(line -> line[1].replaceAll("\\s", ""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> newValue += oldValue));
    }

    // 1.2 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz2() throws IOException {
        List<String[]> csvLines = readCsvLines();
        // 스트림 시작 전에 정으로 시작하는지 확인
        // 공백 없애는 코드
        // 취미 열에 접근해서 :로 구분되어 있는 것을 스트림 평면화한다.
        // Map<String, Integer>으로 만들고 key, value, mergeFunction 설정
        return csvLines.stream()
                .filter(line -> line[0].startsWith("정"))
                .map(line -> line[1].replaceAll("\\s", ""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> newValue += oldValue));
    }

    // 1.3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
    public int quiz3() throws IOException {
        List<String[]> csvLines = readCsvLines();
        // 재귀함수를 이용해 TARGET 이 확인되고 나서 뒤에 TARGET이 있는지 확인
        // 스트림 요소를 하나의 데이터로 만들어준다.
        return csvLines.stream()
                .map(line -> countContains(line[2], 0))
                .reduce(0, Integer::sum);
    }

    private int countContains (String src, int fromIndex) {
        int index = src.indexOf(TARGET, fromIndex); // src 내에서 fromIndex 이후 TARGET 시작 인덱스 리턴
        if (index >= 0) { // 타겟 문자열이 없으면 -1 을 리턴
            return 1 + countContains(src, index + TARGET_LENGTH); // 재귀 함수로 TARGET 시작 인덱스 이후에 TARGET이 있는지 확인
        }
        return 0;
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
