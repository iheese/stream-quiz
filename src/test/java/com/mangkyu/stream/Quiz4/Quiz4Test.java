package com.mangkyu.stream.Quiz4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Quiz4Test {

    private final Answer4 answer = new Answer4();
    private final Quiz4 quiz = new Quiz4();

    @Test
    void quiz1() {
        assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
        print(1, quiz.quiz1(), answer.quiz1());
    }

    @Test
    void quiz2() {
        assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
        print(2, quiz.quiz2(), answer.quiz2());
    }

    @Test
    void quiz3() {
        assertThat(quiz.quiz3()).isEqualTo(answer.quiz3());
        print(3, quiz.quiz3(), answer.quiz3());
    }

    @Test
    void quiz4() {
        assertThat(quiz.quiz4()).isEqualTo(answer.quiz4());
        print(4, quiz.quiz4(), answer.quiz4());
    }

    @Test
    void quiz5() {
        assertThat(quiz.quiz5()).isEqualTo(answer.quiz5());
        print(5, quiz.quiz5(), answer.quiz5());
    }

    @Test
    void quiz6() {
        assertThat(quiz.quiz6()).isEqualTo(answer.quiz6());
        print(6, quiz.quiz6(), answer.quiz6());
    }

    @Test
    void quiz7() {
        assertThat(quiz.quiz7()).isEqualTo(answer.quiz7());
        print(7, quiz.quiz7(), answer.quiz7());
    }

    public void print(int quizNumber,Object answer, Object quiz) {
        System.out.println( quizNumber + "번 문제 정답 출력 결과 : " + answer);
        System.out.println( quizNumber + "번 나의 정답 출력 결과 : " + quiz);
    }
}