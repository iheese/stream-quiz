package com.mangkyu.stream.Quiz2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Quiz2Test{

    private final Answer2 answer = new Answer2();
    private final Quiz2 quiz = new Quiz2();


    @Test
    void quiz1() {
        assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
        print(1, answer.quiz1(), quiz.quiz1());
    }

    @Test
    void quiz2() {
        assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
        print(2, answer.quiz2(), quiz.quiz2());
    }

    public void print(int quizNumber,Object answer, Object quiz) {
        System.out.println( quizNumber + "번 문제 정답 출력 결과 : " + answer);
        System.out.println( quizNumber + "번 나의 정답 출력 결과 : " + quiz);
    }
}