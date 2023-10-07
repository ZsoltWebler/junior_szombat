package contest;

public class Question {
    String question;
    String answer;
    int point;
    String topic;

    public Question(String question, String answer, int point, String topic) {
        this.question = question;
        this.answer = answer;
        this.point = point;
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", point=" + point +
                ", topic='" + topic + '\'' +
                '}';
    }

    public int getPoint() {
        return point;
    }

    public String getTopic() {
        return topic;
    }
}
