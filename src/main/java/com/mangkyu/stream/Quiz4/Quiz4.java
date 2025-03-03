package com.mangkyu.stream.Quiz4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz4 {

    private List<Transaction> transactions;

    public Quiz4() {
        Trader kyu = new Trader("Kyu", "Seoul");
        Trader ming = new Trader("Ming", "Gyeonggi");
        Trader hyuk = new Trader("Hyuk", "Seoul");
        Trader hwan = new Trader("Hwan", "Busan");

        transactions = Arrays.asList(
                new Transaction(kyu, 2019, 30000),
                new Transaction(kyu, 2020, 12000),
                new Transaction(ming, 2020, 40000),
                new Transaction(ming, 2020, 7100),
                new Transaction(hyuk, 2019, 5900),
                new Transaction(hwan, 2020, 4900)
        );
    }

    // 4.1 2020년에 일어난 모든 거래 내역을 찾아 거래값을 기준으로 오름차순 정렬하라.
    public List<Transaction> quiz1() {
        // 2020년도 조건
        // sorted Transaction 거래값 비교, 내림차순은 reversed() 뒤에 붙이기
        // 리스트화
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == 2020)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    // 4.2 거래 내역이 있는 거래자가 근무하는 모든 도시를 중복 없이 나열하라.
    public List<String> quiz2() {
        // 거래 내역의 거래자의 도시로 변환
        // 중복 없이 처리
        // 리스트화
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    // 4.3 서울에서 근무하는 모든 거래자를 찾아서 이름순서대로 정렬하라.
    public List<Trader> quiz3() {
        // 거래내역의 거래자로 변환
        // 중복이면 제거
        // 서울에서 거래한지 확인
        // 거래자 이름 순서대로(오름차순)
        // 리스트화
        return transactions.stream()
                .map(transaction -> transaction.getTrader())
                .distinct()
                .filter(trader -> trader.getCity().equals("Seoul"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    // 4.4 모든 거래자의 이름을 구분자(",")로 구분하여 정렬하라.
    public String quiz4() {
        // 거래 내역의 거래자 이름 추출
        // 중복 제거
        // String 스트림 오름차순 정렬
        // 구분자 포함해서 String 값으로 만들기
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
    }

    // 4.5 부산에 거래자가 있는지를 확인하라.
    public boolean quiz5() {
        // 거래자의 도시에 Busan 이 있는지 확인
        return transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Busan"));
    }

    // 4.6 서울에 거주하는 거래자의 모든 거래 금액을 구하라.
    public List<Integer> quiz6() {
        // 거래 내역의 거래자의 도시가 Seoul 인지 확인
        // 일치하면 해당 거래 내역의 거래 금액 변경
        // 모든 거래 금액 리스트화
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Seoul"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
    }

    // 4.7 모든 거래 내역중에서 거래 금액의 최댓값과 최솟값을 구하라. 단, 최댓값은 reduce를 이용하고 최솟값은 stream의 min()을 이용하라.
    public Integer[] quiz7() {
        Integer[] array = new Integer[2];
        // 거래 내역의 거래 금액을 가져옵니다.
        // 거래 금액 중 최대 값을 가져옵니다. // reduce는 스트림 여러 개의 값을 하나로 만듭니다.
        // 아니면 -1 을 출력합니다.
        array[0] = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .orElse(-1);

//        array[0] = transactions.stream()
//                .max(Comparator.comparingInt(Transaction::getValue))
//                .orElseThrow(RuntimeException::new).getValue();

        // 거래 내역 스트림에서 거래 금액을 비교해 최솟값을 가져옵니다.
        // 존재하지 않으면 예외를 던진다.
        array[1] = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .orElseThrow(RuntimeException::new).getValue();

//        array[1] = transactions.stream()
//                .map(Transaction::getValue) // 거래 내역의 거래 금액을 가져옵니다.
//                // reduce는 스트림 여러 개의 값을 하나로 만듭니다.
//                .reduce(Integer::min) // 거래 금액 중 최대 값을 가져옵니다.
//                .orElse(-1); // 아니면 -1 을 출력합니다.

        // 최솟값과 최댓값을 구하는 건 두 가지 방식으로 가능하다.
        return array;
    }
}
