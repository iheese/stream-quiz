package com.mangkyu.stream.Quiz1;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Quiz1Test {

    private final Answer1 answer = new Answer1();
    private final Quiz1 quiz = new Quiz1();

    @Test
    void quiz1() throws IOException {
        assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
        print(1, answer.quiz1(), quiz.quiz1()); // 정답과 나의 답을 출력한다.
    }

    @Test
    void quiz2() throws IOException {
        assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
        print(2, answer.quiz2(), quiz.quiz2());
    }

    @Test
    void quiz3() throws IOException {
        assertThat(quiz.quiz3()).isEqualTo(answer.quiz3());
        print(3, answer.quiz3(), quiz.quiz3());
    }

    public void print(int quizNumber,Object answer, Object quiz) {
        System.out.println( quizNumber + "번 문제 정답 출력 결과 : " + answer);
        System.out.println( quizNumber + "번 나의 정답 출력 결과 : " + quiz);
    }
}