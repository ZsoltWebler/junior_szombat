package java_collections;

import java.util.Objects;

public class Question {

    private final String question;
    private final String answer;
    private final int score;
    private final String genre;

    public Question(String question, String answer, int score, String genre) {
        this.question = question;
        this.answer = answer;
        this.score = score;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public String getQuestion() {
        return question;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", score=" + score +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return score == question1.score && Objects.equals(question, question1.question) && Objects.equals(answer, question1.answer) && Objects.equals(genre, question1.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer, score, genre);
    }
}
