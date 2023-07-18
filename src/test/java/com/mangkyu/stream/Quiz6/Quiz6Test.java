package com.mangkyu.stream.Quiz6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Quiz6Test {

    private final Answer6 answer = new Answer6();
    private final Quiz6 quiz = new Quiz6();

    @Test
    void quiz1() {
        assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
        print(1, quiz.quiz1(), answer.quiz1());
    }

    @Test
    void quiz2() {
        assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
        print(1, quiz.quiz2(), answer.quiz2());
    }

    public void print(int quizNumber,Object answer, Object quiz) {
        System.out.println(quizNumber + "번 문제 정답 출력 결과 : " + answer);
        System.out.println(quizNumber + "번 나의 정답 출력 결과 : " + quiz);
    }
}