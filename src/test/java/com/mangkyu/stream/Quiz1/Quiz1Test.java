package com.mangkyu.stream.Quiz1;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Quiz1Test<T> {

    private final Answer1 answer = new Answer1();
    private final Quiz1 quiz = new Quiz1();
    private T t;

    @Test
    void quiz1() throws IOException {
        assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
        print((T) answer.quiz1(), (T) quiz.quiz1()); // 정답과 나의 답을 출력한다.
    }

    @Test
    void quiz2() throws IOException {
        assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
        print((T) answer.quiz2(), (T) quiz.quiz2());
    }

    @Test
    void quiz3() throws IOException {
        assertThat(quiz.quiz3()).isEqualTo(answer.quiz3());
        System.out.println("문제 정답 출력 결과 : " + answer.quiz3());
        System.out.println("나의 정답 출력 결과 : " + quiz.quiz3());
    }

    private void print(T answer, T quiz) {
        System.out.println("문제 정답 출력 결과 : " + answer);
        System.out.println("나의 정답 출력 결과 : " + quiz);
    }
}